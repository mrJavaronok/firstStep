package pages.authPage;

import data.Employees;
import data.Users;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class AuthPage {
    // Ссылка на окно авторизации КСЭД
    public static String homeWeb () {
        return "http://172.30.48.40:8080/share/page/arm?code=SED";
    }
    // Авторизация под пользователем
    public static void goAuth(Employees user) {
        $(By.name("username")).setValue(user.getLogin());
        $(By.name("password")).setValue(user.getPassword());
        $x("//button[text()='Войти']").click();
    }
    // Сменить пользователя
    public static void outAuth() {
        refresh();
        $x("//span[contains(@id,'USER_MENU')]").click();
        $x("//td[text()='Выход']").click();
    }
    // Проверить, что авторизация прошла
    public static void checkAuthCompleted () {
        $x("//div[@id='HEADER_USER_MENU_BAR']").shouldBe(visible);
    }

}
