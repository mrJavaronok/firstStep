import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class ApprovalCard1 {

    @BeforeMethod
    public void configureTests() {
        Configuration.timeout = 10000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }

    @Test
    public void test1 () {
        // Открыть страницу и проверить главную стринцу
        open(MainPage.homeWeb());
        AuthPage.goAuth(Users.getFortest1());
        AssertMainPage.authCompleted("Выданные мной поручения");
        WebElements.createTypeDoc("Карточка согласования");
        WebElements.setCategoryDoc("ДВП");
        WebElements.setTitle("Тестовый документ Карточка согласования. Удалить");
        WebElements.setKindDoc("Прочие", "План");

        sleep(2000); //1
    }
}