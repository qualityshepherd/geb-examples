package pages

import geb.Page
import modules.CLResults

class CLSearchResultsPage extends Page {
    static at = {searchBody}
    static content = {
        searchBody(wait:true) {$('body.search')}
        searchBox {$('input#query')}
        searchButton {$('input#searchbtn')}
        searchResults { $('p.row').collect {module CLResults, it} }

        picviewButton {$('a#picview')}
        picviewButtonSelected(required:false) {$('a#picview.sel')}
        listviewButton {$('a#listview')}
        listviewButtonSelected(required:false) {$('a#listview.sel')}

        hasPicCheckbox {$('span.haspic')}
        picIcons {$('span.px')}
        resultRows {$('p.row')}

        nearbyResults(required:false) {$('h4.ban.nearby')}
        noResultsMessage(required:false) {$('div.noresults')}

        //price {$('span.price').text()}
        //location {$('small').text()}
    }
}
