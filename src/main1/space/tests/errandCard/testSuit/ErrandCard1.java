package tests.errandCard.testSuit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPage.AuthPage;

import static com.codeborne.selenide.Selenide.*;

public class ErrandCard1 {

    @BeforeMethod
    public void configureTests() {
        //Configuration.timeout = 120000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }

    @Test
    public void test1 () {
        open(AuthPage.homeWeb());

        sleep(2000);

    }

}
