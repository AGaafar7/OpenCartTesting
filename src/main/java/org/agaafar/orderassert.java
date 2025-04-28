package org.agaafar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderassert extends PageBase{
    public orderassert (WebDriver driver) {super(driver);}

    String url ="https://www.opencart.com/blog/can-you-start-a-successful-ecommerce-business-without-inventory";

    public String orderasserttext = "Hamza abu sabra";

    By actualResult= By.id("//*[@id=\"form-order\"]/div[1]/table/tbody/tr/td[4]");
    public String ActualResultAssert(){return driver.findElement(actualResult).getText();}
}


