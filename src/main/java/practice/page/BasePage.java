package practice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected String pageTitle;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    //can be used for validation (public boolean validate())
//    public BasePage(WebDriver driver, String pageTitle) {
//        this.driver = driver;
//        this.pageTitle = pageTitle;
//        PageFactory.initElements(driver, this);
//    }
}
