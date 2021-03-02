package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RealTimeExercise {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        exercise(driver);

        /*//System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a")).size());

        WebElement footA = driver.findElement(By.id("gf-BIG"));
        System.out.println(footA.findElements(By.tagName("a")).size());

        WebElement columnA = driver.findElement(By.id("gf-BIG"));
        List<WebElement> elementsList = columnA.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a"));

        /*stream
        elementsList.remove(0);
        elementsList.forEach(webElement -> {
            String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
            webElement.sendKeys(selectLinkOpeninNewTab);
        });*/
        /*String title = driver.getTitle();

        for (int i = 1; i < elementsList.size(); i++) {
            String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);  //open links in new tabs
            elementsList.get(i).sendKeys(selectLinkOpeninNewTab);
            Thread.sleep(3000);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next()).getTitle();
            System.out.println(driver.getTitle());
        }
        driver.quit();*/
    }

    public static void exercise(WebDriver driver)
    {
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));

        Select s=new Select(dropdown);
        s.selectByVisibleText(opt);

        driver.findElement(By.name("enter-name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();

        String text=  driver.switchTo().alert().getText();
        if(text.contains(opt))
        {
            System.out.println("Alert message success");
        }
        else
            System.out.println("Something wrong with execution");
    }
}
