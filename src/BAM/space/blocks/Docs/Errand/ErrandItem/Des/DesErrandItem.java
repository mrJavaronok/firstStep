package blocks.Docs.Errand.ErrandItem.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesErrandItem {

    public SelenideElement addItemErrandBtn() {
        return $x("//button[contains(@id, 'ord_temp-items-assoc-toolbar-newRowButton-button')]");
    }

    public SelenideElement textItemErrandField() {
        return $x("//textarea[contains(@name, 'prop_lecm-ord-table-structure_item-content')]");
    }

    public SelenideElement saveAndCloseBtn() {
        return $x("//button[text()='Сохранить и закрыть']");
    }

}
