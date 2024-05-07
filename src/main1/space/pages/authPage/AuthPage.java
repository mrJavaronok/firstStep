package pages.authPage;

import data.Employees;
import data.Users;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class AuthPage {

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

}
