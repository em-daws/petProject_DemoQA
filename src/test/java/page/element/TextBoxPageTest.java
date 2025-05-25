package page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.page.CustomPageFactory;
import practice.page.element.TextBoxPage;

public class TextBoxPageTest {

    private TextBoxPage textBoxPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = CustomPageFactory.getDriver();
        driver.manage().window().maximize();
        //ChromeOptions options = new ChromeOptions(); //розглянути
        driver.get("https://demoqa.com/text-box");
        textBoxPage = CustomPageFactory.getTextBoxPage();

        //with using generics:
        //textBoxPage = CustomPageFactory.getPage(TextBoxPage.class);

        //old way without Factory:
        //driver = new ChromeDriver();
        //textBoxPage = new TextBoxPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        textBoxPage = null;
        driver.quit();
        driver = null;
    }

    @Test
    public void fullNameFieldTest() {
        String inputText = "Hanna";

        textBoxPage.enterFullName(inputText);
        textBoxPage.submit();

        Assert.assertTrue(textBoxPage.getOutputText().contains(inputText));
    }
}
