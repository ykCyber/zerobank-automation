package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.graalvm.compiler.asm.sparc.SPARCAssembler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ResultsTable {

    // this will return each results of related Header
    static List<String> searchResultsFor(String header) {
        String xpath = "//div[@id='filtered_transactions_for_account']//th[contains(text(),'" + header + "')]//..//..//..//td[3]";
        return BrowserUtils.getElementsText(By.xpath(xpath));
    }

    static boolean isSearchResultContains(String string) {
        BrowserUtils.waitFor(1);
        List<WebElement> results = Driver.get().findElements(By.xpath("//div[@id='ui-tabs-2']//tr//td[2]"));
        List<String> elementsText = BrowserUtils.getElementsText(results);
        boolean contains = false;
        for (int i = 0; i < elementsText.size(); i++) {
            contains = elementsText.get(i).contains(string);
        }
        return contains;
    }
}
