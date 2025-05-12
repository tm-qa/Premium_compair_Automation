package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BikeDetailsPage extends TestBase {

    public BikeDetailsPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Your Bike detail']")
    WebElement BikeLbl;

    @FindBy(xpath = "//input[@type='search']")
    WebElement BikeModel;

    @FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='Honda Activa']")
    WebElement SelectTWModel;

    @FindBy(xpath = "//span[text()='2024']")
    WebElement RegYear;

    @FindBy(xpath = "//span[text()='Petrol']")
    WebElement Tw_FuelType;

    @FindBy(xpath = "//div[@placeholder='Type name or select']//span[@aria-label='Select box activate']")
    WebElement ClickVariant;

    @FindBy(xpath = "//span[contains(text(),'5G Deluxe (110 CC)')]")
    WebElement SelectTWVariant;

    @FindBy(xpath = "//span[contains(text(),'3G (110 CC)')]")
    WebElement SelectTWVariant2;


    @FindBy(xpath = "//span[contains(text(),'5G (110 CC)')]")
    WebElement SelectTWVariant5g110cc;


    @FindBy(id = "container-next-btn")
    WebElement NextButton;

    public SaveQuotePage SaveBikeDetails(String BikeName) throws InterruptedException {

        BikeLbl.isDisplayed();
        TestUtil.sendKeys(BikeModel,BikeName,BikeName+" BikeName entered");
        TestUtil.click(SelectTWModel,SelectTWModel.getText()+" Selected");
        TestUtil.click(RegYear,RegYear.getText()+" Selected");
        TestUtil.click(Tw_FuelType," Tw_FuelType Selected");
        TestUtil.click(ClickVariant," ClickVariant Clicked");

        try {
            TestUtil.click(SelectTWVariant2,SelectTWVariant2.getText()+" selected");
        }
       catch (Exception e){
           TestUtil.click(SelectTWVariant5g110cc,SelectTWVariant5g110cc.getText()+" selected");
       }

        TestUtil.click(NextButton," NextButton");

        return new SaveQuotePage();

    }
}
