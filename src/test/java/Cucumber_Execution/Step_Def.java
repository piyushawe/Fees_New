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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Step_Def implements Locators {
    public static SoftAssert sc=new SoftAssert();
    @FindBy(how=How.XPATH,using = "//ul[@id='side-menu']")
    private WebElement navigationleftpanel;

    @FindBy(how=How.XPATH,using = "//span[text()='Global Masters']")
    private WebElement Globalmaster;

    @FindBy(how =How.XPATH,using = "//span[text()='Define Remark']")
    private WebElement Defineremark;

    private static Step_Def sd;
    static
    {
        sd=PageFactory.initElements(WebDriverInitialization.returnDriver(),Step_Def.class);

    }
    /**
     **/
    @Then("^Go to the left navigation panel$")
    public void go_to_the_left_navigation_panel() throws InterruptedException {

        Utility.getwindow();
        WebDriverMethods.action_MoveToElement_Click(sd.navigationleftpanel,false);
    }

    @Given("^Click on Global Master$")
    public void click_on_Global_Master() throws Throwable {
        WebDriverMethods.action_MoveToElement_Click(sd.Globalmaster,true);
    }

    @Then("^Click on Define Remark menu$")
    public void click_on_Define_Remark_menu(){
        WebDriverMethods.action_MoveToElement_Click(sd.Defineremark,true);
    }
    @Given("^intilize brow$")
    public void intilize_brow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is firefox");

    }
    @Given("^open tools qa$")
    public void open_tools_qa() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //sc.assertEquals(1,2);
        //Assert.assertEquals(1,2);
        System.out.println("This is chrome");
    }
    @When("^openji$")
    public void openji() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //WebDriverInitialization.returnDriver().findElement(By.)
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
