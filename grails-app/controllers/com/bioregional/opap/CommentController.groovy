package com.bioregional.opap

import grails.plugins.springsecurity.Secured

class CommentController {
    def springSecurityService
    def commentService

    def save() {
        def user = springSecurityService.currentUser
        def target
        if(user) {
            switch(params.targetClass) {
                case "com.bioregional.opap.ActionPlan":
                    target = ActionPlan.get(params.targetId)
                    break
                case "com.bioregional.opap.Action":
                    target = Action.get(params.targetId)
                    break
            }
        
            if(target) {
                commentService.addComment(target, user, params.message, params.private == 'on' ? true : false)
                flash.message = "You comment has been saved."
            }
            else {
                flash.error = "Sorry, we could not save your message."
            }
        }
        else {
            flash.error = "You must be logged in to leave a message."
        }

        switch(params.targetClass) {
            case "com.bioregional.opap.ActionPlan":
                redirect(controller: 'action', action: 'plan', id: target.id)
                break
            case "com.bioregional.opap.Action":
                redirect(controller: 'action', action: 'view', id: target.id)
                break
            default:
                redirect(uri: '/')
        }
    }

    @Secured(['ROLE_COMMENT_MOD'])
    def toggleShow() {
        def comment = Comment.get(params.id)
        comment.moderatorHidden = !comment.moderatorHidden
        if(comment.save(flush: true)) {
            flash.message = "Comment has been updated."
        }
        else {
            flash.error = "Sorry, the message could not be updated."
        }

        switch(comment.clazz) {
            case "com.bioregional.opap.ActionPlan":
                redirect(controller: 'action', action: 'plan', id: comment.commentRef)
                break
            case "com.bioregional.opap.Action":
                redirect(controller: 'action', action: 'view', id: comment.commentRef)
                break
            default:
                redirect(uri: '/')
        }
    }
}
