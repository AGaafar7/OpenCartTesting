package org.agaafar;
import com.sun.jna.WString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderpage extends PageBase{
    public orderpage(WebDriver driver){super(driver);}
    By clickonadministration=By.xpath("//*[@id=\"cms-demo\"]/div[2]/div/div[2]/div");
    By clickonloginadminstration=By.xpath("//button[@type=\"submit\"]");
    By clickonsale=By.id("menu-sale");
    By clickonorder=By.xpath("//*[@id=\"collapse-4\"]/li[1]/a");
    By orderid=By.xpath("//*[@id=\"input-order-id\"]");
    By customer=By.xpath("//*[@id=\"input-customer\"]");
    By total=By.xpath("//*[@id=\"input-total\"]");
    By orderstatus=By.xpath("//*[@id=\"input-order-status\"]");
    By filterbutton=By.xpath("//*[@id=\"button-filter\"]");

    public void checkclickonadminstration(){
        scrollDown(300);
        clickOnElement(clickonadministration);
    };
    public void checkclickonloginadminstration(){
        clickOnElement(clickonloginadminstration);
    }
    public void checkclickonsale(){
        clickOnElement(clickonsale);
    }
    public void checkclickonorder(){
        clickOnElement(clickonorder);
    }
    public void checkfillorderid (String Orderid){
        sendKeys(this.orderid, Orderid);
    }
    public void checkfillcustomername (String Customer){
        sendKeys(this.customer, Customer);
    }
    public void checkfilltotal (String Total){
        sendKeys(this.total, Total);
    }
    public void checkselectorderstatus(String value){
        selectfromDropDownList(orderstatus,value);
    }
    public  void checkfilterbutton(){
        clickOnElement(filterbutton);};
}
