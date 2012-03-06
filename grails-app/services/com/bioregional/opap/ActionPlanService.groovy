package com.bioregional.opap

class ActionPlanService {
    def createPlan() {
    }

    def isPlanOwner(user, plan) {
        return user.id == plan.org.owner.id
    }

    def setOrgDefaultPlan(plan) {
        def org = plan.org
        def defs = ActionPlan.findAllByOrgAndAutoShow(org, true)
        defs.each {
            it.autoShow = false
            it.save(flush: true)
        }
        plan.autoShow = true
        plan.save(flush: true)
    }
}
