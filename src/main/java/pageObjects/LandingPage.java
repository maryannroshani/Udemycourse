package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

   By logIn =  By.xpath("//span[contains(text(),'Login')]");
   By navMenu = By.cssSelector("ul[class='nav navbar-nav navbar-right']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin()
   {
       return driver.findElement(logIn);
   }

   public boolean navigationMenu()
   {
       driver.findElement(navMenu).isDisplayed();
       return true;
   }
}
