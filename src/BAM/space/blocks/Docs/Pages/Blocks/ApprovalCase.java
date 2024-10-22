package blocks.Docs.Pages.Blocks;

import blocks.Docs.Pages.Blocks.Des.DesApprovalCase;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.Keys.ENTER;

public class ApprovalCase {

    DesApprovalCase desApprovalCase = new DesApprovalCase();

    public void createRoute(String stepName, String userName) {
        desApprovalCase.createApprovalRouteBtn().click();
        desApprovalCase.typeRouteBtn("Индивидуальный маршрут").click();
        desApprovalCase.doneParamRouteBtn("Продолжить").click();
        desApprovalCase.doneParamRouteBtn("ОК").click();
        desApprovalCase.addStepBtn().click(); //спотыкаемся
        desApprovalCase.typeStepBtn().shouldBe(appear).click();
        desApprovalCase.fieldSearchTypeStep().setValue(stepName);
        desApprovalCase.searchTypeStepBtn().click();
        desApprovalCase.selectTypeStep(stepName).click();
        desApprovalCase.doneParamStepBtn().click();
        desApprovalCase.addEmployeeBtn().click();
        desApprovalCase.listTypeApprovers().click();
        desApprovalCase.selectTypeApproverList("Выбор функциональных групп").shouldBe(visible);
        desApprovalCase.selectTypeApproverList("Выбор функциональных групп").click();
        desApprovalCase.fieldSearchFG().setValue("Фортест ФГ").press(ENTER);
        desApprovalCase.selectEmployeeApprover("Фортест ФГ").click();
        desApprovalCase.doneSelectApproversBtn().click();
        desApprovalCase.doneCreateStepBtn().click();


    }

}
