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
import org.testng.ITestContext;
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
    Actions actions;

    @BeforeClass
    public void logIn(ITestContext context){
        propertyHandling = new PropertyHandling();
        driver = CommonFunction.launchBrowser(propertyHandling.getProperty("browser"));

        context.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();

        logInPage = new LogInPage(driver);
        recruitmentModulePage = new RecruitmentModulePage(driver);
        logOutPage = new LogOutPage(driver);
        actions = new Actions(driver);

        driver.get(propertyHandling.getProperty("url"));

        CommonFunction.elementToBeVisible(driver, logInPage.username);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        logInPage.login(username,password);

        CommonFunction.elementToBeVisibleByElement(driver,recruitmentModulePage.recruitmentModule);
        recruitmentModulePage.recruitmentModule.click();
    }

    @Test
    public void addCandidates() throws InterruptedException {
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

        recruitmentModulePage.candidatesButton.click();

        actions.scrollByAmount(0,800).perform();

    }

    @Test
    public void searchVacancies() throws InterruptedException {
        CommonFunction.elementToBeVisibleByElement(driver, recruitmentModulePage.vacanciesButton);
        recruitmentModulePage.vacanciesButton.click();

        CommonFunction.elementToBeVisibleByElement(driver, recruitmentModulePage.jobTitle);
        recruitmentModulePage.jobTitle.click();

        List<WebElement> jobTitlesList = recruitmentModulePage.jobTitleList;
        Thread.sleep(2000);

        for (WebElement element : jobTitlesList){

            //System.out.println(jobTitle);
            try {
                String jobTitle  = element.getText();
                if (jobTitle.equals("IT Manager")){
                    element.click();
                }
            }catch (Exception e){

            }

        }

        recruitmentModulePage.vacancy.click();
        List<WebElement> vacanciesList = recruitmentModulePage.vacancyList;

        for (WebElement element: vacanciesList){
            try {
                String vacancy = element.getText();
                if (vacancy.equals("Associate IT Manager")){
                    element.click();
                }
            }catch (Exception e){

            }

        }


        recruitmentModulePage.hiringManager.click();
        List<WebElement> hiringManagerList = recruitmentModulePage.hiringManagerList;

        for (WebElement element : hiringManagerList){
            try {
                String hiringManger = element.getText();
                if (hiringManger.equals("-- Select --")){
                    element.click();
                }
            }catch (Exception e){

            }

        }

        recruitmentModulePage.status.click();
        List<WebElement> statusList = recruitmentModulePage.statusList;

        for (WebElement element : statusList){
            try {
                String status = element.getText();
                if (status.equals("Active")){
                    element.click();
                }
            }catch (Exception e){

            }

        }

        recruitmentModulePage.searchButton.click();

        actions.scrollByAmount(0,200).perform();
        Thread.sleep(2000);

        recruitmentModulePage.resetButton.click();
        Thread.sleep(2000);

        CommonFunction.elementToBeVisibleByElement(driver,recruitmentModulePage.addVacancyButton);
        recruitmentModulePage.addVacancyButton.click();

        CommonFunction.elementToBeVisibleByElement(driver, recruitmentModulePage.vacancyName);
        recruitmentModulePage.vacancyName.sendKeys("Associates IT");
        recruitmentModulePage.jobTitles.click();
        List<WebElement> jobTitleList = recruitmentModulePage.jobTitlesList;

        for (WebElement element : jobTitleList){
            try {
                String title = element.getText();
                if (title.equals("IT Manager")){
                    element.click();
                }
            }catch (Exception e) {

            }


        }

        recruitmentModulePage.hiringManagers.sendKeys("Linda");
        Thread.sleep(3000);
        recruitmentModulePage.saveButton.click();

        Thread.sleep(5000);

    }



    @AfterClass
    public void logOut(){
        CommonFunction.elementToBeVisible(driver,logOutPage.userDropDown);
        logOutPage.logOut();
    }
}
