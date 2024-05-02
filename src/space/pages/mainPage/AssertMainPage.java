import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertEquals;

public class AssertMainPage {

    public static void authCompleted(String expectedHighlightNode) {
        assertEquals($x("//table[contains(@class, 'highlight1')]//child::span[text()='Выданные мной поручения']"),
                $x("//table[contains(@class, 'highlight1')]//child::span[text()='"+ expectedHighlightNode +"']"));
    }

}
