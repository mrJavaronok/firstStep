package tests.approvalCard.testSuit;

import com.codeborne.selenide.Configuration;
import data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools.Buttons;

public class Test10812 {
    @BeforeMethod
    public void configureTests() {
        Configuration.timeout = 10000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }
    Users users = new Users();

    @Test
    public void main () {

    }
}
