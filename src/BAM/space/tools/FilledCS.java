package tools;

import data.Users;
import blocks.Arm.ArmPage;
import blocks.Auth.AuthPage;
import blocks.Docs.Pages.Cases.CategoryCase;
import blocks.Docs.Pages.Cases.KindDocCase;
import blocks.Docs.Pages.DocCreatePage;

import static com.codeborne.selenide.Selenide.open;

public class FilledCS {
    Users users = new Users();
    AuthPage authPage = new AuthPage();
    ArmPage armPage = new ArmPage();
    DocCreatePage docCreatePage = new DocCreatePage();
    CategoryCase categoryCase = new CategoryCase();
    KindDocCase kindDocCase = new KindDocCase();
    public void createFilledCS() {
        authPage.goAuth(users.getFortest1());
        armPage.assertUserMenuName("Фортест1");
        // step 2
        armPage.createTypeDoc("Карточка согласования");
        docCreatePage.assertHeadName("Карточка согласования");
        // step 3
        kindDocCase.setKindDoc("Прочие", "Акт");
        docCreatePage.fillTitleDoc("Это тестовый документ");
        categoryCase.setCategoryDoc("Открытый");
        // step 4
        docCreatePage.clickFinalCreateBtn("Сохранить проект");
    }

}


