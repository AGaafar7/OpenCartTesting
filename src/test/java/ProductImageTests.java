
import org.agaafar.ProductImagePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductImageTests extends TestBase {
    private ProductImagePage imagePage;

    @BeforeMethod
    public void setUpTest() {
        imagePage = new ProductImagePage(driver);
        String TEST_PRODUCT = "Canon EOS 5D";
        imagePage.navigateToProduct(TEST_PRODUCT);
    }

    @Test
    public void testImageModal() {
        imagePage.clickProductImage();
        assertTrue(imagePage.isImageModalDisplayed(),
                "Image modal should be displayed after clicking product image");
    }

    @Test(dependsOnMethods = "testImageModal")
    public void testImageNavigation() {
        imagePage.clickProductImage();
        String initialImageSrc = imagePage.getCurrentImageSource();

        imagePage.navigateNextImage();
        assertNotEquals(imagePage.getCurrentImageSource(), initialImageSrc,
                "Next image should be different after clicking right arrow");

        imagePage.navigatePreviousImage();
        assertEquals(imagePage.getCurrentImageSource(), initialImageSrc,
                "Original image should reappear after clicking left arrow");
    }

    @Test
    public void testZoomFunctionality() {
        imagePage.clickProductImage();
        int initialWidth = imagePage.getImageWidth();
        int initialHeight = imagePage.getImageHeight();

        imagePage.zoomWithKeyboard(ProductImagePage.ZOOM_IN);
        assertTrue(imagePage.getImageWidth() > initialWidth &&
                        imagePage.getImageHeight() > initialHeight,
                "Image dimensions should increase after zoom in");

        imagePage.zoomWithKeyboard(ProductImagePage.ZOOM_OUT);
        assertTrue(imagePage.getImageWidth() < initialWidth &&
                        imagePage.getImageHeight() < initialHeight,
                "Image dimensions should decrease after zoom out");
    }
}