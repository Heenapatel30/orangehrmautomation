package TestNG;

import common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PimModule {

    WebDriver driver = CommonFunction.launchBrowser("chrome");
    @BeforeClass
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void logIn() throws InterruptedException {
        //Thread.sleep(2000);
        System.out.println("this is login method");
       CommonFunction.elementToBeVisible(driver,By.name("username"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void pimModuleClick(){
        CommonFunction.elementToBeVisible(driver,By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]"));
        driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[2]")).click();
    }
}
