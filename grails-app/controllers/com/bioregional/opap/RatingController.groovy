package com.bioregional.opap

import grails.plugins.springsecurity.Secured
import grails.converters.*

class RatingController {
    def ratingService
    def springSecurityService

    @Secured(['ROLE_USER'])
    def rate() {
        def rater = springSecurityService.currentUser
        def target
        switch(params.type) {
            case "actionPlan":
                target = ActionPlan.get(params.id)
                break
            default:
                log.error("We did not recognise the rating type ${params.type}")
                return
        }

        def scope = params.scope
        if(target)
            ratingService.rate(target, rater, params.int('rating'), scope)

        def res = [ msg: 'Thank you, your vote has been recorded.' ] as JSON
        render(res)
    }
}
