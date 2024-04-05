package com.elements;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    // @Test
    // public void JsScroll() throws InterruptedException {
    //     WebDriverManager.chromedriver().setup();
    //     WebDriver driver = new ChromeDriver();
    //     driver.get("https://www.indiratrade.com/blog");
    //     driver.manage().window().maximize();
    //     Thread.sleep(5000);
    //     JavascriptExecutor js = (JavascriptExecutor) driver;
    //     Thread.sleep(4000);
    //     js.executeScript("window.scroll(0,250)", "");
    //     Thread.sleep(6000);
    // }

    @Test
    public void Popups() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://max-neo-selenium.netlify.app/");
        Thread.sleep(3000);
        driver.findElement(By.id("alertx")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/button[2]")).click();
        Alert alert1=driver.switchTo().alert();
        alert1.sendKeys("Hello");
        alert1.accept();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/a[3]")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/input")).sendKeys("Mohanrj");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        // Thread.sleep(3000);
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/input")).sendKeys("mohanraj.m@iamneo.ai");
        Thread.sleep(3000);
        driver.close();
    }
}
