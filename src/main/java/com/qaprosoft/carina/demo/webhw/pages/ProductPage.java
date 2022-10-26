package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath ="//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    private ExtendedWebElement inventoryItemName;

    @FindBy(xpath ="//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    private ExtendedWebElement inventoryItemPrice;

    @FindBy(xpath ="//*[@id=\"back-to-products\"]")
    private ExtendedWebElement backToProductsButton;

    @FindBy(xpath ="//*[@id=\"react-burger-menu-btn\"]")
    private ExtendedWebElement sidebar;

    @FindBy(xpath ="//*[@id=\"logout_sidebar_link\"]")
    private ExtendedWebElement logOut;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory-item.html?id=4");
    }

    public ExtendedWebElement getInventoryItemName() {
        return inventoryItemName;
    }

    public ExtendedWebElement getInventoryItemPrice() {
        return inventoryItemPrice;
    }

    public void clickOnBackToProductsButton(){
        backToProductsButton.click();;
    }

    public void clickOnSideBar(){
        backToProductsButton.click();;
    }

    public void clickOnSideBarThenLogout(){
        sidebar.click();;
        logOut.click();
    }
}
