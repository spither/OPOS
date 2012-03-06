package com.bioregional.opap

class ActionCategory {

    String name
    String code

    static constraints = {
        name(nullable: false, size: 0..50)
        code(nullable: false, size: 0..15)
    }
}
