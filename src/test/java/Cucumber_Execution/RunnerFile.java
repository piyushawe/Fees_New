package Cucumber_Execution;

import Webdriver_Support.WebDriverInitialization;
import Webdriver_Support.Utility;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;


/**
 * Unit test for simple WebDriverInitialization.
 */

@CucumberOptions(
        features = {"src/test/Feature"},
        glue = {"Cucumber_Execution"},
        plugin= {"pretty","html:target/cucumber_html_report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"}

)
public class RunnerFile
{
   private TestNGCucumberRunner testing;
   @Parameters("browser")
   @BeforeClass
   public void getTheBroswer(String browser)
   {
       WebDriverInitialization.intiliazedriver(browser);
   }
   @BeforeClass(alwaysRun=true)
   public void before()
   {
       System.out.println("This is Beforeclass");
       testing=new TestNGCucumberRunner(this.getClass());
   }

   @DataProvider(name="getscenario")
    public Object[][] getdata()
   {
       return testing.provideFeatures();
   }

   @Test(dataProvider = "getscenario",groups = "Positive")
    public void getscen(CucumberFeatureWrapper cf)
   {
       testing.runCucumber(cf.getCucumberFeature());
   }
   @AfterClass
    public void closeBrowser()
   {/* Need to close window as for different test in testng.xml there is no need of previous windows and for parallel testing
       if i don't close window then getWindowsHandles method will might provide undesired output

       desiredwindow flag is set to false to make sure for every test in testng.xml reset to default flag status
      */
       WebDriverInitialization.returnDriver().quit();
       Utility.desiredwindow=false;
   }
}
