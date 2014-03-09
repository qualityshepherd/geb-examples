import geb.spock.GebReportingSpec
import pages.WikipediaRecentChangesPage
import spock.lang.IgnoreRest

/**
 * Created by qualityshepherd on 3/6/14.
 */
class WikipediaRecentChangesSpec extends GebReportingSpec {

    def "Filter by last 50 results displays 50 results"() {
        given:
        to WikipediaRecentChangesPage

        when:
        showLast50.click()

        then:
        numberOfResults() == 50
    }

    def "Filter by last 100 results displays 100 results"() {
        given:
        to WikipediaRecentChangesPage

        when:
        showLast100.click()
        showLast100.click() // fixes bug in safari somehow...

        then:
        numberOfResults() == 100
    }

    def "Filter by draft namespace returns only draft results"() {
        given:
        to WikipediaRecentChangesPage

        when:
        last30Days.click()
        selectNamespace "Draft"

        then:
        resultsRowContains "Draft:"
    }
}
