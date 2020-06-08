package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    public void goToAccountType(String accountType) {
        Driver.get().findElement(By.linkText(accountType)).click();
    }
}
