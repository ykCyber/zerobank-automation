package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Date;
import java.util.logging.SimpleFormatter;


public class PurchaseForeingCurrncyStepDef {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        PayBills.AddNewPayee a = new PayBills.AddNewPayee();
        a.goToPayBills();
        Driver.get().findElement(By.linkText("Purchase Foreign Currency")).click();

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(DataTable dataTable) {
        boolean currencyIncluded = new PayBills.PurchaseFCC().isCurrencyIncluded(dataTable.asList());
        Assert.assertTrue(currencyIncluded);
    }

    @When("user tries	to	calculate	cost	without	selecting	a	{string}")
    public void ser_tries_to_calculate_cost_without_selecting_a_currency(String currency) {
        PayBills.PurchaseFCC page = new PayBills.PurchaseFCC();
        page.calculateWithoutSelection(currency);
        BrowserUtils.waitFor(1);
    }

    @When("user calculates amount {int} from currency {string}  to {string}")
    public void user_calculates_amount_from_currency_to(Integer amount, String from, String to) {
        PayBills.PurchaseFCC page = new PayBills.PurchaseFCC();
        page.calculateWithSelection(amount, from, to);
        BrowserUtils.waitFor(10);
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        PayBills.PurchaseFCC page = new PayBills.PurchaseFCC();
        Assert.assertTrue("Alert is presende ", new PayBills.PurchaseFCC().isAlertPresent());


    }
}
