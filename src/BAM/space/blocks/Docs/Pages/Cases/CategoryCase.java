package blocks.Docs.Pages.Cases;

import blocks.Docs.Pages.Cases.Des.DesCategoryCase;

public class CategoryCase {
    DesCategoryCase desCategoryCase = new DesCategoryCase();
    public void setCategoryDoc(String categoryName) {
        desCategoryCase.categoryDocBtn().click();
        desCategoryCase.clearSetCategoryElemBtn().click();
        desCategoryCase.setCategoryAddBtn(categoryName).click();
        desCategoryCase.completeSetCategoryBtn().click();
    }
}
