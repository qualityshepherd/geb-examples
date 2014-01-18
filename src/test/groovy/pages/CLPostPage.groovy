package pages

import geb.Page

/**
 * Created by qualityshepherd on 1/17/14.
 */
class CLPostPage extends Page {
    static at = {postingTitle}
    static content = {
        postingTitle {$('h2.postingtitle')}
    }

}
