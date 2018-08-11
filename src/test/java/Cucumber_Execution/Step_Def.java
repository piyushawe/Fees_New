package Cucumber_Execution;

import Log4jpackage.LoggerClass;
import Webdriver_Support.WebDriverInitialization;
import Webdriver_Support.Utility;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

public class Step_Def {
    @Given("^opening toolsqa$")
    public void opening_toolsqa() throws Throwable {
        //WebDriverInitialization.returnDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        // Write code here that turns the phrase above into concrete actions
        LoggerClass.log_info.info("Currently is Background");
        //WebDriverInitialization.returnDriver().navigate().to("http://toolsqa.com/automation-practice-form/");
        WebDriverInitialization.returnDriver().navigate().to("http://qaerp.franciscanecare.net/Secure/default.aspx");
        WebDriverInitialization.returnDriver().findElement(By.id("txtUserName")).sendKeys("admin");
        WebDriverInitialization.returnDriver().findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");
        Thread.sleep(2000);
        WebDriverInitialization.returnDriver().findElement(By.id("btnLogin")).click();
        //WebDriverInitialization.returnDriver().findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
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
