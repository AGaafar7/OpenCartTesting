package org.agaafar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderpage extends PageBase{
    public orderpage(WebDriver driver){super(driver);}
    By clickonadministration=By.xpath("//a[@href=\"https://demo.opencart.com/admin/\"]");
    By clickonloginadminstration=By.xpath("//button[@type=\"submit\"]");

    public void checkclickonadminstration(){clickOnElement(clickonadministration);};
    public void checkclickonloginadminstration(){clickOnElement(clickonloginadminstration);}

}
