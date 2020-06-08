package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Find Transactions")
    WebElement findTranscations;

    @FindBy(linkText = "Show Transactions")
    WebElement showTransactions;


    public void goToFindTranscations(){
        if(getPageTitle().contentEquals("Account Activity"))
        findTranscations.click();
        else {goToActivity();
        goToFindTranscations();
        }
       // Assert.assertTrue(Driver.get().findElement(By.xpath("//h2[contains(text(),'Find Transactions')]")).isDisplayed());

    }
 public void goToShowTranscations(){
     if(getPageTitle().contentEquals("Account Activity"))
         showTransactions.click();
     else {
         goToActivity();
         goToShowTranscations();
     }
       showTransactions.click();
        Assert.assertTrue(Driver.get().findElement(By.xpath("//h2[contains(text(),'Show Transactions')]")).isDisplayed());

    }
}

