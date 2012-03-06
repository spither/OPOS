package com.bioregional.opap

class Action {

    ActionPlan actionPlan
    ActionCategory actionCat
    String title
    String summary
    String progress
    Date dateCreated
    Date lastUpdated

    static constraints = {
        actionPlan(nullable: false)
        actionCat(nullable: false)
        title(nullable: false, blank: false, size: 0..200)
        summary(nullable: true, size: 0..10000)
        progress(nullable: true, size: 0..10000)
    }
}
