package com.orangehrm_automation;

import com.orangehrm_automation.common.InsertData;
import com.orangehrm_automation.pages.LogInPage;
import com.orangehrm_automation.pages.PimModulePage;
import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestListeners.class)
public class EmployeeDataInsertionTest {

    WebDriver driver;
    PropertyHandling propertyHandling;
    LogInPage logInPage;

    PimModulePage pimModulePage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        propertyHandling = new PropertyHandling();
        driver=CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        logInPage = new LogInPage(driver);
        pimModulePage = new PimModulePage(driver);
        driver.get(propertyHandling.getProperty("url"));
        CommonFunction.elementToBeVisible(driver, logInPage.username);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);
        CommonFunction.elementToBeVisible(driver,pimModulePage.pimModule);
        driver.findElement(pimModulePage.pimModule).click();
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
       List<WebElement> rows = pimModulePage.table;
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
