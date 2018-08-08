package Fees_New;

import cucumber.api.java.en.Given;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Step_Def {
    @Given("^opening toolsqa$")
    public void opening_toolsqa() throws Throwable {
        //App.returnDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is Background");
        //App.returnDriver().navigate().to("http://toolsqa.com/automation-practice-form/");
        App.returnDriver().navigate().to("http://qaerp.franciscanecare.net/Secure/default.aspx");
        App.returnDriver().findElement(By.id("txtUserName")).sendKeys("admin");
        App.returnDriver().findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");
        Thread.sleep(2000);
        App.returnDriver().findElement(By.id("btnLogin")).click();
        //App.returnDriver().findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
        Utility.getwindow();
        if (Utility.desiredWindow) {

        }else{
            Thread.sleep(4000);
            App.returnDriver().findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
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

}
