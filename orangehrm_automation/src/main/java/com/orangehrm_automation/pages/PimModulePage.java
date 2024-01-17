package com.orangehrm_automation.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimModulePage {
    WebDriver driver;

    public PimModulePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public By pimModule = By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]");

    public By addEmployeeButton = By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[3]");

    public By firstName = By.name("firstName");

    public By lastName = By.name("lastName");

    public By submitButton = By.xpath("//button[@type='submit']");

    public By employeeListButton = By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[2]");

    public By dashBoard = By.xpath("//ul[@class='oxd-main-menu']/li[8]");

    //public By table = By.xpath("//div[@class='oxd-table-card']");

    @FindBy(xpath="//div[@class='oxd-table-card']")
    public List<WebElement> table;

    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']//li[4]")
    public WebElement reportLink;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input")
    public WebElement reportName;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[1]")
    public WebElement resetButton;

}
