package Cucumber_Execution;


import Log4jpackage.LoggerClass;
import Webdriver_Support.Locators;
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
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
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
/**
 * Listener is use to zip and mail the report */
@Listeners(Webdriver_Support.Listeners.class)
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

    public  String global_url;
    public  String global_username;
    public  String global_password;
    private TestNGCucumberRunner testing;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports reports;
    private static ExtentTest logger;
    private static ExtentTest scenariotest;
    private static ExtentTest steptest;
    private static RunnerFile sd;
    private static StringBuilder sct;
    private static Boolean flag=true;
    private static StringBuilder duplicatefeaturename;
    private static PickleEventWrapper globalpickle;
    /**
     * @param scenario  this parameter will get scenario on every scenario execution
     * <br>
     * This @Before will execute before every scenario and get the name of the same
     * <br>
     * It also provide all feature name and create test(Extent Report_V3) for different scenario
     * <br>
     * It also create node for each scenario
     * <br>
     * It also club all scenario of same feature in one test*/
    @Before
    public void getScenario(Scenario scenario)
    {
        LoggerClass.log_info.debug("Currently getting scenario name");
        sct=new StringBuilder(scenario.getName());
        StringBuilder featurename=new StringBuilder(globalpickle.getPickleEvent().uri);
        featurename=new StringBuilder(featurename.toString().substring(featurename.lastIndexOf("/")+1,featurename.indexOf(".feature")));
        if(flag)
        {
            duplicatefeaturename=featurename;
            flag=false;
            logger = reports.createTest(featurename.toString());
        }
        if(!(featurename.toString().equalsIgnoreCase(duplicatefeaturename.toString())))
        {
            duplicatefeaturename=featurename;
            logger = reports.createTest(featurename.toString());
        }
            scenariotest=logger.createNode(sct.toString());
    }
    /**
     *This annotation will execute after every step in feature file including background steps
     * <br>
     * It will create node for each step executed of a scenario */
    @AfterStep
    public void afterStep(Scenario scenario)
    {
        System.out.println(scenario.getStatus());
       // scenariotest.log(Status.PASS,MarkupHelper.createLabel(Thread_Local.get().getStepText(),ExtentColor.GREEN));
        //Thread_Local.get().
         //String status=scenario.getStatus().toString();
         if(Step_Def.stepstatus.equalsIgnoreCase("passed"))
        {
            scenariotest.log(Status.PASS,MarkupHelper.createLabel(Thread_Local.get().getStepText(),ExtentColor.GREEN));
        }
        if(Step_Def.stepstatus.equalsIgnoreCase("failed"))
        {
            scenariotest.log(Status.FAIL,MarkupHelper.createLabel(Thread_Local.get().getStepText(),ExtentColor.RED));
        }
        if(Step_Def.stepstatus.equalsIgnoreCase("skipped"))
        {
           scenariotest.log(Status.SKIP,MarkupHelper.createLabel(Thread_Local.get().getStepText(),ExtentColor.YELLOW));
        }
        //steptest=scenariotest.createNode(Thread_Local.get().getStepText());
       // steptest.getStatus();
        //steptest.log(Status.PASS, MarkupHelper.createLabel(Thread_Local.get().getStepText(), ExtentColor.GREEN));
        Step_Def.stepstatus="passed";
    }
    @After
    public void getStatus(Scenario scenario)
    {
//        if(scenario.isFailed())
//        {
//            scenariotest.fail(MarkupHelper.createLabel("scenario failed",ExtentColor.RED));
//        }
    }
    /**
     * @param browser will tell on which browser execution going to happen
     * <br>
     * This annotation will execute every time, doesn't depend on group because of alwaysRun=true */
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void getTheBroswer(@Optional("chrome") String browser)
   {
       WebDriverInitialization.initializedriver(browser);
   }
/**
 * @param url will get provide the url for testing
 * <br>
 * @param username will provide username for the url
 * <br>
 * @param password will provide password for the url
 * <br>
 * This annotation will execute every time, doesn't depend on group because of alwaysRun=true */
   @Parameters({"url","username","password"})
   @BeforeClass(alwaysRun = true)
   public void getcredential(String url,String username,String password)
   {
       global_url=url;
       global_username=username;
       global_password=password;

   }
/**
 * Here we have initialized pagefactory elements
 * <br>
 * It go to url, enter username and password,click login button,go to fees
 * <br>
 * This annotation will execute every time, doesn't depend on group because of alwaysRun=true*/
   @BeforeClass(alwaysRun = true)
   public void openDesiredModule()
   {
       System.out.println("Opening desired module");
       sd= PageFactory.initElements(WebDriverInitialization.returnDriver(),RunnerFile.class);
       LoggerClass.log_info.debug("Currently is Background");
       WebDriverMethods.gotToUrl(global_url);
       WebDriverMethods.pageLoad(Utility.propertyfilereader(Locators.messagefilepath,new StringBuilder("login_title")));
       try {
           WebDriverMethods.sendText(sd.username, new StringBuilder(global_username));
       } catch (TimeoutException e) {
           LoggerClass.log_info.debug(Utility.propertyfilereader(Locators.messagefilepath, new StringBuilder("pageloadingmessage")));
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
           }
           catch (NoSuchElementException e)
           {
               WebDriverInitialization.returnDriver().quit();
               System.exit(-2);
           }
   }
/**
 *This annotation will execute every time, doesn't depend on group because of alwaysRun=true
 * <br>
 *Here we initialize TestNGCucumberRunner,ExtentHtmlReporter,ExtentReports
 * <br>
 *Here set the environment info,also set the reports properties like documenttitle,reportname etc.*/
   @BeforeClass(alwaysRun=true)
   public void before()
   {
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
/**
 * This dataprovider provides list of scenarios */
   @DataProvider(name="getscenario")
    public Object[][] getdata()
   {
       return testing.provideScenarios();
   }
/**
 *Ths test method will execute each scenario it receives from dataprovider
 * <br>
 *The only purpose of PickleEventWrapper,CucumberFeatureWrapper interface are to be able to provide a custom toString()  */
   @Test(dataProvider = "getscenario")
    public void getscen(PickleEventWrapper pickle , CucumberFeatureWrapper cf) throws Throwable {
         globalpickle=pickle;
         testing.runScenario(pickle.getPickleEvent());
  }
    /**
     * Need to close window as for different test in testng.xml there is no need of previous windows and for parallel testing
     *      if i don't close window then getWindowsHandles method will might provide undesired output
     *<br>
     * flush() method of ExtentReports class is use to write all information of test to html reporter and it print after executing all @Test
     * execution
     */

   @AfterClass
    public void closeBrowser() {
       reports.flush();
       WebDriverInitialization.returnDriver().quit();
   }


}
