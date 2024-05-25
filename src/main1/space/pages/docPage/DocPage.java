package pages.docPage;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DocPage extends DocCreatePage {

    @Override
    public SelenideElement filledAttributes(String valueForCheck) {
        return  $x(String.format("//div[@class='main-content']//*[text()='%s']", valueForCheck));
    }

    public SelenideElement docNumber() {
        return $x("//span[contains(@id, 'prop_lecm-document_regnum')]");
    }

    public SelenideElement changeAttributesBtn() {
        return $x("//a[@title='Редактировать сведения']");
    }

    public String getDocNumberText() {
        return docNumber().getText();
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



    //***Methods**
    public void removeDoc() {
        rightMenuRemoveBtn().click();
        confirmBtn().click();
        messageAfterRemove().shouldBe(visible);
    }
    public DocChangePage clickChangeAttributesBtn() {
        changeAttributesBtn().click();
        return page(DocChangePage.class);
    }
}
