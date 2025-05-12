package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrowPage extends TestBase {

    @FindBy(xpath = "//span[text()='Sell']")
    WebElement SellBtn;


    public GrowPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateGrowPageTitle()
    {
        return driver.getTitle();
    }

    public ProductsPage ValidateLogin() throws InterruptedException {
        Thread.sleep(2000);
       // SellBtn.click();
        TestUtil.click(SellBtn,"");
        LogUtils.info("Sell button clicked");
        return new ProductsPage();
    }
}
