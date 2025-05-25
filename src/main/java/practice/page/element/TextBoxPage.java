package practice.page.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.page.BasePage;
import practice.page.Path;

import java.util.List;

public class TextBoxPage extends BasePage {
    @FindBy(css = Path.TEXT_BOX_FULL_NAME)
    private WebElement fullNameField;

    @FindBy(css = Path.TEXT_BOX_EMAIL)
    private WebElement emailField;

    @FindBy(css = Path.TEXT_BOX_CURRENT_ADDRESS)
    private WebElement currentAddressField;

    @FindBy(css = Path.TEXT_BOX_PERMANENT_ADDRESS)
    private WebElement permanentAddressField;

    @FindBy(css = Path.TEXT_BOX_SUBMIT_BUTTON)
    private WebElement submitBtn;

    @FindBy(css = Path.OUTPUT)
    private WebElement output;

    //конструктор не потрібен, бо маємо CustomPageFactory
//    public TextBoxPage(WebDriver driver) {
//        //ініціалізуємо елементи, коли викликаємо їх
//        PageFactory.initElements(driver, this);
//    }

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
