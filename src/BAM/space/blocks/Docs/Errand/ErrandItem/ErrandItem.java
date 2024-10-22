package blocks.Docs.Errand.ErrandItem;

import blocks.Docs.Errand.ErrandItem.Des.DesErrandItem;

public class ErrandItem {

    DesErrandItem desErrandItem = new DesErrandItem();

    public void addItemTable() {
        desErrandItem.addItemErrandBtn().click();
    }

    public void fillTextErrand(String textErrand) {
        desErrandItem.textItemErrandField().setValue(textErrand);
    }

    public void crtItemDone() {
        desErrandItem.saveAndCloseBtn().click();
    }

}
