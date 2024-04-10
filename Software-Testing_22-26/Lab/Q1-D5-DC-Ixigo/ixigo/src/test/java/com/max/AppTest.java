package com.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    @Test

    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ixigo.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement RoundTrip = driver.findElement(By.cssSelector(
                "body > main > div.max-w-\\[1240px\\].m-auto.mainContainer > div.pt-30.mx-0.relative.px-20.xl\\:px-0 > div.border-none.shadow-500.p-20.flex.flex-col.gap-10.rounded-20.bg-white.undefined > div.flex.justify-between.items-center > div.flex.flex-col > div > button.flex.items-center.relative.transition-all.min-h-\\[40px\\].py-5.border.rounded-full.px-15.text-primary.hover\\:bg-primary-over.border-secondary.hover\\:bg-subbrand-50"));
        RoundTrip.click();

        Thread.sleep(2000);
        WebElement From = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div"));
        From.click();
        Thread.sleep(2000);
        WebElement FromCity = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[2]/li"));
        FromCity.click();
        Thread.sleep(2000);
        WebElement To = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div"));
        To.click();
        Thread.sleep(2000);
        WebElement ToCity = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[3]/li"));
        ToCity.click();

        Thread.sleep(2000);
        WebElement Depature = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div"));
        Depature.click();
        Thread.sleep(2000);
        WebElement DepatureDate = driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[3]"));
        DepatureDate.click();
        Thread.sleep(2000);
        WebElement Return = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]"));
        Return.click();
        Thread.sleep(2000);
        WebElement ReturnDate = driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[4]"));
        ReturnDate.click();

        Thread.sleep(2000);
        WebElement TravelersClass = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[1]/div"));
        TravelersClass.click();
        Thread.sleep(2000);
        WebElement TravelerAdult = driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[2]"));
        TravelerAdult.click();
        Thread.sleep(2000);
        WebElement TravelerChild = driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[2]"));
        TravelerChild.click();
        Thread.sleep(2000);
        WebElement Class = driver.findElement(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]"));
        Class.click();
        Thread.sleep(2000);
        WebElement Done = driver
                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/button"));
        Done.click();

        Thread.sleep(2000);
        WebElement Search = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/button"));
        Search.click();

        Thread.sleep(5000);
        driver.quit();
    }

}
