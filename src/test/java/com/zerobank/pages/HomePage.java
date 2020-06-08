package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = ".alert")
    WebElement alert;

    public void isErrorMessageDisplayed() {
        System.out.println("alert.getText() = " + alert.getText());
        System.out.println("alert.isDisplayed() = " + alert.isDisplayed());
    }

}
