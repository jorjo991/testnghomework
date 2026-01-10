package org.solvd.test.webTest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.common.CommonUtils;
import org.solvd.web.components.CartPage;
import org.solvd.web.components.CatalogPage;
import org.solvd.web.components.HomePage;
import org.solvd.web.components.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartAndRemove extends AbstractTest {

    @Test
    public void addProductToCartAndRemove() {
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
        CommonUtils.pause(2);
        cartPage.removeProduct();
        Assert.assertFalse(cartPage.isProductInCart("Black heels"), "Product is not in the cart");

    }
}
