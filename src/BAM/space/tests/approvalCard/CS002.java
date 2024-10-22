package tests.approvalCard;

import org.testng.annotations.Test;
import tools.Config;
import tools.FilledCS;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class CS002 extends Config {

    FilledCS filledCS = new FilledCS();
    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        // step 1a;
        open(baseUrl);
        filledCS.createFilledCS();
    }

}
