package com.orangehrm_automation;

import common.CommonFunction;
import common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDataInsertion {

    WebDriver driver;
    PropertyHandling propertyHandling;
    LogInPage logInPage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        propertyHandling = new PropertyHandling();
        driver=CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        logInPage = new LogInPage();
        driver.get(propertyHandling.getProperty("url"));
        CommonFunction.elementToBeVisible(driver, logInPage.username);
        driver.findElement(logInPage.username).sendKeys(propertyHandling.getProperty("username"));
        driver.findElement(logInPage.password).sendKeys(propertyHandling.getProperty("password"));
        driver.findElement(logInPage.logInButton).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]"));
        driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void insertEmpDataInExcel() throws IOException {

        InsertData insertData = new InsertData();
        Object[][] empData = getEmployeeData();
        insertData.insertDataInExcel(empData);


    }

    @DataProvider
    public Object[][] getEmployeeData(){
       List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
       Object[][] empDataObject = new Object[rows.size()][1];

       for (int i=1; i<=rows.size(); i++) {
           List<String> data = new ArrayList<>();
           for (int j=2; j<=8; j++) {
               String dataXpath = "//div[@class='oxd-table-card']"+"["+i+"]"+"//div["+j+"]/div";

               String value = driver.findElement(By.xpath(dataXpath)).getText();
               data.add(value);
           }
           empDataObject[i-1][0] = data;
       }
        return empDataObject;
    }

}
