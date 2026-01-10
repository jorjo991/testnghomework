package org.solvd.web.components;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    //logo that says that we on the home page
    @FindBy(xpath = "h1, .logo, .site-header__logo")
    private ExtendedWebElement pageLogo;

    @FindBy(xpath = "//input[@class='search']")
    private ExtendedWebElement searchInput;

    @FindBy(css = "body")
    private ExtendedWebElement body;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLogoPresent() {
        return pageLogo.isElementPresent();
    }

    public HomePage openHomePage() {
        openURL("https://sauce-demo.myshopify.com");
        return this;
    }

    public boolean isPageOpened() {
        return body.isElementPresent(5);  // wait for 5 seconds
    }

    public SideBar sideBar() {
        return new SideBar(driver, body.getElement());
    }

    public TopHeader topHeader() {

        return new TopHeader(driver, body.getElement());
    }

    public CatalogPage catalogPage() {
        sideBar().clickCatalog();
        return new CatalogPage(driver);
    }

    public void searchProduct(String productName) {
        searchInput.type(productName);
        ExtendedWebElement clickSearch = findExtendedWebElement(By.xpath("//input[@id='search-submit']"));
        clickSearch.click();
        CommonUtils.pause(2);
    }

    public boolean isProductDisplayed(String productName) {
        CommonUtils.pause(2);
        return !findExtendedWebElements(
                By.xpath("//h3[contains(normalize-space(.),'" + productName + "')]")).
                isEmpty();
    }

}