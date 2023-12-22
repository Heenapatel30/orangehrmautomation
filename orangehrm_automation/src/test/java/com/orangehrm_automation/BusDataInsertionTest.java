package com.orangehrm_automation;

import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.InsertData;
import com.orangehrm_automation.common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusDataInsertionTest {

    WebDriver driver;
    PropertyHandling propertyHandling;

    @BeforeTest
    public void setUp() throws InterruptedException {
        propertyHandling = new PropertyHandling();
        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.redbus.in/");
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("pune");
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[starts-with(@class,'sc-dnqmqq')]/li[1]"));
        driver.findElement(By.xpath("//ul[starts-with(@class,'sc-dnqmqq')]/li[1]")).click();

        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("mumbai");
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[starts-with(@class,'sc-dnqmqq')]/li[1]"));
        driver.findElement(By.xpath("//ul[starts-with(@class,'sc-dnqmqq')]/li[1]")).click();

        driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("search_button")).click();
        Thread.sleep(3000);

    }
    @Test
    public void insertBusDataInExcel() throws IOException, InterruptedException {

        InsertData insertData = new InsertData();
        Object[][] busData = getBusDetail();
        insertData.insertBusData(busData);
    }

    @DataProvider
    public Object[][] getBusDetail() throws InterruptedException {
        CommonFunction.elementToBeVisible(driver,By.xpath("//div[@id='result-section']//div/ul/div"));
        Thread.sleep(50000);

        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='result-section']//div/ul/div"));
        Object[][] busDataObject = new Object[rows.size()][1];
        System.out.println(rows.size());

        for (int i = 1; i <= rows.size() ; i++) {
            List<String> data = new ArrayList<>();
            String value = null;
            for (int j = 1; j <= 6; j++) {
                if (j==5){
                    continue;
                }else {
                    String dataXpath = "//div[@id='result-section']//div/ul/div" + "[" + i + "]" + "//li/div/div[1]/div[1]/div[" + j + "]/div[1]";
                    CommonFunction.fluentWait(driver,By.xpath(dataXpath));
                    value = driver.findElement(By.xpath(dataXpath)).getText();
                }
                data.add(value);
            }
            busDataObject[i-1][0] = data;
        }
        return busDataObject;
    }


}
