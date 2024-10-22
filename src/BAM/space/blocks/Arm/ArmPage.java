package blocks.Arm;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.Keys.ENTER;

public class ArmPage {
    DesArmPage desArmPage = new DesArmPage();
    int waitTime = 300;


    public void assertUserMenuName(String innterText) {
        desArmPage.userMenuName().shouldHave(innerText(innterText)); // затык
    }

    public void waitAndSearchDoc(String docNum) {
        await()
                .pollInSameThread()
                .ignoreExceptions()
                .atMost(waitTime, SECONDS)
                .until(() -> checkDocInTable(docNum));
    }

    public void waitAndSearchDocNotExist(String docNum) {
        await()
                .pollInSameThread()
                .ignoreExceptions()
                .atMost(waitTime, SECONDS)
                .until(() -> checkDocNotExist(docNum));
    }

    public void clickDocInTable(String docNum) {
        desArmPage.docInTableBtn(docNum).click();
    }

    // Проверить что док присутствует в таблице узла по номеру дока
    public boolean checkDocInTable(String docNum) {
        desArmPage.fieldSearchDoc().setValue(docNum).press(ENTER);
        desArmPage.docInTable(docNum).shouldBe(visible);
        return true;
    }

    public boolean checkDocNotExist(String docNum) {
        desArmPage.fieldSearchDoc().setValue(docNum).press(ENTER);
        desArmPage.messageNotSearchElem().shouldBe(visible);
        return true;
    }

    public void selectParentNode(String nameNode) {
        desArmPage.parentNodeArm(nameNode).click();
    }

    // Выбрать узел по наименованию
    public void selectNode (String nameNode) {
        desArmPage.nodeArm(nameNode).click();
    }

    public void createTypeDoc(String typeName) {
        desArmPage.createTypeDocBtn().click();
        desArmPage.clickTypeDocBtn(typeName).click();
    }

}
