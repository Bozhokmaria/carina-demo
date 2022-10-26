package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.webhw.components.InventoryItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends AbstractPage {

    @FindBy(id = "inventory_container")
    private List<InventoryItem> items;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]")
    private ExtendedWebElement imageLink;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    private ExtendedWebElement sortingButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    private ExtendedWebElement fromAToZ;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private ExtendedWebElement fromZToA;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement fromLowToHigh;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement fromHighToLow;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();;
    }

    public void clickOnCartButton(){
        cartButton.click();;
    }

    public void clickOnImageLink(){
        imageLink.click();;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void clickOnSortButton(){
        sortingButton.click();;
    }

    public void clickOnOptionFromAtoZ(){
        clickOnSortButton();
        fromAToZ.click();;
    }

    public void clickOnOptionFromZtoA(){
        clickOnSortButton();
        fromZToA.click();;
    }

    public void clickOnOptionFromLowtoHigh(){
        clickOnSortButton();
        fromLowToHigh.click();;
    }

    public void clickOnOptionFromHighToLow(){
        clickOnSortButton();
        fromHighToLow.click();;
    }
}
