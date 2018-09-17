package Webdriver_Support;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testing {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        List list=new ArrayList();
        list.add(10);
        list.add(10);

        /*WebDriver web;
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        web = new ChromeDriver();
        web.manage().window().maximize();
        web.navigate().to("http://qaerp.franciscanecare.net/Secure/default.aspx");
        web.findElement(By.id("txtUserName")).sendKeys("admin");
        web.findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");
        web.findElement(By.id("btnLogin")).click();
        web.findElement(By.xpath("//a[@href='/FeeManagement/Default.aspx']")).click();
        //web.close();
        //web.close();
        // web.quit();
        JavascriptExecutor js = (JavascriptExecutor) web;
        js.executeAsyncScript("alert('hello');");
        Thread.sleep(5000);
        //web.switchTo().alert().accept();
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);*/
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
    }
}
