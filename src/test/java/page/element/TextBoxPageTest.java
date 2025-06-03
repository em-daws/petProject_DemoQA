package page.element;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BaseTest;
import practice.page.CustomPageFactory;
import practice.page.element.TextBoxPage;

import java.time.Duration;

public class TextBoxPageTest extends BaseTest {

    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        //ChromeOptions options = new ChromeOptions(); //розглянути
        driver.get("https://demoqa.com/text-box");

        //with Factory:
//        textBoxPage = CustomPageFactory.getTextBoxPage();
        //with using generics:
        //textBoxPage = CustomPageFactory.getPage(TextBoxPage.class);

        //old way without Factory:
        textBoxPage = new TextBoxPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        textBoxPage = null;
        super.tearDown();
    }

    @Description("Allure description")
    @Test
    public void fullNameFieldTest() {
        String inputText = "Hanna";

        textBoxPage.enterFullName(inputText);
        textBoxPage.submit();

        Assert.assertTrue(textBoxPage.getOutputText().contains(inputText));
    }
}
