package com.orangehrm_automation;

import common.CommonFunction;
import common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PimModule {

    WebDriver driver;
    PropertyHandling propertyHandling;

    PimModulePage pimModulePage;

    LogInPage logInPage;
    @BeforeClass
    public void setUp(){
        propertyHandling = new PropertyHandling();
        driver =  CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        logInPage = new LogInPage();
        pimModulePage = new PimModulePage();
        driver.manage().window().maximize();
        driver.get(propertyHandling.getProperty("url"));
    }
    @Test
    public void logIn() throws InterruptedException {
        //Thread.sleep(2000);
        //System.out.println("this is login method");
       CommonFunction.elementToBeVisible(driver,logInPage.username);
        driver.findElement(logInPage.username).sendKeys(propertyHandling.getProperty("username"));
        driver.findElement(logInPage.password).sendKeys(propertyHandling.getProperty("password"));
        driver.findElement(logInPage.logInButton).click();
    }

    @Test
    public void pimModuleClick() throws InterruptedException {
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
        CommonFunction.elementToBeVisible(driver,By.xpath("//li[@class='oxd-userdropdown']"));
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]"));
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
    }


}
