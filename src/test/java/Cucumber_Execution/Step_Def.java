package Cucumber_Execution;

import Log4jpackage.LoggerClass;
import Webdriver_Support.WebDriverInitialization;
import Webdriver_Support.Utility;
import Webdriver_Support.WebDriverMethods;
import cucumber.api.java.en.Given;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Step_Def {
    private Step_Def sd;
    @FindBy(how=How.ID,using = "txtUserNam")
    @CacheLookup
    private WebElement username;

    @FindBy(how=How.ID,using = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(how = How.ID,using = "btnLogin")
    @CacheLookup
    private WebElement loginbutton;

    @Given("^opening toolsqa$")
    public void opening_toolsqa() throws Throwable {
        sd=PageFactory.initElements(WebDriverInitialization.returnDriver(),Step_Def.class);
        LoggerClass.log_info.debug("Currently is Background");
        WebDriverMethods.gotToUrl(RunnerFile.global_url);
        WebDriverMethods.pageLoad();
        try {
            WebDriverMethods.sendText(sd.username, new StringBuilder(RunnerFile.global_username));
            WebDriverMethods.sendText(sd.password,new StringBuilder(RunnerFile.global_password));
            WebDriverMethods.click(sd.loginbutton);
        }
        catch (TimeoutException e)
        {
            LoggerClass.log_info.debug("Page loading has taken more than 120 seconds");
            LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
            WebDriverInitialization.returnDriver().quit();
            System.exit(-2);
        }catch (NoSuchElementException e)
        {
            WebDriverInitialization.returnDriver().quit();
            System.exit(-2);
        }
        Utility.getwindow();
        if (Utility.desiredwindow) {
        }else{
            Thread.sleep(4000);
            WebDriverInitialization.returnDriver().findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
        }
    }
    @Given("^intilize brow$")
    public void intilize_brow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is firefox");

    }
    @Given("^open tools qa$")
    public void open_tools_qa() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is chrome");
    }
    @Given("^do testing$")
    public void do_testing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is Do Testing");
    }

    @Given("^doing testing$")
    public void doing_testing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is Doing Testing");
    }

}
