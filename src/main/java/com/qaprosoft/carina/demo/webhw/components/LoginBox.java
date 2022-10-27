package com.qaprosoft.carina.demo.webhw.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.webhw.pages.InventoryPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginBox extends AbstractUIObject {

    @FindBy(id = "user-name")
    private ExtendedWebElement username;

    @FindBy(id = "password")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private ExtendedWebElement errorMessageDiv;

    public LoginBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeUserName(String username) {
        this.username.type(username);
    }

    public void typePassword(String password) {
        this.password.type(password);
    }

    public InventoryPage clickOnSubmitButton(){
        submitButton.click();;
        return new InventoryPage(getDriver());
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public String getErrorMessageDiv() {
        return errorMessageDiv.getText();
    }
}
