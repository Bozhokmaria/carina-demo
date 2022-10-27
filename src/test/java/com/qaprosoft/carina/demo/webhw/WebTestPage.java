package com.qaprosoft.carina.demo.webhw;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.webhw.components.InventoryItem;
import com.qaprosoft.carina.demo.webhw.pages.CartPage;
import com.qaprosoft.carina.demo.webhw.pages.InventoryPage;
import com.qaprosoft.carina.demo.webhw.pages.LoginPage;
import com.qaprosoft.carina.demo.webhw.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTestPage implements IAbstractTest {

    @Test
    @MethodOwner(owner = "bozhok")
    public void testOpenPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testClickSubmitButtonWithNoDataProvided() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertEquals(loginPage.getLoginBox().getErrorMessageDiv(), "Epic sadface: Username is required", "Text not matching");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testClickSubmitButtonWithInvalidDataProvided() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("standard_user");
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertEquals(loginPage.getLoginBox().getErrorMessageDiv(), "Epic sadface: Username and password do not match any user in this service","Text not matching");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("secret_sauce");

        InventoryPage inventoryPage = loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");
        inventoryPage.clickOnAddToCartButton();

        CartPage cartPage = inventoryPage.clickOnCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertEquals(cartPage.getInventoryItemName(), "Sauce Labs Backpack", "Name is not similar");
        Assert.assertEquals(cartPage.getInventoryItemPrice(), 29.99, "Price is not similar");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testOpenProductPageGoBackAndLogOut() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");

        ProductPage productPage = inventoryPage.clickOnImageLink();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");

        Assert.assertEquals(productPage.getInventoryItemName(), "Sauce Labs Backpack", "Name is not similar");
        Assert.assertEquals(productPage.getInventoryItemPrice(), 29.99, "Price is not similar");
        inventoryPage = productPage.clickOnBackToProductsButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");
        productPage.clickOnSideBarThenLogout();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testSorting() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");

        //Default A-Z sorting
        List<InventoryItem> itemList = inventoryPage.getItems();
        Assert.assertEquals(itemList, inventoryPage.sortedBy("az"), "A to Z sorting error");

        // Z-A sorting
        inventoryPage.clickOnOptionFromZtoA();
        List<InventoryItem> itemListZtoA = inventoryPage.getItems();
        Assert.assertEquals(itemListZtoA, inventoryPage.sortedBy("za"), "Z to A sorting error");

        // low to high price sorting
        inventoryPage.clickOnOptionFromLowToHigh();
        List<InventoryItem> itemListLowToHigh = inventoryPage.getItems();
        Assert.assertEquals(itemListLowToHigh, inventoryPage.sortedBy("lohi"), "From Low to High sorting error");

        // high to low price sorting
        inventoryPage.clickOnOptionFromHighToLow();
        List<InventoryItem> itemListHighToLow = inventoryPage.getItems();
        Assert.assertEquals(itemListHighToLow, inventoryPage.sortedBy("hilo"), "From High to Low sorting error");

    }
}