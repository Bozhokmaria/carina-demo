package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {


    @FindBy(className ="inventory_item_name")
    private ExtendedWebElement inventoryItemName;

    @FindBy(className ="inventory_item_price")
    private ExtendedWebElement inventoryItemPrice;
    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("/cart.html");
    }

    public String getInventoryItemName() {
        return inventoryItemName.getText();
    }

    public Double getInventoryItemPrice() {
        return Double.valueOf(inventoryItemPrice.getText().substring(1));
    }
}
