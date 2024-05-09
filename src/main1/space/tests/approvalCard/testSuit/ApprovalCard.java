package tests.approvalCard.testSuit;
import com.codeborne.selenide.Configuration;
import data.Users;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;
import pages.blackBar.BlackBar;
import pages.docPage.ChangeFormDoc;
import pages.docPage.CreationFormDoc;
import pages.docPage.FormDoc;
import pages.docPage.RightPanel;
import tools.Buttons;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ApprovalCard {

    @BeforeMethod
    public void configureTests() {
        Configuration.timeout = 30000; 
        
    }
    Users users = new Users();
    @Test
    public void main () {
        
        open(AuthPage.homeWeb()); 
        AuthPage.goAuth(users.getFortest1()); 
        AuthPage.authCompleted(); 
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
        BlackBar.pushKSED(); 
        ArmPage.selectNode("Созданные мной документы"); 
        ArmPage.sheckDocExist(docNum); 
        ArmPage.pushDocFromTable(docNum); 
        FormDoc.pushSetChange(); 
        ChangeFormDoc.verifyFormDocChange(docNum); 
        CreationFormDoc.setCategoryDoc("ДВП"); 
        ChangeFormDoc.checkAttributes(new String[]{"ДВП"}); 
        Buttons.push("Сохранить"); 
        FormDoc.checkAttributes(new String[]{"Акт", "ДВП"}); 
        RightPanel.pushButton("Удалить"); 
        FormDoc.checkMassageRemove(); 
        BlackBar.pushKSED(); 
        ArmPage.selectNode("Проекты"); 
        ArmPage.checkDocRemoved(docNum); 

        sleep(2000); 
    }
}