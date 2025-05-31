package page.widget;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BaseTest;
import practice.page.widget.SliderPage;

public class SliderPageTest extends BaseTest {
    SliderPage sliderPage;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/slider");
        sliderPage = new SliderPage(driver);
    }

    @Override
    @AfterMethod
    public void tearDown() {
        super.tearDown();
        sliderPage = null;
    }

    @Test
    public void sliderTest() throws InterruptedException {
        int expectedValue = 100;

        sliderPage.moveSliderTo(100);
        int actual = sliderPage.getSliderValue();

        Assert.assertEquals(actual, expectedValue);
    }
}
