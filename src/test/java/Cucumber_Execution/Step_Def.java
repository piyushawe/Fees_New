package Cucumber_Execution;

import Log4jpackage.LoggerClass;
import Webdriver_Support.Locators;
import Webdriver_Support.WebDriverInitialization;
import Webdriver_Support.Utility;
import Webdriver_Support.WebDriverMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Step_Def implements Locators {
    private Step_Def sd;
    @FindBy(how=How.ID,using = "txtUserName")
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
    /**
     **/
    @Given("^Go to the url$")
    public void go_to_the_url(){
        Utility.getdesiredframe(new StringBuilder(defineremark));
        if(Utility.desiredframe)
        {}
        else{
        sd=PageFactory.initElements(WebDriverInitialization.returnDriver(),Step_Def.class);
        LoggerClass.log_info.debug("Currently is Background");
        WebDriverMethods.gotToUrl(RunnerFile.global_url);
        WebDriverMethods.pageLoad(Utility.propertyfilereader(messagefilepath,new StringBuilder("login_title")));
        }
    }

    @When("^Enter the username$")
    public void enter_the_username(){
        if(Utility.desiredframe){}
        else {
            try {
                WebDriverMethods.sendText(sd.username, new StringBuilder(RunnerFile.global_username));
            } catch (TimeoutException e) {
                LoggerClass.log_info.debug(Utility.propertyfilereader(messagefilepath, new StringBuilder("pageloadingmessage")));
                LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
                WebDriverInitialization.returnDriver().quit();
                System.exit(-2);
            } catch (NoSuchElementException e) {
                WebDriverInitialization.returnDriver().quit();
                System.exit(-2);
            }
        }
    }

    @When("^Enter the password$")
    public void enter_the_password(){
        if(Utility.desiredframe)
        {}
        else {
            try {
                WebDriverMethods.sendText(sd.password, new StringBuilder(RunnerFile.global_password));
            } catch (NoSuchElementException e) {
                WebDriverInitialization.returnDriver().quit();
                System.exit(-2);
            }
        }
    }

    @Then("^Click on login button$")
    public void click_on_login_button(){
        if(Utility.desiredframe)
        { }
        else {
            try {
                WebDriverMethods.click(sd.loginbutton);
            } catch (NoSuchElementException e) {
                WebDriverInitialization.returnDriver().quit();
                System.exit(-2);
            }
        }
    }

    @Then("^Click on the fees button$")
    public void click_on_the_fees_button(){
        if(Utility.desiredframe)
        {}
        else{
        Utility.getwindow();
        if (Utility.desiredwindow) {
        }else{
            try {
                WebDriverMethods.click(sd.feesbutton);
            }
            catch (NoSuchElementException e)
            {
                WebDriverInitialization.returnDriver().quit();
                System.exit(-2);
            }
        }

    }
    }
    @Then("^Go to the left navigation panel and click on Global Master$")
    public void go_to_the_left_navigation_panel_and_click_on_Global_Master(){
        if(Utility.desiredframe){}
        else {
            Actions ac = new Actions(WebDriverInitialization.returnDriver());
            ac.moveToElement(WebDriverInitialization.returnDriver().findElement(By.xpath("//div[@role='navigation']"))).perform();
            WebDriverInitialization.returnDriver().findElement(By.xpath("//span[text()='Global Masters']")).click();
            WebDriverInitialization.returnDriver().findElement(By.xpath("//span[text()='Define Remark']")).click();
        }

    }

    @Then("^Click on Define Remark menu$")
    public void click_on_Define_Remark_menu(){
        // Write code here that turns the phrase above into concrete actions

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
