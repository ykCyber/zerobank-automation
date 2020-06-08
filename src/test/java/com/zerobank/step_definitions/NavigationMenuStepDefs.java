//package com.zerobank.step_definitions;
//
//import com.vytrack.pages.ContactsPage;
//import com.vytrack.pages.DashboardPage;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
//public class NavigationMenuStepDefs {
//    @When("the user navigates {string}  {string}")
//    public void the_user_navigates(String tab, String module) {
//        new DashboardPage().navigateToModule(tab, module);
//    }
//
//    @Then("default page number should be {int}")
//
//    public void default_page_number_should_be(Integer expectedPageNumber) {
//
//        new DashboardPage().waitUntilLoaderScreenDisappear();
//
//        ContactsPage contactsPage = new ContactsPage();
//
//        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
//        Assert.assertEquals(expectedPageNumber, actualNumber);
//
//
//    }
//
//}
//
//
//
//
//
//
