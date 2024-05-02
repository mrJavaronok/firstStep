import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class ErrandCard1 {

    Users Fortest1 = new Users("Фортест1", "Fortest1", "Sh273Ht1");
    Users Fortest2 = new Users("Фортест2", "Fortest2", "Sh273Ht1");
    Users Fortest3 = new Users("Фортест3", "Fortest3", "Sh273Ht1");
    @BeforeMethod
    public void configureTests() {
        Configuration.timeout = 120000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }

    @Test
    public void test1 () {
        open(MainPage.homeWeb());
        AuthPage.goAuth(Fortest1.getLogin(), Fortest1.getPassword());
        AssertMainPage.authCompleted("Выданные мной поручения");
        WebElements.createTypeDoc("Поручение");
        WebElements.setCategoryDoc("СКХ");
        WebElements.setExecutor(Fortest2.getName());
        //$x("//button[text()='Создать']").click();

        sleep(2000);

    }

}
