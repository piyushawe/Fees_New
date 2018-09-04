package Webdriver_Support;

import Cucumber_Execution.Step_Def;
import org.testng.IExecutionListener;

public class Listeners implements IExecutionListener {
    @Override
    public void onExecutionStart() {

    }
/**
 *This method invoke just before JVM closing and it zip the file and send to intended users with attachments */
    @Override
    public void onExecutionFinish() {
      //  Utility.converToZip();
       // Utility.sendReportWithAttachment();
        Step_Def.sc.assertAll();
    }
}
