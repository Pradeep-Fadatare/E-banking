package com.inetbanking.Utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetbanking.pageobject.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Reporting extends BaseClass implements  ITestListener {


    public Reporting() throws IOException {
        super();
    }


    public void onTestStart(ITestResult result, ITestContext context) {
        //before each test case start

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //Before any test case start

    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test case skipped");
    }

    @Override
    public void onFinish(ITestContext context) {


    }
}
