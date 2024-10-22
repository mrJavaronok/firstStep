package blocks.Docs.Pages.Cases;

import blocks.Docs.Pages.Cases.Des.DesKindCase;

import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.Keys.ENTER;

public class KindDocCase {
    DesKindCase desKindCase = new DesKindCase();
    public void setKindDoc(String catalog, String kindName) {
        desKindCase.kindDocBtn().click();
        desKindCase.catalogKindBtn(catalog).click();
        desKindCase.loadKindElem().shouldNotBe(visible);
        desKindCase.fieldKindSearch().setValue(kindName).press(ENTER);
        desKindCase.setKindAddBtn(kindName).click();
        desKindCase.completeSetKindBtn().click();
    }

    // Выбор вида документа из выпадающего меню (РД)
    public void setDropListKind(String kindName) {
        desKindCase.elemDropListKind(kindName).click();
    }
}
