package pages.Doc.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesDocPage {

    public SelenideElement filledAttributes(String valueForCheck) {
        return  $x(String.format("//div[@class='main-content']//*[text()='%s']", valueForCheck));
    }
    public SelenideElement docNumber() {
        return $x("//span[contains(@id, 'prop_lecm-document_regnum')]");
    }

    public SelenideElement changeAttributesBtn() {
        return $x("//a[@title='Редактировать сведения']");
    }

    public SelenideElement rightMenuRemoveBtn() {
        return $x("//div[text()='Удалить']");
    }

    public SelenideElement confirmBtn() {
        return $x("//button[text()='OK']");
    }
    public SelenideElement messageAfterRemove() {
        return  $x("//div[contains(text(), 'Документ был удален.')]");
    }

}
