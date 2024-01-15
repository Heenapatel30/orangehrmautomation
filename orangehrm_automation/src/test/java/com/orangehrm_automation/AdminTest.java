package com.orangehrm_automation;

import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import com.orangehrm_automation.pages.AdminPage;
import com.orangehrm_automation.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminTest {

    WebDriver driver;
    PropertyHandling propertyHandling;

    LogInPage logInPage;

    AdminPage adminPage;

    @BeforeClass
    public void setUp(){

        propertyHandling = new PropertyHandling();

        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        logInPage = new LogInPage(driver);
        adminPage = new AdminPage(driver);
        driver.get(propertyHandling.getProperty("url"));

    }

    @Test
    public void logIn(){
        CommonFunction.elementToBeVisible(driver,logInPage.username);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);
    }

    @Test
    public void moduleAdminClick(){
        CommonFunction.fluentWait(driver,adminPage.adminModule);

        driver.findElement(adminPage.adminModule).click();

        CommonFunction.fluentWait(driver,adminPage.userNameTextField);


        driver.findElement(adminPage.userNameTextField).sendKeys("Admin");
        driver.findElement(adminPage.userRole).click();
        driver.findElement(adminPage.userRoleDropDown).click();
        driver.findElement(adminPage.employeeName).sendKeys("Paul Collings");
        driver.findElement(adminPage.status).click();
        driver.findElement(adminPage.statusDropDown).click();

        driver.findElement(adminPage.searchButton).click();

    }

}
