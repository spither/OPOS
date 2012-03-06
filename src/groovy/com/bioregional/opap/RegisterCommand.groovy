package com.bioregional.opap

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class RegisterCommand {
    String email
    String password
    String confirmPassword
    String name
    String alias
    String postcode
    String country
    String iAm

    static constraints = {
        email(blank: false, email: true, validator: { val, obj ->
            !(val && User.findByEmail(val))
        })
        password(blank: false, size: 6..30, password: true)
        confirmPassword(blank: false, password: true, validator: { val, obj ->
            obj.properties['password'] == val
        })
        name(blank: false, size: 0..100)
        alias(size: 0..50, validator: { val, obj ->
            !(val && User.findByAlias(val))
        })
        postcode(blank: false, size: 0..50)
        country(blank: false, size: 2..3)
        iAm(blank: false, inList: [
            'an individual',
            'an organisation'
        ])
    }
}
