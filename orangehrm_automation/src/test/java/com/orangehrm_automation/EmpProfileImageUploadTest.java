package com.orangehrm_automation;

import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.pages.EmployeeDetailsPage;
import com.orangehrm_automation.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmpProfileImageUploadTest {
    WebDriver driver;
    EmployeeDetailsPage employeeDetailsPage;
    LogInPage logInPage;

    @BeforeClass
    public void beforeClass(){

        driver = CommonFunction.launchBrowser("chrome");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

        employeeDetailsPage = new EmployeeDetailsPage();
        logInPage = new LogInPage(driver);

    }

    @Test
    public void verifyFileUpload() throws IOException, InterruptedException {

        CommonFunction.elementToBeVisible(driver, logInPage.username);

        logInPage.login("admin","admin123");

        CommonFunction.elementToBeVisible(driver,employeeDetailsPage.profileImg);

        driver.findElement(employeeDetailsPage.profileImg).click();

        CommonFunction.elementToBeVisible(driver,employeeDetailsPage.uploadProfileImg);

        driver.findElement(employeeDetailsPage.uploadProfileImg).click();

        Thread.sleep(1000);

        String fileToUpload ="C:\\Users\\LENOVO\\Pictures\\Screenshots\\profile.png";

        String scriptPath = "D:\\selenium\\orangehrmautomation\\orangehrm_automation\\src\\test\\resources\\FileUploadScript.exe";

        Runtime.getRuntime().exec(scriptPath + " "+ fileToUpload);



    }
}
