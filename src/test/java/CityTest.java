import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CityTest extends StartSettings
{

    @Test(groups = {"functional"})
    public void City() throws InterruptedException
    {
        WDr.findElement(By.className("header2-menu__text")).click();
        WebElement changeCity = WDr.findElement(By.className("header2-region-popup"));
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        changeCity.findElement(By.className("input__control")).sendKeys("Энгельс");
        Thread.sleep(2000);

        changeCity.findElement(By.className("input__control")).sendKeys(Keys.DOWN, Keys.ENTER);
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        changeCity.findElement(By.className("input__control")).sendKeys(Keys.TAB, Keys.ENTER);
        Thread.sleep(2000);

        WebElement StartCity = WDr.findElement(By.className(("n-region-notification_layout_manual")));
        StartCity.findElement(By.cssSelector(".n-region-notification__back-to")).click();

        WDr.quit();
    }
}