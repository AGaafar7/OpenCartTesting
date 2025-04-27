package org.agaafar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase {
    // Locators
    private By storeFrontLink = By.xpath("//a[contains(.,'Store Front')]");
    private final By firstName = By.id("input-payment-firstname");
    private final By lastName = By.id("input-payment-lastname");
    private final By email = By.id("input-payment-email");
    private final By continueBtn = By.id("button-payment-address");
    private final By shippingMethod = By.name("shipping_method");
    private final By paymentMethod = By.name("payment_method");
    private final By successMessage = By.cssSelector(".alert-success");

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

    public void selectShippingMethod() {
        clickOnElement(shippingMethod);
        clickOnElement(continueBtn);
    }

    public void selectPaymentMethod() {
        clickOnElement(paymentMethod);
        clickOnElement(continueBtn);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            waitTimeToBeVisible(successMessage);
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}