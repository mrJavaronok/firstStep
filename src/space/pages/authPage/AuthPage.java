import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthPage {

    Asserts getAssert = new Asserts();
    public static void goAuth(String loginIs, String passwordIs) {
        $(By.name("username")).setValue(loginIs);
        $(By.name("password")).setValue(passwordIs);
        $x("//button[text()='Войти']").click();
    }

    public static void outAuth() {
        refresh();
        $x("//span[contains(@id,'USER_MENU')]").click();
        $x("//td[text()='Выход']").click();
    }

}
