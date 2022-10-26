package com.qaprosoft.carina.demo.webhw.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginBox extends AbstractUIObject {

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input")
    private ExtendedWebElement username;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input")
    private ExtendedWebElement password;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
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

    public void clickOnSubmitButton(){
        submitButton.click();;
    }

    public ExtendedWebElement getUsername() {
        return username;
    }

    public ExtendedWebElement getPassword() {
        return password;
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public ExtendedWebElement getErrorMessageDiv() {
        return errorMessageDiv;
    }
}
