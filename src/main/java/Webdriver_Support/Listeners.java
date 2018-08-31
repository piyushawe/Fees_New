package Webdriver_Support;

import org.testng.IExecutionListener;

public class Listeners implements IExecutionListener {
    @Override
    public void onExecutionStart() {

    }

    @Override
    public void onExecutionFinish() {
        Utility.converToZip();
        Utility.sendReportWithAttachment();
    }
}
