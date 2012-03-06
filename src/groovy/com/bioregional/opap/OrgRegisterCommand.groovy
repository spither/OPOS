package com.bioregional.opap

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class OrgRegisterCommand {
    String orgName
    String orgType
    String orgAddress
    String orgPostcode
    String orgCountry

    static constraints = {
        orgName(blank: false, size: 0..100)
        orgType(blank: false, size: 0..100, inList: [
            'Company (less than 50 employees)',
            'Company (50-250 employees)',
            'Company (more than 250 employees)',
            'Charity',
            'Local authority',
            'Government department',
            'Community group',
            'Other'
        ])
        orgAddress(nullable: true, size: 0..250)
        orgPostcode(blank: false, size: 0..50)
        orgCountry(blank: false, size: 2..3)
    }
}
