package com.bioregional.opap

class User {

	transient springSecurityService

	String email
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    String name
    String alias
    String postcode
    String country

    Date dateCreated
    Date lastUpdated

	static constraints = {
		email blank: false, unique: true, email: true
		password blank: false
        name nullable: false, size: 0..100
        alias nullable: true, size: 0..50, unique: true
        postcode nullable: true, size: 0..50
        country nullable: false, size: 2..3
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
