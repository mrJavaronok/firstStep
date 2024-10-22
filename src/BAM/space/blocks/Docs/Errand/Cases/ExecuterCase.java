package blocks.Docs.Errand.Cases;

import blocks.Docs.Errand.Cases.Des.DesExecuterCase;

import static com.codeborne.selenide.Condition.visible;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.Keys.ENTER;

public class ExecuterCase {

    int waitTime = 300;
    DesExecuterCase desExecuterCase = new DesExecuterCase();

    public void setExecuter(String userName) {
        desExecuterCase.executerBtn().click();
        desExecuterCase.searchField().setValue(userName);
        await()
                .pollInSameThread()
                .ignoreExceptions()
                .atMost(waitTime, SECONDS)
                .until(() -> checkExecuterInField(userName));
        desExecuterCase.setEmployee(userName).click();
        desExecuterCase.doneBtn().click();
    }

    // Проверить что док присутствует в таблице узла по номеру дока
    private boolean checkExecuterInField(String userName) {
        desExecuterCase.searchBtn().click();
        desExecuterCase.setEmployee(userName).shouldBe(visible);
        return true;
    }
}
