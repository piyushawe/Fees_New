package Webdriver_Support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaits {

    static public void explicitWait_visbilityCheck(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(WebDriverInitialization.returnDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    static public void explicitWait_()
    {

    }
    static public void fluentWait()
    {

    }

}
