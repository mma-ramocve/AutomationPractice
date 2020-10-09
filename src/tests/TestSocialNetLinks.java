package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;

import java.util.ArrayList;

/*   Proveriti da li ikonice koje se nalaze u meniju na kraju stranice vode na odgovarajuće adrese
     (ikonice za Facebook, Twitter, YouTube...) */
public class TestSocialNetLinks {
    public WebDriver driver;

//    @BeforeTest
//    public void getHomePage() {
//        System.setProperty("webdriver.chrome.driver", Home.driverPath);
//        driver = new ChromeDriver();
//        driver.get(Home.homeUrl);
//    }
//
//    @AfterTest
//    public void closeBrowser() throws InterruptedException {
//        driver.quit();
//
//    }

    @Test
    public void facebookLinkCheck() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.get(Home.homeUrl);

        WebElement faceBookLink = driver.findElement(By.xpath(Home.FaceBookLinkXPath));
        faceBookLink.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.facebook.com/groups/525066904174158/");

        driver.quit();
    }

    @Test
    public void twitterLinkCheck() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.get(Home.homeUrl);

        WebElement twitterLink = driver.findElement(By.xpath(Home.TwitterLinkXPath));
        twitterLink.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://twitter.com/seleniumfrmwrk");

        driver.quit();
    }

    @Test
    public void youtubeLinkCheck() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.get(Home.homeUrl);

        WebElement youtubeLink = driver.findElement(By.xpath(Home.YouTubeLinkXPath));
        youtubeLink.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA");

        driver.quit();
    }
}