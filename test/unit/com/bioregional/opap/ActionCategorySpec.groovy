package com.bioregional.opap

import spock.lang.*
import grails.test.mixin.*

@TestFor(ActionCategory)
class ActionCategorySpec extends Specification {

    def "contraints test"() {
        given:
            mockForConstraintsTests(ActionCategory)

        when:
            def ac = new ActionCategory()

        then:
            !ac.validate()
            ac.errors["name"] == "nullable"
            ac.errors["code"] == "nullable"

        when:
            ac = new ActionCategory(code: 'carbon', name: "Zero Carbon")

        then:
            ac.validate()
            ac.save()
    }
}
