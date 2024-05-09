package pages.docPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ChangeFormDoc {

    public static void checkAttributes(String[] myArray) {
        for (var value : myArray) {
            $x("//span[@class='mandatory-indicator']//ancestor::div//child::*[text()='"+value+"' or @title='"+value+"'][not(self::li)]").shouldBe(visible);
        }
    }
    public static void verifyFormDocChange(String docNum) {
        $x("//span[contains(@id, 'prop_lecm-document_regnum') and text()='"+docNum+"']").shouldBe(visible);
    }
}
