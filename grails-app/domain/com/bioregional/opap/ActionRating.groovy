package com.bioregional.opap

class ActionRating {

    Action action
    User user
    Integer value
    Date dateCreated
    Date lastUpdated

    static constraints = {
        action(nullable: false)
        user(nullable: false)
        value(nullable: false, range: 0..10)
    }
}
