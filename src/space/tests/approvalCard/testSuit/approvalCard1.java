import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class approvalCard1 extends data {

    authPage auth = new authPage();
    webElements webElem = new webElements();
    asserts getAssert = new asserts();

    @Test
    public void test1 () {
        // Открыть страницу и проверить главную стринцу
        open(homeSite);
        auth.goAuth(executer);
        webElem.createBtn().click();
        webElem.typeDoc("Карточка согласования").click();

        sleep(2000); //1
    }
}