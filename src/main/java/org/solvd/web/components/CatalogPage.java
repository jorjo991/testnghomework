package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage {

    @FindBy(css="body")
    ExtendedWebElement catalogPageBody;

    protected CatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCatalogPageBodyPresent(){
        return catalogPageBody.isElementPresent();
    }

    public SideBar sideBar(){
        return  new SideBar(driver, catalogPageBody.getElement());
    }

    public TopHeader topHeader(){
        return  new TopHeader(driver, catalogPageBody.getElement());
    }

    public ProductPage goToproductPage(){
        ExtendedWebElement productLink= catalogPageBody.findExtendedWebElement(org.openqa.selenium.By.xpath("//a[text()='Products']"));
        productLink.assertElementPresent();
        productLink.click();
        return new ProductPage(driver);
    }

}
