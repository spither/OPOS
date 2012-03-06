package com.bioregional.opap

class OrgUser {

    Organisation org
    User user
    // Rights
    Date dateCreated
    Date lastUpdated

    static constraints = {
        org(nullable: false)
        user(nullable: false)
    }
}
