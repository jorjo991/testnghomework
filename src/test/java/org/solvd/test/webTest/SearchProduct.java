package org.solvd.test.webTest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.common.CommonUtils;
import org.solvd.web.components.HomePage;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchProduct extends AbstractTest {

    @Test
    public void searchForProduct() {

        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        homePage.searchProduct("black");
        CommonUtils.pause(2);
        assertTrue(homePage.isProductDisplayed("Black"), "Product is not displayed");

    }

    @AfterTest
    public void Setdown() {
        getDriver().quit();
    }
}
