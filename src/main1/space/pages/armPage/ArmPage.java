package pages.armPage;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ArmPage {
    // Отжать кнопку создать по типу документа
    public static void createTypeDoc (String type) {
        $x("//button[text()='Создать']").click();
        $x("//a[text()='"+type+"']").click();
    }
    // Выбрать узел по наименованию
    public static void selectNode (String name) {
        $x("//span[text()='"+name+"']").click();
    }
    // Проверить что док присутствует в таблице узла по номеру дока
    public static void sheckDocExist(String docNum) {
        do {
            $x("//div[@class='right ']//child::input[@type='text']").setValue(docNum).sendKeys(Keys.ENTER);
            $x("//span[text()='Загрузка...']").shouldNotBe(visible);
        } while (!$x("//div[text()='Проект']//ancestor::tr//child::a[text()='"+docNum+"']").exists());
    }
    // Нажать на док в таблице по номеру дока
    public static void pushDocFromTable(String docNum) {
        $x("//td//child::a[text()='"+docNum+"']").click();
    }
    // Проверить нет удаленного дока в узеле по номеру дока
    public static void checkDocRemoved(String docNum) {
        $x("//td//child::a[text()='"+docNum+"']").shouldNotBe(visible);
    }


}
