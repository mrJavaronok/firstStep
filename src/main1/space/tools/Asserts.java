package tools;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class Asserts {

    WebElements webElem = new WebElements();
    public void currentTitle (String expectedTitle) {
        String title = title();
        assertEquals(title, expectedTitle);
    }

}
