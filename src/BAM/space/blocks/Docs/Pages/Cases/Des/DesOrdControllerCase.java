package blocks.Docs.Pages.Cases.Des;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DesOrdControllerCase {

    public SelenideElement ordControllersBtn () {
        return $x("//button[contains(@id, 'lecm-ord_controller-assoc-cntrl-tree-picker-button')]");
    }

    //Поле поиска
    public SelenideElement searchField () {
        return $x("//input[contains(@id, 'lecm-ord_controller-assoc-cntrl-picker-searchText')]");
    }
    //Кнопка выполнения поиска
    public SelenideElement searchBtn () {
        return $x("//button[contains(@id, 'lecm-ord_controller-assoc-cntrl-picker-searchButton-button')]");
    }
    //Выбор пользователя
    public SelenideElement setEmployee (String userName) {
        return $x(String.format("//a[contains(., '%s')]//ancestor::tr//child::a[contains(@class, 'controller')]", userName));
    }
    //Подтверждение выбора
    public SelenideElement doneBtn () {
        return $x("//button[contains(@id, 'lecm-ord_controller-assoc-cntrl-ok-button')]");
    }

}
