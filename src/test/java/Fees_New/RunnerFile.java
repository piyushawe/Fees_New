package Fees_New;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;


/**
 * Unit test for simple App.
 */

@CucumberOptions(
        features = {"src/test/java/Fees_New/Login.feature"},
        glue = {"Fees_New"},
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
       App.intiliazedriver(browser);
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
   {
       App.returnDriver().quit();
       Utility.desiredWindow=false;
   }
}
