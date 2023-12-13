package com.orangehrm_automation;

import common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TestNgAnnotation {
    WebDriver driver = CommonFunction.launchBrowser("chrome");
    @BeforeClass
    public void setUp(){
        System.out.println("this is setup method");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @Test
    public void logIn() throws InterruptedException {
        //Thread.sleep(2000);
        System.out.println("this is login method");
        CommonFunction.elementToBeVisible(driver,By.name("username"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @Test
    public  void logOut(){
        System.out.println("this is logout method");
        CommonFunction.elementToBeVisible(driver,By.xpath("//li[@class='oxd-userdropdown']"));
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]"));
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("this is tear down method");
        driver.quit();
    }


}
