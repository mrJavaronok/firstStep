import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class webElements {

    public SelenideElement createBtn () {
        return $x("//button[text()='Создать']");
    }

    public SelenideElement typeDoc (String type) {
        return $x("//a[text()='"+ type +"']");
    }

    public SelenideElement highlightMyCreateDocs () {
        return $x("//table[contains(@class, 'highlight1')]//child::span[text()='Выданные мной поручения']");
    }
}
