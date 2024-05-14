package pages.authPage;

import data.Employees;
import org.openqa.selenium.By;
import pages.armPage.ArmPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class AuthPage {
    // Ссылка на окно авторизации КСЭД
    public String homeWeb () {
        return "http://172.30.48.40:8080/share/page/arm?code=SED";
    }
    // Авторизация под пользователем
    public ArmPage goAuth(Employees user) {
        $(By.name("username")).setValue(user.getLogin());
        $(By.name("password")).setValue(user.getPassword());
        $x("//button[text()='Войти']").click();
        return page(ArmPage.class);
    }
    // Сменить пользователя
    public AuthPage outAuth() {
        refresh();
        $x("//span[contains(@id,'HEADER_USER_MENU_POPUP_text')]").shouldBe(visible);
        $x("//span[contains(@id,'HEADER_USER_MENU_POPUP_text')]").click();
        $x("//td[text()='Выход']").click();
        return page(AuthPage.class);
    }
    // Проверить, что авторизация прошла

}
