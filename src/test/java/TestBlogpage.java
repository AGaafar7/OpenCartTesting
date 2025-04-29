import org.agaafar.Blogpage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.agaafar.blogassert;
import org.testng.annotations.Test;

public class TestBlogpage extends TestBase{

    Blogpage blogpage;
    blogassert Blogassert;
    @BeforeMethod
    public void init(){
        blogpage= new Blogpage(driver);
        Blogassert  = new blogassert(driver);
    }

    @Test
    public void login()throws InterruptedException{
        blogpage.clickoncheckclickBlog();
        Thread.sleep(1000);
        blogpage.clickoncheckcontinuereading();
        Thread.sleep(1000);
        Assert.assertEquals(Blogassert.ActualResultAssert(),Blogassert.blogasserttext);
    }
}

