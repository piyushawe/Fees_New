package Fees_New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{  private static WebDriver web;
    private App()
    {
    }
   static public void intiliazedriver(String Browser)
    {
       if(Browser.equalsIgnoreCase("chrome"))
       {
           System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
           web=new ChromeDriver();
       }
       if(Browser.equalsIgnoreCase("firefox"))
       {
           System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.21.0-win64\\geckodriver.exe");
           web=new FirefoxDriver();
       }

    }
    static public WebDriver returnDriver()
    {
        return web;

    }
}
