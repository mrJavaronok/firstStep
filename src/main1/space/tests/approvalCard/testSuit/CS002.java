package tests.approvalCard.testSuit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.Users;
import org.awaitility.Awaitility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.Keys.ENTER;

public class CS002 {
    private Users users;

    @BeforeMethod
    public void configuration() {
        baseUrl = "http://172.30.48.40:8080/share/page/";
        Configuration.timeout = 20000;
        Configuration.headless = false;

        users = new Users();
    }

    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        // step 1
        AuthPage authPage = open(baseUrl, AuthPage.class);
        ArmPage armPage = authPage.goAuth(users.getFortest1());
        armPage.userMenuName().shouldHave(innerText("Фортест1"));
        // step 2
        armPage.selectParentNode("Созданные мной документы");
        armPage.selectNode("Проекты");
        Awaitility.await().atMost(5, SECONDS).until(docExist());

    }
    private Callable<Boolean> docExist() {
        return () -> $x("//div[text()='У-12345-24']").exists(); // The condition that must be fulfilled
    }

    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();

    }
}
