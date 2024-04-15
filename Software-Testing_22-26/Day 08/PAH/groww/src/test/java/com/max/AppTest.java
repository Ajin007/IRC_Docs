package com.max;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.EventHandler;
public class AppTest {
    private static final long PAGE_LOAD_TIME = 30;
	public static WebDriver driver;
	

 @BeforeMethod
    public WebDriver beforeMethod() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
        driver.manage().window().maximize();
		driver.get("https://groww.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME));
        WebDriverListener listener = new EventHandler();
		driver = new EventFiringDecorator<>(listener).decorate(driver);
		return driver;
    }

 @Test
 	public void test () throws InterruptedException {

		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PAGE_LOAD_TIME));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement QuickLinks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/div[1]/div[2]/div[3]/div")));
        js.executeScript("arguments[0].scrollIntoView(true);", QuickLinks);
        QuickLinks.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Calculators"))).click();
        WebElement HomeLoanEMI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/a[15]/div")));
        HomeLoanEMI.click();
        WebElement LoanAmount = wait.until(ExpectedConditions.elementToBeClickable(By.id("LOAN_AMOUNT")));
        LoanAmount.clear();
        LoanAmount.sendKeys("2300000");
        WebElement LoanInterest = wait.until(ExpectedConditions.elementToBeClickable(By.id("RATE_OF_INTEREST")));
        LoanInterest.clear();
        LoanInterest.sendKeys("8");
        WebElement LoanYear = wait.until(ExpectedConditions.elementToBeClickable(By.id("LOAN_TENURE")));
        LoanYear.clear();
        LoanYear.sendKeys("20");
        WebElement ResultTable = driver.findElement(By.className("tb10Table"));
        List<WebElement> Result = ResultTable.findElements(By.xpath("./tr/td[2]/span"));
        System.out.println("Monthly EMI: ₹"+Result.get(0).getText());
        System.out.println("Principal Amount: ₹"+Result.get(1).getText());
        System.out.println("Total Interest: ₹"+Result.get(2).getText());
        System.out.println("Total Amount: ₹"+Result.get(3).getText());
 	}

 @AfterMethod
	public void teardown () {
		driver.quit();
	}
}



