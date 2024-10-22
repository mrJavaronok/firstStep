package blocks.Docs.Pages.Cases.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesKindCase {
    public SelenideElement kindDocBtn() {
        return $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree-picker-button-button')]");
    }
    public SelenideElement catalogKindBtn(String catalog) {
        return $x(String.format("//span[text()='%s']", catalog));
    }

    public SelenideElement loadKindElem() {
        return $x("//div[text()='Загрузка...']//ancestor::tbody[@style= '']");
    }

    public SelenideElement fieldKindSearch() {
        return $x("//input[contains(@id, 'document-kind-assoc-cntrl-picker-searchText')]");
    }

    public SelenideElement setKindAddBtn(String kindName) {
        return $x(String.format("//span[text()='%s']//ancestor::tr//child::span[@class='addIcon']", kindName));
    }

    public SelenideElement completeSetKindBtn() {
        return $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok-button')]");
    }

    //Вид документа в выпадающем спискеs
    public SelenideElement dropListKind() {
        return $x("//select[@name='assoc_lecm-eds-document_document-type-assoc']");
    }

    //Значение для выбора из выпадающего списка вида документа
    public SelenideElement elemDropListKind(String kindName) {
        return $x(String.format("//select[@name='assoc_lecm-eds-document_document-type-assoc']//child::option[text()='%s']", kindName));
    }

}
