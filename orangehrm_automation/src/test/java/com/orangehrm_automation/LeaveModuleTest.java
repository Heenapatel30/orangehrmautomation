package com.orangehrm_automation;

import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import com.orangehrm_automation.pages.LeaveModulePage;
import com.orangehrm_automation.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveModuleTest {

    WebDriver driver;
    PropertyHandling propertyHandling;

    LogInPage logInPage;

    LeaveModulePage leaveModulePage;

    @BeforeClass
    public void setUp(){

        propertyHandling = new PropertyHandling();
        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(propertyHandling.getProperty("url"));

        logInPage = new LogInPage(driver);
        leaveModulePage = new LeaveModulePage();

        String userName = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");

        CommonFunction.fluentWait(driver,logInPage.username);

        logInPage.login(userName,password);
    }

    @Test
    public void leaveModuleClick(){

        CommonFunction.fluentWait(driver,leaveModulePage.leaveModule);
        driver.findElement(leaveModulePage.leaveModule).click();

    }
}
