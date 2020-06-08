package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    @FindBy(id = "account_summary_tab")
    protected WebElement accountSummaryTab;
    @FindBy(id = "account_activity_tab")
    protected WebElement accountActivityTab;
    @FindBy(id = "transfer_funds_tab")
    protected WebElement transferFundsTab;
    @FindBy(id = "pay_bills_tab")
    protected WebElement payBills;
    @FindBy(id = "money_map_tab")
    protected WebElement myMoneyTap;
    @FindBy(id = "online_statements_tab")
    protected WebElement onlineStatements;
    @FindBy(id = "settingsBox")
    protected WebElement settingBox;
    @FindBy(id = "searchTerm")
    protected WebElement searchBox;

    public void BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void search(String searchTerm) {
        searchBox.sendKeys(searchTerm, Keys.ENTER);
    }

    public void goToOnlineStatements() {
        onlineStatements.click();
    }

    public void goToMyMoney() {

        myMoneyTap.click();
    }

    public void goToAccountSummary() {

        accountSummaryTab.click();
    }

    public void goToAccountActivityPage() {

        accountActivityTab.click();
    }

    public void goToPayBills() {
        payBills.click();
    }

    protected void goToActivity() {
        accountActivityTab.click();
    }


    public void goToTransferFunds() {
        transferFundsTab.click();
    }

    public static String getPageTitle() {
        String pageTitle = Driver.get().getTitle().replace("Zero - ", "");
        return pageTitle;
    }

    public static boolean isPageActive(String str) {
        boolean titleIsCorrect = getPageTitle().contentEquals(str);
        String xpath = "//a[contains(text(),\"" + str + "\")]/..";
        WebElement element = Driver.get().findElement(By.xpath(xpath));
        String isActive = element.getAttribute("class");
        return isActive.contentEquals("active") & titleIsCorrect;
    }

    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
}
