package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public BasePage() {
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


//        BrowserUtils.waitForClickablility(payBills,3);
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

    //page =new loginPage()
    //page.isPageActive(Account Summery);
    public static boolean isPageActive(String str) {
        boolean titleIsCorrect = getPageTitle().contentEquals(str);

        String tab = "//a[contains(text(),\"" + str + "\")]/..";
       // WebElement element = Driver.get().findElement(By.xpath(tab));
        //ismi class olan attributun valuesu "active" olması lazım
       // String isActive = element.getAttribute("class");
        return false;
    }

    public void gotoPage(String pageName) {
        Driver.get().findElement(By.xpath("//a[contains(text(),'" + pageName + "')]")).click();
        isPageActive(pageName);

    }


}
