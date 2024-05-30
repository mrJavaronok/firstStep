package pages.Auth;

import data.Employees;
import pages.Arm.ArmPage;

import static com.codeborne.selenide.Selenide.*;

public class AuthPage {

    public void goAuth(Employees user) {
        $x("//input[@name='username']").setValue(user.getLogin());
        $x("//input[@name='password']").setValue(user.getPassword());
        $x("//button[text()='Войти']").click();
    }

    public void outAuth() {
        refresh();
        $x("//span[@id='HEADER_USER_MENU_POPUP_text']").click();
        $x("//td[text()='Выход']").click();
    }

}
