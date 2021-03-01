package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class EcommerceApp {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.get("http://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        //assignment(driver);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //addItems(driver);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        fluentWait(driver);

    }

    public static void addItems(WebDriver driver)
    {
        //Check the name you extracted is in the array list or not
        String [] itemsNeeded = {"Brocolli" , "Cucumber", "Cauliflower", "Beetroot"};
//Explicitwait
        WebDriverWait explicitWait = new WebDriverWait(driver, 5);
        //convert array to array list
        List itemNeededList = Arrays.asList(itemsNeeded);

        List <WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i = 0; i<productNames.size(); i++)
        {
            //acutalname Brocolli - 1 kg
            //format the acutal name to just vegetable name
            String [] name = productNames.get(i).getText().split("-");
            String formattedName = name[0].trim();

            if(itemNeededList.contains(formattedName))
            {
                driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
            }
        }

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class=promoCode]")));
        driver.findElement(By.cssSelector("input[class=promoCode]")).sendKeys("234");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
       // driver.close();
    }

    public static void assignment(WebDriver driver)
    {
        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, 5);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));
        System.out.println(driver.findElement(By.cssSelector("#results")).getText());
    }

    public static void fluentWait(WebDriver driver)
    {
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        Wait <WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement fluent = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("#finish")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("#finish"));
                } else
                    return null;
            }
        });
        System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
        driver.close();
    }
}
