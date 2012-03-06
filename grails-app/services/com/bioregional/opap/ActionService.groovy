package com.bioregional.opap

import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor

class ActionService {

    def springSecurityService

    ActionService() {
        GroovyDynamicMethodsInterceptor i = new GroovyDynamicMethodsInterceptor(this)
        i.addDynamicMethodInvocation(new BindDynamicMethod())
    }

    def latestActions(int max) {
        Action.list([ sort: 'dateCreated', order: 'desc', max: max ])
    }

    def listActions(long apId, long catId) {
        def actPlan = ActionPlan.get(apId)
        def cat = ActionCategory.get(catId)
        if(actPlan && cat) {
            // TODO perform access checks
            // def user = springSecurityService.currentUser
            return Action.findAllByActionPlanAndActionCat(actPlan, cat)
        }
        return []
    }

    def createAction(long apId, long catId, Map attrs) {
        def actPlan = ActionPlan.get(apId)
        def cat = ActionCategory.get(catId)
        if(actPlan && cat) {
            def act = new Action()
            act.actionPlan = actPlan
            act.actionCat = cat
            bindData(act, attrs, [ include: [ 'title', 'summary', 'progress' ] ])
            act.save(flush: true)
            return act
        }
        else {
            log.error("Failed to find category and plan, got: ${cat} - ${actPlan}")
        }
        return false
    }

    def updateAction(Action act, Map attrs) {
        bindData(act, attrs, [ include: [ 'title', 'summary', 'progress' ] ])
        return act.save(flush: true)
    }
}
