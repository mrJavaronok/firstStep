package blocks.Docs.Pages.Blocks.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesApprovalCase {

    public SelenideElement createApprovalRouteBtn() {
        return $x("//button[text()='Создать маршрут']");
    }
    public SelenideElement typeRouteBtn(String typeRoute) {
        return $x(String.format("//a[text()='%s']", typeRoute));
    }

    public SelenideElement doneParamRouteBtn(String nameButton) {
        return $x(String.format("//button[text()='%s']", nameButton));
    }

    public SelenideElement addStepBtn() {
        return $x("//button[text()='Добавить этап']");
    }

    public SelenideElement typeStepBtn() {
        return $x("//button[contains(@id, 'rn-stage-type-cntrl-tree-picker-button-button')]");
    }

    public SelenideElement selectTypeStep(String stepName) {
        return $x(String.format("//span[text()='%s']//ancestor::tr//child::span[@class='addIcon']", stepName));
    }

    public SelenideElement fieldSearchTypeStep() {
        return $x("//input[contains(@id, 'rn-stage-type-cntrl-picker-searchText')]");
    }

    public SelenideElement searchTypeStepBtn() {
        return $x("//button[contains(@id, 'rn-stage-type-cntrl-picker-searchButton-button')]");
    }

    public SelenideElement winTypeStepLoaded() {
        return $x("//div[text()='Новый этап']");
    }

    public SelenideElement doneParamStepBtn() {
        return $x("//button[contains(@id, 'assoc_lecm-approval-rn-aspects_rn-stage-type-cntrl-ok-button')]");
    }

    public SelenideElement addEmployeeBtn() {
        return $x("//button[contains(@id, 'prop_lecm-approval-rn-aspects_approvers-btn-pick-button')]");
    }

    public SelenideElement fieldSearchEmployee() {
        return $x("//input[contains(@id, 'approvers-picker-employee-search-text')]");
    }

    public SelenideElement fieldSearchFG() {
        return $x("//input[contains(@id, 'prop_lecm-approval-rn-aspects_approvers-picker-fg-search-text')]");
    }

    public SelenideElement selectEmployeeApprover(String userName) {
        return $x(String.format("//a[contains(text(), '%s')]//ancestor::tr//child::i[@class='icon-plus']", userName));
    }

    public SelenideElement listTypeApprovers() {
        return $x("//button[contains(@id, 'prop_lecm-approval-rn-aspects_approvers-picker-select')]");
    }

    public SelenideElement selectTypeApproverList(String typeName) {
        return $x(String.format("//button[contains(@id, 'prop_lecm-approval-rn-aspects_approvers-picker-select')]//ancestor::div//child::a[text()='%s']", typeName));
    }

    public SelenideElement doneSelectApproversBtn() {
        return $x("//button[contains(@id, 'prop_lecm-approval-rn-aspects_approvers-picker-ok-butto')]");
    }

    public SelenideElement doneCreateStepBtn() {
        return $x("//button[contains(@id, 'form-submit-button')]");
    }

    /*
    //... добавление сотруднка уже реализовано
//$x("input[contains(@id, 'approvers-picker-employee-search-text')]").setValue(getUser.getName).setKyes(Keys.ENTER); //user
//wait load
    $x("//a[contains(text(), 'KSED_approve_OG5  тестировщик ООО «ПровСег 5')]//ancestor::tr//child::i[@class='icon-plus']").click(); //user
    $x("//button[contains(@id, 'rn-aspects_approvers-picker-ok-button')]").click();*/

}
