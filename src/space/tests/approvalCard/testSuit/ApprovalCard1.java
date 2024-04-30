import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ApprovalCard1 extends Data {

    AuthPage auth = new AuthPage();
    WebElements webElem = new WebElements();
    Asserts getAssert = new Asserts();

    @Test
    public void test1 () {
        // Открыть страницу и проверить главную стринцу
        open(homeSite);
        auth.goAuth(executer);
        webElem.createBtn().click();
        webElem.typeDocCreate("Карточка согласования").click();

        sleep(2000); //1
    }
}