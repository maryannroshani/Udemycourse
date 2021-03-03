package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //No of columns
        int columns = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr//th")).size();
        System.out.println(columns);

       // System.out.println(driver.findElements(By.xpath("//table[@name='courses']//tbody//tr//th")).size());

        //No of rows
        int rows = driver.findElements(By.xpath("//table[@name='courses']//tbody//tr")).size();
        System.out.println(rows);

        //Row 2 text
        String rowTwo = driver.findElement(By.xpath("//table[@name='courses']//tbody//tr[3]")).getText();
        System.out.println(rowTwo);
        //List<WebElement> Sndrow = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
        //for (int i = 0; i < Sndrow.size(); i++) {
          //  System.out.print(Sndrow.get(i).getText());
        //}


        /*
        WebElement table=driver.findElement(By.id("product"));
System.out.println(table.findElements(By.tagName("tr")).size());
System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
System.out.println(secondrow.get(0).getText());
System.out.println(secondrow.get(1).getText());
System.out.println(secondrow.get(2).getText());
        */
    }
}
