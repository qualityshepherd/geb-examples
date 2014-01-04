import geb.Browser

// simple example that displays Geb/SafariDriver bug...
Browser.drive() {
    go 'http://madison.craigslist.org/'
    $('select', name:'catAbb').value('community')

    assert $('select', name:'catAbb').value() == 'ccc'
}
