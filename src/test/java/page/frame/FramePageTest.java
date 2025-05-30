package page.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BaseTest;
import practice.page.frame.FramePage;

public class FramePageTest extends BaseTest {
    private FramePage framePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/frames");
        framePage = new FramePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        framePage = null;
    }

    @Test
    public void headerTest() {
        String expectedHeader = "This is a sample page";
        String actualHeader = framePage.getHeaderText();
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void newTabTest() throws InterruptedException {
        String windowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com/");
        Thread.sleep(1000);

        driver.switchTo().window(windowHandle);
        Thread.sleep(1000);
    }
}