package pages.authPage;

import com.codeborne.selenide.SelenideElement;
import data.Employees;
import org.openqa.selenium.By;
import pages.armPage.ArmPage;

import javax.naming.Name;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class AuthPage {

    private SelenideElement userNameField = $x("//input[@name='username']");
    private SelenideElement userPasswordField = $x("//input[@name='password']");
    private SelenideElement submitBtn = $x("//button[text()='Войти']");

    public AuthPage fillUserField(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }
    public AuthPage fillPasswordField(String password) {
        userPasswordField.sendKeys(password);
        return this;
    }
    public ArmPage clickSubmit() {
        submitBtn.click();
        return page(ArmPage.class);
    }
    public ArmPage goAuth(Employees user) {
        fillUserField(user.getLogin());
        fillPasswordField(user.getPassword());
        clickSubmit();
        return page(ArmPage.class);
    }




}
