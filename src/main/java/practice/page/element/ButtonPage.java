package practice.page.element;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ButtonPage {
    private SelenideElement doubleClickBtn = Selenide.$("#doubleClickBtn");
    private SelenideElement doubleClickMessage = Selenide.$("#doubleClickMessage");

    public void doubleClickDoubleClickBtn() {
        doubleClickBtn.shouldBe(Condition.clickable).doubleClick();
    }

    public String getDoubleClickMessage() {
        return doubleClickMessage.shouldBe(Condition.visible).getText();
    }
}
