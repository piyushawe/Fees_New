package Webdriver_Support;

import Log4jpackage.LoggerClass;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebdriverWaits {
   private static WebDriverWait wait;
   /**
    * This static block use to WebDriverWait class */
    static {
      wait  =new WebDriverWait(WebDriverInitialization.returnDriver(),10);
    }
    /**
     * This hmethod use to check visibility of element, will check only if element visible or not in DOM   */
    static public void explicitWait_visbilityCheck(WebElement element)
    {
     try{   wait.until(ExpectedConditions.visibilityOf(element));
    }
    catch (TimeoutException e)
    {
        LoggerClass.log_info.debug("Element is not visible under set time period");
        LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
    }
    }
//    static public void explicitWait_visbilityAndPresenceCheck(WebElement element)
//    {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//
//    }
    /**
     *  */
    static public void explicitWait_AlertPresent()
    {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        }
        catch (TimeoutException e)
        {
            LoggerClass.log_info.debug("Alert is not present under set time period");
            LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));

        }    }
    static public void explicitWait_TextToBePresentInElement(WebElement element, StringBuilder text)
    {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text.toString()));
        }
        catch (TimeoutException e)
        {
            LoggerClass.log_info.debug("Text is not available under set time period");
            LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
        }
    }
    static public void explicitWait_CheckTitle(StringBuilder title)
    {
        try {
            wait.until(ExpectedConditions.titleIs(title.toString()));
        }
        catch (TimeoutException e)
        {
            LoggerClass.log_info.debug("Title is not present under set time period or Page has been changed" +title);
            LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
        }
    }
    static public void explicitWait_ElementToBeClickable(WebElement element)
    {
       try {
           wait.until(ExpectedConditions.elementToBeClickable(element));
       }
       catch (TimeoutException e)
       {
           LoggerClass.log_info.debug("Element is either not clickable or not available under set time period");
           LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
       }
    }
    static public void explicitWait_ElementToBeSelected(WebElement element)
    {
        try {
            wait.until(ExpectedConditions.elementToBeSelected(element));
        }
        catch (TimeoutException e)
        {
            LoggerClass.log_info.debug("Element is either not selected or not available under set time period");
            LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));

        }    }
    static public void explicitWait_InvisibilityOf(WebElement element)
    {
        wait.until(ExpectedConditions.invisibilityOf(element));

    }
    static public void explicitWait_VisibilityOf(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
