package com.bioregional.opap

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class CommentTagLib {
    def commentService

    def listComments = { attrs ->
        def target = attrs.target
        if(target) {
            def comments = commentService.listPublicCommentsFor(target)
            if(attrs.showAll == 1 && SpringSecurityUtils.ifAllGranted('ROLE_COMMENT_MOD')) {
                comments = commentService.listCommentsFor(target)
            }
            comments.each {
                out << render(template: '/blocks/comment', model: [ comment: it ])
            }
        }
    }
}
