package com.bioregional.opap

import grails.converters.*

class BrowseController {
    def location() {
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ plans: ActionPlan.list(params), planTotal: ActionPlan.count() ]
    }

    def listPins() {
        def plans = ActionPlan.findAllByLatIsNotNull()
        def locs = plans.collect {
            [
                lat: it.lat,
                lng: it.lng,
                title: it.name,
                url: g.createLink(controller: 'action', action: 'plan', id: it.id)
            ]
        }
        render(locs as JSON)
    }
}
