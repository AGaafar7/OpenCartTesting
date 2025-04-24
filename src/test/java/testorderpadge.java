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
    }
}