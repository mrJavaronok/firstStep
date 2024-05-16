package tests.approvalCard.testSuit;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class CS001 {
    private Users users;
    private AuthPage authPage;
    private ArmPage armPage;
    private DocCreatePage docCreatePage;
    private DocPage docPage;
    private DocChangePage docChangePage;
    private BlackBar blackBar;

    @BeforeMethod
    public void configuration() {
        baseUrl = "http://172.30.48.40:8080/share/page/";
        Configuration.timeout = 20000; // неявное ожидание в 5 секунд
        //Configuration.headless = true;

        users = new Users();
        authPage = new AuthPage();
        armPage = new ArmPage();
        docCreatePage = new DocCreatePage();
        docPage = new DocPage();
        docChangePage = new DocChangePage();
        blackBar = new BlackBar();


    }

    @Test (/*invocationCount = 2*/)
    public void testRun() {
        open(baseUrl);
        authPage.goAuth(users.getFortest1());
        blackBar.userMenuAvailable();
        armPage.createTypeDoc("Карточка согласования");
        docCreatePage.assertTitleHead("Карточка согласования");
        /*docCreatePage.checkFormTitle("Карточка согласования");
        docCreatePage.setCategoryDoc("Открытый");
        docCreatePage.setTitle("Тестовый документ Карточка согласования. Удалить");
        docCreatePage.setKindDoc("Прочие", "Акт");
        docCreatePage.checkAttributes(new String[]{"Заголовок", "Акт", "Открытый"});
        docCreatePage.pushButton("Сохранить проект");
        docPage.checkAttributes(new String[]{"Акт", "Открытый", "Проект"});
        String docNum = docPage.getDocNumber().getText();
        docPage.pushBlackBarKSED();
        armPage.selectNode("Созданные мной документы");
        armPage.sheckDocExist(docNum);
        armPage.pushDocFromTable(docNum);
        docPage.changeAttributeButton();
        docChangePage.verifyFormDocChange(docNum);
        docChangePage.setCategoryDoc("ДВП");
        docChangePage.checkAttributes(new String[]{"ДВП"});
        docChangePage.pushButton("Сохранить");
        docPage.checkAttributes(new String[]{"Акт", "ДВП"});
        docPage.pushRigthMenuRemove();
        docPage.checkMassageRemove();
        docPage.pushBlackBarKSED();
        armPage.selectNode("Проекты");
        armPage.checkDocRemoved(docNum);*/
    }
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
    
}
/*
open(baseUrl);
        authPage.goAuth(users.getFortest1());
        blackBar.userMenuAvailable();
        armPage.createTypeDoc("Карточка согласования");
        docCreatePage.formLoaded();
        docCreatePage.checkFormTitle("Карточка согласования");
        docCreatePage.setCategoryDoc("Открытый");
        docCreatePage.setTitle("Тестовый документ Карточка согласования. Удалить");
        docCreatePage.setKindDoc("Прочие", "Акт");
        docCreatePage.checkAttributes(new String[]{"Заголовок", "Акт", "Открытый"});
        docCreatePage.pushButton("Сохранить проект");
        docPage.checkAttributes(new String[]{"Акт", "Открытый", "Проект"});
        String docNum = docPage.getDocNumber().getText();
        docPage.pushBlackBarKSED();
        armPage.selectNode("Созданные мной документы");
        armPage.sheckDocExist(docNum);
        armPage.pushDocFromTable(docNum);
        docPage.changeAttributeButton();
        docChangePage.verifyFormDocChange(docNum);
        docChangePage.setCategoryDoc("ДВП");
        docChangePage.checkAttributes(new String[]{"ДВП"});
        docChangePage.pushButton("Сохранить");
        docPage.checkAttributes(new String[]{"Акт", "ДВП"});
        docPage.pushRigthMenuRemove();
        docPage.checkMassageRemove();
        docPage.pushBlackBarKSED();
        armPage.selectNode("Проекты");
        armPage.checkDocRemoved(docNum);
 */