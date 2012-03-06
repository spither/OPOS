package com.bioregional.opap

class Comment {

    User sender
    Long commentRef
    String clazz
    String message
    Boolean privateMsg = false
    Boolean moderatorHidden = false
    String notifiedEmail
    Date dateCreated
    Date lastUpdated

    static constraints = {
        sender(nullable: false)
        commentRef(nullable: false, min: 0L)
        clazz(blank: false, size: 0..100)
        message(nullable: false, size: 0..10000)
        notifiedEmail(nullable: true, size: 0..250)
    }

    static mapping = {
        cache(true)
        commentRef(index: 'comment_ref_idx')
    }
}
