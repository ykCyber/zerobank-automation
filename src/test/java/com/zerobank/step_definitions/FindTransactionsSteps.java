package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FindTransactionsSteps {


    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        boolean rangeFlag = new AccountActivityPage.FindTransactions().isResultsInRange(string, string2);
        Assert.assertTrue("results are in range ", rangeFlag);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage.FindTransactions().clickSearch();
        BrowserUtils.waitFor(1);
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().goToFindTranscations();

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {


        AccountActivityPage.FindTransactions page = new AccountActivityPage.FindTransactions();
        page.enterDates(fromDate, toDate);
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String removedDate) {
        AccountActivityPage.FindTransactions findTransactions = new AccountActivityPage.FindTransactions();

        System.out.println("findTransactions.isNotContainDate(removedDate) = " + findTransactions.isNotContainDate(removedDate));
        System.out.println("is not in the list " + removedDate);
        System.out.println();

        Assert.assertTrue("removed date should not be in list", findTransactions.isNotContainDate(removedDate));
    }

    @When("the user enter {string} to description")
    public void the_user_enter_to_description(String string) {
        new AccountActivityPage.FindTransactions().enterDescription(string);
    }

    @Then("results should contain {string}")
    public void results_should_contain(String string) {
        System.out.println("Searching for " + string);

        new AccountActivityPage.FindTransactions();
        Assert.assertTrue("Contains " + string, new AccountActivityPage.FindTransactions().isSearchResultContains(string));
    }

    @Then("when search {string} results should contain {string}")
    public void whenSearchResultsShouldContain(String searchItem, String expectedResult) {
        results_should_contain(expectedResult);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        new AccountActivityPage.FindTransactions().selectType(type);
    }

    @Then("there is NO {string}")
    public void there_is_NO(String otherType) {



    }

}

