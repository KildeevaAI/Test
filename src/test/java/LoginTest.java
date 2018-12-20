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

public class LoginTest extends StartSettings
{

    @Test(groups = {"functional"})
    public void Login() throws InterruptedException
    {
        String oldWindow = WDr.getWindowHandle();

        WebElement header = WDr.findElement(By.className("header2__main"));
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        header.findElement(By.xpath("/html/body/div[1]/div/div[1]/noindex/" +
                "div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/a")).click();

        Set<String> newWindows = WDr.getWindowHandles();
        newWindows.remove(oldWindow);
        String newWindowHandle = newWindows.iterator().next();

        WDr.switchTo().window(newWindowHandle);
        Thread.sleep(2000);

        WDr.findElement(By.name("login")).sendKeys("authorizationtest2018");
        Thread.sleep(2000);

        WDr.findElement(By.name("passwd")).sendKeys("authorizationtest20181");
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WDr.findElement(By.cssSelector("button.passport-Button:nth-child(1)")).click();
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WDr.switchTo().window(oldWindow);

        Assert.assertTrue(WDr.findElement(By.cssSelector(
                ".n-passport-suggest-popup-opener > a:nth-child(1) > span:nth-child(1)")).isEnabled());

        WDr.quit();
    }
}
