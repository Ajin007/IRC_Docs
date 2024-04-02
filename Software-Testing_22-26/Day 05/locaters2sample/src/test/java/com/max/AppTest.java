package com.max;

import org.junit.Test;
import org.openqa.selenium.Alert;
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
    public void TestLocators() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        // driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("MacBook air")).click();
        // driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[3]/div/div/h4/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
        String title = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")).getText();
        String price = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[3]")).getText();
        System.out.println(title + price);
    }
}
