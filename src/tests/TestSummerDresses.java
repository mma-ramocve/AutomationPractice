package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CategorySummerDresses;
import pages.Home;

public class TestSummerDresses {
    public WebDriver driver;

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void putDressesToChart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.get(CategorySummerDresses.urlSummerDresses);
        Actions action = new Actions(driver);
        WebElement printedSummerDress = driver.findElement(By.xpath(CategorySummerDresses.whitePrintedSummerDressXPath));
        action.moveToElement(printedSummerDress).perform();
        printedSummerDress.click();
        Select drpSize = new Select(driver.findElement(By.xpath(CategorySummerDresses.sizeXPath)));
        drpSize.selectByVisibleText("M");
        WebElement quantity = driver.findElement(By.xpath(CategorySummerDresses.addQuantityXPath));
        quantity.click();
        WebElement chart = driver.findElement(By.xpath(CategorySummerDresses.addToCHart));
        chart.click();
        Thread.sleep(1000);
        WebElement closePopUp = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
        closePopUp.click();
        WebElement checkChart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
        checkChart.click();
        Thread.sleep(1000);

        String actualProductTitle = driver.findElement(By.xpath("//*[@id=\"product_6_41_0_0\"]/td[2]/p/a")).getText().trim();
        Assert.assertEquals(actualProductTitle, "Printed Summer Dress");

        String actualProductAttributes = driver.findElement(By.xpath("//*[@id=\"product_6_41_0_0\"]/td[2]/small[2]/a")).getText().trim();
        Assert.assertEquals(actualProductAttributes, "Color : White, Size : M");
    }
}
