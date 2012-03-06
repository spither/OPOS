package com.bioregional.opap

class NewsService {
    def latestNews(int max, Organisation org = null) {
        if(org) {
            NewsItem.findAllByOrg(org, [ sort: 'dateCreated', order: 'desc', max: max ])
        }
        else {
            NewsItem.list([ sort: 'dateCreated', order: 'desc', max: max ])
        }
    }
}
