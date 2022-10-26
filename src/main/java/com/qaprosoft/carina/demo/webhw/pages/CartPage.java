package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {


    @FindBy(xpath ="//*[@id=\"item_4_title_link\"]/div")
    private ExtendedWebElement inventoryItemName;

    @FindBy(xpath ="//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private ExtendedWebElement inventoryItemPrice;
    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/cart.html");
    }

    public ExtendedWebElement getInventoryItemName() {
        return inventoryItemName;
    }

    public ExtendedWebElement getInventoryItemPrice() {
        return inventoryItemPrice;
    }
}
