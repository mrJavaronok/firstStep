import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class methods {

    public methods open() {
        Selenide.open("http://172.30.48.40:8080/share/page");
        return this;
    }

    public SelenideElement inputLogin () {
        return $(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-username"));
    }

    public SelenideElement inputPass () {
        return $(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-password"));
    }

    public SelenideElement auth () {
        return $(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button"));
    }

    public SelenideElement creatBtn () {
        return $(By.id("template_x002e_accordion-toolbar_x002e_arm_x0023_default-newDocumentButton-button"));
    }

    public ElementsCollection typeCreateMenu () {
        return $$("li[id*=yui-gen]");
    }

    public SelenideElement typeTitle () {
        return $("h1");
    }

    public SelenideElement typeDocBtn () {
        return $(By.id("template_x002e_content_x002e_document-create_x0023_default_assoc_rn-document-approval_document-kind-assoc-cntrl-tree-picker-button-button"));
    }

    public void assertUrl(String expectedUrl) {
        String url = WebDriverRunner.url();
        assertEquals(url, expectedUrl);
    }

    public void assertTitle (String expectedTitle) {
        String title = title();
        assertEquals(title, expectedTitle);
    }

}
