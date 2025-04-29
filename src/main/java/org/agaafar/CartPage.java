package org.agaafar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {
    private final By storeFrontLink = By.xpath("//*[@id='cms-demo']/div[2]/div/div[1]/div");
    private final By addToCartBtn = By.cssSelector("button#button-cart");
    private final By cartTotal = By.id("cart-total");
    private final By viewCart = By.linkText("View Cart");
    private final By quantityInput = By.cssSelector("input[name='quantity']");
    private final By updateBtn = By.cssSelector("button[data-original-title='Update']");
    private final By couponInput = By.id("input-coupon");
    private final By applyCouponBtn = By.id("button-coupon");
    private final By successAlert = By.cssSelector(".alert-success");
    private final By errorAlert = By.cssSelector(".alert-danger");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToStoreFront() {
        clickOnElement(storeFrontLink);
    }

    public void addToCart() {
        clickOnElement(addToCartBtn);
    }

    public void openCart() {
        clickOnElement(cartTotal);
        clickOnElement(viewCart);
    }

    public void updateQuantity(int quantity) {
        sendKeys(quantityInput, String.valueOf(quantity));
        clickOnElement(updateBtn);
    }

    public void applyCoupon(String coupon) {
        sendKeys(couponInput, coupon);
        clickOnElement(applyCouponBtn);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            waitTimeToBeVisible(successAlert);
            return driver.findElement(successAlert).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            waitTimeToBeVisible(errorAlert);
            return driver.findElement(errorAlert).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}