package org.solvd.test.webTest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.common.CommonUtils;
import org.solvd.web.components.CartPage;
import org.solvd.web.components.CatalogPage;
import org.solvd.web.components.HomePage;
import org.solvd.web.components.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNoteToProduct extends AbstractTest {

    @Test
    public void  addNoteToProductTest() {
        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        CatalogPage catalogPage = homePage.catalogPage();
        ProductPage productPage = catalogPage.goToproductPage();
        CommonUtils.pause(2);
        productPage = productPage.chooseProduct("Black heels");
        CommonUtils.pause(2);
        CartPage cartPage = productPage.addProductCart();
        CommonUtils.pause(2);
        cartPage.openCartPage();
        cartPage.addNote("this is for my sister");
        Assert.assertTrue(cartPage.isNoteAdded("this is for my sister"), "Note was not added to the product");

    }
}
