package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactions;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class FindTransactionsSteps {


    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        boolean rangeFlag = new FindTransactions().isResultsInRange(string, string2);
        Assert.assertTrue("results are in range ", rangeFlag);
    }

    @When("clicks search")
    public void clicks_search() {
        new FindTransactions().clickSearch();
        BrowserUtils.waitFor(1);
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().goToFindTranscations();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        FindTransactions find = new FindTransactions();
        find.enterDates(fromDate, toDate);
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String removedDate) {
        FindTransactions findTransactions = new FindTransactions();
        System.out.println("findTransactions.isNotContainDate(removedDate) = " + findTransactions.isNotContainDate(removedDate));
        System.out.println("is not in the list " + removedDate);
        System.out.println();
        Assert.assertTrue("removed date should not be in list", findTransactions.isNotContainDate(removedDate));
    }

    @When("the user enter {string} to description")
    public void the_user_enter_to_description(String string) {
        new FindTransactions().enterDescription(string);
    }

    @Then("results should contain {string}")
    public void results_should_contain(String string) {
        System.out.println("Searching for " + string);
        Assert.assertTrue("Contains " + string, new FindTransactions().isSearchResultContains(string));
    }

    @Then("when search {string} results should contain {string}")
    public void whenSearchResultsShouldContain(String searchItem, String expectedResult) {
        results_should_contain(expectedResult);

    }
}

