import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class asserts {

    public void assertTitle (String expectedTitle) {
        String title = title();
        assertEquals(title, expectedTitle);
    }

}
