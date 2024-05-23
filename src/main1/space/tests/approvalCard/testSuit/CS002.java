package tests.approvalCard.testSuit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import data.Users;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
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

        for (var i = 0; i < 5; i++) {
            armPage.selectParentNode("Созданные мной документы");
            armPage.selectNode("Проекты");
            //$$x("//div[text()='Карточка согласования']").get(i).shouldBe(visible);
            sleep(2000);
            actions().moveToElement($$x("//div[text()='Карточка согласования']").get(i)).perform();
            $$x("//img[@title='Добавить в избранное']").get(i).click();
            armPage.selectNode("Избранное");
            armPage.clickKsedBtn();
            await().atMost(60, SECONDS).until(armPage.awaitSizeList());
        }



    }


/*    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();

    }*/
}
