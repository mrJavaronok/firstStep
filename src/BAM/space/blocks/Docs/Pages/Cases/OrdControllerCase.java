package blocks.Docs.Pages.Cases;

import blocks.Docs.Pages.Cases.Des.DesOrdControllerCase;

import static org.openqa.selenium.Keys.ENTER;

public class OrdControllerCase {

    DesOrdControllerCase desOrdControllerCase = new DesOrdControllerCase();

    public void setOrdController(String userName) {
        desOrdControllerCase.ordControllersBtn().click();
        desOrdControllerCase.searchField().setValue(userName).press(ENTER);
        desOrdControllerCase.setEmployee(userName).click();
        desOrdControllerCase.doneBtn().click();
    }

}
