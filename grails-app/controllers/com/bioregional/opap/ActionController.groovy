package com.bioregional.opap

class ActionController {

    def planService
    def actionService

    def plan() {
        def plan = ActionPlan.get(params.long('id'))
        def actionCats = planService.buildCatList(plan)

        [ plan: plan, actionCats: actionCats ]
    }

    def cat() {
        def plan = ActionPlan.get(params.long('pid'))
        def cat = ActionCategory.get(params.long('cid'))
        if(!plan || !cat) {
            flash.error = "Could not find requested action plan category"
            return redirect(uri: '/')
        }
        def actionCat = planService.buildCatList(plan).find { it.id == cat.id }

        [ plan: plan, cat: actionCat, actions: actionService.listActions(plan.id, cat.id) ]
    }

    def view() {
        def act = Action.get(params.long('id'))
        [ act: act ]
    }
}
