package com.orangehrm_automation;

import org.testng.*;

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
        String methodName = result.getMethod().getMethodName();
        System.out.println(" @test method failed : " + methodName);

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
