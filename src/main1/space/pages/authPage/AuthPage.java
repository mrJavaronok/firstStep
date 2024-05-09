package pages.authPage;

import data.Employees;
import data.Users;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class AuthPage {

    public static String homeWeb () {
        return "http://172.30.48.40:8080/share/page/arm?code=SED";
    }

    public static void goAuth(Employees user) {
        $(By.name("username")).setValue(user.getLogin());
        $(By.name("password")).setValue(user.getPassword());
        $x("//button[text()='Войти']").click();
    }
    public static void outAuth() {
        refresh();
        $x("//span[contains(@id,'USER_MENU')]").click();
        $x("//td[text()='Выход']").click();
    }
    public static void authCompleted () {
        $x("//div[@id='HEADER_USER_MENU_BAR']").shouldBe(visible);
    }

}
