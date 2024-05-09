package pages.blackBar;

import static com.codeborne.selenide.Selenide.$x;

public class BlackBar {
    public static void  pushKSED () {
        $x("//div[@role='menubar']//child::a[@title='КСЭД']").click();
    }
}
