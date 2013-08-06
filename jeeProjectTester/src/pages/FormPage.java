package pages;

import java.text.MessageFormat;

import org.openqa.selenium.support.ui.Select;

public class FormPage extends Pages {

    public void setName(String name) {
        element("unit.name").sendKeys(name);
    }

    public void setCode(String code) {
        element("unit.code").sendKeys(code);
    }

    public void addPhone(String number) {
        element("addChannel").click();

        String channelCount = element("channelCount").getAttribute("value");

        int lastIndex = Integer.valueOf(channelCount) - 1;

        String elementId = MessageFormat.format("channels{0}.value", lastIndex);
        element(elementId).sendKeys(number);
    }

    public void save() {
        element("saveForm").click();
    }

    public void setSuperiorCode(String superiorCode) {
        Select select = new Select(element("superiorCode"));
        select.selectByValue(superiorCode);
    }

}
