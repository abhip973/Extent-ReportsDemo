package abhishek_Learns;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extentReports;

    @BeforeTest
    public void config() {
        /* 2 classes useful to generate extent reports are:
        1. ExtentReports
        2. ExtentSparkReporter
         */

        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);

        extentReports.setSystemInfo("Tester", "Abhishek Punj");

    }

    @Test
    public void initialDemo() {
        ExtentTest test = extentReports.createTest("InitialDemo");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/");
        String pageTitle = driver.getTitle();
        driver.close();
        System.out.println(pageTitle);

        test.fail("My choice");
        extentReports.flush();
    }
}
