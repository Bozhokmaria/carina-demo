package com.qaprosoft.carina.demo.webhw;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.webhw.components.InventoryItem;
import com.qaprosoft.carina.demo.webhw.pages.CartPage;
import com.qaprosoft.carina.demo.webhw.pages.InventoryPage;
import com.qaprosoft.carina.demo.webhw.pages.LoginPage;
import com.qaprosoft.carina.demo.webhw.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class WebTestPage implements IAbstractTest {

    LoginPage loginPage = null;

    InventoryPage inventoryPage = null;

    CartPage cartPage = null;

    ProductPage productPage = null;

    @BeforeSuite
    public void startDriver() {
        // Open GSM Arena home page and verify page is opened
        loginPage = new LoginPage(getDriver());
        inventoryPage = new InventoryPage(getDriver());
        cartPage = new CartPage(getDriver());
        productPage = new ProductPage(getDriver());
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testOpenPage() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testClickSubmitButtonWithNoDataProvided() {
        loginPage.open();
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(
                loginPage.getLoginBox().isElementWithTextPresent(
                        loginPage.getLoginBox().getErrorMessageDiv(), "Epic sadface: Username is required"
                ),
                "Text not matching");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testClickSubmitButtonWithInvalidDataProvided() {
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("standard_user");
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(
                loginPage.getLoginBox().isElementWithTextPresent(
                        loginPage.getLoginBox().getErrorMessageDiv(), "Epic sadface: Username and password do not match any user in this service"
                ),
                "Text not matching");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testAddToCart() {
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("secret_sauce");
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnCartButton();
        Assert.assertTrue(  cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertEquals(cartPage.getInventoryItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getInventoryItemPrice().getText(), "$29.99");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testOpenProductPageGoBackAndLogOut() {
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("secret_sauce");
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");
        inventoryPage.clickOnImageLink();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
        Assert.assertEquals(productPage.getInventoryItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(productPage.getInventoryItemPrice().getText(), "$29.99");
        productPage.clickOnBackToProductsButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");
        productPage.clickOnSideBarThenLogout();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }

    @Test
    @MethodOwner(owner = "bozhok")
    public void testSorting() {
        loginPage.open();
        loginPage.getLoginBox().typeUserName("standard_user");
        loginPage.getLoginBox().typePassword("secret_sauce");
        loginPage.getLoginBox().clickOnSubmitButton();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened");

        //Default A-Z sorting
        List<InventoryItem> itemList = inventoryPage.getItems();
        Assert.assertEquals(itemList.get(0).getItemName().getText(), "Sauce Labs Backpack", "A to Z sorting error");

        // Z-A sorting
        inventoryPage.clickOnOptionFromZtoA();
        List<InventoryItem> itemListZtoA = inventoryPage.getItems();
        Assert.assertEquals(itemListZtoA.get(0).getItemName().getText(), "Test.allTheThings() T-Shirt (Red)", "Z to A sorting error");

        // low to high price sorting
        inventoryPage.clickOnOptionFromLowtoHigh();
        List<InventoryItem> itemListLowToHigh = inventoryPage.getItems();
        Assert.assertEquals(itemListLowToHigh.get(0).getItemPrice().getText(), "$7.99", "From Low to High sorting error");

        // high to low price sorting
        inventoryPage.clickOnOptionFromHighToLow();
        List<InventoryItem> itemListHighToLow = inventoryPage.getItems();
        Assert.assertEquals(itemListHighToLow.get(0).getItemPrice().getText(), "$49.99", "From High to Low sorting error");

    }
}