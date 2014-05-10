package pages

import geb.Page
import modules.CheckboxModule

/**
 * Created by qualityshepherd on 5/8/14.
 */
class AngularInputPage extends Page {
    static url = "https://docs.angularjs.org/examples/example-checkbox-input-directive/"
    static at = {title =~ "example-checkbox-input"}
    static content = {
        checkbox1 {module CheckboxModule, $("input", "ng-model":"value1")}
        checkbox2 {module CheckboxModule, $("input", "ng-model":"value2")}
    }
}
