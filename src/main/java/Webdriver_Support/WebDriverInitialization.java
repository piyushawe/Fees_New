package Webdriver_Support;

import Log4jpackage.LoggerClass;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Hello world!
 *
 */
public class WebDriverInitialization {
    private static WebDriver web;

    private WebDriverInitialization() {
    }

    static public void intiliazedriver(String Browser) {
        DOMConfigurator.configure("Log4j.xml");
        switch (Browser.toLowerCase()) {
            case "chrome": {
                try{
                    System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
                    web = new ChromeDriver();
                    LoggerClass.log_info.debug("Code Currently in browser initialization");
                }
                catch (IllegalStateException e)
                {
                    LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
                    System.exit(-2);
                }
                break;
            }
            case "firefox": {
               try {
                   System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
                   web = new FirefoxDriver();
                   LoggerClass.log_info.debug("Code Currently in browser initialization");
               }catch (IllegalStateException e)
               {
                   LoggerClass.log_error.fatal(ExceptionUtils.getStackTrace(e));
                   System.exit(-2);
               }                break;
            }
            default: {
                LoggerClass.log_info.debug("There is no matched browser key");
                LoggerClass.log_error.fatal("There is no matched browser key");
                System.exit(-2);
            }
        }
    }
        static public WebDriver returnDriver()
        {
            return web;
        }

}
