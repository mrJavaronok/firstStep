package pages.Doc.Cases;

import pages.Doc.Cases.Des.DesKindDoc;

import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.Keys.ENTER;

public class KindDocCase {
    DesKindDoc desKindDoc = new DesKindDoc();
    public void setKindDoc(String catalog, String kindName) {
        desKindDoc.kindDocBtn().click();
        desKindDoc.catalogKindBtn(catalog).click();
        desKindDoc.loadKindElem().shouldNotBe(visible);
        desKindDoc.fieldKindSearch().setValue(kindName).press(ENTER);
        desKindDoc.setKindAddBtn(kindName).click();
        desKindDoc.completeSetKindBtn().click();
    }
}
