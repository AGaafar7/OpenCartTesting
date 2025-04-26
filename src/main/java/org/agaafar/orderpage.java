package org.agaafar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderpage extends PageBase{
    public orderpage(WebDriver driver){super(driver);}
    By clickonadministration=By.xpath("//a[@href=\"https://demo.opencart.com/admin/\"]");
    By clickonloginadminstration=By.xpath("//button[@type=\"submit\"]");
    By clickonsale=By.id("menu-sale");
    By clickonorder=By.xpath("//*[@id=\"collapse-4\"]/li[1]/a");
    By orderid=By.xpath("//*[@id=\"input-order-id\"]");
    By customer=By.xpath("//*[@id=\"input-customer\"]");
    By total=By.xpath("//*[@id=\"input-total\"]");
    By filterbutton=By.xpath("//*[@id=\"button-filter\"]");

    public void checkclickonadminstration(){clickOnElement(clickonadministration);};
    public void checkclickonloginadminstration(){clickOnElement(clickonloginadminstration);}
    public void checkclickonsale(){clickOnElement(clickonsale);}
    public void checkclickonorder(){clickOnElement(clickonorder);}
    public void checkfillorderid (String Orderid){sendKeys(this.orderid, Orderid);}
    public void checkfillcustomername (String Customer){sendKeys(this.customer, Customer);}
    public void checkfilltotal (String Total){sendKeys(this.total, Total);}
    public  void checkfilterbutton(){clickOnElement(filterbutton);};
}