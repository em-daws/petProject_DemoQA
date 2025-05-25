package practice.page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ElementUtils {

    public static void clickElementWithScrolling(WebElement element, WebDriver driver) {

        //WebDriverWait extends FluentWait
        //chain responsibility pattern:
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(5000L))
                .pollingEvery(Duration.ofMillis(50L))
                .ignoring(ElementClickInterceptedException.class);

        Actions actions = new Actions(driver);

        wait.until(webDriver -> {
            actions.scrollByAmount(0, 30)
                    .perform();
            element.click();
            return true;
        });
    }
}
