package tests.approvalCard;

import data.Users;
import org.testng.annotations.Test;
import blocks.Arm.ArmPage;
import blocks.Auth.AuthPage;
import blocks.Docs.Pages.Cases.CategoryCase;
import blocks.Docs.Pages.Cases.KindDocCase;
import blocks.Docs.Pages.DocChangePage;
import blocks.Docs.Pages.DocCreatePage;
import blocks.Docs.Pages.DocPage;
import blocks.Panels.BlackBar;
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
    CategoryCase categoryCase = new CategoryCase();
    KindDocCase kindDocCase = new KindDocCase();
    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        // step 1a;
        open(baseUrl);
        authPage.goAuth(users.getFortest1());
        armPage.assertUserMenuName("Фортест1");
        // step 2
        armPage.createTypeDoc("Карточка согласования");
        docCreatePage.assertHeadName("Карточка согласования");
        // step 3
        kindDocCase.setKindDoc("Прочие", "Акт");
        docCreatePage.fillTitleDoc("Это тестовый документ");
        categoryCase.setCategoryDoc("Открытый");

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
        categoryCase.setCategoryDoc("ДВП");
        docChangePage.checkAttributes(new String[]{"ДВП"});
        // step 8
        docChangePage.clickFinalCreateBtn("Сохранить");
        docPage.checkAttributes(new String[]{"Акт", "ДВП"});
        // step 9
        docPage.removeDoc();
        // step 10
        blackBar.clickKsedBtn();
        armPage.selectNode("Проекты");
        armPage.waitAndSearchDocNotExist(docNum);

    }
    
}

