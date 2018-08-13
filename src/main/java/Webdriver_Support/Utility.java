package Webdriver_Support;

import java.util.ArrayList;
import java.util.Iterator;


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
}
