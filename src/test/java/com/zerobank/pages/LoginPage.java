package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='alert alert-error']")
    WebElement alert;

    @FindBy(id = "signin_button")
    protected WebElement signButton;

    @FindBy(id = "user_login")
    protected WebElement userName;

    @FindBy(id = "user_password")
    protected WebElement password;

    @FindBy(name = "submit")
    protected WebElement submit;

    public boolean isLoginErrorMessageDisplayed() {
        //if user enters wrong credentials
        //page title is "Log-in" and an alert is displayed
        System.out.println(alert.getText());
        return getPageTitle().contentEquals("Log in") && alert.isDisplayed();
    }

    public boolean login(String userNameStr, String passwordStr) {
        Driver.get().get(ConfigurationReader.get("url"));
        signButton.click();
        BrowserUtils.waitForVisibility(userName, 10);
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        if (isPageActive(ConfigurationReader.get("landPage")) && !isLoginErrorMessageDisplayed())
            System.out.println("Logged in successfully");
        return isPageActive(ConfigurationReader.get("landPage")) && isLoginErrorMessageDisplayed();
    }

    public boolean loginWithTrueCredentials() {
        return login(ConfigurationReader.get("userName"), ConfigurationReader.get("password"));
    }
}
