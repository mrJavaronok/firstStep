package blocks.Docs.Errand.Cases.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesExecuterCase {

    public SelenideElement executerBtn () {
        return $x("//button[contains(@id, 'item_assoc_lecm-errands_complex-executor-assoc-btn-pick-button')]");
    }

    //Поле поиска
    public SelenideElement searchField () {
        return $x("//input[contains(@id, 'item_assoc_lecm-errands_complex-executor-assoc-picker-employee-search-text')]");
    }
    //Кнопка выполнения поиска
    public SelenideElement searchBtn () {
        return $x("//button[contains(@id, 'item_assoc_lecm-errands_complex-executor-assoc-picker-employee-search-button')]");
    }
    //Выбор пользователя
    public SelenideElement setEmployee (String userName) {
        return $x(String.format("//a[contains(., '%s')]//ancestor::tr//child::i[contains(@class, 'icon-plus')]", userName));
    }
    //Подтверждение выбора
    public SelenideElement doneBtn () {
        return $x("//button[contains(@id, 'item_assoc_lecm-errands_complex-executor-assoc-picker-ok-button')]");
    }

}
