package Webdriver_Support;

import Log4jpackage.LoggerClass;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class duplicate_web {


    /**
     * Singelton class */
        private static WebDriver web;
        /**
         * Private constructor to restrict outside object creation and allows to create single object*/
        private duplicate_web() {
        }
        /**
         *@param Browser Tells on which browser execution will takes place,and initialize corresponding browser driver
         *This method instructs which lo4j.xml to use for logging the log
         * */
        static public void initializedriver(String Browser) {
            DOMConfigurator.configure("Log4j.xml");
            switch (Browser.toLowerCase()) {
                case "chrome": {
                    try{
                        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
                        web = new ChromeDriver();
                        WebDriverMethods.maximizeWindow();
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
                        System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
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
        /**This method use to get the webdriver reference and this same reference will use in whole project */
        static public WebDriver returnDriver()
        {
            return web;
        }

    }

