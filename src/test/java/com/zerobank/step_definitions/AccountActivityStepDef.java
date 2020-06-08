package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.ShowTransactions;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityStepDef {
    @When("the user clicks on	{string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.goToAccountSummary();
        accountSummaryPage.goToAccountType(accountType);


    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String page) {
      boolean flag =  BasePage.isPageActive(page);

      Assert.assertTrue(page+" page is displayed",flag);


    }

    @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountType) {
        ShowTransactions showTransactions = new ShowTransactions();
        showTransactions.isSelected(accountType);
        System.out.println("showTransactions.isSelected(string) = " + showTransactions.isSelected(accountType));


    }
}
