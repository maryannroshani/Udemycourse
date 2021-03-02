package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowFrames {

     public static void main(String[] args) {
          System.setProperty("webdriver.chrome.driver", "/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
          WebDriver driver = new ChromeDriver();
          nestedFrames(driver);
          /*driver.get("https://jqueryui.com/droppable/");
          driver.switchTo().frame(0); //withid
          Actions a = new Actions(driver);
          WebElement source = driver.findElement(By.cssSelector("#draggable"));
          WebElement target = driver.findElement(By.cssSelector("#droppable"));
          a.dragAndDrop(source, target).build().perform();
          driver.switchTo().defaultContent();*/
     }

     public static void nestedFrames(WebDriver driver)
     {
          driver.get("https://the-internet.herokuapp.com/");
          driver.findElement(By.linkText("Nested Frames")).click();
          driver.switchTo().frame("frame-top");
          driver.switchTo().frame("frame-middle");
          System.out.println(driver.findElement(By.id("content")).getText());


          //System.out.println(driver.findElements(By.xpath("/frameset//frame")).size());
          driver.close();
          /*
         System.out.println(driver.findElement(By.xpath("//iframe[1]")).getText());
          driver.switchTo().frame(driver.findElement(By.xpath("//frameset[1]/frame[2]")));
          String frameName = driver.findElement(By.cssSelector("#content")).getText();
          System.out.println(frameName);*/
     }

}
