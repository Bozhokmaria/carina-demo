package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'inventory_details_name')]")
//    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement inventoryItemName;

    @FindBy(className = "inventory_details_price")
    private ExtendedWebElement inventoryItemPrice;

    @FindBy(id = "back-to-products")
    private ExtendedWebElement backToProductsButton;

    @FindBy(id ="react-burger-menu-btn")
    private ExtendedWebElement sidebar;

    @FindBy(id ="logout_sidebar_link")
    private ExtendedWebElement logOut;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageURL("/inventory-item.html?id=4");
    }

    public String getInventoryItemName() {
        return inventoryItemName.getText();
    }

    public Double getInventoryItemPrice() {
        return Double.valueOf(inventoryItemPrice.getText().substring(1));
    }

    public InventoryPage clickOnBackToProductsButton(){
        backToProductsButton.click();
        return new InventoryPage(getDriver());
    }

    public void clickOnSideBar(){
        backToProductsButton.click();;
    }

    public LoginPage clickOnSideBarThenLogout(){
        sidebar.click();;
        logOut.click();
        return new LoginPage(getDriver());
    }
}
