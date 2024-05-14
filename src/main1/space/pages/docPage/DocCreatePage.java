package pages.docPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class DocCreatePage {
    public DocPage pushButton (String name) {
        $x("//button[text()='"+ name +"']").click();
        return page(DocPage.class);
    }
    // Форма создания прогужена
    public DocCreatePage formLoaded() {
        $x("//legend[text()='Документы для информации']//ancestor::div[@class='uploader-block']").shouldBe(visible);
        return this;
    }
    // Проверить заголовок страницы по наименованию
    public DocCreatePage checkFormTitle(String name) {
        $x("//h1[@id='HEADER_TITLE']//child::span[contains(text(), '"+name+"')]").shouldBe(visible);
        return this;
    }
    // Выбрать категорию документа
    public DocCreatePage setCategoryDoc (String type) {
        $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]").click();
        $x("//div[contains(@id, 'document-category-assoc-cntrl-picker-selection')]//child::span[text()='Очистить']").click();
        $x("//span[text()='"+ type +"']//ancestor::tr//child::span[@class='addIcon']").click();
        $x("//button[contains(@id, '-category-assoc-cntrl-ok')]").click();
        return this;
    }
    // Заполнить заголовок документа
    public DocCreatePage setTitle(String name) {
        $(By.name("prop_lecm-document_title")).setValue(name);
        return this;
    }
    // Выбрать вид документа (КС)
    public DocCreatePage setKindDoc(String catalog, String kindName) {
        $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree-picker-button-')]").click();
        $x("//span[text()='"+ catalog +"']").click();
        $x("//div[text()='Загрузка...']//ancestor::tbody[@style= '']").shouldNotBe(visible); // дождаться отсутствия сообщения "Загрузка..."
        $x("//input[contains(@id, 'document-kind-assoc-cntrl-picker-searchText')]").val(kindName).press(Keys.ENTER);
        $x("//span[text()='"+ kindName +"']//ancestor::tr//child::span[@class='addIcon']").click();
        $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok-button')]").click();
        return this;
    }
    // Выбрать отвественного исполнителя
    public DocCreatePage setExecutor (String user) {
        $x("//button[contains(@id, 'executor-assoc-btn-pick-')]").click();
        $x("//input[contains(@id, 'executor-assoc-picker-employee-search-text')]").val(user).press(Keys.ENTER);
        $x("//a[contains(., '"+ user +"')]//ancestor::tr//child::i[@class='icon-plus']").click();
        $x("//button[contains(@id, 'executor-assoc-picker-ok-')]").click();
        return this;
    }
    // Проверить атрибуты по указанным значениям
    public DocCreatePage checkAttributes(String[] myArray) {
        for (var value : myArray) {
            $x("//span[@class='mandatory-indicator']//ancestor::div//child::*[@title='"+value+"'][not(self::li)]").shouldBe(visible);
        }
        return this;
    }

}
