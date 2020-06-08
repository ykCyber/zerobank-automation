package com.zerobank.step_definitions;

import com.zerobank.pages.AddNewPayee;
import com.zerobank.pages.PurchaseFCC;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bind.ParameterLengthResolver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


public class PurchaseForeingCurrncyStepDef {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        AddNewPayee a = new AddNewPayee();
        a.goToPayBills();
        Driver.get().findElement(By.linkText("Purchase Foreign Currency")).click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(DataTable dataTable) {
        boolean currencyIncluded = new PurchaseFCC().isCurrencyIncluded(dataTable.asList());
        Assert.assertTrue(currencyIncluded);
    }

    @When("user tries	to	calculate	cost	without	selecting	a	currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PurchaseFCC page = new PurchaseFCC();
        page.calculateWithoutSelection();
        BrowserUtils.waitFor(2);
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
       PurchaseFCC page= new PurchaseFCC();
        page.isAlertPresent();

    }


}
