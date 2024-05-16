package pages.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BlackBar {
    private SelenideElement userMenu = $x("//span[@id='HEADER_USER_MENU_POPUP_text']");

    public BlackBar userMenuAvailable() {
        userMenu.isDisplayed();
        return this;
    }

}
