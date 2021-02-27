package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Javascript {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        javascript.executeScript("document.querySelector(\".tableFixHead\").scrollTop=400;\n");

          List<WebElement> listValues = driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//td[4]"));
        int sum = 0;
        for(int i = 0; i <listValues.size(); i++)
              sum = sum + Integer.parseInt(listValues.get(i).getText());
        System.out.println(sum);
         int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
         Assert.assertEquals(sum,total);
        driver.close();
    }
}

/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tableexercises {

public static void main(String[] args) {
// TODO Auto-generated method stub
int sum=0;
System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");

WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
int rowcount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

for(int i=0;i<count-2;i++)
{
String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
int valueinteger=  Integer.parseInt(value);
sum=sum+valueinteger;//103
}
//System.out.println(sum);

String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
int extrasValue=Integer.parseInt(Extras);
int TotalSumValue=sum+extrasValue;
System.out.println(TotalSumValue);


String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
int ActualTotalVAlue=Integer.parseInt(ActualTotal);
if(ActualTotalVAlue==TotalSumValue)
{
System.out.println("Count Matches");
}
else
{
System.out.println("count fails");
}
}

}
 */