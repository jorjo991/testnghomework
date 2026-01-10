package org.solvd.web.components;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(css = "body")
    ExtendedWebElement productBody;

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    public TopHeader topHeader() {
        return new TopHeader(driver, productBody.getElement());
    }

    public ProductPage chooseProduct(String productName) {

        productBody.assertElementPresent();
        ExtendedWebElement productLink = productBody.findExtendedWebElement(By.xpath("//a[.//h3[text()='" + productName + "']]"));
        productLink.scrollTo();
        productLink.click();
        return new ProductPage(getDriver());

    }

    public CartPage addProductCart() {

        ExtendedWebElement addProduct = productBody.findExtendedWebElement(By.xpath("//input[@id='add']"));
        addProduct.scrollTo();
        addProduct.click();
        CommonUtils.pause(2);
        return new CartPage(driver);
    }

}
