package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() throws InterruptedException{
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
        Thread.sleep(3000);
        driver.findElement(By.className("gNO89b")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void closeTest() {
        driver.quit();
    }
}
