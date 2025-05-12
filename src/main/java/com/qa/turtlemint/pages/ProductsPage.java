package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends TestBase {

    @FindBy(xpath ="//p[text()='Car']")
    WebElement FW;

    @FindBy(xpath ="//p[text()='Bike']")
    WebElement tw;

    @FindBy(xpath ="//p[text()='Commercial Vehicle']")
    WebElement cw;

    @FindBy(xpath ="//p[text()='Health']")
    WebElement health;

    @FindBy(xpath ="//span[text()='Personal Accident']")
    WebElement PA;

    @FindBy(xpath ="//span[text()='Term Life']")
    WebElement TL;

    public ProductsPage()
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

    public GetQuotePage ValidateMotorFWClick() throws InterruptedException {
        TestUtil.click(FW,"FW clicked");
        return new GetQuotePage();
    }

    public GetQuotePage ValidateMotorTWClick() throws InterruptedException {
        TestUtil.click(tw,"TW clicked");
        return new GetQuotePage();
    }
    public GetQuotePage ValidateMotorCVClick() throws InterruptedException {
        TestUtil.click(cw,"CW clicked");
        return new GetQuotePage();
    }



}
