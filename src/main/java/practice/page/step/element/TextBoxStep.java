package practice.page.step.element;

import practice.page.element.TextBoxPage;

public class TextBoxStep {
    TextBoxPage textBoxPage;


    public TextBoxStep(TextBoxPage textBoxPage) {
        this.textBoxPage = textBoxPage;
//        textBoxPage.getDriver(); //if need to work with driver only through steps
    }

    public DynamicPropertiesStep clickDynamicPropertiesBtn() {
        //do smth
        return new DynamicPropertiesStep();
    }
}
