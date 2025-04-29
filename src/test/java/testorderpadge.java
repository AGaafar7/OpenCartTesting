import org.agaafar.blogassert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.agaafar.orderpage;
import org.testng.annotations.Test;
import org.agaafar.orderassert;

public class testorderpadge extends TestBase {

    orderpage Orderpage;
    orderassert Orderassert;
    @BeforeMethod
    public void init() {
        Orderpage = new orderpage(driver);
        Orderassert  = new orderassert(driver);
    }
    @Test
    public void loginorderoagewithvalidinformation()throws InterruptedException{
        Thread.sleep(10000);
        Orderpage.checkclickonadminstration();
        Thread.sleep(1000);
        Orderpage.checkclickonloginadminstration();
        Thread.sleep(1000);
        Orderpage.checkclickonsale();
        Thread.sleep(1000);
        Orderpage.checkclickonorder();
        Thread.sleep(1000);
        Orderpage.checkfillorderid("2599");
        Thread.sleep(1000);
        Orderpage.checkfillcustomername("Hamza abu sabra");
        Thread.sleep(1000);
        Orderpage.checkfilltotal("105.00");
        Orderpage.checkselectorderstatus("Pending");
        Thread.sleep(1000);
        Orderpage.checkfilterbutton();
        Assert.assertEquals(Orderassert.ActualResultAssert(),Orderassert.orderasserttext);
    }
    public void loginorderoagewithunvalidinformation()throws InterruptedException{
        Orderpage.checkclickonadminstration();
        Thread.sleep(1000);
        Orderpage.checkclickonloginadminstration();
        Thread.sleep(1000);
        Orderpage.checkclickonsale();
        Thread.sleep(1000);
        Orderpage.checkclickonorder();
        Thread.sleep(1000);
        Orderpage.checkfillorderid("1111");
        Thread.sleep(1000);
        Orderpage.checkfillcustomername("osama");
        Thread.sleep(1000);
        Orderpage.checkfilltotal("30000");
        Orderpage.checkselectorderstatus("hamooo");
        Thread.sleep(1000);
        Orderpage.checkfilterbutton();
        Assert.assertEquals(Orderassert.ActualResultAssert(),Orderassert.orderasserttext);
    }
}
