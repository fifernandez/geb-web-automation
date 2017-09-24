package pages

import geb.Page

class GoogleHomePage extends Page {

    static url = "http://www.google.com"

    static content = {

        entrarButton  (wait: true, required: false) { $('a', text: "Log in") }
        username  (wait: true, required: false) { $('input', name: "username") }
        password  (wait: true, required: false) { $('input', name: "password") }


        log  (wait: true, required: false) { $('a', class: "_aj7mu _taytv _ki5uo _o0442") }


    }

    void secondClick(){
        $('button', text: "Log in").click()
    }

}
