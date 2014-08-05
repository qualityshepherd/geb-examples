package pages

import geb.Page

class CLMainPage extends Page {
    static url = 'http://madison.craigslist.org/'
    static at = {title =~ "craigslist: madison"}
    static content = {
        searchBox {$("input#query")}
        searchButton {$("input#go")}
        dropdown {$("select#catAbb")}
        // workaround for getting the selected text from the dropdown....
        dropdownSelectedText {dropdown.find('option', value:dropdown.value()).text()}
    }

    def searchFor(textString) {
        searchBox = textString
        searchButton.click()
    }
}
