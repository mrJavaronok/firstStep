import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class errandCard extends data {

    authPage auth = new authPage();
    webElements webElem = new webElements();
    asserts methAssert = new asserts();

    @Test
    public void main() {
        open(homeSite);
        auth.goAuth(executer);
        webElem.createBtn().click();
        webElem.typeDoc("Поручение").click();

        sleep(2000);
    }

}
