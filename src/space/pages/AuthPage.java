import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthPage {

    Data user = new Data();
    Asserts getAssert = new Asserts();
    public void goAuth(String loginIs) {
        $(By.name("username")).setValue(loginIs);
        $(By.name("password")).setValue(user.password);
        $x("//button[text()='Войти']").click();
        getAssert.checkHighlightNode("Выданные мной поручения");
    }

    public void outAuth() {
        refresh();
        $x("//span[contains(@id,'USER_MENU')]").click();
        $x("//td[text()='Выход']").click();
        getAssert.checkHighlightNode("Выданные мной поручения");
    }

}
