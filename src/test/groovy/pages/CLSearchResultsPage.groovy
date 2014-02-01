package pages

import geb.Page
import modules.CLResultsModule
import modules.CheckboxModule

class CLSearchResultsPage extends Page {
    static at = {searchBody}
    static content = {
        searchBody(wait:true) {$('body.search')}
        searchBox {$('input#query')}
        searchButton {$('input#searchbtn')}
        // use moduleList to get list of search results and elements...
        searchResults {moduleList CLResultsModule, $('p.row')}
        searchResult {moduleList CLResultsModule, $('p.row')}

        picviewButton {$('a#picview')}
        picviewButtonSelected(required:false) {$('a#picview.sel')}
        listviewButton {$('a#listview')}
        listviewButtonSelected(required:false) {$('a#listview.sel')}

        picCheckbox {module CheckboxModule, $("input", name:"hasPic")}
        picIcons {$('span.px')}
        resultRows {$('p.row')}

        nearbyResults(wait:true, required:false) {$('h4.ban.nearby span.bantext')}
        noResultsMessage(required:false) {$('div.noresults')}
    }
}
