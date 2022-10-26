package com.qaprosoft.carina.demo.webhw.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends AbstractUIObject {

    @FindBy(className="inventory_item_name")
    private ExtendedWebElement itemName;

    @FindBy(className="inventory_item_price")
    private ExtendedWebElement itemPrice;

    public InventoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItemName() {
        return itemName;
    }

    public ExtendedWebElement getItemPrice() {
        return itemPrice;
    }
}
//    @FindBy(xpath=".//div[contains(@class,'inventory_item_name')]")