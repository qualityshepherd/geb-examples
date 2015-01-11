package pages

import geb.Page
import modules.CLResultsModule
import modules.CheckboxModule

class CLSearchResultsPage extends Page {
    static at = {searchBody}
    static content = {
        searchBody(wait:true) {$('body.search')}
        searchBox {$('input#query')}

        // use moduleList to get list of search results and elements...
        searchResults {moduleList CLResultsModule, $('p.row')}

        thumbButton {$("a#picview")}
        thumbButtonSelected(required:false) {$('a#picview.sel')}
        listviewButton {$('a#listview')}
        listviewButtonSelected(required:false) {$('a#listview.sel')}

        picCheckbox {module CheckboxModule, $("input", name:"hasPic")}
        picIcons {$('span.px')}
        resultRows {$('p.row')}

        nearbyResults(wait:true, required:false) {$('h4.ban.nearby span.bantext')}
        noResultsMessage(required:false) {$('div.noresults')}
    }

    // click the nth post and return the title of the post...
    def openNthPost(i) {
        def titleText = searchResults[i].title.text()
        searchResults[i].title.click()
        return titleText
    }
}
