import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class asserts {

    public void currentTitle (String expectedTitle) {
        String title = title();
        assertEquals(title, expectedTitle);
    }

    public void highlightNode () {
        assertNotNull($x("//table[contains(@class, 'highlight1')]//child::span[text()='Выданные мной поручения']"));
    }

}
