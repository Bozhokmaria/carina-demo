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

    public String getItemName() {
        return itemName.getText();
    }

    public Double getItemPrice() {
        return Double.parseDouble(itemPrice.getText().substring(1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryItem)) return false;

        InventoryItem that = (InventoryItem) o;

        if (itemName.getText() != null ? !itemName.getText().equals(that.itemName.getText()) : that.itemName.getText() != null) return false;
        return itemPrice.getText() != null ? itemPrice.getText().equals(that.itemPrice.getText()) : that.itemPrice.getText() == null;
    }

    @Override
    public int hashCode() {
        int result = itemName.getText() != null ? itemName.getText().hashCode() : 0;
        result = 31 * result + (itemPrice != null ? itemPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemName=" + itemName.getText() +
                ", itemPrice=" + itemPrice.getText() +
                "} " + super.toString();
    }
}