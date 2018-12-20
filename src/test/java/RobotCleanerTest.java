import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RobotCleanerTest extends LoginTest
{
    @Test(groups = {"functional"})
    public void Cleaner() throws InterruptedException
    {
        Login();

        WDr.findElement(By.className("header2__main")).findElement(By.name("text")).sendKeys(
                "пылесосы", Keys.ENTER);
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement searchLayout = WDr.findElement(By.className("search-layout"));
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchLayout.findElement(By.cssSelector("#search-prepack > div > div > div:nth-child(3) > " +
                "div > div._178jz2CyDL > div:nth-child(5) > fieldset > ul > li:nth-child(2) >" +
                " div > label > div")).click();

        searchLayout.findElement(By.cssSelector("#search-prepack > div > div > div:nth-child(3) >" +
                " div > div._178jz2CyDL > div:nth-child(14) > fieldset > div > label > div")).click();
        WDr.quit();
    }
}
