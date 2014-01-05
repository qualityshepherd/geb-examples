package pages

import geb.Page

class CLSearchResultsPage extends Page {
    static at = {searchResults}
    static content = {
        searchResults(wait:true) {$('body.search')}
        searchBox {$('input#query')}
        searchButton {$('input#searchbtn')}

        picviewButton {$('a#picview')}
        picviewButtonSelected(required:false) {$('a#picview.sel')}
        listviewButton {$('a#listview')}
        listviewButtonSelected(required:false) {$('a#listview.sel')}

        hasPicCheckbox {$('span.haspic')}
        picIcons {$('span.px')}
        resultRows {$('p.row')}

        nearbyResults(required:false) {$('h4.ban.nearby')}
        noResultsMessage(required:false) {$('div.noresults')}
    }
}
