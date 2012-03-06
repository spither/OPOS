package com.bioregional.opap

import spock.lang.*
import grails.test.mixin.*

@TestFor(ActionService)
@Mock([ Action, ActionPlan, ActionCategory, Organisation ])
class ActionServiceSpec extends Specification {

    @Shared
    def org

    def setupSpec() {
        def user = User.build(email: 'test@test.com')
        org = Organisation.build(owner: user)
    }

    def "create new action"() {
        setup:
        def s = new ActionService()
        def cat = ActionCategory.build()
        def plan = ActionPlan.build(org: org)
        assert s.listActions(plan.id, cat.id).size() == 0

        expect:
        def res = s.createAction(plan.id, cat.id, [ title: title, summary: summary, progress: progress ])
        res != false
        res.hasErrors() == false
        res.id > 0
        res.title == title
        res.summary == summary
        res.progress == progress
        s.listActions(plan.id, cat.id).size() == 1

        cleanup:
        Action.list()*.delete()
        ActionPlan.list()*.delete()

        where:
        title | summary | progress
        'First Action' | 'Test summary' | null
        'Another action' | null | null
        'Simple act' | null | 'This has a progress'
    }
}
