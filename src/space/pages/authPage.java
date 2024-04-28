import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class authPage {

    Users user = new Users();
    public void goAuth(String loginIs) {

        $(By.name("username")).setValue(loginIs);
        $(By.name("password")).setValue(user.password);
        $x("//button[text()='Войти']").click();
    }

    public void outAuth() {
        refresh();
        $("span[id*=USER_MENU]").click();
        $x("//td[text()='Выход']").click();
    }

}
