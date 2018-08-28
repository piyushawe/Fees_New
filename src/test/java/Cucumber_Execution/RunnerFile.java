package Cucumber_Execution;

import Log4jpackage.LoggerClass;
import Webdriver_Support.WebDriverInitialization;
import Webdriver_Support.Utility;
import Webdriver_Support.WebDriverMethods;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.formatter.Formatter;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.StepDefinitionMatch;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


import static Webdriver_Support.Locators.messagefilepath;


/**
 * Unit test for simple WebDriverInitialization.
 */

@CucumberOptions(
        features = {"src/test/Feature"},
        glue = {"Cucumber_Execution"},
       /* plugin= {"pretty","html:target/cucumber_html_report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},*/
        plugin={"pretty","html:/reports\\cucumber-pretty",
                "json:/Reports\\cucumber.json",
                "Cucumber_Execution.Custom_Formatter"
                },
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
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest logger;
    private ExtentTest scenariotest;
    private ExtentTest steptest;
    private static RunnerFile sd;
    private static StringBuilder sct;
    private Boolean flag=true;
    private StringBuilder duplicatefeaturename;
    private String step;
    @Before
    public void getScenario(Scenario scenario)
    {
        LoggerClass.log_info.debug("Currently getting scenario name");
        sct=new StringBuilder(scenario.getName());
    }
    public void beforeStep()
    {

    }
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
       htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/Test.html");
       reports=new ExtentReports();
       reports.attachReporter(htmlReporter);
       htmlReporter.setAppendExisting(true);
       reports.setSystemInfo("Host Name", "MyTest");
       reports.setSystemInfo("Environment", "SIT");
       reports.setSystemInfo("User Name", "Peter Wong");
       htmlReporter.config().setDocumentTitle("Automation_Report");
       htmlReporter.config().setReportName("Automation_Report_1");
       htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
       htmlReporter.config().setTheme(Theme.STANDARD);
   }

   @DataProvider(name="getscenario")
    public Object[][] getdata()
   {
       return testing.provideScenarios();
   }

   @Test(dataProvider = "getscenario")
    public void getscen(PickleEventWrapper pickle, CucumberFeatureWrapper cf) throws Throwable {
       testing.runScenario(pickle.getPickleEvent());
       StringBuilder featurname=new StringBuilder(pickle.getPickleEvent().uri);
       featurname=new StringBuilder(featurname.toString().substring(featurname.lastIndexOf("/")+1,featurname.indexOf(".feature")));
       if(flag)
       {
           duplicatefeaturename=featurname;
         flag=false;
         logger = reports.createTest(featurname.toString());
       }
       if(!(featurname.toString().equalsIgnoreCase(duplicatefeaturename.toString())))
       {
           duplicatefeaturename=featurname;
           logger = reports.createTest(featurname.toString());
       }
       scenariotest=logger.createNode(sct.toString());
       steptest=scenariotest.createNode(Thread_Local.get().getStepText());
       steptest.log(Status.PASS, MarkupHelper.createLabel(Thread_Local.get().getStepText(), ExtentColor.GREEN));
//       steptest=scenariotest.createNode(Thread_Local.get().getStepText());
//       steptest.log(Status.PASS, MarkupHelper.createLabel(Thread_Local.get().getStepText(), ExtentColor.GREEN));
       //scenariotest.log(Status.PASS,MarkupHelper.createLabel(Thread_Local.get().getStepText(),ExtentColor.GREEN));

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
       reports.flush();
       WebDriverInitialization.returnDriver().quit();
       Utility.desiredframe=false;
   }


}
