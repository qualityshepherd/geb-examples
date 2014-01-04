import geb.spock.GebReportingSpec
import pages.CLSearchResultsPage
import pages.CLMainPage
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

    def 'search with few results offers nearby results'() {
        given:
        at CLMainPage

        when:
        dropdown = category
        searchFor(fewResultsText)

        then:
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
}
