package pages.Panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesBlackBar {

    public SelenideElement ksedBtn() {
        return $x("//div[@role='menubar']//child::a[@title='КСЭД']");
    }

}
