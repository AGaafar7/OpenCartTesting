package org.agaafar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class blogassert extends PageBase {
    public blogassert (WebDriver driver) {super(driver);}

    String url ="https://www.opencart.com/blog/can-you-start-a-successful-ecommerce-business-without-inventory";

    public String blogasserttext = "Search articles";

    By actualResult= By.id("blog-search");

    public String ActualResultAssert(){return driver.findElement(actualResult).getText();}}

