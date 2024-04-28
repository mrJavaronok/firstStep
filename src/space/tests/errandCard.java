import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class errandCard extends Users{

    authPage auth = new authPage();

    @Test
    public void main() {
        open("http://172.30.48.40:8080/share/page/arm?code=SED");
        auth.goAuth(executer);
        auth.outAuth();
        auth.goAuth(approval);
        sleep(2000);
    }

}
