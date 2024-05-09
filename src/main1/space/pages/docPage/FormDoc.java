package pages.docPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FormDoc {

    public static void pushSetChange() {
        $x("//a[@title='Редактировать сведения']").click();
    }
    public static void checkMassageRemove() {
        $x("//div[contains(text(), 'Документ был удален.')]").shouldBe(visible);
    }
    public static void checkAttributes(String[] myArray) {
        for (var value : myArray) {
            $x("//div[@class='main-content']//*[text()='"+value+"']").shouldBe(visible);
        }
    }

    public static SelenideElement getDocNumber() {
        return  $x("//span[contains(@id, 'prop_lecm-document_regnum')]");
    }

}
