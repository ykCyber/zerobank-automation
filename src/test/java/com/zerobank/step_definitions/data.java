package com.zerobank.step_definitions;

import io.cucumber.java.en.When;
import org.junit.Assert;

public class data {
    @When("{string} entered")
    public void entered(String string) {

        System.out.println(string);
        Assert.assertTrue(string.equals("3")||string.equals("5"));
    }
}
