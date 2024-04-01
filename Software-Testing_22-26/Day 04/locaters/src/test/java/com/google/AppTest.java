package com.google;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
   public void Test()throws InterruptedException{
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
    Thread.sleep(3000);
    driver.findElement(By.className("gNO89b")).click();
    Thread.sleep(3000);
    driver.navigate().back();
    Thread.sleep(3000);
    driver.navigate().refresh();
    Thread.sleep(3000);
    driver.close();


}
}
