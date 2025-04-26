
import org.agaafar.CartPage;
import org.agaafar.ProductImagePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CartTests extends TestBase {
    private static final String TEST_PRODUCT = "Canon EOS 5D";
    private static final String INVALID_COUPON = "INVALIDCODE";
    private static final int TEST_QUANTITY = 3;

    private ProductImagePage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        productPage = new ProductImagePage(driver);
        cartPage = new CartPage(driver);

        cartPage.navigateToStoreFront();
    }

    @Test
    public void testAddToCart() {
        productPage.openProduct();
        cartPage.addToCart();

        assertTrue(cartPage.isSuccessMessageDisplayed(),
                "Success message should appear after adding to cart");
    }

    @Test(dependsOnMethods = "testAddToCart")
    public void testQuantityUpdate() {
        productPage.openProduct();
        cartPage.addToCart();
        cartPage.openCart();

        cartPage.updateQuantity(TEST_QUANTITY);
        assertFalse(cartPage.isErrorMessageDisplayed(),
                "No error should occur when updating quantity");
    }

    @Test
    public void testCouponApplication() {
        productPage.openProduct();
        cartPage.addToCart();
        cartPage.openCart();

        cartPage.applyCoupon(INVALID_COUPON);
        assertTrue(cartPage.isErrorMessageDisplayed(),
                "Error message should appear for invalid coupon");
    }
}