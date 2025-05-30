package practice.page.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.page.BasePage;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        String heading = getFirstFrame().getHeading();
        driver.switchTo().defaultContent(); //parentFrame?
        return heading;
    }

    public SamplePage getFirstFrame() {
        return new SamplePage("frame1");
//        return PageFactory.initElements(driver, SamplePage.class); //can I do that?
    }

    class SamplePage {
        @FindBy(css = "#sampleHeading")
        private WebElement heading;

        public SamplePage() {
            PageFactory.initElements(driver, this);
        }

        public SamplePage(String selector) {
            PageFactory.initElements(driver, this);
            driver.switchTo().frame(selector);
        }

        public String getHeading() {
            return heading.getText();
        }

//        public FramePage returnToParentFrame() {
//            driver.switchTo().parentFrame();
//            return new FramePage(driver);
//        }
    }
}