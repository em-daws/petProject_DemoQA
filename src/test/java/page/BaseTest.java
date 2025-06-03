package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    protected static File DOWNLOADS = new File("C:\\Users\\user\\IdeaProjects\\petProject_DemoQA\\src\\main\\resources\\downloads");
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //with Factory:
//        driver = CustomPageFactory.getDriver();

        //set up downloads directory
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        HashMap<String, Object> prefs = new HashMap<>();
        if(!DOWNLOADS.exists()) {
            DOWNLOADS.mkdir();
        }
        prefs.put("download.default_directory", DOWNLOADS.getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);

        //old way without Factory:
        driver = new ChromeDriver(options);
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
