package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {



    @FindBy(xpath = "//div[@class='alert alert-error']")
    WebElement alert;
    @FindBy(id = "signin_button")
    public WebElement siginButton;

    @FindBy(id = "user_login")
    public WebElement userName;


    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    public boolean isLoginErrorMessageDisplayed() {
        boolean flag = getPageTitle().contentEquals("Log in");
        if (flag) {
            System.out.println(alert.getText());
            return alert.isDisplayed();
        }
        return flag;
    }

    public boolean login(String userNameStr, String passwordStr) {
        Driver.get().get(ConfigurationReader.get("url"));

        siginButton.click();
        BrowserUtils.waitForVisibility(userName, 10);
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        boolean errorMessageDisplayed = isLoginErrorMessageDisplayed();

        if (errorMessageDisplayed) {
            return !errorMessageDisplayed;
        } else
            System.out.println("Logged in successfully");
            return isPageActive("Account Summary");

    }


    public boolean loginWithTrueCredentials() {

        return login(ConfigurationReader.get("userName"), ConfigurationReader.get("password"));
    }
}
