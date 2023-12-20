package com.orangehrm_automation;

import org.openqa.selenium.By;

public class PimModulePage {

    public By pimModule = By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]");

    public By addEmployeeButton = By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[3]");

    public By firstName = By.name("firstName");

    public By lastName = By.name("lastName");

    public By submitButton = By.xpath("//button[@type='submit']");

    public By employeeListButton = By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[2]");

    public By dashBoard = By.xpath("//ul[@class='oxd-main-menu']/li[8]");

    public By table = By.xpath("//div[@class='oxd-table-card']");
}
