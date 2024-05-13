package tests.approvalCard.testSuit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.Users;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;
import pages.docPage.CreationFormDoc;
import tools.Buttons;

import java.awt.*;
import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.headless;
import static com.codeborne.selenide.Selenide.*;

public class CS002RNTP10812 {
    @BeforeTest
    public void configureTests() {
        Configuration.headless = true;
        Configuration.timeout = 20000; // неявное ожидание в 5 секунд
        baseUrl = "http://172.30.48.40:8080/share/page/";
        // ... Other browser configs
    }
    Users users = new Users();

    @Test (/*threadPoolSize = 5, */invocationCount=50)
    public void cstest () {
        open(baseUrl);
        AuthPage.goAuth(users.getFortest4());
        AuthPage.checkAuthCompleted();
        $x("//span[contains(@id, 'DELEGATION_USER_MENU_POPUP_text')]").click();
        var random = new SecureRandom();
        var list = Arrays.asList("Фортест2", "Фортест3");
        var randomElement = list.get(random.nextInt(list.size()));
        System.out.println("Секретарь в режиме работы за: " + randomElement);
        $x("//a[contains(text(), '"+randomElement+"')]").click(); //user
        $x("//span[contains(text(), '"+randomElement+"')]").shouldBe(visible);

        AuthPage.outAuth();
        AuthPage.goAuth(users.getFortest1());
        AuthPage.checkAuthCompleted();
        ArmPage.createTypeDoc("Карточка согласования");
        CreationFormDoc.formLoaded();

        CreationFormDoc.checkFormTitle("Карточка согласования");
        CreationFormDoc.setCategoryDoc("ДВП");
        $x("//img[contains(@id, 'attachments-temp-assoc-uploader-button-category_id-0')]").click();
        $x("//input[@name ='files[]']")
                .uploadFile(new File("src/main1/space/data/123.txt"));
        CreationFormDoc.setTitle("Тестовый документ Карточка согласования. Удалить");
        CreationFormDoc.setKindDoc("Прочие", "Акт");

        $x("//button[text()='Создать маршрут']").click();
        $x("//a[text()='Индивидуальный маршрут']").click();
        $x("//button[text()='ОК']").click();
        $x("//button[text()='Добавить этап']").click();
        $x("//button[contains(@id, 'rn-stage-type-cntrl-tree-picker-button-button')]").click();
        $x("//span[text()='Фортест этап1']//ancestor::tr//child::span[@class='addIcon']").click(); // Создать этап свой step
        $x("//button[contains(@id, 'rn-aspects_rn-stage-type-cntrl-ok-button')]").click();
        $x("//button[contains(@id, 'rn-aspects_approvers-btn-pick-button')]").click();
        //... добавление сотруднка уже реализовано
        $x("//input[contains(@id, 'approval-rn-aspects_approvers-picker-employee-search-text')]").val(users.getFortest3().getName()).press(Keys.ENTER);
        $x("//a[contains(., '"+ users.getFortest3().getName() +"')]//ancestor::tr//child::i[@class='icon-plus']").click();
        $x("//button[contains(@id, 'approvers-picker-ok-button')]").click();
        Buttons.push("ОК");


        $x("//a[contains(@id, 'attachment-show-preview')]").shouldBe(visible);


        Buttons.push("Направить на согласование");
        $x("//em[text()='Атрибуты']").shouldBe(visible);
        $x("//span[contains(@id, 'prop_lecm-document_regnum')]").shouldBe(visible);
        String numDoc = $x("//span[contains(@id, 'prop_lecm-document_regnum')]").getText();

        AuthPage.outAuth();
        AuthPage.goAuth(users.getFortest4());
        AuthPage.checkAuthCompleted();
        $x("//span[text()='Уведомления']").click();
        $x("//a[contains(text(), '"+numDoc+"')]").shouldBe(visible);
        System.out.println("Получено уведомление о направлении на согласование: " + numDoc);



    }
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
