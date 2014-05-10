import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Created by qualityshepherd on 4/26/14.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses([
    CLSearchSpec.class,
    MoodleSandboxLoginSpec.class,
    WikipediaRecentChangesSpec.class,
    AngularTest.class,
])

public class TestSuite {
}
