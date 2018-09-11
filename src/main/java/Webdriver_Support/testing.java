package Webdriver_Support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testing {
    public static void main(String[] args)
    {
        WebDriver web;
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        web = new ChromeDriver();
        web.manage().window().maximize();
        web.navigate().to("http://qaerp.franciscanecare.net/Secure/default.aspx");
        web.findElement(By.id("txtUserName")).sendKeys("admin");
        web.findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");
        web.findElement(By.id("btnLogin")).click();
        web.findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
        web.close();
        web.close();
       // web.quit();
    }

}
