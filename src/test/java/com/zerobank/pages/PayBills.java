package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBills extends BasePage implements ResultsTable {




    public static class PurchaseFCC extends BasePage {
        public PurchaseFCC() {
            PageFactory.initElements(Driver.get(), this);
        }



        @FindBy(id = "pc_currency")
        WebElement currencyDropDown;
        @FindBy(id = "pc_amount")
        WebElement amountBox;
        @FindBy(id = "pc_inDollars_true")
        WebElement inDollorsRadioButton;
        @FindBy(id = "pc_inDollars_false")
        WebElement selectedCurrencyRadioButton;
        @FindBy(id = "pc_calculate_costs")
        WebElement calculateButton;

        public boolean isCurrencyIncluded(List<String> currencyList) {
            boolean result = false;
            Select select = new Select(currencyDropDown);
            List<WebElement> options = select.getOptions();
            List<String> elementsText = BrowserUtils.getElementsText(options);
            result = elementsText.contains(currencyList);
//            for (String currency : currencyList) {
//
//                if (!isCurrencyIncluded(currency)) {
//                    result = false;
//                    System.out.println("not inculuded "+currency);
//                }
//            }
            return result;
        }

        public boolean isCurrencyIncluded(String currency) {
            Select select = new Select(currencyDropDown);
            List<WebElement> options = select.getOptions();
            List<String> elementsText = BrowserUtils.getElementsText(options);

            return elementsText.contains(currency);
        }

        public void calculateWithSelection(int amount, String from, String to) {
            amountBox.sendKeys(amount + "");
            selectTheCurrency(from);

        }

        private void selectTheCurrency(String from) {
            Select select = new Select(currencyDropDown);
            List<WebElement> options = select.getOptions();
            options.forEach(o -> System.out.println("o = " + o.getText()));
            select.selectByVisibleText(from);
            System.out.println("select = " + select.getOptions());
        }

        public void calculateWithoutSelection(String info) {

            if (info.contentEquals("Currency")) {
                System.out.println("is not selected " + info);
                amountBox.sendKeys("200");
                inDollorsRadioButton.click();
                calculateButton.click();
            } else {
                Select select = new Select(currencyDropDown);
                select.selectByIndex(2);
                inDollorsRadioButton.click();
                calculateButton.click();
            }

        }

        public boolean isAlertPresent() {
            Alert alert = Driver.get().switchTo().alert();
            System.out.println("alert.getText() = " + alert.getText());
            Assert.assertTrue("Alert appears information if info miss : ", BrowserUtils.isAlertPresent());
            return BrowserUtils.isAlertPresent();
        }
    }

    public static class AddNewPayee extends BasePage {
        @FindBy(id = "np_new_payee_name")
        protected WebElement payeeNameBox;
        @FindBy(id = "np_new_payee_address")
        protected WebElement payeeAddressBox;
        @FindBy(id = "np_new_payee_account")
        protected WebElement payeeAccountBox;
        @FindBy(id = "np_new_payee_details")
        protected WebElement payeeDetailBox;
        @FindBy(id = "add_new_payee")
        protected WebElement addPayeeButton;
        @FindBy(id = "alert_content")
        protected WebElement message;

        public AddNewPayee() {
            PageFactory.initElements(Driver.get(), this);
        }

        public void addNewPayee(String name, String address, String account, String details) {
            //        BrowserUtils.sendKeys(payeeNameBox,name);
            //        BrowserUtils.sendKeys(payeeAddressBox, address);
            //        BrowserUtils.sendKeys(payeeAccountBox, account);
            //        BrowserUtils.sendKeys(payeeDetailBox, details);

            payeeNameBox.sendKeys(name);
            payeeAddressBox.sendKeys(address);
            payeeAccountBox.sendKeys(account);
            payeeDetailBox.sendKeys(details);

            BrowserUtils.waitFor(5);
            addPayeeButton.click();
            //       System.out.println("message.isDisplayed() = " + message.isDisplayed());
        }


    }
}
