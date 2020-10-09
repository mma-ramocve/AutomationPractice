package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategorySummerDresses;
import pages.Home;

public class TestHome {

    public WebDriver driver;

    @BeforeTest
    public void getHomePage() {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.get(Home.homeUrl);
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test(priority = 0)
    /* 	Testirati da li kada se na početnoj stranici sajta mišem stane na dugme WOMEN,
        a zatim odatle odabere SummerDresses odlazi na korektnu stranu */
    public void getSummerDressesFromWomenMenu() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement womenMenu = driver.findElement(By.xpath(Home.womenMenuXPath));
        action.moveToElement(womenMenu).perform();
        WebElement summerDressesWMenu = driver.findElement(By.xpath(Home.summerDressesWomenMenuXPath));
        summerDressesWMenu.click();
        Thread.sleep(1000);

        String actualUrl1 = driver.getCurrentUrl();
        String expectedUrl = CategorySummerDresses.urlSummerDresses;
        Assert.assertEquals(actualUrl1, expectedUrl);

    }

    @Test(priority = 1)
    /*  Testirati da li kada se na početnoj stranici sajta mišem stane na dugme DRESSES, a zatim odatle odabere
        SUMMER DRESSES odlazi na korektnu stranu. */
    public void getSummerDressesFromDressesMenu() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement dressesMenu = driver.findElement(By.xpath(Home.dressesMenuXPath));
        action.moveToElement(dressesMenu).perform();
        WebElement summerDressesDMenu = driver.findElement(By.xpath(Home.summerDressesDressesMenuXPath));
        summerDressesDMenu.click();
        Thread.sleep(1000);

        String actualUrl2 = driver.getCurrentUrl();
        String expectedUrl = CategorySummerDresses.urlSummerDresses;
        Assert.assertEquals(actualUrl2, expectedUrl);

    }

    @Test(priority = 2)
    /* 	Proverite da li prethodne dve tačke vode na istu stranicu.  */
    public void checkSummerDressesUrls() {
        Actions action = new Actions(driver);
        WebElement womenMenu = driver.findElement(By.xpath(Home.womenMenuXPath));
        action.moveToElement(womenMenu).perform();
        WebElement summerDressesWMenu = driver.findElement(By.xpath(Home.summerDressesWomenMenuXPath));
        summerDressesWMenu.click();
        String actualUrl1 = driver.getCurrentUrl();

        WebElement dressesMenu = driver.findElement(By.xpath(Home.dressesMenuXPath));
        action.moveToElement(dressesMenu).perform();
        WebElement summerDressesDMenu = driver.findElement(By.xpath(Home.summerDressesDressesMenuXPath));
        summerDressesDMenu.click();
        String actualUrl2 = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl1, actualUrl2);

    }
}
