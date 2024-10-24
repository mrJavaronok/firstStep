package blocks.Docs.Pages;

import blocks.Docs.Pages.Des.DesDocChangePage;

import static com.codeborne.selenide.Condition.visible;

public class DocChangePage extends DocCreatePage {
    DesDocChangePage desDocChangePage = new DesDocChangePage();

    public void checkAttributes(String[] myArray) {
        for (var valueForCheck : myArray) {
            desDocChangePage.filledAttributes(valueForCheck).shouldBe(visible);
        }
    }
}
