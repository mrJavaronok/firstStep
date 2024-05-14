package pages.docPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DocChangePage extends DocCreatePage {

    // Проверить атрибуты по указанным значениям
    public DocChangePage checkAttributes(String[] myArray) {
        for (var value : myArray) {
            $x("//span[@class='mandatory-indicator']//ancestor::div//child::*[text()='"+value+"' or @title='"+value+"'][not(self::li)]").shouldBe(visible);
        }
        return this;
    }
    // Убедится что редактируется обозначенный док по номеру
    public DocChangePage verifyFormDocChange(String docNum) {
        $x("//span[contains(@id, 'prop_lecm-document_regnum') and text()='"+docNum+"']").shouldBe(visible);
        return this;
    }

}
