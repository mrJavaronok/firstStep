package blocks.Docs.Pages.Cases.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesCategoryCase {
    public SelenideElement categoryDocBtn() {
        return $x("//button[contains(@id,'document-category-assoc-cntrl-tree')]");
    }

    public SelenideElement clearSetCategoryElemBtn() {
        return $x("//div[contains(@id, 'document-category-assoc-cntrl-picker-selection')]//child::span[text()='Очистить']");
    }

    public SelenideElement setCategoryAddBtn(String categoryName) {
        return $x(String.format("//span[text()='%s']//ancestor::tr//child::span[@class='addIcon']", categoryName));
    }

    public SelenideElement completeSetCategoryBtn() {
        return $x("//button[contains(@id, '-category-assoc-cntrl-ok')]");
    }

}
