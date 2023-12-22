package com.orangehrm_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
  WebDriver driver;

  public LogInPage(WebDriver driver){

    this.driver = driver;
  }
  public By username = By.name("username");
  public By password = By.name("password");
  public By logInButton = By.xpath("//button[@type='submit']");

  public void login(String username, String password){
    driver.findElement(this.username).sendKeys(username);
    driver.findElement(this.password).sendKeys(password);
    driver.findElement(logInButton).click();
  }

}
