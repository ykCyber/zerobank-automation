package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccountActivityPage extends BasePage implements ResultsTable {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Find Transactions")
    protected WebElement findTranscations;

    @FindBy(linkText = "Show Transactions")
    protected WebElement showTransactions;


    public void goToFindTranscations() {
        if (getPageTitle().contentEquals("Account Activity"))
            findTranscations.click();
        else {
            goToActivity();
            goToFindTranscations();
        }
        // Assert.assertTrue(Driver.get().findElement(By.xpath("//h2[contains(text(),'Find Transactions')]")).isDisplayed());

    }

    public void goToShowTranscations() {
        if (getPageTitle().contentEquals("Account Activity"))
            showTransactions.click();
        else {
            goToActivity();
            goToShowTranscations();
        }
        showTransactions.click();
        Assert.assertTrue(Driver.get().findElement(By.xpath("//h2[contains(text(),'Show Transactions')]")).isDisplayed());

    }

    public static class FindTransactions {
        @FindBy(name = "fromDate")
        protected WebElement fromDate;

        @FindBy(id = "aa_toDate")
        protected WebElement toDate;

        @FindBy(xpath = "//button[@class='btn btn-primary']")
        protected WebElement findButton;
        @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
        List<WebElement> resultDates;


        @FindBy(xpath = "//div[@id='ui-tabs-2']//tr//td[2]")
        List<WebElement> resultDescriptions;


        @FindBy(id = "aa_description")
        protected WebElement descriptonBox;
        @FindBy(className = "well")
        WebElement noResulText;
        @FindBy(id = "aa_type")
        protected WebElement selectType;


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
                for (String s : elementsText) {
                    System.out.println("From Web Page = " + s);
                }
                Collections.sort(elementsText);
                Collections.reverse(elementsText);
                boolean isTwoListSame = Arrays.deepEquals(actualList.toArray(), elementsText.toArray());
                Assert.assertTrue(isTwoListSame);
                return isTwoListSame;
            } else System.out.println("NoResult");
            return false;
        }

        public boolean isNotContainDate(String removedDate) {
            return !isSearchResultContains(removedDate);
        }

        public void enterDescription(String string) {
            BrowserUtils.waitForVisibility(descriptonBox, 5);
            descriptonBox.clear();
            descriptonBox.sendKeys(string);

        }

        public boolean isSearchResultContains(String string) {
            BrowserUtils.waitFor(1);

            List<String> elementsText = BrowserUtils.getElementsText(resultDescriptions);
            boolean contains = false;
            for (int i = 0; i < elementsText.size(); i++) {
                contains = elementsText.get(i).contains(string);
            }
            return contains;
        }

        //param str fromDate , to Date
        //gets list of Results Date
        // @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
        // List<WebElement> resultDates;
        // convert given strs to related date Format yyyy-MM-dd
        // get first line Date from webPage convert to date
        // get last line Date from webPage convert to date
        //first(line) date of table must be earlier than provided toDate
        //last(line) date of table must be later than provided fromDate
        public boolean isResultInRange(String fromDat, String toDat) throws ParseException {
            List<String> elementsText = BrowserUtils.getElementsText(resultDates);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date provided_FromDate = dateFormatter.parse(fromDat);
            Date provided_ToDate = dateFormatter.parse(toDat);
            Date table_FirstLine = dateFormatter.parse(elementsText.get(0));
            Date table_LastLine = dateFormatter.parse(elementsText.get(elementsText.size() - 1));
//            System.out.println("fromTableLastLine = " + dateFormatter.format(table_LastLine));
//            System.out.println("fromTableFirstLine = " + dateFormatter.format(table_FirstLine));
//            System.out.println("providedFromDate = " + dateFormatter.format(provided_FromDate));
//            System.out.println("providedFromDate = " + dateFormatter.format(provided_ToDate));
//            System.out.println("tableLastLine.after(providedFromDate) = " + !table_LastLine.before(provided_FromDate));
//            System.out.println("tableFirstLine.before(providedToDate) = " + !table_FirstLine.after(provided_ToDate));
            //if two dates are same before or after methods return false
            // so that we have to use  !before and !after
            //lastLine is not before than provided From date
            //first line is not after than provided ToDate
            return !table_LastLine.before(provided_FromDate) && !table_FirstLine.after(provided_ToDate);
        }

        public boolean isResultsInRange(String from, String to) {

            int fromDate = Integer.parseInt(from.replace("-", ""));
            int toDate = Integer.parseInt(to.replace("-", ""));

            List<String> dates = BrowserUtils.getElementsText(resultDates);
            for (String date : dates) {
                System.out.println("From Web " + date);
            }
            int firstLine = Integer.parseInt(dates.get(0).replace("-", ""));
            int lastLine = Integer.parseInt(dates.get(dates.size() - 1).replace("-", ""));
            boolean fromBoolean = fromDate <= lastLine;
            boolean toBoolean = toDate >= firstLine;
            return fromBoolean & toBoolean;
        }

        //select withdrawl or Deposit options
        public void selectType(String type) {
            Select select = new Select(selectType);
            select.selectByVisibleText(type);
            System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        }

    }

    public static class ShowTransactions extends BasePage {
        public ShowTransactions() {
            PageFactory.initElements(Driver.get(), this);
        }

        @FindBy(id = "aa_accountId")
        public WebElement accountDropDown;

        public boolean isSelected(String expectedSelection) {
            Select accountSelectMenu = new Select(accountDropDown);
            String actualSelection = accountSelectMenu.getFirstSelectedOption().getText();
            return actualSelection.contentEquals(expectedSelection);
        }


    }


}

