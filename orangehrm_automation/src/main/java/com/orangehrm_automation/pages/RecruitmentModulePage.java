package com.orangehrm_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecruitmentModulePage {

    WebDriver driver;

    public RecruitmentModulePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[5]")
    public WebElement recruitmentModule;

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/button")
    public WebElement addButton;

    @FindBy(name ="firstName")
    public WebElement firstNameTextField;

    @FindBy(name = "lastName")
    public WebElement lastNameTextField;

    @FindBy(xpath = "//div[@class='oxd-select-text--after']/i")
    public WebElement dropDownIcon;

    @FindBy(xpath = "//div[@role='option']/span")
    public List<WebElement> options;

    @FindBy(xpath="//div[@class='oxd-input-group__label-wrapper']/label[text()='Email']//following::div[1]/input")
    public WebElement emailTextField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li[1]")
    public WebElement candidatesButton;

    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']//li[2]")
    public WebElement vacanciesButton;

    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[1]//div/div/div/div/div//i")
    public WebElement jobTitle;

    @FindBy(xpath = "//div[@role='option']/span")
    public List<WebElement> jobTitleList;

    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[2]//div/div/div/div/div//i")
    public WebElement vacancy;

    @FindBy(xpath = "//div[@role='option']/span")
    public List<WebElement> vacancyList;

    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[3]//div/div/div/div/div//i")
    public WebElement hiringManager;

    @FindBy(xpath = "//div[@role='option']")
    public List<WebElement> hiringManagerList;

    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[4]//div/div/div/div/div//i")
    public WebElement status;

    @FindBy(xpath = "//div[@role='option']/span")
    public List<WebElement> statusList;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='button']")
    public WebElement resetButton;

    @FindBy(xpath = "//div[@class='orangehrm-header-container']/button")
    public WebElement addVacancyButton;

    @FindBy(xpath = "//form[@class='oxd-form']/div[1]/div[1]//input")
    public WebElement vacancyName;

    @FindBy(xpath = "//form[@class='oxd-form']/div[1]/div[2]//i")
    public WebElement jobTitles;

    @FindBy(xpath = "//div[@role='option']/span")
    public List<WebElement> jobTitlesList;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input")
    public WebElement hiringManagers;

    @FindBy(xpath = "//button[@type ='submit']")
    public WebElement saveButton;








}
