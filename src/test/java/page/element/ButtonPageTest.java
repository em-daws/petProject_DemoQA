package page.element;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.page.element.ButtonPage;

public class ButtonPageTest {

    @BeforeMethod
    public void beforeMethod() {
        Configuration.browser = "firefox";
        Configuration.pollingInterval = 100;
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://demoqa.com/buttons");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        Selenide.closeWebDriver();
    }

    @Test
    public void buttonPageTest() throws InterruptedException {
        String expectedString = "You have done a right click";

        SelenideElement rightClickBtn = Selenide.$(By.id("rightClickBtn"));
        rightClickBtn.contextClick();

        String actualString = Selenide.$(By.id("rightClickMessage")).getText();

        Thread.sleep(3000);

        Assert.assertEquals(expectedString, actualString);
        //Configuration
        //SelenideConfig - where all default configs are
    }

    @Test
    public void doubleClickTest() {

        String expectedString = "You have done a double click";

        ButtonPage buttonPage = new ButtonPage();
        buttonPage.doubleClickDoubleClickBtn();
        String actualString = buttonPage.getDoubleClickMessage();

        Assert.assertEquals(expectedString, actualString);
    }
}
