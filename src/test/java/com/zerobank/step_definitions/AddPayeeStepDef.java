package com.zerobank.step_definitions;

import com.zerobank.pages.AddNewPayee;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.Map;

public class AddPayeeStepDef {
    @Then("the user accesses the Add New Payee tab")
    public void the_user_accesses_the_Add_New_Payee_tab() {
        Driver.get().findElement(By.linkText("Add New Payee")).click();
        BrowserUtils.waitForVisibility(new AddNewPayee().payeeNameBox,
                2);
    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataSet = dataTable.asMap(String.class, String.class);
        String name = dataSet.get("Payee Name");
        System.out.println("name = " + name);

        String payee_address = dataSet.get("Payee Address");
        System.out.println("payee_address = " + payee_address);
        String account = dataSet.get("Account");
        System.out.println("account = " + account);
        String payee_details = dataSet.get("Payee details");
        System.out.println("payee_details = " + payee_details);

        AddNewPayee add = new AddNewPayee();
        add.addNewPayee(name, payee_address, account, payee_details);

    }


    @Then("message {string} displayed")
    public void message_displayed(String string) {

    }
}
