package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShowTransactions extends BasePage {
    public ShowTransactions() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;

    public boolean isSelected(String expectedSelection) {
        Select accountSelectMenu = new Select(accountDropDown);
        String actualSelection = accountSelectMenu.getFirstSelectedOption().getText();
        return actualSelection.contentEquals(expectedSelection);
    }
}
