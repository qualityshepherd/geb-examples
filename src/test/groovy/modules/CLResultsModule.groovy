package modules

import geb.Module

/**
 * Created by qualityshepherd on 1/10/14.
 */
class CLResultsModule extends Module {
    static content = {
        star {$('span.star')}
        date {$('span.date').text()}
        title {$('span.pl a')}
        price(required:false) {$('span.l2 span.price').text()}
        location(required:false) {$('span.pnr small').text()}
        pic(required:false) {$('span.p')}
        map(required:false) {$('a.maptag')}
        catagory {$('a.gc')}
    }
}
