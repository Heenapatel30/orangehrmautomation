package TestNG;

import common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotation {
    WebDriver driver = CommonFunction.launchBrowser("chrome");
    @BeforeTest
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @Test
    public void logIn() throws InterruptedException {
        //Thread.sleep(2000);
        CommonFunction.elementToBeVisible(driver,By.name("username"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @Test
    public  void logOut(){
        CommonFunction.elementToBeVisible(driver,By.xpath("//li[@class='oxd-userdropdown']"));
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        CommonFunction.elementToBeVisible(driver,By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]"));
        driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]")).click();
    }

    @Test
    public void tearDown(){
        driver.quit();
    }


}
