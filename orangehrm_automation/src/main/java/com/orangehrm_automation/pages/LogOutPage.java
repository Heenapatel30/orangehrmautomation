package com.orangehrm_automation.pages;

import com.orangehrm_automation.common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {

    WebDriver driver;

    public LogOutPage(WebDriver driver){
        this.driver = driver;
    }

    public By userDropDown = By.xpath("//li[@class='oxd-userdropdown']");
    public By logOutButton = By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]");

    public void logOut(){

        driver.findElement(userDropDown).click();
        CommonFunction.elementToBeVisible(driver,logOutButton);
        driver.findElement(logOutButton).click();
    }
}
