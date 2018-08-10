package Webdriver_Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class WebDriverInitialization {
    private static WebDriver web;

    private WebDriverInitialization() {
    }

    static public void intiliazedriver(String Browser) {
        switch (Browser.toLowerCase()) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "D:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
                web = new ChromeDriver();
                break;
            }
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", "D:\\selenium drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
                web = new FirefoxDriver();
                break;
            }
            default:
            {
                System.exit(-2);

            }
        }

        static public WebDriver returnDriver ()
        {
            return web;

        }
    }
}
