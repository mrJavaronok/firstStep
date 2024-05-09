package tools;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class Buttons {
    // Кнопка по названию, пока чаще всего встречается в формах подтвержения
    public static void push (String name) {
        $x("//button[text()='"+ name +"']").click();
    }
    /*Общая проверка форм дока, создания дока и изменения дока
    Если страница создания или редактирования, то указываем "Заголовок"
    Дорабоать в месте когда ссылка ещё не успела перейти в новое состояние*/
    public static void checkAttributes(String[] myArray) {

        String currentlyUrl = WebDriverRunner.url();
        if (currentlyUrl.matches("(.*)edit(.*)")) {
            for (var value : myArray) {
                $x("//span[@class='mandatory-indicator']//ancestor::div//child::*[text()='" + value + "' or @title='" + value + "'][not(self::li)]").shouldBe(visible);
                System.out.println(1);
            }
        } else if (currentlyUrl.matches("(.*)create(.*)")) {
            for (var value : myArray) {
                $x("//span[@class='mandatory-indicator']//ancestor::div//child::*[@title='" + value + "'][not(self::li)]").shouldBe(visible);
                System.out.println(2);
            }
        } else {
            for (var value : myArray) {
                $x("//div[@class='main-content']//*[text()='" + value + "']").shouldBe(visible);
                System.out.println(3);
            }
        }
    }

}
