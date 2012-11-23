package lamerfilter

import grails.test.*
import com.grailsrocks.plugin.lamerfilter.*

class LamerDetectorFiltersTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testNullUserAgentDoesNotCrash() {
        def filt = new LamerDetectorFilters().testableFilterCode
        def deleg = new Expando()
        def redirected = false
        deleg.request = [forwardURI:'test', getHeader: { s -> null} ]
        deleg.redirect = { Map args -> redirected = true }
        deleg.session = [:]

        filt.delegate = deleg
        filt()
        
        assertFalse redirected
        assertNull deleg.session.seenLamerWarning
    }

    void testMSIE6Redirects() {
        def filt = new LamerDetectorFilters().testableFilterCode
        def deleg = new Expando()
        def redirected = false
        deleg.request = [forwardURI:'test', getHeader: { s -> 'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)'} ]
        deleg.redirect = { Map args -> redirected = true }
        deleg.session = [:]

        filt.delegate = deleg
        filt()
        
        assertTrue redirected
        assertTrue deleg.session.seenLamerWarning
    }


    void testSafariDoesNotRedirect() {
        def filt = new LamerDetectorFilters().testableFilterCode
        def deleg = new Expando()
        def redirected = false
        deleg.request = [forwardURI:'test', getHeader: { s -> 
            'Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_4; en-us) AppleWebKit/533.19.4 (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4'} ]
        deleg.redirect = { Map args -> redirected = true }
        deleg.session = [:]

        filt.delegate = deleg
        filt()
        
        assertFalse redirected
        assertNull deleg.session.seenLamerWarning
    }
}
