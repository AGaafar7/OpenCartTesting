import org.agaafar.CheckoutPage;
import org.agaafar.CartPage;
import org.agaafar.ProductImagePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CheckoutTests extends TestBase {
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String EMAIL = "john@example.com";
    private static final String TEST_PRODUCT = "Canon EOS 5D";

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        ProductImagePage productPage = new ProductImagePage(driver);
        CartPage cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        // Navigate to product and add to cart
        productPage.navigateToProduct(TEST_PRODUCT);
        cartPage.addToCart();
        cartPage.openCart();
    }

    @Test
    public void testPersonalDetailsEntry() {
        checkoutPage.enterDetails(FIRST_NAME, LAST_NAME, EMAIL);
        checkoutPage.clickContinueAfterDetails();
        assertTrue(checkoutPage.isSuccessMessageDisplayed(),
                "Should proceed after entering personal details");
    }

    @Test(dependsOnMethods = "testPersonalDetailsEntry")
    public void testShippingMethodSelection() {
        checkoutPage.enterDetails(FIRST_NAME, LAST_NAME, EMAIL);
        checkoutPage.clickContinueAfterDetails();

        checkoutPage.selectShippingMethod();
        assertTrue(checkoutPage.isSuccessMessageDisplayed(),
                "Shipping method should be selected successfully");
    }

    @Test(dependsOnMethods = "testShippingMethodSelection")
    public void testPaymentMethodSelection() {
        checkoutPage.enterDetails(FIRST_NAME, LAST_NAME, EMAIL);
        checkoutPage.clickContinueAfterDetails();
        checkoutPage.selectShippingMethod();

        // Test cash on delivery payment method
        checkoutPage.selectPaymentMethod("Cash On Delivery");
        assertTrue(checkoutPage.isSuccessMessageDisplayed(),
                "Payment method should be selected successfully");

        // Alternatively test credit card payment method
        checkoutPage.selectPaymentMethod("Credit Card");
        assertTrue(checkoutPage.isSuccessMessageDisplayed(),
                "Credit card payment method should be selected successfully");
    }

    @Test
    public void testCompleteCheckoutProcess() {
        checkoutPage.enterDetails(FIRST_NAME, LAST_NAME, EMAIL);
        checkoutPage.clickContinueAfterDetails();
        checkoutPage.selectShippingMethod();
        checkoutPage.selectPaymentMethod("Cash On Delivery");
        checkoutPage.confirmOrder();

        assertTrue(checkoutPage.isOrderConfirmationDisplayed(),
                "Order should be successfully placed");
    }
}