import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class WebElements {

    public static void createTypeDoc (String type) {
        $x("//button[text()='Создать']").click();
        $x("//a[text()='"+ type +"']").click();
    }

    public static void setCategoryDoc (String type) {
        $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]").click();
        $x("//span[text()='"+ type +"']//ancestor::tr//child::span[contains(@class, 'addIcon')]").click();
        $x("//button[contains(@id, '-category-assoc-cntrl-ok')]").click();
    }

    public static void setExecutor (String user) {
        $x("//button[contains(@id, 'executor-assoc-btn-pick-')]").click();
        $x("//input[contains(@id, 'executor-assoc-picker-employee-search-text')]").val(user);
        $x("//button[contains(@id, 'executor-assoc-picker-employee-search-button')]").click();
        $x("//a[contains(., '"+ user +"')]//ancestor::tr//child::i[contains(@class, 'icon-plus')]").click();
        $x("//button[contains(@id, 'executor-assoc-picker-ok-')]").click();
    }

    public static SelenideElement setTitle (String name) {
        return $(By.name("prop_lecm-document_title")).setValue(name);
    }

    public static  void setKindDoc() {
        $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree-picker-button-')]").click();
    }

}
