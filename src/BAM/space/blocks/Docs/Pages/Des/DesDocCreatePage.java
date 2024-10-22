package blocks.Docs.Pages.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class DesDocCreatePage {

    // Заголовок страницы создания документа
    public SelenideElement titleHeadName() {
        return $x("//span[@class='alfresco-header-Title__text']");
    }

    // Поле вложения для информации
    public SelenideElement fieldAttachForInfo() {
        return $x("//legend[text()='Документы для информации']//ancestor::div[@class='uploader-block']");
    }

    // Поле заголовка
    public SelenideElement fieldTitleDoc() {
        return $x("//input[@name='prop_lecm-document_title']");
    }

    // Кнопка завершения создания
    public SelenideElement completeCreateDocBtn(String nameBtn) {
        return $x(String.format("//button[text()='%s']", nameBtn));
    }

    // Поле преамбула
    public SelenideElement fieldSummaryContent() {
        return $x("//textarea[@name='prop_lecm-eds-document_summaryContent']");
    }

}
