package pages.armPage;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ArmPage {
    public static void createTypeDoc (String type) {
        $x("//button[text()='Создать']").click();
        $x("//a[text()='"+ type +"']").click();
    }
    public static void selectNode (String name) {
        $x("//span[text()='"+name+"']").click();
    }
    public static void sheckDocExist(String docNum) {
        do {
            $x("//div[@class='right ']//child::input[@type='text']").setValue(docNum).sendKeys(Keys.ENTER);
            $x("//span[text()='Загрузка...']").shouldNotBe(visible);
        } while (!$x("//div[text()='Проект']//ancestor::tr//child::a[text()='"+docNum+"']").exists());
    }
    public static void pushDocFromTable(String docNum) {
        $x("//td//child::a[text()='"+docNum+"']").click();
    }
    public static void checkDocRemoved(String docNum) {
        $x("//td//child::a[text()='"+docNum+"']").shouldNotBe(visible);
    }


}
