package Cucumber_Execution;

import Log4jpackage.LoggerClass;
import Webdriver_Support.WebDriverInitialization;
import Webdriver_Support.Utility;
import Webdriver_Support.WebDriverMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static Webdriver_Support.Locators.messagefilepath;


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
    @FindBy(how= How.ID,using = "txtUserName")
    @CacheLookup
    private WebElement username;

    @FindBy(how=How.ID,using = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(how = How.ID,using = "btnLogin")
    @CacheLookup
    private WebElement loginbutton;

    @FindBy(how=How.XPATH,using = "//a[@href='/FeeManagement/Default.aspx']")
    @CacheLookup
    private WebElement feesbutton;

    public static String global_url;
    public static String global_username;
    public static String global_password;
   private TestNGCucumberRunner testing;
    private static RunnerFile sd;
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

   }

   @BeforeClass(alwaysRun = true)
   public void openDesiredModule()
   {
       System.out.println("Opening desired module");
       sd= PageFactory.initElements(WebDriverInitialization.returnDriver(),RunnerFile.class);
       LoggerClass.log_info.debug("Currently is Background");
       WebDriverMethods.gotToUrl(global_url);
       WebDriverMethods.pageLoad(Utility.propertyfilereader(messagefilepath,new StringBuilder("login_title")));
       try {
           WebDriverMethods.sendText(sd.username, new StringBuilder(global_username));
       } catch (TimeoutException e) {
           LoggerClass.log_info.debug(Utility.propertyfilereader(messagefilepath, new StringBuilder("pageloadingmessage")));
           LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
           WebDriverInitialization.returnDriver().quit();
           System.exit(-2);
       } catch (NoSuchElementException e) {
           WebDriverInitialization.returnDriver().quit();
           System.exit(-2);
       }
       try {
           WebDriverMethods.sendText(sd.password, new StringBuilder(global_password));
       } catch (NoSuchElementException e) {
           WebDriverInitialization.returnDriver().quit();
           System.exit(-2);
       }
       try {
           WebDriverMethods.click(sd.loginbutton);
       } catch (NoSuchElementException e) {
           WebDriverInitialization.returnDriver().quit();
           System.exit(-2);
       }
           try {
               WebDriverMethods.click(sd.feesbutton);
               //WebDriverMethods.pageLoad(Utility.propertyfilereader(messagefilepath,new StringBuilder("Fees_Title")));
           }
           catch (NoSuchElementException e)
           {
               WebDriverInitialization.returnDriver().quit();
               System.exit(-2);
           }
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
       Utility.desiredframe=false;
   }
}
