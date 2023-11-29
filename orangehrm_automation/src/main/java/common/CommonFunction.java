package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));

  }

}


