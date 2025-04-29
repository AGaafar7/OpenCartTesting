package org.agaafar;

import org.agaafar.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class ProductImagePage extends PageBase {
    // Locators
    private final By storeFrontLink = By.xpath("//*[@id='cms-demo']/div[2]/div/div[1]/div");
    private final By productLink = By.linkText("Canon EOS 5D");
    private final By productImage = By.cssSelector(".thumbnails img");
    private final By imageModal = By.id("image-modal");
    private final By leftArrow = By.cssSelector(".mfp-arrow-left");
    private final By rightArrow = By.cssSelector(".mfp-arrow-right");

    // Constants
    public static final String ZOOM_IN = "in";
    public static final String ZOOM_OUT = "out";

    public ProductImagePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProduct(String productName) {
        clickOnElement(storeFrontLink);
        clickOnElement(By.linkText(productName));
    }

    public String getCurrentImageSource() {
        return driver.findElement(imageModal).getAttribute("src");
    }

    public void openProduct() {
        clickOnElement(productLink);
    }

    public void clickProductImage() {
        clickOnElement(productImage);
    }

    public boolean isImageModalDisplayed() {
        try {
            waitTimeToBeVisible(imageModal);
            return driver.findElement(imageModal).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateNextImage() {
        clickOnElement(rightArrow);
    }

    public void navigatePreviousImage() {
        clickOnElement(leftArrow);
    }

    public void zoomWithKeyboard(String direction) {
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys(direction.equals("in") ? Keys.ADD : Keys.SUBTRACT)
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public int getImageWidth() {
        return driver.findElement(imageModal).getSize().getWidth();
    }

    public int getImageHeight() {
        return driver.findElement(imageModal).getSize().getHeight();
    }

}