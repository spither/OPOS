import com.bioregional.opap.*

fixture {
    user1(User) {
        email = "simon@seoss.co.uk"
        password = "password1"
        name = "Simon"
        postcode = "AB1 1BA"
        country = "GB"
        enabled = true
    }

    ur(UserRole) {
        user = user1
        role = Role.get(1)
    }

    org1(Organisation) {
        owner = user1
        name = "Test Organisation"
        type = 'Charity'
        postcode = "AB1 1BA"
        country = "GB"
    }

    org2(Organisation) {
        owner = user1
        name = "Another Org"
        type = 'Charity'
        postcode = "AB1 1BA"
        country = "GB"
    }

    plan1(ActionPlan) {
        org = org1
        type = 'Department'
        name = "This is a test action plan only!"
        description = "A fairly simple test vision that doesn't really say very much at all.\n\nHowever it is spread over a couple of lines."
        lat = 51.5001
        lng = -0.1262
    }

    plan2(ActionPlan) {
        org = org1
        type = 'Department'
        name = "This is the second plan for Test Org"
        description = "Not much of a description for this one."
        lat = 50.5001
        lng = 5.1262
    }

    plan3(ActionPlan) {
        org = org2
        type = 'Department'
        name = "ZZZ - This one is last"
        description = "Not much of a description for this one."
        lat = 50.5001
        lng = 5.1262
    }

    act1(Action) {
        actionPlan = plan1
        actionCat = ActionCategory.get(1)
        title = "Action no. 1"
        summary = "This action has some details but they don't really say much."
    }
    act2(Action) {
        actionPlan = plan1
        actionCat = ActionCategory.get(1)
        title = "Action no. 2"
        summary = "This action has some details but they don't really say much."
    }
    act3(Action) {
        actionPlan = plan1
        actionCat = ActionCategory.get(1)
        title = "Another action"
    }
    act4(Action) {
        actionPlan = plan1
        actionCat = ActionCategory.get(2)
        title = "Let's do something"
        summary = "This action has some details but they don't really say much."
    }
    act5(Action) {
        actionPlan = plan1
        actionCat = ActionCategory.get(2)
        title = "Get better"
        summary = "This action has some details but they don't really say much."
    }

    news1(NewsItem) {
        org = org1
        author = user1
        title = "An exciting headline"
        body = "This is a sample news story.  It should be very exciting but sadly it's only a sample."
    }
}
