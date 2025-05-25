package page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.page.CustomPageFactory;
import practice.page.element.TextBoxPage;

import java.time.Duration;

public class TextBoxPageTest {

    private TextBoxPage textBoxPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //with Factory:
//        driver = CustomPageFactory.getDriver();

        //old way without Factory:
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //використання implicitly вейтера для драйвера
        //очікування завантаження сторінки
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1L));

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
