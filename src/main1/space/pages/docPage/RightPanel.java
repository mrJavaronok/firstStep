package pages.docPage;

import tools.Buttons;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RightPanel {
    // На правой панели действий отжать кнопку по указанном наименованию
    public static void pushPanelButton(String name) {
        $x("//div[text()='"+name+"']").click();
        Buttons.push("OK");
    }
}
