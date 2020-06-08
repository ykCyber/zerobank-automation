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



    public  class PurchaseFCC extends BasePage {
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

        public void calculateWithoutSelection() {
            amountBox.sendKeys("200");
            inDollorsRadioButton.click();
            calculateButton.click();
        }

        public boolean isAlertPresent() {
            Alert alert = Driver.get().switchTo().alert();
            System.out.println("alert.getText() = " + alert.getText());
            Assert.assertTrue("Alert appears information if info miss : ", BrowserUtils.isAlertPresent());
            return BrowserUtils.isAlertPresent();
        }
    }

