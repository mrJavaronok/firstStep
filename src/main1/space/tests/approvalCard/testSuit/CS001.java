package tests.approvalCard.testSuit;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.Users;
import lombok.Data;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;
import pages.panels.BlackBar;
import pages.docPage.ChangeFormDoc;
import pages.docPage.CreationFormDoc;
import pages.docPage.FormDoc;
import pages.panels.RightPanel;
import tools.Buttons;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class CS001 {

    @BeforeMethod
    public void configuration() {
        Configuration.headless = true;
        Configuration.timeout = 20000; // неявное ожидание в 5 секунд
        baseUrl = "http://172.30.48.40:8080/share/page/";
    }
    Users users = new Users();
    @Test
    public void testRun () {
        open(AuthPage.homeWeb()); 
        AuthPage.goAuth(users.getFortest1());
        AuthPage.checkAuthCompleted();
        ArmPage.createTypeDoc("Карточка согласования"); 
        CreationFormDoc.formLoaded();
        CreationFormDoc.checkFormTitle("Карточка согласования"); 
        CreationFormDoc.setCategoryDoc("Открытый"); 
        CreationFormDoc.setTitle("Тестовый документ Карточка согласования. Удалить"); 
        CreationFormDoc.setKindDoc("Прочие", "Акт"); 
        CreationFormDoc.checkAttributes(new String[]{"Заголовок", "Акт", "Открытый"}); 
        Buttons.push("Сохранить проект"); 
        FormDoc.checkAttributes(new String[]{"Акт", "Открытый", "Проект"}); 
        String docNum = FormDoc.getDocNumber().getText();
        BlackBar.pushPanelButton("КСЭД");
        ArmPage.selectNode("Созданные мной документы"); 
        ArmPage.sheckDocExist(docNum); 
        ArmPage.pushDocFromTable(docNum); 
        FormDoc.changeAttributeButton();
        ChangeFormDoc.verifyFormDocChange(docNum); 
        CreationFormDoc.setCategoryDoc("ДВП"); 
        ChangeFormDoc.checkAttributes(new String[]{"ДВП"}); 
        Buttons.push("Сохранить"); 
        FormDoc.checkAttributes(new String[]{"Акт", "ДВП"}); 
        RightPanel.pushPanelButton("Удалить");
        FormDoc.checkMassageRemove(); 
        BlackBar.pushPanelButton("КСЭД");
        ArmPage.selectNode("Проекты"); 
        ArmPage.checkDocRemoved(docNum); 

        sleep(2000); 
    }
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}