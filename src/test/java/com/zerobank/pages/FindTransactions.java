package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactions {
    @FindBy(name = "fromDate")
    WebElement fromDate;

    @FindBy(id = "aa_toDate")
    WebElement toDate;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement findButton;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    List<WebElement> resultDates;
    @FindBy(xpath = "//div[@id='ui-tabs-2']//tr//td[2]")
    List<WebElement> resultDescriptions;
    @FindBy(id = "aa_description")
    WebElement descriptonBox;
    @FindBy(className = "well")
    WebElement noResulText;

    //div[@id='filtered_transactions_for_account']//td[1]

    public FindTransactions() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void enterDates(String startDate, String endDate) {
        BrowserUtils.waitForVisibility(fromDate, 5);
        fromDate.clear();
        fromDate.sendKeys(startDate);
        toDate.clear();
        toDate.sendKeys(endDate);

    }

    public void clickSearch() {
        BrowserUtils.waitForClickablility(findButton, 2);
        findButton.click();
    }

    public boolean isThereAnyResult() {
        return !noResulText.isEnabled();
    }

    public boolean searchResultDatesBetween(String string, String string2) {
        //We got list of dates two times we will sort one of them and control if two of them are same?
        if (isThereAnyResult()) {
            List<String> elementsText = BrowserUtils.getElementsText(resultDates);
            List<String> actualList = BrowserUtils.getElementsText(resultDates);
            //now sort element to create expected list
            Collections.sort(elementsText);
            Collections.reverse(elementsText);
            boolean isTwoListSame = Arrays.deepEquals(actualList.toArray(), elementsText.toArray());
            Assert.assertTrue(isTwoListSame);
            return isTwoListSame;
        } else System.out.println("NoResult");
        return false;
    }

    public boolean isNotContainDate(String removedDate) {
        return !resultDates.contains(removedDate);
    }

    public void enterDescription(String string) {
        BrowserUtils.waitForVisibility(descriptonBox, 5);
        descriptonBox.clear();
        descriptonBox.sendKeys(string);

    }

    public boolean isSearchResultContains(String string) {
        BrowserUtils.waitFor(2);

        List<String> elementsText = BrowserUtils.getElementsText(resultDescriptions);
        boolean contains = false;
        for (int i = 0; i < elementsText.size(); i++) {
            contains = elementsText.get(i).toString().contains(string);
        }
        return contains;
    }

    public boolean isResultsInRange(String from, String to) {

        int fromDate = Integer.parseInt(from.replace("-", ""));
        int toDate = Integer.parseInt(to.replace("-", ""));
        List<String> dates = BrowserUtils.getElementsText(resultDates);
        int firstLine = Integer.parseInt(dates.get(0).replace("-", ""));
        int lastLine = Integer.parseInt(dates.get(dates.size() - 1).replace("-", ""));
        boolean fromBoolean = fromDate <= lastLine;
        boolean toBoolean = toDate >= firstLine;
        return fromBoolean & toBoolean;
    }

}