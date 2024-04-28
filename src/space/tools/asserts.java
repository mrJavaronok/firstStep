import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class asserts {

    webElements webElem = new webElements();
    public void currentTitle (String expectedTitle) {
        String title = title();
        assertEquals(title, expectedTitle);
    }

    public void checkHighlightNode (String expectedHighlightNode) {
        assertEquals($x("//table[contains(@class, 'highlight1')]//child::span[text()='Выданные мной поручения']"),
                $x("//table[contains(@class, 'highlight1')]//child::span[text()='"+ expectedHighlightNode +"']"));
    }

}
