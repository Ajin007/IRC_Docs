package com.max;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// import ch.qos.logback.core.joran.action.Action;
// import utils.*;
// import uistore.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    public WebDriver driver;
    public final int IMPLICIT_WAIT_TIME = 10;
    public final int PAGE_LOAD_TIME = 5;
    // WebDriverHelper helper = new WebDriverHelper(driver);
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void startUp() throws Exception {
        // DesiredCapabilities dc = new DesiredCapabilities();
        // dc.setBrowserName("chrome");
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sparkReporter = new ExtentSparkReporter("./reports/PuriHoli.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        driver.manage().window().maximize();

        driver.get("https://www.puriholidayresort.com/");
        Thread.sleep(10000);
        // WebDriverListener listener = new EventHandler();
        // driver = new EventFiringDecorator<>(listener).decorate(driver);

    }

    @Test(priority = 0)
    public void test1() throws Exception {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        driver.findElement(By.xpath("//input[@id='arr_datepicker']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),'30')]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='custom-btn']")).click();
    }

    @Test(priority = 1)
    public void test2() throws Exception {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[2]/a[contains(text(),'Rooms & Suites')]"))).build()
                .perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Royal Suite')]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[contains(text(),'AMENITIES')]")).click();
    }

    @Test(priority = 2)
    public void test3() throws Exception {
        Thread.sleep(3000);
        By continLocator = By.xpath(
                "//textarea[contains(text(),'Title your review - Describe your stay in one sentence or less. ')]");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[1]/a[contains(text(),'About Puri')]"))).build()
                .perform();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Chilika Lake')]")).click();

        Thread.sleep(4000);
        driver.findElement(continLocator).click();
        driver.findElement(continLocator).sendKeys("Excellent");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Family')]")).click();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @AfterTest
    public void setupreport() {
        extent.flush();
    }

}
