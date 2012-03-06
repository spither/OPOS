package com.bioregional.opap

class CommentService {
    def grailsLinkGenerator
    def mailService

    def addComment(target, user, message, priv) {
        def com = new Comment(
            commentRef: target.id,
            sender: user,
            clazz: target.class.name,
            privateMsg: priv ?: false,
            message: message
        )
        if(com.save(flush: true)) {
            def recip
            def title
            def url
            switch(target.class.name) {
                case "com.bioregional.opap.ActionPlan":
                    recip = target.org.owner
                    title = "Action Plan (${target.name})"
                    url = grailsLinkGenerator.link(controller: 'action', action: 'plan', id: target.id, absolute: true)
                    break
                case "com.bioregional.opap.Action":
                    recip = target.actionPlan.org.owner
                    title = "Action (${target.title} - ${target.actionPlan.name})"
                    url = grailsLinkGenerator.link(controller: 'action', action: 'view', id: target.id, absolute: true)
                    break
            }

            if(recip) {
                mailService.sendMail {
                    from 'not-valid@bioregional.com'
                    to recip.email
                    subject 'A One Planet Action Plan comment has been left for you'
                    body """
Dear ${recip.name},

A new comment has just been left on your ${title}.  The message left for you was:

---
${com.message}
---

${com.privateMsg ? "This is a private message from ${user.name} <${user.email}> and is not visible online" : "This message can also be seen online at ${url}"}

Kind regards,

Comment Robot
BioRegional: One Planet Action Plan
"""
                }
            }

            return com
        }
        else {
            log.error("Failed to save comment...")
            com.errors.each { log.error it }
            return null
        }
    }

    def listCommentsFor(target) {
        return Comment.findAllByClazzAndCommentRef(target.class.name, target.id, [ sort: 'dateCreated', order: 'asc' ])
    }

    def listPublicCommentsFor(target) {
        return Comment.findAllByClazzAndCommentRef(target.class.name, target.id, [ sort: 'dateCreated', order: 'asc' ]).findAll { !it.privateMsg && !it.moderatorHidden }
    }

    def latestCommentPlans(int max) {
        def comments = Comment.findAllByClazz('com.bioregional.opap.ActionPlan', [ sort: 'dateCreated', order: 'desc', max: max ])
        def plans = comments.collect { com ->
            ActionPlan.get(com.commentRef)
        }
    }
}
