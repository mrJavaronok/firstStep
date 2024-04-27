import org.testng.annotations.Test;
import java.util.List;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class approvalCard {
    methods home = new methods();
    //users user = new users();
    @Test
    public void testPushElement () {
        // Открыть страницу и проверить главную стринцу
        home
                .open()
                .assertUrl("http://172.30.48.40:8080/share/page");

        home.inputLogin().val("Fortest1");
        home.inputPass().val("Sh273Ht1");
        home.auth().click();

        // Проверить заголовок страницы
        home.assertTitle("АРМ");

        home.creatBtn().click();
        home.typeCreateMenu().get(0).click();
        home.typeTitle()
                .shouldHave(text("Создать документ \"Карточка согласования\""));
        home.typeDocBtn().click();

        sleep(2000); //1
    }
}

        /*List<String> expectedLinks = List.of("Карточка согласования", "Поручение");

        ElementsCollection linkLists = $$("li[id*=yui-gen]");
        System.out.println(linkLists.texts());
        linkLists.shouldHave(CollectionCondition.texts(expectedLinks));
        linkLists.get(0).click();

        $(By.id("HEADER_USER_MENU_POPUP_text"))
                .shouldHave(text("Фортест1 Фортест1")).click();
        $(By.id("LECM_PROFILE_MENU_ITEM_text")).click();
        // cssSelector
        $("h1")
                .shouldHave(text("Логика ECM. Мой профиль"));
        // xPath
        $(By.xpath("//label[contains(text(),'Я вернусь:')]"))
                .should(be(visible));*/