import grails.util.Environment

class BootStrap {

    def baseDataService
    def fixtureLoader

    def init = { servletContext ->
        baseDataService.checkRoles()
        baseDataService.checkActionCategories()

        if(Environment.current == Environment.DEVELOPMENT) {
            fixtureLoader.load("dev/*")
        }
    }

    def destroy = {
    }
}
