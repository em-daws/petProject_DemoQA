package page.element;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BaseTest;
import practice.page.element.UploadDownloadPage;

import java.io.File;

public class UploadDownloadPageTest extends BaseTest {
    private UploadDownloadPage page;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/upload-download");
        page = new UploadDownloadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        page = null;
    }

    @Test(groups = {"myGroup"})
    public void testUploadFile() {
        String pathToFile = "C:\\Users\\user\\IdeaProjects\\petProject_DemoQA\\src\\main\\resources\\test.txt";
        page.uploadFile(pathToFile);
    }

    @Test(testName = "TestName", description = "Here is description")
    public void testDownload() throws InterruptedException {
        Reporter.log("Will be displayed in Reporter output");
        page.downloadButtonClick();
        Thread.sleep(10000);
        File downloadedFile = new File("C:\\Users\\user\\Downloads\\sampleFile.jpeg");
        Assert.assertTrue(downloadedFile.exists());
    }
}