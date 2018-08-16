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
        features = {"src/test/Feature/DefineRemark.feature"},
        glue = {"Cucumber_Execution"},
        plugin= {"pretty","html:target/cucumber_html_report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},
        monochrome = true
)
public class RunnerFile
{
    public static String global_url;
    public static String global_username;
    public static String global_password;
   private TestNGCucumberRunner testing;
   @Parameters("browser")
   @BeforeClass(alwaysRun = true)
   public void getTheBroswer(String browser)
   {
       WebDriverInitialization.initializedriver(browser);
   }

   @Parameters({"url","username","password"})
   @BeforeClass(alwaysRun = true)
   public void getcredential(String url,String username,String password)
   {
       global_url=url;
       global_username=username;
       global_password=password;

   }   @BeforeClass(alwaysRun=true)
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

   @Test(dataProvider = "getscenario")
    public void getscen(CucumberFeatureWrapper cf)
   {
       testing.runCucumber(cf.getCucumberFeature());
   }
    /**
     * Need to close window as for different test in testng.xml there is no need of previous windows and for parallel testing
     *      if i don't close window then getWindowsHandles method will might provide undesired output
     *<br>
     * desiredwindow flag is set to false to make sure for every test in testng.xml reset to default flag status
     */

   @AfterClass
    public void closeBrowser()
   {
       WebDriverInitialization.returnDriver().quit();
       Utility.desiredwindow=false;
   }
}
