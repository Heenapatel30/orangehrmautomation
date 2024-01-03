package com.orangehrm_automation;

import com.orangehrm_automation.pages.LogInPage;
import com.orangehrm_automation.pages.LogOutPage;
import com.orangehrm_automation.pages.PimModulePage;
import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PimModuleTest {

    WebDriver driver;
    PropertyHandling propertyHandling;

    PimModulePage pimModulePage;

    LogInPage logInPage;

    LogOutPage logOutPage;
    @BeforeClass
    public void setUp(ITestContext context){
        propertyHandling = new PropertyHandling();
        driver =  CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));

        context.setAttribute("WebDriver",driver);
        logInPage = new LogInPage(driver);
        pimModulePage = new PimModulePage(driver);
        logOutPage = new LogOutPage(driver);

        driver.manage().window().maximize();
        driver.get(propertyHandling.getProperty("url"));
    }
    @Test
    public void logIn() throws InterruptedException, IOException {
        CommonFunction.elementToBeVisible(driver,logInPage.username);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);
       // CommonFunction.takeScreenShot(driver, "loginPage.png");
    }

    @Test
    public void pimModuleClick() throws InterruptedException, IOException {
        Thread.sleep(1000);

        CommonFunction.elementToBeVisible(driver,pimModulePage.pimModule);
        driver.findElement(pimModulePage.pimModule).click();

        CommonFunction.fluentWait(driver,pimModulePage.addEmployeeButton);
        driver.findElement(pimModulePage.addEmployeeButton).click();

        CommonFunction.fluentWait(driver,pimModulePage.firstName);
        driver.findElement(pimModulePage.firstName).sendKeys("abcxyz");
        driver.findElement(pimModulePage.lastName).sendKeys("patil");
        driver.findElement(pimModulePage.submitButton).click();
        Thread.sleep(2000);

        driver.findElement(pimModulePage.employeeListButton).click();

        CommonFunction.fluentWait(driver,pimModulePage.dashBoard);
        driver.findElement(pimModulePage.dashBoard).click();

    }

    @AfterClass
    public void logOut(){
        CommonFunction.elementToBeVisible(driver,logOutPage.userDropDown);
        logOutPage.logOut();


    }


}
