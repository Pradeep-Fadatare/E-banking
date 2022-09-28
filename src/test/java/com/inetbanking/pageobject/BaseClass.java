package com.inetbanking.pageobject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static File file;
    public static ExtentTest extentTest;
    public static String foldername;


    public BaseClass() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\91956\\IdeaProjects\\FirstProject\\src\\Configuration\\Config.properties");
        prop = new Properties();
        prop.load(fr);
    }

    @BeforeClass
    public void setUp() {
        String browsername=System.getProperty("browser")!=null ?System.getProperty("browser"):prop.getProperty("browser");



        if (browsername.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("baseurl"));
        } else if (browsername.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("baseurl"));
        } else if (browsername.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.get(prop.getProperty("baseurl"));
        }
    }

    public boolean isalertpresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String CaptureScreenshot(String Filename) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File src = new File("C:\\Users\\91956\\IdeaProjects\\FirstProject\\src\\Configuration\\Screenshots\\" + foldername + ".jpg");

        FileUtils.copyFile(file, src);

        return src.getAbsolutePath();
    }

    @BeforeMethod
    public void extenttestsetup(ITestContext context){
        extentTest = extentReports.createTest(context.getName());
        extentTest.assignAuthor("Pradeep");

    }
    @BeforeSuite
    public void extentreportInitialization(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter myformatobj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        foldername = ldt.format(myformatobj);

        extentReports = new ExtentReports();
        file = new File("C:\\Users\\91956\\IdeaProjects\\FirstProject\\src\\Configuration\\" + foldername + ".html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("failed.html");
        sparkReporter_failed.filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
        extentReports.attachReporter(sparkReporter, sparkReporter_failed);
    }
    @AfterSuite
    public void flushreport(){
        extentReports.flush();
    }
    @AfterMethod
    public void teardown(Method m, ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String pathname = CaptureScreenshot(result.getTestContext().getName());
            extentTest.addScreenCaptureFromPath(pathname);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS,"Datails are correct");
        }
    }

    @AfterClass
    public void teardown(){
        driver.quit();
        }
        //Quiting The browser
    }


