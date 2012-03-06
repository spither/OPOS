package com.bioregional.opap

class HelperTagLib {

    def springSecurityService

    def nl2br = { attrs, body ->
        def str = body()
        out << str.replaceAll(/\n/, '<br />')
    }

    def ifUserHasOrg = { attrs, body ->
        def user = springSecurityService.currentUser
        def org = user ? Organisation.findByOwner(user) : null
        if(org?.id) {
            out << body()
        }
    }
}
