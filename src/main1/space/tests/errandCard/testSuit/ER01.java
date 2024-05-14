package tests.errandCard.testSuit;

import com.codeborne.selenide.Configuration;
import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ER01 {
    @BeforeMethod
    public void configuration() {
        Configuration.timeout = 30000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }
    Users users = new Users();
    @Test
    public void test1 () {
     /*   open(AuthPage.homeWeb());
        AuthPage.goAuth(users.getFortest1());
        ArmPage.createTypeDoc("Поручение");
        CreationFormDoc.formLoaded();
        CreationFormDoc.setCategoryDoc("СКХ");
        CreationFormDoc.setExecutor(users.getFortest2().getName());
        CreationFormDoc.checkAttributes(new String[]{"СКХ"});
        Buttons.push("Создать");
        FormDoc.checkAttributes(new String[] {"СКХ"});
        String numDoc = FormDoc.getDocNumber().getText();
        BlackBar.pushPanelButton("КСЭД");
        ArmPage.selectNode("Созданные мной документы");
        ArmPage.sheckDocExist(numDoc);
        ArmPage.pushDocFromTable(numDoc);
        FormDoc.checkAttributes(new String[] {"СКХ", "Test1"});
        RightPanel.pushPanelButton("Удалить");*/


        sleep(2000);

    }

}
