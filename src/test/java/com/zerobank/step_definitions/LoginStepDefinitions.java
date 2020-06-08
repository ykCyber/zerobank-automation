package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    //login with true userName and Password
    @Given("the user logged in with correct credentials")
    public void the_user_logged_in_with_correct_credentials() {
        loginPage.loginWithTrueCredentials();
    }


    @Given("the user tries to login with inValid credentials")
    public void the_user_tries_to_login_with_inValid_credentials() {
        boolean flag = loginPage.login("xxxx", "xxxx");
        Assert.assertFalse("login with inValid credentials ", flag);
    }

    @Given("the user tries to login with empty credentials")
    public void the_user_tries_to_login_with_empty_credentials() {
        boolean flag = loginPage.login(" ", " ");
        Assert.assertFalse("login with empty credentials", flag);
    }


    @Then("error message displayed")
    public void error_message_displayed() {
        Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed());
    }
}
