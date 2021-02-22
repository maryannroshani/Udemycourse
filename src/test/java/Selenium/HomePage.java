
package Selenium;


import Resources.base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class HomePage extends base {

    @Test(dataProvider = "getData")
    public void basePageNavigate(String Username, String Password) throws IOException {
        driver = initializeDriver();
        driver.get(dataProp.getProperty("url"));

        LandingPage land = new LandingPage(driver);
        Assert.assertEquals(driver.getTitle(),"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
        Assert.assertTrue(land.navigationMenu());
        //System.out.println(land.navigationMenu());
        land.getLogin().click();

        LoginPage log = new LoginPage(driver);
        log.getEmail().sendKeys(Username);
        log.getPassword().sendKeys(Password);
        log.signIn().click();
    }


    @DataProvider
    public Object[][] getData()
    {
        // Row stands for how many different data types test should run
        //Column stands for how many values per each test
      Object [][] data = new Object[2][2];
      //0th row
            data [0][0] = "Invaliduser@qw.com";
            data [0][1] = "453454";
       //1st row
            data [1][0] = "Validuser@gw.com";
            data [1][1] = "6456456546";
            return data;
    }


    @AfterTest
    public void close()
    {
       driver.quit();
    }
}
