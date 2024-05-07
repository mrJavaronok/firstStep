package tools;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Objects;
import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class WebElements {

    public static void createTypeDoc (String type) {
        $x("//button[text()='Создать']").click();
        $x("//a[text()='"+ type +"']").click();
    }

    public static void setCategoryDoc (String type) {
        $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]").click();
        $x("//div[contains(@id, 'document-category-assoc-cntrl-picker-selection')]//child::span[text()='Очистить']").click();
        $x("//span[text()='"+ type +"']//ancestor::tr//child::span[@class='addIcon']").click();
        $x("//button[contains(@id, '-category-assoc-cntrl-ok')]").click();
    }

    public static void setExecutor (String user) {
        $x("//button[contains(@id, 'executor-assoc-btn-pick-')]").click();
        $x("//input[contains(@id, 'executor-assoc-picker-employee-search-text')]").val(user).press(Keys.ENTER);
        $x("//a[contains(., '"+ user +"')]//ancestor::tr//child::i[@class='icon-plus']").click();
        $x("//button[contains(@id, 'executor-assoc-picker-ok-')]").click();
    }

    public static SelenideElement setTitle (String name) {
        return $(By.name("prop_lecm-document_title")).setValue(name);
    }

    public static void setKindDoc(String catalog, String kindName) {
        $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree-picker-button-')]").click();
        $x("//span[text()='"+ catalog +"']").click();
        $x("//div[text()='Загрузка...']//ancestor::tbody[@style= '']").shouldNotBe(visible); // дождаться отсутствия сообщения "Загрузка..."
        $x("//input[contains(@id, 'document-kind-assoc-cntrl-picker-searchText')]").val(kindName).press(Keys.ENTER);
        $x("//span[text()='"+ kindName +"']//ancestor::tr//child::span[@class='addIcon']").click();
        $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok-button')]").click();
    }
    public static SelenideElement pushButton (String name) {
        return $x("//button[text()='"+ name +"']");
    }

}
