package Webdriver_Support;



import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testing {
    static WebDriver driver=null;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://siteportalstg.medavante.net");
        driver.findElement(By.id("WebLogin_UserName")).sendKeys("AT_Test3");
        driver.findElement(By.id("Password")).sendKeys("#tester5");
        driver.findElement(By.id("WebLogin_Login")).click();
        driver.findElement(By.xpath("//span[@class='dashboard-tile-name' and text()='Central Ratings']")).click();

}
//    ExtentReports extentReports=null;
//    //ExtentHtmlReporter extentHtmlReporter=null;
//    WebDriver driver=null;
//    ExtentTest extentTest=null;
//    ExtentTest extentTest1=null;
//    StringBuilder stringBuilder=new StringBuilder();
//    @BeforeMethod
//    public void before(Method method)
//    {
//        extentReports=new ExtentReports("E:\\Reports.html",false);
//        extentTest=extentReports.startTest(method.getName());
////        extentReports.attachReporter(extentHtmlReporter);
////        extentTest=extentReports.createTest(method.getName());
//    }
//    @BeforeClass
//    public void beforeclass()
//    {
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://siteportalstg.medavante.net");
////        extentHtmlReporter=new ExtentHtmlReporter("E:\\Reports.html");
////        extentHtmlReporter.setAppendExisting(true);
//    }
//
//@Test
//    public void userLogin()
//{
//    extentTest.log(LogStatus.PASS,"Enter User Name");
//    driver.findElement(By.id("WebLogin_UserName")).sendKeys("test_ci1");
//    extentTest.log(LogStatus.PASS,"Password");
//    driver.findElement(By.id("Password")).sendKeys("#2Pencil");
//    extentTest.log(LogStatus.PASS,"Click On Login Button");
//    driver.findElement(By.id("WebLogin_Login")).click();
//}
//
//@Test
//    public void userLogout()
//{
//    extentTest.log(LogStatus.PASS,"Click On Logout Button");
//    driver.findElement(By.className("btn logout")).click();
//}
//
//@AfterMethod
//    public void after(ITestResult iTestResult)
//{
//    if(iTestResult.getStatus()==ITestResult.FAILURE)
//    {
//        extentTest.log(LogStatus.FAIL,"This Step is Failed");
//    }
//    extentReports.flush();
//    extentReports=null;
//}

//    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
//       // String name="piyush";
//        StringBuilder name=new StringBuilder("piyush");
//        Thread.sleep(10000);
//        for(int i=1;i<1000;i++)
//        {
//            System.out.println(name+"_"+i);
//        }
//        List list=new ArrayList();
//        list.add(10);
//        list.add(10);
//        WebDriver web;
//        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
//        web = new ChromeDriver();
//        web.manage().window().maximize();
//        web.navigate().to("https://siteportalstg.medavante.net/admin#/manage/organizations/1929e8a8-3c55-41b8-aa9b-54b98171c6c9/general");
//        web.findElement(By.id("WebLogin_UserName")).sendKeys("test_ci1");
//        web.findElement(By.id("Password")).sendKeys("#2Pencil");
//        web.findElement(By.id("WebLogin_Login")).click();

     //   web.findElement(By.xpath("//button[@type='button']")).click();
//JavascriptExecutor js =(JavascriptExecutor)web;
//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        Robot rb=new Robot();
//        rb.keyPress(KeyEvent.VK_ENTER);
        //web.findElement(By.id("txtUserName")).sendKeys("admin");
//        JavascriptExecutor ja=(JavascriptExecutor)web;
//        ja.executeScript("document.getElementById('txtUserName').value='admin'");
//        web.findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");
//        web.findElement(By.id("btnLogin")).click();
//        web.findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
        //web.close();
        //web.close();
        // web.quit();
//        JavascriptExecutor js = (JavascriptExecutor) web;
//        js.executeAsyncScript("alert('hello');");
//        Thread.sleep(5000);
//        //web.switchTo().alert().accept();
//        Robot r = new Robot();
//        r.keyPress(KeyEvent.VK_ENTER);
        // FileInputStream fl = new FileInputStream("E:\\testingdatahashmap.xlsx");
        //FileInputStream fw=new FileInputStream("E:\\testingwrite.xlsx");
        //Workbook ww=new XSSFWorkbook(fw);
//        Workbook wb = new XSSFWorkbook(fl);
//        Sheet sh = wb.getSheetAt(0);
//        Map<String, Map<String,String>> supermap=new HashMap<>();
//        Map<String,String> mymap=new HashMap<>();
        //Sheet sw=ww.getSheetAt(0);
        //List outer=new ArrayList();
        //List list=null;
        //for (int i = 0; i <= sh.getLastRowNum(); i++) {
        //list = new ArrayList();
        //Row rw = sh.getRow(i);
        //String key=rw.getCell(0).getRichStringCellValue().toString();
        //Row rr=sw.createRow(i);
        //for (int j = 1; j < rw.getLastCellNum(); j++) {
        // try {
        // Cell cl = rw.getCell(j);
        // switch (cl.getCellType()) {
        // case NUMERIC:
        //mymap.put(key,cl.getNumericCellValue())
        //list.add(cl.getNumericCellValue());
//                            Cell c=rr.createCell(j);
//                            c.setCellType(CellType.NUMERIC);
//                            c.setCellValue(cl.getNumericCellValue());
        //   break;
        //   case STRING:
        // mymap.put(key,cl.getRichStringCellValue().getString());
        //list.add(cl.getRichStringCellValue());
//                            Cell cs=rr.createCell(j);
//                            cs.setCellType(CellType.STRING);
//                            cs.setCellValue(cl.getRichStringCellValue());
        //   break;
        //  }

//                }catch (NullPointerException e)
//                {
//
//                }
//            }
//            supermap.put("MasterData",mymap);
//         //outer.add(list);
//        }
//        FileOutputStream fo=new FileOutputStream("E:\\testingwrite.xlsx");
//        ww.write(fo);
//        fo.close();
        //System.out.println(outer);
//        System.out.println(supermap);
//    }
  //  }
}
