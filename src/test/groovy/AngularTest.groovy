import geb.spock.GebReportingSpec
import pages.AngularInputPage

class AngularTest extends GebReportingSpec {

    def "Check Angular checkboxes and verify checked"() {
        given:
        to AngularInputPage

        when:
        checkbox1.uncheck()
        checkbox2.uncheck()

        then:
        checkbox1.isUnchecked()
        checkbox2.isUnchecked()
    }
}