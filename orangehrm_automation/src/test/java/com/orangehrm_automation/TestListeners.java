package com.orangehrm_automation;

import com.orangehrm_automation.common.CommonFunction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestListeners implements ISuiteListener, ITestListener {

    public void onStart(ISuite suite){

        System.out.println("This is on suite start");
    }

    public void onFinish(ISuite suite){

        System.out.println("This is on suite finish");
    }
    public void onTestStart(ITestResult result) {
        System.out.println(" On test Start method ");
    }


    public void onTestSuccess(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        System.out.println(" @test method executed successfully : " + methodName);

    }


    public void onTestFailure(ITestResult result) {

        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
        String methodName = result.getMethod().getMethodName();
        //System.out.println(" @test method failed : " + methodName);
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("D:\\selenium\\orangehrmautomation\\orangehrm_automation\\src\\test\\resources\\screenshots\\" + methodName+".png");

            FileUtils.copyFile(sourceFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void onTestSkipped(ITestResult result) {

        System.out.println("@test method got skipped");

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {

        onTestFailure(result);
    }


    public void onStart(ITestContext context) {
        System.out.println("On test start method ....");

    }

    public void onFinish(ITestContext context) {
        System.out.println("On test finish method ....");

    }
}
