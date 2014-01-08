import geb.Browser

Browser.drive {
    go('http://translate.google.com/')
    $('div#gt-sl-gms').click()
    $('div.goog-menuitem-content', text:'Norwegian').click()

    $('textarea#source') << 'ost'

    waitFor {
        $('span#result_box').text() == 'cheese'
    }

    quit()
}
