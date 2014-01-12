package modules

import geb.Module

/**
 * Created by qualityshepherd on 1/10/14.
 */
class CLResults extends Module {
    static content = {
        star {$('span.star')}
        date {$('span.date').text()}
        postTitle {$('a',1).text()}
        price(required:false) {$('span.price').text()}
        location {$('small').text()}
        pic(required:false) {$('span.p')}
        map(required:false) {$('a.maptag')}
        catagory {$('a.gc')}
    }
}
