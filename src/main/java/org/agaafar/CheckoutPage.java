package org.agaafar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase {
    // Locators
    private final By storeFrontLink = By.xpath("//*[@id='cms-demo']/div[2]/div/div[1]/div");
    private final By firstName = By.id("input-payment-firstname");
    private final By lastName = By.id("input-payment-lastname");
    private final By email = By.id("input-payment-email");
    private final By continueAfterDetails = By.id("button-payment-address");
    private final By shippingMethod = By.name("shipping_method");
    private final By continueAfterShipping = By.id("button-shipping-method");
    private final By paymentMethod = By.name("payment_method");
    private final By cashOnDelivery = By.xpath("//input[@value='cod']");
    private final By creditCard = By.xpath("//input[@value='credit_card']");
    private final By continueAfterPayment = By.id("button-payment-method");
    private final By confirmOrder = By.id("button-confirm");
    private final By successMessage = By.cssSelector(".alert-success");
    private final By orderConfirmation = By.cssSelector("#content h1");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToStoreFront() {
        clickOnElement(storeFrontLink);
    }

    public void enterDetails(String fName, String lName, String emailAddr) {
        sendKeys(firstName, fName);
        sendKeys(lastName, lName);
        sendKeys(email, emailAddr);
    }

    public void clickContinueAfterDetails() {
        clickOnElement(continueAfterDetails);
    }

    public void selectShippingMethod() {
        clickOnElement(shippingMethod);
        clickOnElement(continueAfterShipping);
    }

    public void selectPaymentMethod(String method) {
        if (method.equalsIgnoreCase("Cash On Delivery")) {
            clickOnElement(cashOnDelivery);
        } else if (method.equalsIgnoreCase("Credit Card")) {
            clickOnElement(creditCard);
        }
        clickOnElement(continueAfterPayment);
    }

    public void confirmOrder() {
        clickOnElement(confirmOrder);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            waitTimeToBeVisible(successMessage);
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOrderConfirmationDisplayed() {
        try {
            waitTimeToBeVisible(orderConfirmation);
            return driver.findElement(orderConfirmation).getText()
                    .contains("Your order has been placed");
        } catch (Exception e) {
            return false;
        }
    }
}