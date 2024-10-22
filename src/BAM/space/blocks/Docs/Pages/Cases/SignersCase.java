package blocks.Docs.Pages.Cases;

import blocks.Docs.Pages.Cases.Des.DesSignersCase;

import static org.openqa.selenium.Keys.ENTER;

public class SignersCase {

    DesSignersCase desSignersCase = new DesSignersCase();

    //Выбор подписанта
    public void setSigner(String userName) {
        desSignersCase.signersBtn().click();
        desSignersCase.searchField().setValue(userName).press(ENTER);
        desSignersCase.setEmployee(userName).click();
        desSignersCase.doneBtn().click();
    }

}
