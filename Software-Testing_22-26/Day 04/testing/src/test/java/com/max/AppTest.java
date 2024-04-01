package com.max;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void Test1() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //to maximize the window
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void Test2() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.bing.com/");
        //to maximize the window
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void Test3() throws InterruptedException{
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.bing.com/");
        //to maximize the window
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        Thread.sleep(5000);
        driver.close();
    }
}
