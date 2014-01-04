import data.UserData
import geb.spock.GebReportingSpec
import pages.MoodleSandboxPage

class MoodleSandboxLoginSpec extends GebReportingSpec {
    static admin = UserData.admin

    def 'login to Moodle Sandbox'() {
        given:
        to MoodleSandboxPage

        when:
        loginToMoodleSandboxAs(admin)

        and: 'if browser window is < 980px, expand navbar button'
        clickNavbarButtonIfExists()

        then: 'assert user logged in'
        // note: this fails on safari because bug in driver and/or moodle...
        loggedInAs.text() == admin.fullname
    }
}
