package practice.page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import practice.page.BasePage;

public class UploadDownloadPage extends BasePage {
    @FindBy(id = "uploadFile")
    private WebElement uploadInput;
    @FindBy(id = "downloadButton")
    private WebElement downloadButton;

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String pathToFile) {
        uploadInput.sendKeys(pathToFile);
    }

    public void downloadButtonClick() {
        downloadButton.click();
    }
}
