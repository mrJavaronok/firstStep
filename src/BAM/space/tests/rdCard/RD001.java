package tests.rdCard;

import blocks.Docs.Errand.Cases.ExecuterCase;
import blocks.Docs.Errand.ErrandItem.ErrandItem;
import blocks.Docs.Pages.Blocks.ApprovalCase;
import blocks.Docs.Pages.Cases.*;
import data.Users;
import org.testng.annotations.Test;
import blocks.Arm.ArmPage;
import blocks.Auth.AuthPage;
import blocks.Docs.Pages.DocChangePage;
import blocks.Docs.Pages.DocCreatePage;
import blocks.Docs.Pages.DocPage;
import blocks.Panels.BlackBar;
import tools.Config;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RD001 extends Config {
    Users users = new Users();
    AuthPage authPage = new AuthPage();
    ArmPage armPage = new ArmPage();
    DocCreatePage docCreatePage = new DocCreatePage();
    DocPage docPage = new DocPage();
    DocChangePage docChangePage = new DocChangePage();
    BlackBar blackBar = new BlackBar();
    CategoryCase categoryCase = new CategoryCase();
    KindDocCase kindDocCase = new KindDocCase();
    SignersCase signersCase = new SignersCase();
    OrdControllerCase ordControllerCase = new OrdControllerCase();
    ErrandItem errandItem = new ErrandItem();
    ExecuterCase executerCase = new ExecuterCase();
    ApprovalCase approvalCase = new ApprovalCase();

    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        /*open(baseUrl);
        authPage.goAuth(users.getFortest1());
        armPage.createTypeDoc("Распорядительный документ");
        docCreatePage.fillTitleDoc("Тестовый документ");
        docCreatePage.formLoaded();
        categoryCase.setCategoryDoc("ДВП");
        docCreatePage.fillSummaryContent("Да тут соберем всю полезную информацию");
        kindDocCase.setDropListKind("РД по расследованию несчастного случая");
        signersCase.setSigner(users.getFortest2().getName());
        ordControllerCase.setOrdController(users.getFortest2().getName());
        errandItem.addItemTable();
        errandItem.fillTextErrand("Прошу исполнить поручение в срок");
        executerCase.setExecuter(users.getFortest3().getName());
        errandItem.crtItemDone();
        docCreatePage.clickFinalCreateBtn("Создать");
        docPage.pageLoaded();*/
        open("http://172.30.48.40:8080/share/page/document?nodeRef=workspace://SpacesStore/c7d4a7bb-850f-4e2c-9389-f36ec6a93fa1");
        authPage.goAuth(users.getFortest1());
        docPage.pageLoaded();
        approvalCase.createRoute("Фортест этап1", users.getFortest3().getName());


        sleep(5000);
    }

}


