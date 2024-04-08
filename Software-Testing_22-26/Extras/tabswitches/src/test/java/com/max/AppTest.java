package com.max;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void Test() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        WebElement elem = driver.findElement(
                By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[1]/a/div[2]"));
        Actions actions = new Actions(driver);
        // [To trigger manual new tab]
        actions.keyDown(Keys.CONTROL)
                .click(elem)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        Thread.sleep(2000);
        // [ArrayList for Tabs]
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // [Switch to new TAB]
        driver.switchTo().window(tabs.get(1));
        String x = driver.getCurrentUrl();
        System.out.println(x);
        Thread.sleep(2000);
        // [Switch to old Tab]
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(5000);
        driver.quit();
    }
}
