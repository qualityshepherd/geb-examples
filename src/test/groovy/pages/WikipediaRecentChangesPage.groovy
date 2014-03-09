package pages

import geb.Page

/**
 * Created by qualityshepherd on 3/6/14.
 */
class WikipediaRecentChangesPage extends Page {
    static url = "https://en.wikipedia.org/wiki/Special:RecentChanges"
    static at = {heading.isDisplayed()}
    static content = {
        heading {$("h1#firstHeading span", text:"Recent changes")}

        // filters...
        showLast50 {$("a", text:"50")}
        showLast100(wait:true) {$("a", text:"100")}
        last30Days {$("a", text:"30")}
        namespaceSelect {$("select#namespace")}
        goButton {$("input", value:"Go")}

        // list...
        changeList {$("ul.special")}
        resultsRow {$("li.mw-changeslist-line-not-watched")}
    }

    def numberOfResults() {
        waitFor {changeList.isDisplayed()}
        return resultsRow.size()
    }

    def selectNamespace(name) {
        namespaceSelect = name
        goButton.click()
    }

    def resultsRowContains(text) {
        resultsRow.each {it.text().contains(text)}
    }
}
