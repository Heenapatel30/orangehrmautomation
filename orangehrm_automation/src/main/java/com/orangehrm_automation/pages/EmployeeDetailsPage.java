package com.orangehrm_automation.pages;

import org.openqa.selenium.By;

public class EmployeeDetailsPage{


    public By uploadProfileImg = By.xpath("//input[@type='file']/following::img");

    public By profileImg = By.className("employee-image");

}
