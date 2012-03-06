package com.bioregional.opap

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class ProfileController {
    def springSecurityService

    def loginLand() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        if(org?.id) {
            redirect(controller: 'dashboard')
        }
        else {
            flash.message = "You are now logged in."
            redirect(uri: '/')
        }
    }

    def index() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        [ userInstance: user, org: org ]
    }

    def editUser() {
        def user = springSecurityService.currentUser
        [ userInstance: user ]
    }

    def updateUser() {
        def userInstance = springSecurityService.currentUser
        if (!userInstance) {
            flash.message = "Sorry, we could not update your user at this time."
            redirect(action: "index")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "editUser", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "editUser", model: [userInstance: userInstance])
            return
        }

        flash.message = "Your details have been updated."
        redirect(action: "index")
    }

    def editOrg() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        [ org: org ]
    }

    def updateOrg() {
        def user = springSecurityService.currentUser
        def org = Organisation.findByOwner(user)
        if (!org) {
            flash.message = "Sorry, we could not update your organisation at this time."
            redirect(action: "index")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (org.version > version) {
                org.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this organisation while you were editing")
                render(view: "editOrg", model: [org: org])
                return
            }
        }

        org.properties = params

        if (!org.save(flush: true)) {
            render(view: "editOrg", model: [org: org])
            return
        }

        flash.message = "Your details have been updated."
        redirect(action: "index")
    }
}
