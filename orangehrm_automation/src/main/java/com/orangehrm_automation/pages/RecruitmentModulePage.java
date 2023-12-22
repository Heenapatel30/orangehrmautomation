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
    public WebElement canditatesButton;


}
