package com.bioregional.opap

class Rating {
    User user
    Long ratingRef
    String clazz
    String scope
    Integer value
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user(nullable: false)
        value(range: 0..10)
        ratingRef(min: 0L)
        clazz(blank: false)
        scope(nullable: true, size: 0..40)
    }

    static mapping = {
        cache(true)
        ratingRef(index: 'rating_ref_idx')
    }
}
