package page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BaseTest;
import practice.page.element.DynamicPropertiesPage;

import java.time.Duration;

public class DynamicPropertiesPageTest extends BaseTest {
    private DynamicPropertiesPage page;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/dynamic-properties");
        page = new DynamicPropertiesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        page = null;
    }

    @Test
    public void checkAfterBtnColorChangeTest() {
        String colorBefore;
        String colorAfter;

        colorBefore = page.getBckgrndColorOfEnableAfter();
        page.waitAfterBtnToBeClickable();
        page.hoverOverAfterBtn();
        colorAfter = page.getBckgrndColorOfEnableAfter();

        Assert.assertNotEquals(colorBefore, colorAfter);
    }
}