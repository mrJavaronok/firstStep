import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;

public class errandCard1 extends data {

    authPage auth = new authPage();
    webElements webElem = new webElements();
    asserts getAssert = new asserts();
    data user = new data();

    @Test
    public void test1 () {
        open(homeSite);
        auth.goAuth(executer);
        webElem.createBtn().click();
        webElem.typeDoc("Поручение").click();
        $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]").click();
        $x("//span[text()='ДВП']//ancestor::tr//child::span[contains(@class, 'addIcon')]").click();
        $x("//button[contains(@id, '-category-assoc-cntrl-ok')]").click();
        $x("//button[contains(@id, 'executor-assoc-btn-pick-')]").click();
        $x("//input[contains(@id, 'executor-assoc-picker-employee-search-text')]").val("Фортест2");
        $x("//button[contains(@id, 'executor-assoc-picker-employee-search-button')]").click();
        $x("//a[contains(., 'Фортест2')]//ancestor::tr//child::i[contains(@class, 'icon-plus')]").click();
        $x("//button[contains(@id, 'executor-assoc-picker-ok-')]").click();
        $x("//button[text()='Создать']").click();


        sleep(2000);

    }

}
