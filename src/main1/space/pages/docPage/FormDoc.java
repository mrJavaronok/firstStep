package pages.docPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FormDoc {
    // Получить учетный номер документа
    public static SelenideElement getDocNumber() {
        return  $x("//span[contains(@id, 'prop_lecm-document_regnum')]");
    }
    // Нажать на кнопку Редактировать сведения
    public static void pushChangeAttributes() {
        $x("//a[@title='Редактировать сведения']").click();
    }
    // Проверка сообщения, что документ был удален после удаления
    public static void checkMassageRemove() {
        $x("//div[contains(text(), 'Документ был удален.')]").shouldBe(visible);
    }
    // Проверить атрибуты по указанным значениям
    public static void checkAttributes(String[] myArray) {
        for (var value : myArray) {
            $x("//div[@class='main-content']//*[text()='"+value+"']").shouldBe(visible);
        }
    }

}
