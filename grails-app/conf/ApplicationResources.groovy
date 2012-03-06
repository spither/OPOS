modules = {
    'ui-stars' {
        defaultBundle 'core'
        dependsOn 'jquery-ui'
        resource url: [ dir: 'js', file: 'jquery.ui.stars.js' ]
        resource url: [ dir: 'css/stars', file: 'jquery.ui.stars.min.css' ]
        resource url: [ dir: 'css', file: 'star.css' ]
    }

    opap {
        resource url: 'css/opap.less', attrs: [ rel: "stylesheet/less", type: 'css' ]
    }

    map {
        resource url: 'js/map.js'
    }

    overrides {
        'bootstrap-tabs' {
            defaultBundle 'afterjQui'
            dependsOn 'jquery-ui'
        }
    }
}
