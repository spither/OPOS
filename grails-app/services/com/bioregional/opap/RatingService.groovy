package com.bioregional.opap

class RatingService {
    def springSecurityService

    def rate(target, int value, String scope = null) {
        def user = springSecurityService.currentUser
        if(user) {
            return rate(target, user, value, scope)
        }
        else {
            return null
        }
    }

    def rate(target, user, int value, String scope = null) {
        def rating = getUserRating(target, user, scope)
        if(rating && rating.size() == 1) {
            rating = rating[0]
            rating.value = value
        }
        else {
            rating = new Rating(
                user: user,
                ratingRef: target.id,
                clazz: target.class.name,
                scope: scope,
                value: value
            )
        }
        if(rating.save()) {
            return rating
        }
        else {
            log.error("Failed to save rating...")
            rating.errors.each { log.error it }
            return null
        }
    }

    def getUserRating(target, user, String scope = null) {
        if(!user) return null
        if(!target?.id) return null
        Rating.withCriteria {
            eq "ratingRef", target.id
            eq "clazz", target.class.name
            eq "user", user
            if(scope == null) isNull "scope"
            else if(scope == 'any') { }
            else eq "scope", scope
            cache true
        }
    }

    def countRatings(target, String scope = null) {
        Rating.createCriteria().count {
            eq "clazz", target.class.name
            eq "ratingRef", target.id
            if(scope == null) isNull "scope"
            else if(scope == 'any') { }
            else eq "scope", scope
            cache true
        }
    }

    def getAverageRating(target, String scope = null) {
        if(target?.id != null) {
            def result = Rating.createCriteria().get {
                projections { avg 'value' }
                eq "ratingRef", target.id
                eq "clazz", target.class.name
                if(scope == null) isNull "scope"
                else if(scope == 'any') { }
                else eq "scope", scope
                cache true
            }
            result ?: 0
        } else {
            return 0
        }
    }
}
