package pages.docPage;

import com.codeborne.selenide.SelenideElement;
import pages.armPage.ArmPage;
import tools.Buttons;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DocPage {

   /*/ На правой панели действий отжать кнопку по указанном наименованию
    public DocPage pushRigthMenuRemove() {
        $x("//div[text()='Удалить']").click();
        Buttons.push("OK");
        return this;
    }
    // Отжать кнопку на черной панели по наименованию
    public ArmPage pushBlackBarKSED () {
        $x("//div[@role='menubar']//child::a[@title='КСЭД']").click();
        return page(ArmPage.class);
    }
    // Получить учетный номер документа
    public SelenideElement getDocNumber() {
        return $x("//span[contains(@id, 'prop_lecm-document_regnum')]");
    }
    // Нажать на кнопку Редактировать сведения
    public DocChangePage changeAttributeButton() {
        $x("//a[@title='Редактировать сведения']").click();
        return page(DocChangePage.class);
    }
    // Проверка сообщения, что документ был удален после удаления
    public DocPage checkMassageRemove() {
        $x("//div[contains(text(), 'Документ был удален.')]").shouldBe(visible);
        return this;
    }
    // Проверить атрибуты по указанным значениям
    //@Override
    public DocPage checkAttributes(String[] myArray) {
        for (var value : myArray) {
            $x("//div[@class='main-content']//*[text()='" + value + "']").shouldBe(visible);
        }
        return this;
    }*/

}
