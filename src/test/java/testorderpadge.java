import org.testng.annotations.BeforeMethod;
import org.agaafar.orderpage;
import org.testng.annotations.Test;
import org.agaafar.orderpage;

public class testorderpadge extends TestBase {

    orderpage Orderpage;
    @BeforeMethod
    public void init() {
        Orderpage = new orderpage(driver);
    }
    @Test
    public void loginorderoage()throws InterruptedException{
        Thread.sleep(100);
        Orderpage.checkclickonadminstration();
        Thread.sleep(1000);
        Orderpage.checkclickonloginadminstration();
        Thread.sleep(1000);
        Orderpage.checkclickonsale();
        Thread.sleep(1000);
        Orderpage.checkclickonorder();
        Thread.sleep(1000);
        Orderpage.checkfillorderid("555");
        Thread.sleep(1000);
        Orderpage.checkfillcustomername("osama");
        Thread.sleep(1000);
        Orderpage.checkfilltotal("200");
        Thread.sleep(1000);
        Orderpage.checkfilterbutton();
    }
}