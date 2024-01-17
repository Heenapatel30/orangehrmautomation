package com.orangehrm_automation;

import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import com.orangehrm_automation.pages.AdminPage;
import com.orangehrm_automation.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminTest {

    WebDriver driver;
    PropertyHandling propertyHandling;

    LogInPage logInPage;

    AdminPage adminPage;

    Actions actions ;

    @BeforeClass
    public void setUp(){

        propertyHandling = new PropertyHandling();

        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        logInPage = new LogInPage(driver);
        adminPage = new AdminPage(driver);
        actions = new Actions(driver);
        driver.get(propertyHandling.getProperty("url"));

        CommonFunction.elementToBeVisible(driver,logInPage.username);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);

        CommonFunction.fluentWait(driver,adminPage.adminModule);
        driver.findElement(adminPage.adminModule).click();

    }

    @Test
    public void searchUser() throws InterruptedException {

        CommonFunction.fluentWait(driver,adminPage.userNameTextField);
        driver.findElement(adminPage.userNameTextField).sendKeys("Admin");
        driver.findElement(adminPage.userRole).click();
        driver.findElement(adminPage.userRoleDropDown).click();
        driver.findElement(adminPage.employeeName).sendKeys("Paul");
        Thread.sleep(5000);
        driver.findElement(adminPage.status).click();
        driver.findElement(adminPage.statusDropDown).click();

        driver.findElement(adminPage.searchButton).click();

        actions.scrollByAmount(0,500).perform();
    }

    @Test
    public void addJobTitle() throws InterruptedException {

        CommonFunction.elementToBeVisible(driver,adminPage.jobButton);
        driver.findElement(adminPage.jobButton).click();

       CommonFunction.fluentWait(driver,adminPage.jobTitleLink);
       driver.findElement(adminPage.jobTitleLink).click();

       CommonFunction.elementToBeVisible(driver,adminPage.addButton);
       driver.findElement(adminPage.addButton).click();

       CommonFunction.elementToBeVisible(driver,adminPage.jobTitleField);
       driver.findElement(adminPage.jobTitleField).sendKeys("xyz");

       CommonFunction.fluentWait(driver,adminPage.saveButton);
       driver.findElement(adminPage.saveButton).click();

       Thread.sleep(5000);

       driver.findElement(adminPage.userManagementLink).click();
       CommonFunction.elementToBeVisible(driver,adminPage.userLink);
       driver.findElement(adminPage.userLink).click();
    }


}
