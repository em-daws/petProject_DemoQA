package practice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonoBankMainPage extends BasePage{
    @FindBy(css = "a[href*=\"deposit\"]")
    private WebElement menuDepositeBtn;

    public MonoBankMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuDepositeBtn() {
        menuDepositeBtn.click();
    }
}
