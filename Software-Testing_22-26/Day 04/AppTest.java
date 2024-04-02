package com.example;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static WebDriver driver;
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException, InterruptedException
    {
        ChromeOptions co = new ChromeOptions();
        driver= new RemoteWebDriver(new URL("http://localhost:4444/"),co);
        driver.get("https://shoppersstop.com");

      
    }
}
