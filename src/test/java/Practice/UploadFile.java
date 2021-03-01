package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {

    String URL = "https://altoconvertpdftopng.com/";
    @Test
    public void testUpload() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        WebElement element = driver.findElement(By.xpath("//button[@id='dropzoneInput-label']"));
        element.click();
        uploadFile("/Users/maryannroshani/Desktop/QA John.pdf");
        Thread.sleep(2000);
    }

    /**
     * This method will set any parameter string to the system's clipboard.
     */
    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static void uploadFile(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(90);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
