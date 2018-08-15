package Webdriver_Support;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class WebDriverMethods implements Locators {
static public void maximizeWindow()
{
    WebDriverInitialization.returnDriver().manage().window().maximize();
}
static public void gotToUrl(String url)
{
    WebDriverInitialization.returnDriver().navigate().to(url);
}
static public void sendText(WebElement element,StringBuilder entertext) throws NoSuchElementException
{
    WebdriverWaits.explicitWait_ElementToBeClickable(element);
    element.sendKeys(entertext);
}
static public void click(WebElement element) throws NoSuchElementException
{
    WebdriverWaits.explicitWait_ElementToBeClickable(element);
    element.click();
}
static public void pageLoad()
{
        WebDriverInitialization.returnDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
}}

