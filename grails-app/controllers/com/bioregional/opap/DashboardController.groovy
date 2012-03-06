package com.bioregional.opap

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class DashboardController {

    def actionService
    def newsService
    def planService
    def actionPlanService
    def springSecurityService

    def index() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)

        if(!org) {
            // FIXME redirect the user elsewhere
            return [ org: null, plan: null, news: null, actionCats: null ]
        }

        def plans = planService.list(org)
        def id = params.long('id')
        def plan = null
        if(id) {
            plan = plans.find { p -> p.id == id }
        }
        if(!plan) {
            plan = planService.getDefault(org)
        }
        def news = newsService.latestNews(6, org)

        def actionCats = planService.buildCatList(plan)
        [ actionCats: actionCats, org: org, plan: plan, plans: plans, news: news ]
    }

    def createPlan() {
        [ plan: new ActionPlan() ]
    }

    def editPlan() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        if(!org) {
            flash.error = "Your organisation could not be found"
            return redirect(action: 'index')
        }
        def plan = ActionPlan.findByOrgAndId(org, params.long('id'))
        if(!plan || !actionPlanService.isPlanOwner(user, plan)) {
            flash.error = "Your plan could not be found"
            return redirect(action: 'index')
        }
        render(view: 'createPlan', model: [ plan: plan ])
    }

    def savePlan() {
        def user = springSecurityService.currentUser
        def plan
        if(params.id) {
            plan = ActionPlan.get(params.long('id'))
            if(!actionPlanService.isPlanOwner(user, plan)) {
                flash.error = "You do not have access to update that plan."
                redirect(action: 'index')
            }
        }
        else {
            plan = new ActionPlan()
            plan.org = Organisation.findByOwner(user)
        }

        bindData(plan, params, [ include: [ 'name', 'type', 'description', 'lat', 'lng' ] ])
        if(plan.save(flush: true)) {
            flash.message = "Your Action Plan has been saved."
            redirect(action: 'index')
        }
        else {
            flash.error = "Please correct the errors below and try again."
            render(view: 'createPlan', model: [ plan: plan ])
        }
    }

    def defaultPlan() {
        def user = springSecurityService.currentUser
        def plan = ActionPlan.get(params.long('id'))
        if(actionPlanService.isPlanOwner(user, plan)) {
            actionPlanService.setOrgDefaultPlan(plan)
            flash.message = "Your default action plan has been updated."
        }
        else {
            flash.error = "You do not have permissions to set that default."
        }
        redirect(action: 'index')
    }

    def actionCat() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        def planId = params.long('pid')
        def plan = ActionPlan.findByOrgAndId(org, planId)
        def catId = params.long('cid')
        if(!plan || catId == null || catId <= 0) {
            flash.error = "Could not find requested action plan category"
            return redirect(action: 'index')
        }

        [ plan: plan, cat: ActionCategory.get(catId), actions: actionService.listActions(plan.id, catId) ]
    }

    def createAction() {
        def plan
        def cat
        def act
        if(params.id) {
            def user = springSecurityService.currentUser
            act = Action.get(params.long('id'))
            plan = act.actionPlan
            cat = act.actionCat
            if(!actionPlanService.isPlanOwner(user, plan)) {
                flash.error = "You do not have access to update that action."
                redirect(action: 'index')
            }
        }
        else {
            plan = ActionPlan.get(params.long('pid'))
            cat = ActionCategory.get(params.long('cid'))
            act = new Action()
        }

        [ plan: plan, cat: cat, act: act ]
    }

    def saveAction() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        def planId = params.long('pid')
        def plan = ActionPlan.findByOrgAndId(org, planId)
        def catId = params.long('cid')

        if(!plan || catId == null || catId <= 0) {
            flash.error = "Could not save action for unknown action plan category"
            return redirect(action: 'index')
        }

        if(params.id) {
            def act = Action.get(params.long('id'))
            if(!actionPlanService.isPlanOwner(user, act.actionPlan)) {
                flash.error = "You do not have access to update that action."
                redirect(action: 'index')
            }
            if(actionService.updateAction(act, params)) {
                flash.message = "Your action has been updated."
                redirect(action: 'actionCat', params: [ pid: plan.id, cid: catId ])
            }
            else {
                flash.error = "Sorry, we could not save your changes."
                render(view: 'createAction', model: [ plan: plan, cat: ActionCategory.get(catId), act: act ])
            }
        }
        else {
            def act = actionService.createAction(plan.id, catId, params)
            if(act && act.id) {
                flash.message = "Your new action has been created."
                redirect(action: 'actionCat', params: [ pid: plan.id, cid: catId ])
            }
            else {
                render(view: 'createAction', model: [ plan: plan, cat: ActionCategory.get(catId), act: act ])
            }
        }
    }
    
    def deleteAction() {
        def user = springSecurityService.currentUser
        def act = Action.get(params.long('id'))

        if(!actionPlanService.isPlanOwner(user, act.actionPlan)) {
            flash.error = "You do not have access to update that action"
            redirect(action: 'index')
        }
        else {
            def planId = act.actionPlan.id
            def catId = act.actionCat.id
            act.delete(flush: true)
            flash.message = "Action has been removed"
            redirect(action: 'actionCat', params: [ pid: planId, cid: catId ])
        }
    }

    def createNews() {
        def news
        if(params.id) {
            def user = springSecurityService.currentUser
            news = NewsItem.get(params.long('id'))
            if(user.id != news.author.id) {
                flash.error = "You do not have access to update that news article."
                redirect(action: 'index')
            }
        }
        else {
            news = new NewsItem()
        }

        [ newsItem: news ]
    }

    def saveNews() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)

        if(params.id) {
            def news = NewsItem.get(params.long('id'))
            if(user.id != news.author.id) {
                flash.error = "You do not have access to update that new article."
                redirect(action: 'index')
            }
            bindData(news, params, [ include: [ 'title', 'body' ] ])
            if(news.save(flush: true)) {
                flash.message = "Your news article has been updated."
                redirect(action: 'index')
            }
            else {
                flash.error = "Sorry, we could not save your changes."
                render(view: 'createNews', model: [ newsItem: news ])
            }
        }
        else {
            def news = new NewsItem()
            bindData(news, params, [ include: [ 'title', 'body' ] ])
            news.author = user
            news.org = org
            if(news.save(flush: true)) {
                flash.message = "Your new news article has been created."
                redirect(action: 'index')
            }
            else {
                flash.error = "Sorry, we could not save your news article."
                render(view: 'createNews', model: [ newsItem: news ])
            }
        }
    }

}
