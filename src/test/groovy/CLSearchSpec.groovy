import geb.spock.GebReportingSpec
import pages.CLPostPage
import pages.CLSearchResultsPage
import pages.CLMainPage
import spock.lang.IgnoreRest

class CLSearchSpec extends GebReportingSpec {
    static category = "community"
    static fewResultsText = "bluegrass"
    static noResultsText = "!@#\$%^&*("
    static location = "madison"

    def setup() {
        to CLMainPage
    }

    def "searches with few results offer nearby results"() {
        given:
        at CLMainPage

        when: "search for something that returns only a few results"
        searchFor(fewResultsText)

        then: "nearby results message is displayed"
        at CLSearchResultsPage
        nearbyResults.isDisplayed()
    }

    def "message displayed when no results found"() {
        given:
        at CLMainPage

        when:
        dropdown = category
        searchFor(noResultsText)

        then:
        at CLSearchResultsPage
        noResultsMessage.displayed
    }

    def "many results does NOT display few or no results messages"() {
        given:
        at CLMainPage

        when: "many results returned"
        dropdown = category
        searchFor("")

        then: "no and nearby messages are NOT displayed"
        at CLSearchResultsPage
        !noResultsMessage.displayed
        !nearbyResults.displayed
    }

    def "result views are sticky within category"() {
        given:
        at CLMainPage

        when: "performing default search"
        searchFor("")
        at CLSearchResultsPage

        and: "selecting picview"
        thumbButton.click()

        and: "performing another search"
        to CLMainPage
        searchFor("")

        then: "results are still in picview"
        at CLSearchResultsPage
        thumbButtonSelected
    }

    def "result views are NOT sticky when switching categories"() {
        given:
        at CLMainPage

        when:
        searchFor("")
        at CLSearchResultsPage

        and: "show only results with pictures"
        thumbButton.click()

        and: "performing another search in another category"
        to CLMainPage
        dropdown = category
        searchFor("")

        then: "new category search results should not be in picview"
        at CLSearchResultsPage
        listviewButtonSelected
    }

    def "filter results with pics displays only results with pics"() {
        given:
        at CLMainPage

        when:
        searchFor("")
        at CLSearchResultsPage

        and: "filter results with pics"
        picCheckbox.check()

        then: "all results have pics"
        picCheckbox.isChecked()
        at CLSearchResultsPage
        picIcons.size() == resultRows.size()
    }

    // examples of using module for repeating structures
    def "Location 'Madison' exists in results"() {
        given:
        at CLMainPage

        when:
        searchFor("")

        then:
        at CLSearchResultsPage
        searchResults.location.find {it =~ location}
    }

    def "open first post and verify title"() {
        given:
        at CLMainPage

        when:
        searchFor("")
        at CLSearchResultsPage

        // this is way too expensive to call this way but it's just an example...
        def firstPostTitle = openNthPost(0)

        then: "results title matches the result list title"
        at CLPostPage
        postingTitle.text().startsWith(firstPostTitle)
    }
}
