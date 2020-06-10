package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.PayBills;
import io.cucumber.java.en.Then;

import java.util.Map;

public class AddPayeeStepDef {
    @Then("the user accesses the Add New Payee tab")
    public void the_user_accesses_the_Add_New_Payee_tab() {
     //Todo  Driver.get().findElement(By.linkText("Add New Payee")).click();
     //TODO   BrowserUtils.waitForVisibility(new PayBills.AddNewPayee().payeeNameBox,
     //TODO 2);
    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataSet = dataTable.asMap(String.class, String.class);
        String name = dataSet.get("Payee Name");
        String payee_address = dataSet.get("Payee Address");
        String payee_details = dataSet.get("Payee details");
        String account = dataSet.get("Account");

        PayBills.AddNewPayee add = new PayBills.AddNewPayee();
        add.addNewPayee(name, payee_address, account, payee_details);



        new AccountActivityPage().goToFindTranscations();

    }


    @Then("message {string} displayed")
    public void message_displayed(String string) {
//        new PayBills.PurchaseFCC
    }
}
