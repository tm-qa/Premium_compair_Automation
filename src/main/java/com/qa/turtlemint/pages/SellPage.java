package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellPage extends TestBase {

    @FindBy(xpath = "//span[text()='Sell']")
    WebElement SellBtn;


    public SellPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateGrowPageTitle()
    {
        return driver.getTitle();
    }

    public ProductsPage ValidateLogin(String otp)
    {
        SellBtn.click();
        return new ProductsPage();
    }
}
