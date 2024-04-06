package com.max;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;

    @BeforeMethod
    public void testSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() {
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("S@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("P@ssword12");
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }

    @AfterMethod
    public void testClose() {
        driver.close();
    }
}
