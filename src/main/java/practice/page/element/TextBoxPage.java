package practice.page.element;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import practice.page.BasePage;
import practice.page.ElementUtils;
import practice.page.Path;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class TextBoxPage extends BasePage {

//    private WebDriver driver;

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
    //upd: конструктор вернули лекція 21. Lazy init
    public TextBoxPage(WebDriver driver) {
        super(driver);
        //ініціалізуємо елементи, коли викликаємо їх
//        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Fill email input(allure)")
    public void enterFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Submit step(allure)")
    public void submit() {
        ElementUtils.clickElementWithScrolling(submitBtn, driver);

//        //WebDriverWait extends FluentWait
//        //chain responsibility pattern:
//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofMillis(5000L))
//                .pollingEvery(Duration.ofMillis(50L))
//                .ignoring(ElementClickInterceptedException.class);
//
//        Actions actions = new Actions(driver);
//
//        wait.until(webDriver -> {
//            actions.scrollByAmount(0, 30)
//                    .perform();
//            submitBtn.click();
//            return true;
//        });

        //pay attention to:
//        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
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
