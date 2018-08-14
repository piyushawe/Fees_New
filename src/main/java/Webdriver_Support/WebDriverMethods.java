package Webdriver_Support;

import org.openqa.selenium.WebElement;

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
  element.sendKeys(entertext);
}
static public void click(WebElement element)
{
  element.click();
}
}

