package com.bioregional.opap

import grails.util.*

class RatingTagLib {

    static namespace = 'rating'

    def ratingService
    def springSecurityService

    def stars = {attrs ->
        if (!attrs.bean) throw new RuntimeException("There must be a 'bean' domain object included in the ratings tag.")
        def bean = attrs.bean
        def type = GrailsNameUtils.getPropertyName(bean.class)
		def id = attrs.id ?: "rating"
        def caption = attrs.caption == null ? true : attrs.caption

        if (attrs.active == 'false') {
            def average = attrs.average ?: (ratingService.getAverageRating(bean, attrs.scope) ?: 0)
            if(average > 0)
                average = Math.round(average).toInteger()

            out << render(template: '/blocks/stars', model: [ id: id, bean: bean, type: type, caption: caption, userValue: average, disabled: true ])
        }
        else { // Rating is active
            def rater = springSecurityService.currentUser
            def userValue
            if(rater) {
                def r = ratingService.getUserRating(bean, rater, attrs.scope)
                userValue = r.size() > 0 ? (r[0].value) : null
            }

            def scopeParam = attrs.scope ? "&scope=${attrs.scope}" : ''
            out << render(template: '/blocks/stars', model: [ id: id, bean: bean, scopeParam: scopeParam, type: type, caption: caption, userValue: userValue ])
        }
    }

    def rating = { attrs ->
        if (!attrs.bean) throw new RuntimeException("There must be a 'bean' domain object included in the ratings tag.")
        def bean = attrs.bean
        def average = ratingService.getAverageRating(bean) ?: 0
        if(attrs.style == "text")
            out << average
    }

    def numRates = { attrs ->
        if (!attrs.bean) throw new RuntimeException("There must be a 'bean' domain object included in the ratings tag.")
        def bean = attrs.bean
        def c = ratingService.countRatings(bean, attrs.scope)
        out << c
        if(attrs.tail == 'true') {
            out << " rating"
            if(c == 0 || c > 1)
                out << "s"
        }
    }
}
