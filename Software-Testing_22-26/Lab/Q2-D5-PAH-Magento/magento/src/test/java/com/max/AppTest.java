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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// import ch.qos.logback.core.joran.action.Action;
// import utils.*;
// import uistore.*;

public class AppTest {

    public WebDriver driver;
    public final int IMPLICIT_WAIT_TIME = 10;
    public final int PAGE_LOAD_TIME = 10;

    // WebDriverHelper helper = new WebDriverHelper(driver);

    @BeforeMethod
    public void startUp() throws Exception {
        // DesiredCapabilities dc = new DesiredCapabilities();
        // dc.setBrowserName("chrome");
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));

        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(4000);
        // WebDriverListener listener = new EventHandler();
        // driver = new EventFiringDecorator<>(listener).decorate(driver);
    }

    @Test(priority = 0)
    public void test1() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.id("search")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("search")).sendKeys("Shoes");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='search_mini_form']/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("sorter")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//option[@value='price'])[1]")).click();
    }

    @Test(priority = 1)
    public void test2() throws Exception {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-5']"))).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-17']"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='ui-id-20']")).click();
    }

    @Test(priority = 2)
    public void test3() throws Exception {
 

        // Click on the pop-up button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Shop Tees')]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img[@class='product-image-photo'])[3]")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option-label-color-93-item-56")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("product-addtocart-button")).click();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();

    }

}
