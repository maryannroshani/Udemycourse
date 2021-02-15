import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 {
 ExtentReports extent;

 By Username = By.xpath("");

 @BeforeTest
           public void config(){
    //ExtentReports, ExtentSparkReporter
    String path = System.getProperty("user.dir") + "/target/index.html";

    ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
    reporter.config().setReportName("Automation Results");
    reporter.config().setDocumentTitle("Test Results");
    extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester", "Maryann Roshani");
   }

   @Test
    public void Demo() {
//create driver object
       //System.out.println("hello");
               ExtentTest test = extent.createTest("Demo");

               System.setProperty("webdriver.chrome.driver","/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get("http://google.com");
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
                driver.get("http://yahoo.com");
                driver.navigate().back();
                System.out.println(driver.getTitle());
                driver.close();
    }

    @Test
    public void Demo2(){
        //System.out.println("bye");

    }

    @AfterTest
    public void tearUp () {
     extent.flush();
    }
}
