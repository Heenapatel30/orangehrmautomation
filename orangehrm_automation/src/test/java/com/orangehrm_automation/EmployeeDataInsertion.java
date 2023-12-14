package com.orangehrm_automation;

import common.CommonFunction;
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
    @BeforeClass
    public void setUp() throws InterruptedException {
        driver=CommonFunction.launchBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        CommonFunction.elementToBeVisible(driver, By.name("username"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
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
