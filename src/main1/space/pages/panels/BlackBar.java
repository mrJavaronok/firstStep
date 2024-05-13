package pages.panels;

import static com.codeborne.selenide.Selenide.$x;

public class BlackBar {
    // Отжать кнопку на черной панели по наименованию
    public static void pushPanelButton (String name) {
        $x("//div[@role='menubar']//child::a[@title='"+name+"']").click();
    }
}
