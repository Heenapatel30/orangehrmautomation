package com.orangehrm_automation;

import com.orangehrm_automation.pages.LogInPage;
import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import com.orangehrm_automation.pages.LogOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class AnnotationTest {
    WebDriver driver;
    PropertyHandling propertyHandling;

    LogInPage logInPage;

    LogOutPage logOutPage;
    @BeforeClass
    public void setUp(){
        propertyHandling = new PropertyHandling();
        driver=CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        logInPage = new LogInPage(driver);
        logOutPage = new LogOutPage(driver);
        driver.manage().window().maximize();
        driver.get(propertyHandling.getProperty("url"));
    }
    @Test
    public void logIn() throws InterruptedException {
        CommonFunction.elementToBeVisible(driver,logInPage.username);

        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);
    }
    @Test
    public  void logOut(){
        System.out.println("this is logout method");
        CommonFunction.elementToBeVisible(driver,logOutPage.userDropDown);
       logOutPage.logOut();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("this is tear down method");
        driver.quit();
    }


}
