import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class webElements {

    public SelenideElement createBtn () {
        return $x("//button[text()='Создать']");
    }

    public ElementsCollection typeDoc (String type) {
        return $$("li[id*=yui-gen]");
    }

}
