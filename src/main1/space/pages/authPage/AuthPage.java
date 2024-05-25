package pages.authPage;

import data.Employees;
import data.Users;
import pages.armPage.ArmPage;

import static com.codeborne.selenide.Selenide.*;



public class AuthPage extends Users {

    public ArmPage goAuth(Employees user) {
        $x("//input[@name='username']").setValue(user.getLogin());
        $x("//input[@name='password']").setValue(user.getPassword());
        $x("//button[text()='Войти']").click();
        return page(ArmPage.class);
    }

    public void outAuth() {
        refresh();
        $x("//span[@id='HEADER_USER_MENU_POPUP_text']").click();
        $x("//td[text()='Выход']").click();
    }

}
