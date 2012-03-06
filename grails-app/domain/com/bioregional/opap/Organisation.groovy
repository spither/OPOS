package com.bioregional.opap

class Organisation {

    String name
    String type
    User owner
    String address
    String postcode
    String country
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name(nullable: false, blank: false, size: 0..100)
        type(nullable: false, blank: false, size: 0..100, inList: [
            'Company (less than 50 employees)',
            'Company (50-250 employees)',
            'Company (more than 250 employees)',
            'Charity',
            'Local authority',
            'Government department',
            'Community group',
            'Other'
        ])
        owner(nullable: false)
        address(nullable: true, size: 0..250)
        postcode(nullable: true, size: 0..50)
        country(nullable: false, size: 2..3)
    }
}
