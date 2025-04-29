import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AdminLoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       // driver.get("https://demo.opencart.com/admin/");
        driver.get("https://www.opencart.com/index.php?route=cms/demo");

    }

    @Test
    public void testAdminLogin() {
        try {
            Thread.sleep(10000);  // replace with explicit wait in production
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String emailXPath = "//*[@id=\"input-username\"]";
        String passwordXPath = "//*[@id=\"input-password\"]";
        String loginButtonXPath = "//*[@id=\"form-login\"]/div[3]/button";

        WebElement emailField = driver.findElement(By.xpath(emailXPath));
        WebElement passwordField = driver.findElement(By.xpath(passwordXPath));
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));

        emailField.sendKeys("demo");
        passwordField.sendKeys("demo");
        loginButton.click();

        // Wait briefly and verify login success
        try {
 Thread.sleep(3000);  // replace with explicit wait in production
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Dashboard"), "Login failed or incorrect redirect.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
