package com.orangehrm_automation;

import common.CommonFunction;
import common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PimModule {

    WebDriver driver;
    PropertyHandling propertyHandling;
    @BeforeClass
    public void setUp(){
        propertyHandling = new PropertyHandling();
        driver =  CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(propertyHandling.getProperty("url"));
    }
    @Test
    public void logIn() throws InterruptedException {
        //Thread.sleep(2000);
        //System.out.println("this is login method");
       CommonFunction.elementToBeVisible(driver,By.name("username"));
        driver.findElement(By.name("username")).sendKeys(propertyHandling.getProperty("username"));
        driver.findElement(By.name("password")).sendKeys(propertyHandling.getProperty("password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void pimModuleClick() throws InterruptedException {
        CommonFunction.elementToBeVisible(driver,By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]"));
        driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]")).click();
        CommonFunction.fluentWait(driver,By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[3]"));
        driver.findElement(By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[3]")).click();
        CommonFunction.fluentWait(driver,By.name("firstName"));
        driver.findElement(By.name("firstName")).sendKeys("abcxyz");
        driver.findElement(By.name("lastName")).sendKeys("patil");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[2]")).click();
        CommonFunction.fluentWait(driver,By.xpath("//ul[@class='oxd-main-menu']/li[8]"));
        driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[8]")).click();

    }

    @AfterClass
    public void logOut(){
        CommonFunction.elementToBeVisible(driver,By.xpath("//li[@class='oxd-userdropdown']"));
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]"));
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
    }


}
