package com.max;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    WebDriver driver;

    @BeforeMethod
    public void testSetup() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.spencers.in/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
    }

    //Portal
    // public static WebDriver driver;
    // private WebDriverWait wait;
    // public final int IMPLICIT_WAIT_TIME = 10;
    // public final int PAGE_LOAD_TIME = 5;
    // @BeforeMethod
    // public WebDriver beforeMethod() throws MalformedURLException {
    //     ChromeOptions chromeOptions = new ChromeOptions();
    //     driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
    //     driver.get("https://www.spencers.in/");
    //     driver.manage().window().maximize();
    //     wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    //     // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
    //     WebDriverListener listener = new EventHandler();
    //     driver = new EventFiringDecorator<>(listener).decorate(driver);
    //     return driver;

    // }

    @Test(priority = 0)
    public void Test1() throws Exception {
        FileInputStream fs = new FileInputStream("D:\\spencers.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("products");
        XSSFRow row = sheet.getRow(1);
        String product = row.getCell(0).getStringCellValue();
        WebElement sbar = driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[3]"));
        sbar.click();
        WebElement sbardata = driver.findElement(By.xpath("//*[@id='search']"));
        sbardata.sendKeys(product, Keys.ENTER);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/form/ul/li[1]/a")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div[1]/div[5]/div/div/div[2]/ol/li[1]/div/div[2]/div[4]/div/div/form/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[2]/div[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[4]/div/a")).click();
    }
    @Test(priority = 1)
    public void Test2() throws Exception{
        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[5]/div[1]/div/div/div[1]/div/div/div[1]/div/nav/ul[2]/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[5]/div[1]/div/div/div[1]/div/div/div[1]/div/nav/ul[2]/li[1]/ul/li[3]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div/div[2]/div/div[2]/div/div[1]/div[2]/form/ul/li[2]/a")).click();
    }
    @Test(priority = 2)
    public void Test3() throws Exception{
        driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[2]/div[3]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[2]/div[3]/div[1]/div[2]/div/div[2]/div[5]/div/div/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Example20@");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div[2]/div/form/fieldset/div[4]/div[1]/button")).click();
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Save screenshot to desired location
        FileUtils.copyFile(screenshotFile, new File("./screenshots/TSC.png"));
    }

    @AfterMethod
    public void testClose() {
        driver.quit();
    }
}