package com.bioregional.opap

class NewsController {

    def view() {
        def item = NewsItem.get(params.long('id'))
        [ newsItem: item ]
    }
}
