package tests.approvalCard.testSuit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.Employees;
import data.Users;
import org.testng.annotations.*;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;
import pages.docPage.DocCreatePage;

import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.ENTER;

public class CS002RNTP10812 {
    @BeforeTest
    public void configureTests() {
        Configuration.headless = false;
        Configuration.timeout = 20000; // неявное ожидание в 5 секунд
        baseUrl = "http://172.30.48.40:8080/share/page/";
        // ... Other browser configs
    }
    Users users = new Users();


    @Test (/*threadPoolSize = 5, invocationCount=50*/)
    public void cstest () {
       var random = new SecureRandom();
        AuthPage authPage = open(baseUrl, AuthPage.class);
        var list1 = Arrays.asList(users.getFortest4(), users.getFortest5(), users.getFortest6(), users.getFortest7(), users.getFortest8());
               /* for (Employees el : list1) {
            ArmPage armPage = authPage.goAuth(el);
            armPage.userMenuName().shouldHave(innerText(el.getName()));

            var list = Arrays.asList("Фортест2", "Фортест3");
            var randomElement = list.get(random.nextInt(list.size()));
            $x("//span[@id='DELEGATION_USER_MENU_POPUP_text']").click();
            $x("//a[contains(text(), '" + randomElement + "')]").click(); //user
            $x("//span[contains(text(), '" + randomElement + "')]").shouldBe(visible);
            System.out.println("Секретарь "+ el.getName() +" в режиме работы за: " + randomElement);
            authPage.outAuth(el);
        }*/

        ArmPage armPage = authPage.goAuth(users.getFortest1());
        armPage.userMenuName();
        DocCreatePage docCreatePage = armPage.createTypeDoc("Карточка согласования");
        docCreatePage.formLoaded();

        docCreatePage.titleHeadName().shouldHave(innerText("Карточка согласования"));
        docCreatePage.setCategoryDoc("ДВП");
        $x("//img[contains(@id, 'attachments-temp-assoc-uploader-button-category_id-0')]").click();
        $x("//input[@name ='files[]']")
                .uploadFile(new File("src/main1/space/data/123.txt"));
        docCreatePage.fillTitleDoc("Тестовый документ Карточка согласования. Удалить");
        docCreatePage.setKindDoc("Прочие", "Акт");

        $x("//button[text()='Создать маршрут']").click();
        $x("//a[text()='Индивидуальный маршрут']").click();
        $x("//button[text()='ОК']").click();
        $x("//button[text()='Добавить этап']").click();
        $x("//button[contains(@id, 'rn-stage-type-cntrl-tree-picker-button-button')]").click();
        $x("//span[text()='Фортест этап1']//ancestor::tr//child::span[@class='addIcon']").click(); // Создать этап свой step
        $x("//button[contains(@id, 'rn-aspects_rn-stage-type-cntrl-ok-button')]").click();
        $x("//button[contains(@id, 'rn-aspects_approvers-btn-pick-button')]").click();
        //... добавление сотруднка уже реализовано
        $x("//input[contains(@id, 'approval-rn-aspects_approvers-picker-employee-search-text')]").val(users.getFortest3().getName()).press(ENTER);
        $x("//a[contains(., '"+ users.getFortest3().getName() +"')]//ancestor::tr//child::i[@class='icon-plus']").click();
        $x("//button[contains(@id, 'approvers-picker-ok-button')]").click();
        $x("//button[contains(@id, 'form-submit-button')]").click();

        $x("//a[contains(@id, 'attachment-show-preview')]").shouldBe(visible);

        $x("//button[text()='Направить на согласование']").click();
        $x("//span[contains(@id, 'prop_lecm-document_regnum')]").shouldBe(visible);
        String numDoc = $x("//span[contains(@id, 'prop_lecm-document_regnum')]").getText();

        authPage.outAuth(users.getFortest1());
        for (Employees el : list1) {
            authPage.goAuth(el);
            armPage.userMenuName().shouldHave(innerText(el.getName()));
            $x("//span[text()='Уведомления']").click();
            $x("//a[contains(text(), '" + numDoc + "')]").shouldBe(visible);
            System.out.println(el.getName() + " получил уведомление о направлении на согласование: " + numDoc);
            authPage.outAuth(el);
        }
    }
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
