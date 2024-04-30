import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ErrandCard1 extends Data  {

    AuthPage auth = new AuthPage();
    WebElements webElem = new WebElements();
    Asserts getAssert = new Asserts();

    @Test
    public void test1 () {

        open(homeSite);
        auth.goAuth(executer);
        webElem.createBtn().click();
        webElem.typeDocCreate("Поручение").click();
        $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]").click();
        $x("//span[text()='СКХ']//ancestor::tr//child::span[contains(@class, 'addIcon')]").click();
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
