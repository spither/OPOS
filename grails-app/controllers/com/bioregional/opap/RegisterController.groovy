package com.bioregional.opap

class RegisterController {

    def registrationService
    def springSecurityService

    def index(RegisterCommand reg, OrgRegisterCommand orgReg) {
        [ reg: new RegisterCommand(), orgReg: new OrgRegisterCommand() ]
    }

    def save(RegisterCommand reg, OrgRegisterCommand orgReg) {
        def wantOrg = (reg.iAm == "an organisation")
        if(reg.validate()) {
            def user
            if(wantOrg) {
                if(orgReg.validate()) {
                    user = registrationService.userAndOrg(reg.properties, orgReg.properties)
                }
                else {
                    return render(view: 'index', model: [ reg: reg, orgReg: orgReg, msgError: 'Please correct the errors below.' ])
                }
            }
            else {
                user = registrationService.userOnly(reg.properties)
            }
            if(user?.id) {
                springSecurityService.reauthenticate(user.email)
                flash.message = "Your registration has been completed."
                redirect(controller: 'profile', action: 'loginLand')
            }
            else {
                def msg = "Sorry, we could not complete your registration at this time."
                render(view: 'index', model: [ reg: reg, orgReg: (wantOrg ? orgReg : new OrgRegisterCommand()), msgError: msg ])
            }
        }
        else {
            render(view: 'index', model: [ reg: reg, orgReg: (wantOrg ? orgReg : new OrgRegisterCommand()), msgError: 'Please correct the errors below.' ])
        }
    }
}
