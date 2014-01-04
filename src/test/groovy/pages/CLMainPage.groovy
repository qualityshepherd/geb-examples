package pages

import geb.Page

class CLMainPage extends Page {
    static url = 'http://madison.craigslist.org/'
    static at = {pageTitle}
    static content = {
        pageTitle {title == 'craigslist: madison classifieds for jobs, apartments, personals, for sale, services, community, and events'}
        searchBox {$('input#query')}
        searchButton {$('input#go')}
        dropdown {$('select', name:'catAbb')}
        // workaround for getting the selected text from the dropdown....
        dropdownSelectedText {dropdown.find('option', value:dropdown.value()).text()}
    }

    def searchFor(textString) {
        searchBox = textString
        searchButton.click()
    }
}
