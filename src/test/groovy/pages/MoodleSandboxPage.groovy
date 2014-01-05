package pages

import geb.Page

class MoodleSandboxPage extends Page {
    static url = 'http://demo.moodle.net/?lang=en'
    static at = {pageHeader}
    static content = {
        pageHeader {$('h1', text:'Moodle sandbox')}
        loggedInAs {$('div.logininfo a',0)}
        navbarButton(required:false) {$('a.btn-navbar')}

        // login form...
        usernameField {$('input#login_username')}
        passwordField {$('input#login_password')}
        logInButton {$('input', value:'Log in')}
    }

    def loginToMoodleSandbox(username, password) {
        usernameField << username
        passwordField << password
        logInButton.click()
    }

    def loginToMoodleSandboxAs(userMap) {
        loginToMoodleSandbox(userMap.username, userMap.password)
    }

    // if browser window is < 980px wide, login detals are toggled by navbar button...
    def clickNavbarButtonIfExists() {
        if(navbarButton.displayed) {
            navbarButton.click()
        }
    }
}
