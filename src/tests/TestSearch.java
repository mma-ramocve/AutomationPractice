package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;

import javax.naming.directory.SearchResult;

/*  Testirati da li radi ‘search’ bar. Ukucati ‘yellow’ i ispitati rezultat pretrage. Očekivan ishod je prikaz
tri artikla, pri čemu svaki od njih ima mogućnost odabira žute boje.  */
public class TestSearch {

    public WebDriver driver;
    private Object SearchResult;

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

    @Test
    public void checkSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.get(Home.homeUrl);

        WebElement inputSearch = driver.findElement(By.xpath(Home.searchXPath));
        inputSearch.sendKeys("yellow");

        WebElement submitCLick = driver.findElement(By.xpath(Home.submitXPath));
        submitCLick.click();
        Thread.sleep(2000);


    }
}
