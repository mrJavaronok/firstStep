package tools;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.baseUrl;

public class Config {

    @BeforeMethod
    public void configuration() {
        baseUrl = "http://172.30.48.40:8080/share/page/";
        Configuration.timeout = 10000; // неявное ожидание в 5 секунд
        Configuration.headless = false;
    }
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }

}
