package pages.armPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import pages.docPage.DocCreatePage;
import pages.docPage.DocPage;
import pages.panels.BlackBar;

import java.util.concurrent.Callable;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;

public class ArmPage extends BlackBar {

    public SelenideElement userMenuName() {
        return $x("//span[@id='HEADER_USER_MENU_POPUP_text']");
    }

    public SelenideElement createTypeDocBtn() {
        return $x("//button[text()='Создать']");
    }

    public SelenideElement clickTypeDocBtn(String typeName) {
        return $x(String.format("//a[text()='%s']", typeName));
    }

    public SelenideElement nodeArm(String nameNode) {
        return $x(String.format("//span[text()='%s']", nameNode));
    }

    public SelenideElement parentNodeArm(String nameNode) {
        return $x(String.format("//span[text()='%s']//ancestor::tr//child::a", nameNode));
    }

    public SelenideElement fieldSearchDoc() {
        return $x("//div[@class='right ']//child::input[@type='text']");
    }

    public SelenideElement messageLoadSearchDoc() {
        return $x("//span[text()='Загрузка...']");
    }

    public SelenideElement docInTableAndStatus(String docNum, String status) {
        return $x(String.format("//div[text()='%s']//ancestor::tr//child::a[text()='%s']", status, docNum));
    }

    public SelenideElement docInTable(String docNum) {
        return $x(String.format("//div[text()='%s']", docNum));
    }

    public SelenideElement docInTableBtn(String docNum) {
        return $x(String.format("//td//child::a[text()='%s']", docNum));
    }

    // Нажать на док в таблице по номеру дока
    public DocPage clickDocInTable(String docNum) {
        docInTableBtn(docNum).click();
        return page(DocPage.class);
    }


    // Проверить что док присутствует в таблице узла по номеру дока
    public void checkDocInTableAndStatus(String docNum, String status) {
        do {
            fieldSearchDoc().setValue(docNum).press(ENTER);
            messageLoadSearchDoc().shouldNotBe(visible);
        } while (!docInTableAndStatus(docNum, status).exists());
    }

    public void checkNotExistDoc(String docNum) {
        do {
            fieldSearchDoc().setValue(docNum).press(ENTER);
            messageLoadSearchDoc().shouldNotBe(visible);
        } while (docInTable(docNum).exists());
    }

    public void selectParentNode(String nameNode) {
        parentNodeArm(nameNode).click();
    }
    // Выбрать узел по наименованию
    public void selectNode (String nameNode) {
        nodeArm(nameNode).click();
    }

    public DocCreatePage createTypeDoc(String typeName) {
        createTypeDocBtn().click();
        clickTypeDocBtn(typeName).click();
        return page(DocCreatePage.class);
    }


    public ElementsCollection listElem() {
        return $$x("//span[@class='expand-table-icon']");
    }
    public Callable<Boolean> awaitSizeList() {
        return () -> listElem().size() == 2; // The condition that must be fulfilled
    }

}
