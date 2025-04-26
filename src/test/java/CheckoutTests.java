
import org.agaafar.CheckoutPage;
import org.agaafar.CartPage;
import org.agaafar.ProductImagePage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CheckoutTests extends TestBase {

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String EMAIL = "john@example.com";

    @Test
    public void testCheckoutProcess() {
        // Initialize page objects
        ProductImagePage productPage = new ProductImagePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.navigateToStoreFront();

        productPage.openProduct();

        cartPage.addToCart();
        assertTrue(cartPage.isSuccessMessageDisplayed(),
                "Product should be added to cart successfully");

        cartPage.openCart();

        checkoutPage.enterDetails(FIRST_NAME, LAST_NAME, EMAIL);
        checkoutPage.selectShippingMethod();
        assertTrue(checkoutPage.isSuccessMessageDisplayed(),
                "Shipping method should be selected successfully");
    }
}