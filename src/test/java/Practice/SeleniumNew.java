package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//selenium 4.0 new features: add selenium java dependancy 4.0



/*public class SeleniumNew {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/maryannroshani/Dev/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));

        System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());

        WebElement dateofBirth= driver.findElement(By.cssSelector("[for='dateofBirth']"));

        driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("02/02/1992");
        WebElement iceCreamLabel=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(withTagName("input").toLeftOf(iceCreamLabel)).click();

//Get me the label of first Radio button
        WebElement rb=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(withTagName("label").toRightOf(rb)).getText());
/*
import java.io.File;

import java.io.IOException;

import java.util.Iterator;

import java.util.Set;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WindowType;

import org.openqa.selenium.chrome.ChromeDriver;



public class NewWindow {



public static void main(String[] args) throws IOException {

// TODO Auto-generated method stub





System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");



WebDriver driver=new ChromeDriver();

driver.get("https://rahulshettyacademy.com/angularpractice/");

//Switching Window

driver.switchTo().newWindow(WindowType.WINDOW);

Set<String> handles=driver.getWindowHandles();

Iterator<String> it=handles.iterator();

String parentWindowId = it.next();

String childWindow =it.next();

driver.switchTo().window(childWindow);

driver.get("https://rahulshettyacademy.com/");

String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

.get(1).getText();

driver.switchTo().window(parentWindowId);

WebElement name=driver.findElement(By.cssSelector("[name='name']"));

name.sendKeys(courseName);

//Screenshot

File file=name.getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(file, new File("logo.png"));

//driver.quit();

//GEt Height & Width

System.out.println(name.getRect().getDimension().getHeight());

System.out.println(name.getRect().getDimension().getWidth());

}


*/


