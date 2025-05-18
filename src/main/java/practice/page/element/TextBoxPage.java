package practice.page.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.page.Path;

import java.util.List;

public class TextBoxPage {
    private WebElement fullNameField;
    private WebElement emailField;
    private WebElement currentAddressField;
    private WebElement permanentAddressField;
    private WebElement submitBtn;

    private WebElement output;
//    private WebElement outputName;

    public TextBoxPage(WebDriver driver) {
        fullNameField = driver.findElement(By.cssSelector(Path.TEXT_BOX_FULL_NAME));
        emailField = driver.findElement(By.cssSelector(Path.TEXT_BOX_EMAIL));
        currentAddressField = driver.findElement(By.cssSelector(Path.TEXT_BOX_CURRENT_ADDRESS));
        permanentAddressField = driver.findElement(By.cssSelector(Path.TEXT_BOX_PERMANENT_ADDRESS));
        submitBtn = driver.findElement(By.cssSelector(Path.TEXT_BOX_SUBMIT_BUTTON));

        output = driver.findElement(By.cssSelector(Path.OUTPUT));
//        outputName = driver.findElement(By.cssSelector(Path.OUTPUT_NAME));
    }

    public void enterFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void submit() {
        submitBtn.click();
    }

    public String getOutputText() {
        List<WebElement> outputs = output.findElements(By.cssSelector(".mb-1"));
        StringBuilder sb = new StringBuilder();
        for (WebElement outputLine : outputs) {
            sb.append(outputLine.getText());
        }
        return sb.toString();
    }
}
