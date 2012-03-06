package com.bioregional.opap

class NewsItem {
    Organisation org
    User author
    String title
    String body
    Date dateCreated
    Date lastUpdated

    static constraints = {
        org(nullable: false)
        author(nullable: false)
        title(nullable: false, blank: false, size: 0..200)
        body(blank: false, size: 0..10000)
    }
}
