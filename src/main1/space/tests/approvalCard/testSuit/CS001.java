package tests.approvalCard.testSuit;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.InnerText;
import data.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.panels.BlackBar;
import pages.authPage.AuthPage;
import pages.docPage.DocChangePage;
import pages.docPage.DocCreatePage;
import pages.docPage.DocPage;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class CS001 {
    private Users users;

    @BeforeMethod
    public void configuration() {
        baseUrl = "http://172.30.48.40:8080/share/page/";
        Configuration.timeout = 20000; // неявное ожидание в 5 секунд
        Configuration.headless = false;

        users = new Users();
    }

    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        // step 1
        AuthPage authPage = open(baseUrl, AuthPage.class);
        ArmPage armPage = authPage.goAuth(users.getFortest1());
        armPage.userMenuName().shouldHave(innerText("Фортест1"));
        // step 2
        DocCreatePage docCreatePage = armPage.createTypeDoc("Карточка согласования");
        docCreatePage.formLoaded();
        docCreatePage.titleHeadName().shouldHave(innerText("Карточка согласования"));
        // step 3
        docCreatePage.setKindDoc("Прочие", "Акт");
        docCreatePage.fillTitleDoc("Это тестовый документ");
        docCreatePage.setCategoryDoc("Открытый");
        docCreatePage.checkAttributes(new String[]{"Акт", "Заголовок", "Открытый"});
        // step 4
        DocPage docPage = docCreatePage.clickFinalCreateBtn("Сохранить проект");
        docPage.checkAttributes(new String[]{"Акт", "Открытый", "Проект"});
        String docNum = docPage.getDocNumberText();
        // step 5
        docPage.clickKsedBtn();
        armPage.selectParentNode("Созданные мной документы");
        armPage.selectNode("Проекты");
        armPage.checkDocInTableAndStatus(docNum, "Проект");
        armPage.clickDocInTable(docNum);
        // step 6
        DocChangePage docChangePage = docPage.clickChangeAttributesBtn();
        docChangePage.checkAttributes(new String[]{docNum});
        // step 7
        docChangePage.setCategoryDoc("ДВП");
        docChangePage.checkAttributes(new String[]{"ДВП"});
        // step 8
        docChangePage.clickFinalCreateBtn("Сохранить");
        docPage.checkAttributes(new String[]{"Акт", "ДВП"});
        // step 9
        docPage.removeDoc();
        docPage.messageAfterRemove();
        // step 10
        docPage.clickKsedBtn();
        armPage.selectNode("Проекты");
        armPage.checkNotExistDoc(docNum);
    }
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
    
}

