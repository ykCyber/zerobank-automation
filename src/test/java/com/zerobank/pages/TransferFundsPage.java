package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TransferFundsPage extends BasePage implements searchAble {
    public TransferFundsPage() {
        PageFactory.initElements(Driver.get(), this);
    }


}
