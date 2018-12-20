import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;


public class StartSettings
{

    protected WebDriver WDr;

    @BeforeTest
    protected WebDriver getDriver()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        WDr = new FirefoxDriver();

        WDr.manage().window().maximize();
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WDr.get("https://market.yandex.ru");

        return WDr;
    }
}