package pages.docPage;

import com.codeborne.selenide.SelenideElement;
import pages.panels.BlackBar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;


public class DocCreatePage extends BlackBar {

    // Заголовок страницы создания документа
    public SelenideElement titleHeadName() {
        return $x("//span[@class='alfresco-header-Title__text']");
    }
    //
    // Поле вложения для информации
    public SelenideElement fieldAttachForInfo() {
        return $x("//legend[text()='Документы для информации']//ancestor::div[@class='uploader-block']");
    }

    // Вид документа
    //
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

    // Вид документа
    //
    public SelenideElement categoryDocBtn() {
        return $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]");
    }

    public SelenideElement clearSetCategoryElemBtn() {
        return $x("//div[contains(@id, 'document-category-assoc-cntrl-picker-selection')]//child::span[text()='Очистить']");
    }

    public SelenideElement setCategoryAddBtn(String categoryName) {
        return $x(String.format("//span[text()='%s']//ancestor::tr//child::span[@class='addIcon']", categoryName));
    }

    public SelenideElement completeSetCategoryBtn() {
        return $x("//button[contains(@id, '-category-assoc-cntrl-ok')]");
    }

    // Заполнить заголовок документа
    public SelenideElement fieldTitleDoc() {
        return $x("//input[@name='prop_lecm-document_title']");
    }

    public SelenideElement completeCreateDocBtn(String nameBtn) {
        return $x(String.format("//button[text()='%s']", nameBtn));
    }

    // Заполненный атрибут. Для заголовка = Заголовок
    public SelenideElement filledAttributes(String valueForCheck) {
        return  $x(String.format("//span[@class='mandatory-indicator']//ancestor::div//child::*[@title='%s'][not(self::li)]", valueForCheck));
    }


    //***Methods**
    // Проверить атрибуты по указанным значениям
    public void checkAttributes(String[] myArray) {
        for (var valueForCheck : myArray) {
            filledAttributes(valueForCheck).shouldBe(visible);
        }
    }

    public DocPage clickFinalCreateBtn(String nameBtn) {
        completeCreateDocBtn(nameBtn).click();
        return page(DocPage.class);
    }

    public void fillTitleDoc(String titleName) {
        fieldTitleDoc().setValue(titleName);
    }

    public void setCategoryDoc(String categoryName) {
        categoryDocBtn().click();
        clearSetCategoryElemBtn().click();
        setCategoryAddBtn(categoryName).click();
        completeSetCategoryBtn().click();
    }

    public void setKindDoc(String catalog, String kindName) {
        kindDocBtn().click();
        catalogKindBtn(catalog).click();
        loadKindElem().shouldNotBe(visible);
        fieldKindSearch().setValue(kindName).press(ENTER);
        setKindAddBtn(kindName).click();
        completeSetKindBtn().click();
    }
    // Форма создания документа загружена
    public void formLoaded() {
        fieldAttachForInfo().shouldBe(visible);
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
