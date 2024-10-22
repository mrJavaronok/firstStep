package blocks.Arm;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesArmPage {

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
        return $x(String.format("//a[text()='%s']", docNum));
    }

    public SelenideElement docInTableBtn(String docNum) {
        return $x(String.format("//td//child::a[text()='%s']", docNum));
    }
    public SelenideElement messageNotSearchElem() {
        return $x("//div[text()='Нет элементов']");
    }


}
