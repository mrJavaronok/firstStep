package pages.armPage;

import org.openqa.selenium.Keys;
import pages.docPage.DocCreatePage;
import pages.docPage.DocPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ArmPage {
    // Отжать кнопку создать по типу документа
    public DocCreatePage createTypeDoc(String type) {
        $x("//button[text()='Создать']").click();
        $x("//a[text()='"+type+"']").click();
        return page(DocCreatePage.class);
    }
    // Выбрать узел по наименованию
    public ArmPage selectNode (String name) {
        $x("//span[text()='"+name+"']").click();
        return this;
    }
    // Проверить что док присутствует в таблице узла по номеру дока
    public ArmPage sheckDocExist(String docNum) {
        do {
            $x("//div[@class='right ']//child::input[@type='text']").setValue(docNum).sendKeys(Keys.ENTER);
            $x("//span[text()='Загрузка...']").shouldNotBe(visible);
        } while (!$x("//div[text()='Проект']//ancestor::tr//child::a[text()='"+docNum+"']").exists());
        return this;
    }
    // Нажать на док в таблице по номеру дока
    public DocPage pushDocFromTable(String docNum) {
        $x("//td//child::a[text()='"+docNum+"']").click();
        return page(DocPage.class);
    }
    // Проверить нет удаленного дока в узеле по номеру дока
    public ArmPage checkDocRemoved(String docNum) {
        $x("//td//child::a[text()='"+docNum+"']").shouldNotBe(visible);
        return this;
    }
    public ArmPage checkAuthCompleted () {
        $x("//div[@id='HEADER_USER_MENU_BAR']").shouldBe(visible);
        return this;
    }


}
