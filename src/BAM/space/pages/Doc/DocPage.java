package pages.Doc;

import pages.Doc.Des.DesDocPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class DocPage {

    DesDocPage docPageDes = new DesDocPage();

    public String getDocNumberText() {
        return docPageDes.docNumber().getText();
    }

    public void removeDoc() {
        docPageDes.rightMenuRemoveBtn().click();
        docPageDes.confirmBtn().click();
        docPageDes.messageAfterRemove().shouldBe(visible);
    }

    public void clickChangeAttributesBtn() {
        docPageDes.changeAttributesBtn().click();
    }

    public void checkAttributes(String[] myArray) {
        for (var valueForCheck : myArray) {
            docPageDes.filledAttributes(valueForCheck).shouldBe(visible);
        }
    }

}
