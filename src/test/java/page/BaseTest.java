package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

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
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
