package Fees_New;

import gherkin.lexer.Ar;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;


public class Utility {
static boolean desiredWindow=false;
   static public void getwindow()
    {
      ArrayList window=new ArrayList<>(App.returnDriver().getWindowHandles());
        Iterator it =window.iterator();
        while(it.hasNext())
        {
            String s=(String)it.next();
            if(App.returnDriver().switchTo().window(s).getTitle().equalsIgnoreCase("Fees"))
            {
                desiredWindow=true;
                break;
            }
        }

    }
}
