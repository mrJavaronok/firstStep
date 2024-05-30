package tests.approvalCard.testSuit;

import data.Users;
import org.testng.annotations.Test;
import pages.Arm.ArmPage;
import pages.Auth.AuthPage;
import pages.Doc.Cases.CategoryDocCase;
import pages.Doc.Cases.KindDocCase;
import pages.Doc.DocChangePage;
import pages.Doc.DocCreatePage;
import pages.Doc.DocPage;
import pages.Panels.BlackBar;
import tools.Config;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class CS001 extends Config {
    Users users = new Users();
    AuthPage authPage = new AuthPage();
    ArmPage armPage = new ArmPage();
    DocCreatePage docCreatePage = new DocCreatePage();
    DocPage docPage = new DocPage();
    DocChangePage docChangePage = new DocChangePage();
    BlackBar blackBar = new BlackBar();
    CategoryDocCase categoryDocCase = new CategoryDocCase();
    KindDocCase kindDocCase = new KindDocCase();
    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        // step 1a;
        open(baseUrl);
        authPage.goAuth(users.getFortest1());
        armPage.assertUserMenuName("Фортест1");
        // step 2
        docCreatePage = armPage.createTypeDoc("Карточка согласования");
        docCreatePage.assertHeadName("Карточка согласования");
        // step 3
        kindDocCase.setKindDoc("Прочие", "Акт");
        docCreatePage.fillTitleDoc("Это тестовый документ");
        categoryDocCase.setCategoryDoc("Открытый");
        docCreatePage.checkAttributes(new String[]{"Акт", "Заголовок", "Открытый"});
        // step 4
        docCreatePage.clickFinalCreateBtn("Сохранить проект");
        docPage.checkAttributes(new String[]{"Акт", "Открытый", "Проект"});
        String docNum = docPage.getDocNumberText();
        // step 5
        blackBar.clickKsedBtn();
        armPage.selectParentNode("Созданные мной документы");
        armPage.selectNode("Проекты");
        armPage.waitAndSearchDoc(docNum);
        armPage.clickDocInTable(docNum);
        // step 6
        docPage.clickChangeAttributesBtn();
        docChangePage.checkAttributes(new String[]{docNum});
        // step 7
        categoryDocCase.setCategoryDoc("ДВП");
        docChangePage.checkAttributes(new String[]{"ДВП"});
        // step 8
        docChangePage.clickFinalCreateBtn("Сохранить");
        docPage.checkAttributes(new String[]{"Акт", "ДВП"});
        // step 9
        docPage.removeDoc();
        // step 10
        blackBar.clickKsedBtn();
        armPage.selectNode("Проекты");
        armPage.checkDocNotExist(docNum);

    }
    
}

