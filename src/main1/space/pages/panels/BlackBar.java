package pages.panels;

import com.codeborne.selenide.SelenideElement;
import pages.armPage.ArmPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class BlackBar {

    public SelenideElement ksedBtn() {
        return $x("//div[@role='menubar']//child::a[@title='КСЭД']");
    }

    // Отжать кнопку на черной панели по наименованию
    public BlackBar clickKsedBtn() {
        ksedBtn().click();
        return page(ArmPage.class);
    }

}
