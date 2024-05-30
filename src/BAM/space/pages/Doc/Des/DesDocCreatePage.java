package pages.Doc.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class DesDocCreatePage {

    // Заголовок страницы создания документа
    public SelenideElement titleHeadName() {
        return $x("//span[@class='alfresco-header-Title__text']");
    }
    //
    // Поле вложения для информации
    public SelenideElement fieldAttachForInfo() {
        return $x("//legend[text()='Документы для информации']//ancestor::div[@class='uploader-block']");
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





}
