package page.frame;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BaseTest;
import practice.page.MonoBankMainPage;
import practice.page.frame.FramePage;

import java.io.File;
import java.io.IOException;

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
        driver.get("https://monobank.ua/");
//        Thread.sleep(1000);
        MonoBankMainPage monoBankMainPage = new MonoBankMainPage(driver);
        monoBankMainPage.clickMenuDepositeBtn();

//        driver.switchTo().window(windowHandle);
        Thread.sleep(1000);
    }

    @Test
    public void JSExecutorTest() throws InterruptedException, IOException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
//        ((JavascriptExecutor) driver).executeScript("alert('Hello!');");
//        Thread.sleep(2000);

        if(driver instanceof TakesScreenshot screenshot) {
            //+screen.getName();
            screenshot.getScreenshotAs(OutputType.FILE).renameTo(new File("src/main/resources/1.png"));
        }
    }
}