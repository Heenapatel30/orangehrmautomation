package TestNG;

import common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

/*    @BeforeClass
    public void beforeClass(){
        driver = CommonFunction.launchBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://realestateautomation.agilecrm.com/");

    }*/
        @Test(priority = 1, enabled = true, dataProvider = "getExcelData", dataProviderClass = ExcelHandling.class)
        public void verifyLogin (String username, String password){
            System.out.println(username + " : " + password);
         /*if (username != null){
            driver.findElement(By.name("email")).sendKeys(username);
        } else if (password != null) {
            driver.findElement(By.name("password")).sendKeys(password);

        }*/
         System.out.println("TEst");
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
    }


}
