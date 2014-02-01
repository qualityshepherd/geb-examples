package modules

import geb.Module

/**
 * Created by qualityshepherd on 2/1/14.
 */
class CheckboxModule extends Module {
    def check() {
        this.value(true)
    }

    def uncheck() {
        this.value(false)
    }

    def isUnchecked() {
        this.value() == false
    }

    def isChecked() {
        !isUnchecked()
    }
}
