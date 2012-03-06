package com.bioregional.opap

class BlocksTagLib {
    static namespace = 'block'

    def actionService
    def newsService
    def planService
    def commentService

    def latestActions = { attrs, body ->
        def acts = actionService.latestActions(3)
        out << render(template: '/blocks/actionList', model: [ acts: acts ])
    }

    def latestPlans = { attrs, body ->
        def plans = planService.latestPlans(3)
        out << render(template: '/blocks/planList', model: [ plans: plans ])
    }

    def latestNews = { attrs, body ->
        def news = newsService.latestNews(3)
        out << render(template: '/blocks/newsList', model: [ news: news ])
    }

    def latestComments = { attrs, body ->
        def plans = commentService.latestCommentPlans(3)
        out << render(template: '/blocks/commentList', model: [ plans: plans ])
    }
}
