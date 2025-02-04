package com.orangehrm_automation.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonFunction {

  public static WebDriver launchBrowser(String browser){

    WebDriver driver = null;

    switch(browser){
        case "chrome":
          ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("--remote-allow-origins=*");
         chromeOptions.setBinary("D:\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
         driver = new ChromeDriver(chromeOptions);
        break;
        case "firefox" :
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,"D:\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
             driver = new FirefoxDriver();
        break;
    }
    return driver;
  }

  public static void elementToBeVisible(WebDriver driver, By by){
      Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by));

  }

  public static void elementToBeVisibleByElement(WebDriver driver,WebElement element){
      Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void fluentWait(WebDriver driver,By by){

      Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50))
              .pollingEvery(Duration.ofSeconds(5))
              .ignoring(NoSuchElementException.class)
      ;

      fluentWait.until((webDriver)->{
          System.out.println("Checking for Element");
          return webDriver.findElement(by);
      });
  }





}


