package pages.docPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DocChangePage extends DocCreatePage {

    @Override
    public SelenideElement filledAttributes(String valueForCheck) {
        return $x(String.format("//span[@class='mandatory-indicator']//ancestor::div//child::*[text()='%s' or @title='%s'][not(self::li)]", valueForCheck, valueForCheck));
    }

}
