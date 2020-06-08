package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPayee extends BasePage {
    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameBox;
    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressBox;
    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccountBox;
    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailBox;
    @FindBy(id = "add_new_payee")
    public WebElement addPayeeButton;
    @FindBy(id = "alert_content")
    public WebElement message;

    public AddNewPayee() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void addNewPayee(String name, String address, String account, String details) {
//        BrowserUtils.sendKeys(payeeNameBox,name);
//        BrowserUtils.sendKeys(payeeAddressBox, address);
//        BrowserUtils.sendKeys(payeeAccountBox, account);
//        BrowserUtils.sendKeys(payeeDetailBox, details);

        payeeNameBox.sendKeys(name);
        payeeAddressBox.sendKeys(address);
        payeeAccountBox.sendKeys(account);
        payeeDetailBox.sendKeys(details);

        BrowserUtils.waitFor(5);
        addPayeeButton.click();
        //       System.out.println("message.isDisplayed() = " + message.isDisplayed());
    }
}
