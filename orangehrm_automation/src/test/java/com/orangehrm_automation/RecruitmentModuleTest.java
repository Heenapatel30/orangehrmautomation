package com.orangehrm_automation;

import com.orangehrm_automation.pages.LogInPage;
import com.orangehrm_automation.common.CommonFunction;
import com.orangehrm_automation.common.PropertyHandling;
import com.orangehrm_automation.pages.LogOutPage;
import com.orangehrm_automation.pages.RecruitmentModulePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RecruitmentModuleTest {
    WebDriver driver;
    PropertyHandling propertyHandling;
    LogInPage logInPage;

   RecruitmentModulePage recruitmentModulePage;

   LogOutPage logOutPage;

    @BeforeClass
    public void logIn(){
        propertyHandling = new PropertyHandling();
        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));
        driver.manage().window().maximize();

        logInPage = new LogInPage(driver);
        recruitmentModulePage = new RecruitmentModulePage(driver);
        logOutPage = new LogOutPage(driver);

        driver.get(propertyHandling.getProperty("url"));

        CommonFunction.elementToBeVisible(driver, logInPage.username);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);

        CommonFunction.elementToBeVisibleByElement(driver,recruitmentModulePage.recruitmentModule);
        recruitmentModulePage.recruitmentModule.click();
    }

    @Test
    public void recruitmentModuleClick() throws InterruptedException {
        CommonFunction.elementToBeVisibleByElement(driver, recruitmentModulePage.addButton);
        recruitmentModulePage.addButton.click();

        CommonFunction.elementToBeVisibleByElement(driver, recruitmentModulePage.firstNameTextField);
        recruitmentModulePage.firstNameTextField.sendKeys("rahul");
        recruitmentModulePage.lastNameTextField.sendKeys("patil");
        recruitmentModulePage.dropDownIcon.click();

        List<WebElement> webElementList = recruitmentModulePage.options;

        for (WebElement element: webElementList) {

            String vacancyList = element.getText();
            //System.out.println(vacancyList);

            if (vacancyList.equals("Software Engineer")){
                element.click();
            }
        }

        recruitmentModulePage.emailTextField.sendKeys("rahulxyz@gmail.com");
        recruitmentModulePage.submitButton.click();
        Thread.sleep(2000);

        recruitmentModulePage.canditatesButton.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,800).perform();

    }

    @AfterClass
    public void logOut(){
        CommonFunction.elementToBeVisible(driver,logOutPage.userDropDown);
        logOutPage.logOut();
    }
}
