package pages.docPage;

import tools.Buttons;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RightPanel {
    public static void pushButton(String name) {
        $x("//div[text()='"+name+"']").click();
        Buttons.push("OK");
    }
}
