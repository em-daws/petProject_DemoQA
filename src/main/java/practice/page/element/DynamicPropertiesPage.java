package practice.page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import practice.page.BasePage;

import java.time.Duration;

public class DynamicPropertiesPage extends BasePage {
    @FindBy(css = "#enableAfter")
    private WebElement enableAfterBtn;

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public String getBckgrndColorOfEnableAfter() {
        return enableAfterBtn.getCssValue("background-color");
    }

    public void hoverOverAfterBtn() {
        Actions action = new Actions(driver);
        action.moveToElement(enableAfterBtn).perform();
    }

    public void waitAfterBtnToBeClickable() {
        FluentWait<WebDriver> fWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5));
        fWait.until(ExpectedConditions.elementToBeClickable(enableAfterBtn));
    }
}
