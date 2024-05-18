package pages.authPage;

import com.codeborne.selenide.SelenideElement;
import data.Employees;
import org.openqa.selenium.By;
import pages.armPage.ArmPage;

import javax.naming.Name;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class AuthPage {

    public AuthPage fillLoginField(String login) {
        $x("//input[@name='username']").setValue(login);
        return this;
    }
    public AuthPage fillPasswordField(String password) {
        $x("//input[@name='password']").setValue(password);
        return this;
    }
    public ArmPage clickSubmit() {
        $x("//button[text()='Войти']").click();
        return page(ArmPage.class);
    }
    public ArmPage goAuth(Employees user) {
        fillLoginField(user.getLogin());
        fillPasswordField(user.getPassword());
        clickSubmit();
        return page(ArmPage.class);
    }




}
