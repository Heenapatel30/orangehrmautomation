package com.orangehrm_automation;

import common.CommonFunction;
import common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RecruitmentModule {
    WebDriver driver;
    PropertyHandling propertyHandling;

    @BeforeClass
    public void logIn(){
        propertyHandling = new PropertyHandling();
        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(propertyHandling.getProperty("url"));
        CommonFunction.elementToBeVisible(driver, By.name("username"));
        driver.findElement(By.name("username")).sendKeys(propertyHandling.getProperty("username"));
        driver.findElement(By.name("password")).sendKeys(propertyHandling.getProperty("password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[@class='oxd-main-menu']/li[5]"));
        driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[5]")).click();
    }

    @Test
    public void recruitmentModuleClick() throws InterruptedException {
        CommonFunction.fluentWait(driver,By.xpath("//div[@class='orangehrm-header-container']/button"));
        driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button")).click();
        CommonFunction.fluentWait(driver,By.name("firstName"));
        driver.findElement(By.name("firstName")).sendKeys("rahul");
        driver.findElement(By.name("lastName")).sendKeys("patil");
        driver.findElement(By.xpath("//div[@class='oxd-select-text--after']/i")).click();

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@role='option']/span"));

        for (WebElement element: webElementList) {

            String vacancyList = element.getText();
            //System.out.println(vacancyList);

            if (vacancyList.equals("Software Engineer")){
                element.click();
            }
        }

        driver.findElement(By.xpath("//div[@class='oxd-input-group__label-wrapper']/label[text()='Email']//following::div[1]/input")).sendKeys("rahulxyz@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[1]")).click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,800).perform();

    }

    @AfterClass
    public void logOut(){
        CommonFunction.elementToBeVisible(driver,By.xpath("//li[@class='oxd-userdropdown']"));
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]"));
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
    }
}
