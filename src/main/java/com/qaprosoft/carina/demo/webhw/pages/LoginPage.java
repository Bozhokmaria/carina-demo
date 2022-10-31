package com.qaprosoft.carina.demo.webhw.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private ExtendedWebElement username;

    @FindBy(id = "password")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private ExtendedWebElement errorMessageDiv;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
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
