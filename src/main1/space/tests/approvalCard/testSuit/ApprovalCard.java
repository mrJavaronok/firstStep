package tests.approvalCard.testSuit;
import com.codeborne.selenide.Configuration;
import data.Users;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;
import pages.blackBar.BlackBar;
import pages.docPage.ChangeFormDoc;
import pages.docPage.CreationFormDoc;
import pages.docPage.FormDoc;
import pages.docPage.RightPanel;
import tools.Buttons;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ApprovalCard {

    @BeforeMethod
    public void configureTests() {
        Configuration.timeout = 30000; // неявное ожидание в 5 секунд
        // ... Other browser configs
    }
    Users users = new Users();
    @Test
    public void main () {
        // Открыть страницу и проверить главную стринцу
        open(AuthPage.homeWeb()); // Открыть страницу КСЭД
        AuthPage.goAuth(users.getFortest1()); // Авторизоваться
        AuthPage.authCompleted(); // Авторизация выполнена
        ArmPage.createTypeDoc("Карточка согласования"); // Кнопка создать и тип документа
        CreationFormDoc.formLoaded(); // Форма создания загружена
        CreationFormDoc.checkFormTitle("Карточка согласования"); // Проверить что открылась форма создания с указанным типом
        CreationFormDoc.setCategoryDoc("Открытый"); // Выбрать категорию докумета
        CreationFormDoc.setTitle("Тестовый документ Карточка согласования. Удалить"); // Заполнить заголовок
        CreationFormDoc.setKindDoc("Прочие", "Акт"); // Выбрать вид документа
        CreationFormDoc.checkAttributes(new String[]{"Заголовок", "Акт", "Открытый"}); // Проверить заполненные атрибуты
        Buttons.push("Сохранить проект"); // Отжать кнопку
        FormDoc.checkAttributes(new String[]{"Акт", "Открытый", "Проект"}); // Проверить заполненные атрибуты
        String docNum = FormDoc.getDocNumber().getText(); // Сохранить номер дока для манипуляций
        BlackBar.pushKSED(); // Отжать кнопку КСЭД на черной панели сверху
        ArmPage.selectNode("Созданные мной документы"); // Выбрать узел АРМ
        ArmPage.sheckDocExist(docNum); // Проверить что созданный док присутствует в таблице
        ArmPage.pushDocFromTable(docNum); // Нажать на дак в таблице
        FormDoc.pushSetChange(); // Отжать кнопку Редактировать атрибуты
        ChangeFormDoc.verifyFormDocChange(docNum); // Проверить что открылась форма редактирования нужного дока
        CreationFormDoc.setCategoryDoc("ДВП"); // Выбрать категорию докумета
        ChangeFormDoc.checkAttributes(new String[]{"ДВП"}); // Проверить заполненные атрибуты
        Buttons.push("Сохранить"); // Отажать кнопку
        FormDoc.checkAttributes(new String[]{"Акт", "ДВП"}); // Проверить заполненные атрибуты
        RightPanel.pushButton("Удалить"); // На правой панелеи нажать Удалить, Подтвердить
        FormDoc.checkMassageRemove(); // Страница с сообщение что док удален
        BlackBar.pushKSED(); // Отжать кнопку КСЭД на черной панели сверху
        ArmPage.selectNode("Проекты"); // Выбрать узел АРМ
        ArmPage.checkDocRemoved(docNum); // Проверить что в таблице нет удаленного дока

        sleep(2000); //1
    }
}