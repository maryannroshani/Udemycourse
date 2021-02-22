package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties dataProp;


public WebDriver initializeDriver() throws IOException {

    dataProp = new Properties();
    FileInputStream dataPath = new FileInputStream("/Users/maryannroshani/Projects/Introduction/src/main/java/Resources/data.properties");
    dataProp.load(dataPath);
    String browserName = dataProp.getProperty("browser");

    if(browserName.equals("chrome"))
    {
        System.setProperty("webdriver.chrome.driver","/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        this.driver = new ChromeDriver();
    }
    else if(browserName.equals("firefox"))
    {
       // System.setProperty("webdriver.chrome.driver","/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
         this.driver = new FirefoxDriver();
    }
    else if (browserName.equals("IE"))
    {
        //System.setProperty("webdriver.chrome.driver","/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        this.driver = new InternetExplorerDriver();
    }

    this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return this.driver;
}
}
