package practice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import practice.page.element.TextBoxPage;

public class CustomPageFactory {
    private static final WebDriver DRIVER = new ChromeDriver();
    private CustomPageFactory() {}

//    public static TextBoxPage getTextBoxPage() {
//        //створює сторінку і повертає її з заповненими елементами
//        return PageFactory.initElements(DRIVER, TextBoxPage.class);
//    }

    //почитати дженерики
    public static <T extends BasePage> T getPage(Class<T> pageClass) {
        return PageFactory.initElements(DRIVER, pageClass);
    }

    public static WebDriver getDriver() {
        return DRIVER;
    }
}
