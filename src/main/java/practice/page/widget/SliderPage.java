package practice.page.widget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import practice.page.BasePage;

public class SliderPage extends BasePage {
    @FindBy(css = ".range-slider")
    private WebElement slider;

    @FindBy(id = "sliderValue")
    private WebElement sliderValue;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSliderTo(int value) {
        Actions actions = new Actions(driver);
        double doubleValue = (double) value / 100;
        int width = slider.getRect().getWidth();
        int xZero = slider.getLocation().getX();

        actions.clickAndHold(slider)
                .moveToLocation(xZero, 0)
                .moveByOffset((int)(doubleValue * width), 0)
                .perform();
    }

    public int getSliderValue() {
        String text = sliderValue.getDomAttribute("value");
        assert text != null;
        return Integer.parseInt(text);
    }
}
