package com.qa.turtlemint.pages.Health;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.GetQuotePage;
import com.qa.turtlemint.pages.ProductsPage;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthProductsPage extends TestBase {
    @FindBy(xpath ="//span[text()='Car']")
    WebElement FW;

    @FindBy(xpath ="//span[text()='Bike']")
    WebElement tw;

    @FindBy(xpath ="//span[text()='Commercial Vehicle']")
    WebElement cw;

    @FindBy(xpath ="//p[text()='Health insurance']")
    WebElement health;

    @FindBy(xpath ="//span[text()='Personal Accident']")
    WebElement PA;

    @FindBy(xpath ="//span[text()='Term Life']")
    WebElement TL;

    public HealthProductsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateProductsPageTitle()
    {
        return driver.getTitle();
    }

    public ProductsPage ValidateLogin() throws InterruptedException {

        return new ProductsPage();

    }

    public void ValidateVerticals()
    {
        FW.isDisplayed();
        tw.isDisplayed();
        health.isDisplayed();
        PA.isDisplayed();
        TL.isDisplayed();
        cw.isDisplayed();

    }

    public GetQuotePage ValidateHealthClick() throws InterruptedException {
        TestUtil.click(health,"health Button Clicked");
        return new GetQuotePage();
    }
}
