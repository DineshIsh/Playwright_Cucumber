package runner;




import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;




//@RunWith(Cucumber.class)  // if we have testng extention for parallel execution  we need to remove
@CucumberOptions(
        features = "src/test/resources/Features",      // Path to your .feature files
        glue = {"StepDefinition"}, // Package containing step definitions
       /* tags = "@test1",  // ✅ Only run scenarios with @test1 or @test2*/
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        },
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

        // Enable parallel execution of scenarios
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}


