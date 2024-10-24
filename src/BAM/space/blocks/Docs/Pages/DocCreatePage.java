package blocks.Docs.Pages;

import blocks.Docs.Pages.Des.DesDocCreatePage;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class DocCreatePage {
    DesDocCreatePage desDocCreatePage = new DesDocCreatePage();

    public void assertHeadName(String innerText) {
        desDocCreatePage.titleHeadName().shouldHave(innerText(innerText)); // затык
    }

    public void clickFinalCreateBtn(String nameBtn) {
        desDocCreatePage.completeCreateDocBtn(nameBtn).click();
    }

    public void fillTitleDoc(String titleName) {
        desDocCreatePage.fieldTitleDoc().setValue(titleName);
    }

    // Форма создания документа загружена
    public void formLoaded() {
        desDocCreatePage.fieldAttachForInfo().shouldBe(visible);
    }

    // Заполнить поле
    public void fillSummaryContent(String interText) {
        desDocCreatePage.fieldSummaryContent().setValue(interText);
    }


    /*
    // Выбрать отвественного исполнителя
    public DocCreatePage setExecutor(String user) {
        $x("//button[contains(@id, 'executor-assoc-btn-pick-')]").click();
        $x("//input[contains(@id, 'executor-assoc-picker-employee-search-text')]").val(user).press(Keys.ENTER);
        $x("//a[contains(., '"+ user +"')]//ancestor::tr//child::i[@class='icon-plus']").click();
        $x("//button[contains(@id, 'executor-assoc-picker-ok-button)]").click();
        return this;
    }
    */
}
