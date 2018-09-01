package Webdriver_Support;

import Log4jpackage.LoggerClass;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Utility implements Utility_Int {
static public boolean desiredframe=false;
static private Utility util;
@FindBy(how=How.XPATH,using = "//iframe")
private List<WebElement> frames;
static
{
   util=PageFactory.initElements(WebDriverInitialization.returnDriver(),Utility.class);
}
   static public void getwindow()
    {
      ArrayList window=new ArrayList<>(WebDriverInitialization.returnDriver().getWindowHandles());
        Iterator it =window.iterator();
        while(it.hasNext())
        {
            String s=(String)it.next();
            if(WebDriverInitialization.returnDriver().switchTo().window(s).getTitle().equalsIgnoreCase("Fees"))
            {
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
    static public void getdesiredframe(StringBuilder framename)
    {
        Iterator it=util.frames.iterator();
     while (it.hasNext())
     {
         WebElement element=(WebElement)it.next();
         //System.out.println(element.getAttribute("name "));
         if(element.getAttribute("name").equalsIgnoreCase(framename.toString()))
         {
             WebDriverInitialization.returnDriver().switchTo().frame(element);
             desiredframe=true;
             break;
         }
     }
    }
    static public void converToZip()
    {
        System.out.println("zip");
     try(FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"/reports/MyZip.zip");
         FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"/reports/Test.html"))
     {
         ZipEntry ze=new ZipEntry("Test.html");
         ZipOutputStream zos=new ZipOutputStream(fo);
         zos.putNextEntry(ze);
         byte[] buffer= Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/reports/Test.html"));

         zos.write(buffer,0,buffer.length);
         zos.closeEntry();
         zos.close();

     }catch (IOException e)
     {
       LoggerClass.log_error.error(ExceptionUtils.getStackTrace(e));
     }
    }
    static public void sendReportWithAttachment()
    {
            // Create object of Property file
            Properties prop=new Properties();
        // this will set host of server- you can change based on your requirement
            prop.put("mail.smtp.host","smtp.gmail.com");
        // set the port of socket factory
            prop.put("mail.smtp.socketFactory.port","465");
        // set socket factory
            prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        // set the authentication to true
            prop.put("mail.smtp.auth", "true");
        // set the port of SMTP server
        prop.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(prop,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("piyush.nautiyal@franciscansolutions.in", "123456789");

                    }

                });

        try {

            // Create object of MimeMessage class
            Message message = new MimeMessage(session);

            // Set the from address
            message.setFrom(new InternetAddress("piyush.nautiyal@franciscansolutions.in"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("piyush.nautiyal@franciscansolutions.in"));

            // Add the subject link
            message.setSubject("Testing Subject");

            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText("PFA");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            String filename = System.getProperty("user.dir")+"/reports/MyZip.zip";

            // Create data source and pass the filename
            DataSource source = new FileDataSource(filename);

            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));

            // set the file
            messageBodyPart2.setFileName(filename);

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            multipart.addBodyPart(messageBodyPart2);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            LoggerClass.log_info.debug("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }
    }


