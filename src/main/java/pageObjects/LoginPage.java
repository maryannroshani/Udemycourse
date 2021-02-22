package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    By userName = By.cssSelector("#user_email");
    By passWord = By.cssSelector("#user_password");
    By signButton = By.xpath("//input[@name='commit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail()
    {
        return driver.findElement(userName);
    }

    public WebElement getPassword()
    {
        return driver.findElement(passWord);
    }

    public WebElement signIn()
    {
        return driver.findElement(signButton);
    }

}
