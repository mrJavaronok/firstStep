package tests.approvalCard.testSuit;
import com.codeborne.selenide.Configuration;
import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPage.AuthPage;
import pages.mainPage.AssertMainPage;
import pages.mainPage.MainPage;
import tools.WebElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ApprovalCard {

    @BeforeMethod
    public void configureTests() {
        Configuration.timeout = 30000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }
    Users users = new Users();
    @Test
    public void test1 () {
        // Открыть страницу и проверить главную стринцу
        open(MainPage.homeWeb());
        AuthPage.goAuth(users.getFortest1());
        $x("//div[@id='HEADER_USER_MENU_BAR']").shouldBe(visible);
        WebElements.createTypeDoc("Карточка согласования");
        $x("//legend[text()='Документы для информации']//ancestor::div[@class='uploader-block']").shouldBe(visible); // дождаться загрузки страницы
        $x("//h1[@id='HEADER_TITLE']//child::span[contains(text(), 'Карточка согласования')]").shouldBe(visible);
        WebElements.setCategoryDoc("Открытый");
        WebElements.setTitle("Тестовый документ Карточка согласования. Удалить");
        WebElements.setKindDoc("Прочие", "Акт");
        $x("//span[@title='Акт']//ancestor::div[contains(@id, 'kind-assoc-cntrl-currentValueDisplay')]").shouldBe(visible);
        $x("//input[@title='Заголовок']").shouldBe(visible);
        $x("//span[@title='Открытый']//ancestor::div[contains(@id, 'category-assoc-cntrl-currentValueDisplay')]").shouldBe(visible);
        WebElements.pushButton("Сохранить проект").click();

        $x("//div[@class='tab tab-common']//child::span[text()='Открытый']").shouldBe(visible);
        $x("//div[@class='tab tab-common']//child::span[text()='Акт']").shouldBe(visible);
        $x("//div[@class='tab tab-common']//child::span[text()='Проект']").shouldBe(visible);

        //span[contains(@id, 'prop_lecm-document_regnum')]
        String numDoc = $x("//span[contains(@id, 'prop_lecm-document_regnum')]").getText();
        $x("//div[@role='menubar']//child::a[@title='КСЭД']").click();
        $x("//span[text()='Созданные мной документы']").click();
        $x("//td//child::a[text()='"+ numDoc +"']").shouldBe(visible);
        $x("//td//child::a[text()='"+ numDoc +"']").click();

        $x("//a[@title='Редактировать сведения']").click();
        $x("//span[contains(@id, 'prop_lecm-document_regnum') and text()='"+ numDoc +"']").shouldBe(visible);
        WebElements.setCategoryDoc("ДВП");
        $x("//span[@title='ДВП']//ancestor::div[contains(@id, 'category-assoc-cntrl-currentValueDisplay')]").shouldBe(visible);

        WebElements.pushButton("Сохранить").click();

        $x("//div[@class='tab tab-common']//child::span[text()='ДВП']").shouldBe(visible);
        $x("//div[@class='tab tab-common']//child::span[text()='Акт']").shouldBe(visible);

        $x("//div[text()='Удалить']").click();
        WebElements.pushButton("OK").click();
        $x("//div[contains(text(), 'Документ был удален.')]").shouldBe(visible);

        $x("//div[@role='menubar']//child::a[@title='КСЭД']").click();
        $x("//span[text()='Проекты']").click();
        $x("//td//child::a[text()='"+ numDoc +"']").shouldNotBe(visible);



        sleep(2000); //1
    }
}