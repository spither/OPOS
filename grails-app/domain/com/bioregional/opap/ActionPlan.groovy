package com.bioregional.opap

class ActionPlan {

    Organisation org
    String type
    String name
    String description
    Boolean autoShow = false
    Double lat
    Double lng
    Date dateCreated
    Date lastUpdated

    static constraints = {
        org(nullable: false)
        type(nullable: false, blank: false, size: 0..100, inList: [
            'Organisation',
            'Department',
            'Construction project',
            'Other project',
            'Service'
        ])
        name(nullable: false, blank: false, size: 0..250)
        description(nullable: true, size: 0..5000)
        lat(nullable: true, range: 0..90)
        lng(nullable: true, range: -180..180)
    }
}
