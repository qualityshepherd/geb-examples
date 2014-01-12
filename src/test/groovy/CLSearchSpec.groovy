import geb.spock.GebReportingSpec
import pages.CLSearchResultsPage
import pages.CLMainPage
import spock.lang.Ignore
import spock.lang.IgnoreRest

class CLSearchSpec extends GebReportingSpec {
    static category = 'community'
    static fewResultsText = 'bluegrass'
    static noResultsText = '!@#$%^&*('

    def setup() {
        when:
        to CLMainPage

        then:
        at CLMainPage
    }

    def 'searches with few results offer nearby results'() {
        given:
        at CLMainPage

        when: 'select category from dropdown'
        dropdown = category
        searchFor(fewResultsText)

        then: 'nearby results message is displayed'
        at CLSearchResultsPage
        nearbyResults.displayed
    }

    def 'message displayed when no results found'() {
        given:
        at CLMainPage

        when:
        dropdown = category
        searchFor(noResultsText)

        then:
        at CLSearchResultsPage
        noResultsMessage.displayed
    }

    def 'many results does NOT display few or no results messages'() {
        given:
        at CLMainPage

        when: 'many results returned'
        dropdown = category
        searchFor('')

        then: 'no and nearby messages are NOT displayed'
        at CLSearchResultsPage
        !noResultsMessage.displayed
        !nearbyResults.displayed
    }

    def 'result views are sticky within category'() {
        given:
        at CLMainPage

        when: 'performing default search'
        searchFor('')

        then:
        at CLSearchResultsPage

        when: 'selecting picview'
        picviewButton.click()

        and: 'performing another search'
        to CLMainPage
        searchFor('')

        then: 'results are still in picview'
        at CLSearchResultsPage
        picviewButtonSelected
    }

    def 'result views are NOT sticky when switching categories'() {
        given:
        at CLMainPage

        when:
        searchFor('')

        then:
        at CLSearchResultsPage

        when:
        picviewButton.click()

        and: 'performing another search in another category'
        to CLMainPage
        dropdown = category
        searchFor('')

        then: 'new category search results should not be in picview'
        at CLSearchResultsPage
        listviewButtonSelected
    }

    def 'filter results with pics displays only results with pics'() {
        given:
        at CLMainPage

        when:
        searchFor('')

        then:
        at CLSearchResultsPage

        when: 'filter results with pics'
        hasPicCheckbox.click()
        searchButton.click()

        then: 'all results have pics'
        at CLSearchResultsPage
        picIcons.size() == resultRows.size()
    }


    @Ignore('tracking down some bugs in module selectors...')
    // example of using module for repeating structures (thanks to Rob Fletcher!)
    def 'verify title is in results'() {
        given:
        at CLMainPage

        when:
        searchFor('')

        then:
        at CLSearchResultsPage
        searchResults.size() == 100
        println searchResults.date
        println searchResults.postTitle
        println searchResults.price // returning empty strings...
        println searchResults.location // works in page object but not in module
    }
}
