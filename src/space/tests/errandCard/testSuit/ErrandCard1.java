import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class ErrandCard1 {

    @BeforeMethod
    public void configureTests() {
        //Configuration.timeout = 120000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }

    @Test
    public void test1 () {
        open(MainPage.homeWeb());
        //AuthPage.goAuth(Users.Fortest1.getLogin(), Users.Fortest1.getPassword());
        AssertMainPage.authCompleted("Выданные мной поручения");
        WebElements.createTypeDoc("Поручение");
        WebElements.setCategoryDoc("СКХ");
        //WebElements.setExecutor(Users.Fortest2.getName());
        //$x("//button[text()='Создать']").click();

        sleep(2000);

    }

}
