package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.webhw.components.InventoryItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends AbstractPage {

    @FindBy(id = "inventory_container")
    private List<InventoryItem> items;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;

    @FindBy(id = "item_4_img_link")
    private ExtendedWebElement imageLink;

    @FindBy(className = "product_sort_container")
    private ExtendedWebElement sorting;

    @FindBy(xpath = "//*[contains(text(),'Name (A to Z)')]")
    private ExtendedWebElement fromAToZ;

    @FindBy(xpath = "//*[contains(text(),'Name (Z to A)')]")
    private ExtendedWebElement fromZToA;

    @FindBy(xpath = "//*[contains(text(),'Price (low to high)')]")
    private ExtendedWebElement fromLowToHigh;

    @FindBy(xpath = "//*[contains(text(),'Price (high to low)')]")
    private ExtendedWebElement fromHighToLow;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public CartPage clickOnCartButton() {
        cartButton.click();
        return new CartPage(getDriver());
    }

    public ProductPage clickOnImageLink() {
        imageLink.click();
        return new ProductPage(getDriver());
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void clickOnSortButton() {
        sorting.click();
    }

    public void clickOnOptionFromAtoZ() {
        clickOnSortButton();
        fromAToZ.click();
    }


    public void clickOnOptionFromZtoA() {
        clickOnSortButton();
        fromZToA.click();
    }

    public void clickOnOptionFromLowToHigh() {
        clickOnSortButton();
        fromLowToHigh.click();
    }

    public void clickOnOptionFromHighToLow() {
        clickOnSortButton();
        fromHighToLow.click();
    }

    public List<Double> getPrices(List<InventoryItem> itemList) {
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            prices.add(itemList.get(i).getItemPrice());
        }
        return prices;
    }

    public List<String> getNames() {
        List<String> prices = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            prices.add(items.get(i).getItemName());
        }
        return prices;
    }

    public List<InventoryItem> sortedBy(String sort) {
        List<InventoryItem> sorted = new ArrayList<>(items);

        switch (sort) {
            case ("az"): {
                sorted = sorted.stream()
                        .sorted(Comparator.comparing(InventoryItem::getItemName))
                        .collect(Collectors.toList());
                break;
            }
            case ("za"): {
                sorted = sorted.stream()
                        .sorted(Comparator.comparing(InventoryItem::getItemName).reversed())
                        .collect(Collectors.toList());
                break;
            }
            case ("lohi"): {
                sorted = sorted.stream()
                        .sorted(Comparator.comparingDouble(InventoryItem::getItemPrice))
                        .collect(Collectors.toList());
                break;
            }
            case ("hilo"): {
                sorted = sorted.stream()
                        .sorted(Comparator.comparingDouble(InventoryItem::getItemPrice).reversed())
                        .collect(Collectors.toList());
                break;
            }
            default:
                Assert.fail("Wrong sort name");
        }
        return sorted;
    }
}
