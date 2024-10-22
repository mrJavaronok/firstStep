package blocks.Docs.Pages.Cases.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesSignersCase {

    //Диалогово окно с выбором подписанта
    public SelenideElement signersBtn () {
        return $x("//button[contains(@id, 'signing-v2-aspects_signerEmployeeAssoc-cntrl-tree-picker-button')]");
    }

    //Поле поиска
    public SelenideElement searchField () {
        return $x("//input[contains(@id, 'signerEmployeeAssoc-cntrl-picker-searchText')]");
    }
    //Кнопка выполнения поиска
    public SelenideElement searchBtn () {
        return $x("//button[contains(@id, 'lecm-signing-v2-aspects_signerEmployeeAssoc-cntrl-picker-searchButton-button')]");
    }
    //Выбор пользователя
    public SelenideElement setEmployee (String userName) {
        return $x(String.format("//a[contains(., '%s')]//ancestor::tr//child::a[contains(@class, 'signerEmployeeAssoc')]", userName));
    }
    //Подтверждение выбора
    public SelenideElement doneBtn () {
        return $x("//button[contains(@id, 'signerEmployeeAssoc-cntrl-ok-button')]");
    }

}
