package com.max;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.*;
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
public class AppTestXl {
    WebDriver driver;

    @BeforeMethod
    public void testSetup() throws IOException {
        FileInputStream fs = new FileInputStream("D:\\dbankdemo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("login");

        XSSFRow row = sheet.getRow(1); 
        String username = row.getCell(0).getStringCellValue(); 
        String password = row.getCell(1).getStringCellValue(); 

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
    }

    @Test
    public void Test1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }

    // @Test
    // public void Test2() {

    // }

    // @Test
    // public void Test3() {

    // }

    @AfterMethod
    public void testClose() {
        driver.close();
    }
}
