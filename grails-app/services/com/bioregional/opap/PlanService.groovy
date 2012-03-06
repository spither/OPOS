package com.bioregional.opap

class PlanService {
    def list(Organisation org) {
        return ActionPlan.findAllByOrg(org, [ sort: 'name', order: 'asc' ])
    }

    def latestPlans(int max) {
        ActionPlan.list([ sort: 'dateCreated', order: 'desc', max: max ])
    }

    def getDefault(Organisation org) {
        def plans = ActionPlan.findAllByOrgAndAutoShow(org, true, [ sort: 'name', order: 'asc' ])
        if(plans.size() == 0) {
            plans = list(org)
            if(plans.size() == 0) {
                return null
            }
            else {
                def plan = plans[0]
                plan.autoShow = true
                plan.save()
            }
        }
        else if(plans.size() > 1) {
            plans[0..(plans.size() - 1)].each { plan ->
                plan.autoShow = false
                plan.save()
            }
        }
        return plans[0]
    }

    def buildCatList(ActionPlan plan) {
        return ActionCategory.list().collect { cat ->
            [
                id: cat.id,
                name: cat.name,
                code: cat.code,
                actCount: Action.countByActionPlanAndActionCat(plan, cat),
            ]
        }
    }
}
