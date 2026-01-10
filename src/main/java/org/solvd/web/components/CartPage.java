package org.solvd.web.components;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(css = "body")
    ExtendedWebElement cartBody;

    @FindBy(xpath = "//textarea[@id='note']")
    ExtendedWebElement noteField;

    @FindBy(xpath = "//input[@id='update']")
    ExtendedWebElement updateCartButton;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    public TopHeader getTopHeader() {
        return new TopHeader(getDriver(), cartBody.getElement());
    }

    public SideBar getSideBar() {
        return new SideBar(getDriver(), cartBody.getElement());
    }

    public CartPage openCartPage() {
        openURL("https://sauce-demo.myshopify.com/cart");
        CommonUtils.pause(2);
        return this;
    }

    public CartPage removeProduct() {
        ExtendedWebElement removeButton = cartBody.findExtendedWebElement(By.xpath("//a[text()='x']"));
        removeButton.assertElementPresent();
        removeButton.scrollTo();
        removeButton.click();
        CommonUtils.pause(2);
        return this;
    }

    public boolean isProductInCart(String productName) {
        return !findExtendedWebElements(By.xpath("//a[contains(normalize-space(.),'" + productName + "')]")).
                isEmpty();
    }

    public CartPage addNote(String note) {
        noteField.assertElementPresent();
        noteField.scrollTo();
        noteField.type(note);
        updateCartButton.click();
        CommonUtils.pause(2);
        return this;
    }

    public boolean isNoteAdded(String note) {
        ExtendedWebElement addedNote = cartBody.findExtendedWebElement(By.xpath("//textarea[@id='note' and normalize-space(text())='" + note + "']"));
        return addedNote.isElementPresent();
    }
}
