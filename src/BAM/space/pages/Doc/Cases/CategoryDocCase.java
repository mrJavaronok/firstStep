package pages.Doc.Cases;

import pages.Doc.Cases.Des.DesCategoryDocCase;

public class CategoryDocCase {
    DesCategoryDocCase desCategoryDocCase = new DesCategoryDocCase();
    public void setCategoryDoc(String categoryName) {
        desCategoryDocCase.categoryDocBtn().click();
        desCategoryDocCase.clearSetCategoryElemBtn().click();
        desCategoryDocCase.setCategoryAddBtn(categoryName).click();
        desCategoryDocCase.completeSetCategoryBtn().click();
    }
}
