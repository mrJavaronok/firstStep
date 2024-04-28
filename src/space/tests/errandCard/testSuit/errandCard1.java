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
        getAssert.highlightNode(); // Узел выбран в разеделе Моя работа?
        //webElem.highlightMyCreateDocs().shouldBe(visible);
        webElem.createBtn().click();
        webElem.typeDoc("Поручение").click();
        sleep(2000);

    }

}
