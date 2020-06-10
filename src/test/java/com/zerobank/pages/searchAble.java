package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface searchAble {

    static List<WebElement> searchResultsFor(String header) {
        return Driver.get().findElements(By.xpath("//th[contains(text(),'" + header + "')]"));
    }
}
