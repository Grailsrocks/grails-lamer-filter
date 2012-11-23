package com.grailsrocks.plugin.lamerfilter

class LamerDetectorController {

    static defaultAction = 'index'
    
    def index = { 
        render(view:'/lamers/get-a-real-browser')
    }
}
