import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class errandCard1 extends data {

    authPage auth = new authPage();
    webElements webElem = new webElements();
    asserts getAssert = new asserts();

    @Test
    public void test1 () {
        open(homeSite);
        auth.goAuth(executer);
        webElem.createBtn().click();
        webElem.typeDoc("Поручение").click();
        sleep(2000);

    }

}
