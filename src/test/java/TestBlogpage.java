import org.agaafar.Blogpage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.agaafar.blogassert;
public class TestBlogpage extends TestBase{
  Blogpage blogpage;
  blogassert Blogassert;
@BeforeMethod
    public void init(){
    blogpage= new Blogpage(driver);
    Blogassert  = new blogassert(driver);
}

public void login()throws InterruptedException{
    blogpage.clickoncheckclickBlog();
    Thread.sleep(1000);
    blogpage.clickoncheckcontinuereading();
    Thread.sleep(1000);
  Assert.assertEquals(Blogassert.ActualResultAssert(),Blogassert.blogasserttext);
}
}
