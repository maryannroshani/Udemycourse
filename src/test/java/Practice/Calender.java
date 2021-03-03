package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calender {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        //Select the Date of travel box
        driver.findElement(By.id("travel_date")).click();

        //Select a month
        WebElement month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));

        //While loop is a boolean. Neogation is opposite of boolean value. While loop will execute until its false.
        while (!month.getText().contains("March"))
        {
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
        }

        //Select a date

        List<WebElement> dates = driver.findElements(By.cssSelector("[class='day']"));
        int count = dates.size();
        for (int i = 0; i < count; i++) {
            String date = dates.get(i).getText();
            if (date.equals("24")) {
                dates.get(i).click();
                break;
            }
        }
    }
}
