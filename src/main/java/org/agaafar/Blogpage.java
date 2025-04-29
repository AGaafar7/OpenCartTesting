package org.agaafar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Blogpage extends PageBase{

    public Blogpage(WebDriver driver){super(driver);}
    By clickBlog = By.xpath("//li[4]");
    By clickcontinuereading= By.xpath("//a[@class=\"btn btn-primary hidden-xs\"]");


    public void clickoncheckclickBlog(){clickOnElement(clickBlog);
    scrollDown(100);
    }
    public void clickoncheckcontinuereading(){clickOnElement(clickcontinuereading);}
}
