package blocks.Docs.Pages.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesDocChangePage {

    public SelenideElement filledAttributes(String valueForCheck) {
        return $x(String.format("//span[@class='mandatory-indicator']//ancestor::div//child::*[text()='%s' or @title='%s'][not(self::li)]", valueForCheck, valueForCheck));
    }

}
