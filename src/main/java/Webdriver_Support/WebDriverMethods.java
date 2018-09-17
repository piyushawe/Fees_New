package Webdriver_Support;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class WebDriverMethods implements Locators {
    /**
     *This method use to maximize window*/
static public void maximizeWindow()
{
    WebDriverInitialization.returnDriver().manage().window().maximize();
}
/**
 *This method use to navigate to url */
static public void gotToUrl(String url)
{
    WebDriverInitialization.returnDriver().navigate().to(url);
}
/**
 * This method to enter text to text box */
static public void sendText(WebElement element,StringBuilder entertext) throws NoSuchElementException
{
    WebdriverWaits.explicitWait_ElementToBeClickable(element);
    element.sendKeys(entertext);
}
/**
 * This method use to click on element */
static public void click(WebElement element) throws NoSuchElementException
{
    WebdriverWaits.explicitWait_ElementToBeClickable(element);
    element.click();
}
/**
 *This method allow to set page timeout i.e page loading time */
static public void pageLoad(StringBuilder title)
{
        WebdriverWaits.explicitWait_CheckTitle(title);
        WebDriverInitialization.returnDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
}
/**
 *This method use to perform click operation on element using mouse hover  */
static public void  action_MoveToElement_Click(WebElement element, Boolean flag) {
    Actions ac = new Actions(WebDriverInitialization.returnDriver());
    if (flag) {
        ac.moveToElement(element).click().build().perform();
    } else {
        ac.moveToElement(element).perform();
    }
}
}

