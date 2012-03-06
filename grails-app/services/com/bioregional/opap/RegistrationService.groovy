package com.bioregional.opap

class RegistrationService {

    User userOnly(Map userProps) {
        def user = new User()
        user.properties = userProps.subMap([ 'email', 'password', 'name', 'alias', 'postcode', 'country' ])

        // One day this might require email confirmation but for protoype it must be automatic
        user.enabled = true

        if(user.save()) {
            def role = Role.findByAuthority('ROLE_USER')
            UserRole.create(user, role)
            return user
        }
        else {
            log.error("Failed to register user.")
            user.errors.each { log.error it }
            return null
        }
    }

    User userAndOrg(Map userProps, Map orgProps) {
        def user = userOnly(userProps)

        if(user?.id) {
            def org = new Organisation(
                name: orgProps.orgName,
                type: orgProps.orgType,
                address: orgProps.orgAddress,
                postcode: orgProps.orgPostcode,
                country: orgProps.orgCountry
            )
            org.owner = user
            if(org.save(failOnError: true)) {
                return user
            }
            else {
                log.error("Failed to create organisation.")
                org.errors.each { log.error it }
                return null
            }
        }
        else {
            return null
        }
    }

    boolean updateUser(User user, Map userProps) {
        user.properties = userProps.subMap([ 'email', 'password', 'name', 'alias', 'postcode', 'country' ])
        if(user.save()) {
            return true
        }
        else {
            log.error("Failed to register user.")
            user.errors.each { log.error it }
            return false
        }
    }
}
