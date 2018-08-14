package Webdriver_Support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WebDriverMethods implements Locators {
static public void maximizeWindow()
{
    WebDriverInitialization.returnDriver().manage().window().maximize();
}
static public void gotToUrl(String url)
{
    WebDriverInitialization.returnDriver().navigate().to(url);
}
static public void sendText(WebElement element,StringBuilder entertext)
{
    WebdriverWaits.explicitWait_ElementToBeClickable(element);
    element.sendKeys(entertext);
}
static public void click(WebElement element)
{
  element.click();
}
static public void pageLoad()
{
        WebDriverInitialization.returnDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
}}

