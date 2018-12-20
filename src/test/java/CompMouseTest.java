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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CompMouseTest extends StartSettings{

    @Test(groups = {"functional"})
    public void SelectCompMouse() throws InterruptedException
    {
        WDr.findElement(By.cssSelector("#header-search")).sendKeys("Компьютерные мыши", Keys.ENTER);
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement searchLayout = WDr.findElement(By.className("search-layout"));
        WDr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement price = searchLayout.findElement(By.cssSelector("#glpricefrom"));
        price.sendKeys("800", Keys.TAB, Keys.TAB);

        WebElement Price = searchLayout.findElement(By.cssSelector("#glpriceto"));
        Price.sendKeys("1000");
        Thread.sleep(3000);

        List<WebElement> allItems = WDr.findElement(By.className("n-snippet-list")).findElements(By.xpath(
                "//div[@class = 'price']"));

        for (WebElement cost : allItems)
        {
            int mouse = Integer.parseInt(cost.getText().substring(0, cost.getText().length() - 2));
            System.out.println(mouse);
            Assert.assertTrue(mouse <= 1000 && mouse >= 800);
        }

        WDr.quit();
    }
}