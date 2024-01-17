package com.orangehrm_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;
    }

    public By adminModule = By.xpath("//ul[@class='oxd-main-menu']/li[1]");

    public By userNameTextField = By.xpath("//div[@class='oxd-form-row']/div/div[1]//input");

    public By userRole = By.xpath("//div[@class='oxd-form-row']/div/div[2]//div[2]/div");

    public By userRoleDropDown = By.xpath("//div[@role='option'][2]/span");

    public By employeeName = By.xpath("//div[@class='oxd-form-row']/div/div[3]//input");

    public By status = By.xpath("//div[@class='oxd-form-row']/div/div[4]//div[2]/div");

    public By statusDropDown = By.xpath("//div[@role='option'][2]/span");

    public By searchButton = By.xpath("//button[@type='submit']");

    public By jobButton = By.xpath("//nav[@class='oxd-topbar-body-nav']//li[2]");

    public By jobTitleLink = By.xpath("//ul[@class='oxd-dropdown-menu']/li[1]");

    public By addButton = By.xpath("//div[@class='orangehrm-header-container']//button");

    public By jobTitleField = By.xpath("//div[@class='oxd-form-row'][1]//input");

    public By saveButton = By.xpath("//button[@type='submit']");

    public By userManagementLink = By.xpath("//div[@class='oxd-topbar-body']//li[1]");

    public By userLink = By.xpath("//ul[@class='oxd-dropdown-menu']/li");






}
