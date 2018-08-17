package Webdriver_Support;

import Log4jpackage.LoggerClass;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;



public class Utility implements Utility_Int {
static public boolean desiredwindow=false;
   static public void getwindow()
    {
      ArrayList window=new ArrayList<>(WebDriverInitialization.returnDriver().getWindowHandles());
        Iterator it =window.iterator();
        while(it.hasNext())
        {
            String s=(String)it.next();
            if(WebDriverInitialization.returnDriver().switchTo().window(s).getTitle().equalsIgnoreCase("Fees"))
            {
                desiredwindow=true;
                break;
            }
        }

    }
    static public void takeScreenShot()
    {

    }
    static public void excelReading()
    {

    }
    static public StringBuilder propertyfilereader(String Filename, StringBuilder keyname)
    {
        StringBuilder value=null;
       try(BufferedReader b_reader=new BufferedReader(new FileReader(Filename)))
       {
           Properties prop=new Properties();
           prop.load(b_reader);
           value=new StringBuilder(prop.getProperty(keyname.toString()));
       }
       catch (IOException e)
       {
           LoggerClass.log_info.debug("Either I/O exception occurred or File not found");
           LoggerClass.log_error.error(ExceptionUtils.getStackTrace(e));
       }
       return value;
    }

}
