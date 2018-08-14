package Webdriver_Support;

import Log4jpackage.LoggerClass;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaits {
   private static WebDriverWait wait;
    static {
      wait  =new WebDriverWait(WebDriverInitialization.returnDriver(),10);
    }
    static public void explicitWait_visbilityCheck(WebElement element)
    {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    static public void explicitWait_AlertPresent()
    {
       wait.until(ExpectedConditions.alertIsPresent());
    }
    static public void explicitWait_TextToBePresentInElement(WebElement element, StringBuilder text)
    {
        wait.until(ExpectedConditions.textToBePresentInElement(element,text.toString()));

    }
    static public void explicitWait_CheckTitle(StringBuilder title)
    {
      wait.until(ExpectedConditions.titleIs(title.toString()));
    }
    static public void explicitWait_ElementToBeClickable(WebElement element)
    {
       try {
           wait.until(ExpectedConditions.elementToBeClickable(element));
       }
       catch (TimeoutException e)
       {
           LoggerClass.log_info.debug("Element is not clickable under set time period");
           LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));

       }
    }
    static public void explicitWait_ElementToBeSelected(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    static public void explicitWait_InvisibilityOf(WebElement element)
    {
        wait.until(ExpectedConditions.invisibilityOf(element));

    }
    static public void explicitWait_VisibilityOf(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
