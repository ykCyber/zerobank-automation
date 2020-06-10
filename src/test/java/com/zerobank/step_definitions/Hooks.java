package com.zerobank.step_definitions;


import com.zerobank.utilities.Driver;
import com.zerobank.utilities.howMany.HowManyRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void startUp(Scenario scenario) {
        new HowManyRunner();
        System.out.println("===============");
        System.out.println(scenario.getName() + "  test is started");
        System.out.println("===============");
    }

    @After

    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()) System.out.println(Driver.get().getTitle());
        System.out.println(scenario.getName() + " result : " + scenario.getStatus());
        Thread.sleep(500);
        Driver.closeDriver();
        System.out.println("===============");
    }
}
