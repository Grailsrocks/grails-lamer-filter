package com.grailsrocks.plugin.lamerfilter

class LamerDetectorFilters {

    static MSIE6PATTERN = ~/.*MSIE 6.*/

    def testableFilterCode = {
        if (!request.forwardURI.contains('lamerDetector')) {
            def userAgent = request.getHeader('User-Agent')
            if (userAgent && MSIE6PATTERN.matcher(userAgent).matches() && !session.seenLamerWarning) {
                session.seenLamerWarning = true
                redirect(controller:'lamerDetector', action:'index', params:[originalLink:request.forwardURI])
            }
        }
    }
    
    def filters = {
        lamersHo(uri:'/**') {
            def code = testableFilterCode
            code.delegate = delegate
            before = code
            return false // Stop any other processing - or we might get duplicate redirects etc
        }
    }
    
}
