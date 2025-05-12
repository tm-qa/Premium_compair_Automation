package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarDetailsPage extends TestBase {

    public CarDetailsPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Your Car detail']")
    WebElement Carlbl;

    @FindBy(xpath = "//input[@type='search']")
    WebElement CarModel;

    @FindBy(xpath = "//span[text()='Ford Figo']")
    WebElement SelectModel;

    @FindBy(xpath = "//span[text()='Ford Figo']")
    WebElement SelectTWModel;

    @FindBy(xpath = "//span[text()='2024']")
    WebElement RegYear;

    @FindBy(xpath = "//span[text()='Diesel']")
    WebElement FuelType;

    @FindBy(xpath = "//span[text()='Petrol']")
    WebElement Tw_FuelType;
    @FindBy(id = "variant-uiSelect")
    WebElement ClickVariant;

    @FindBy(xpath = "//div[@ng-if=\"$select.open\"]")
    WebElement SelectVariant;

    @FindBy(xpath = "//span[text()='Duratorq LXI (1399 CC)']")
    WebElement SelectTWVariant;

    @FindBy(id = "container-next-btn")
    WebElement NextButton;

    public SaveQuotePage SaveCarDetails(String CarName, String variant) throws InterruptedException {

        Thread.sleep(2000);
        Carlbl.isDisplayed();
        LogUtils.info("Car Details Entering Started");
        Thread.sleep(2000);
        TestUtil.sendKeys(CarModel,CarName,CarName+" CarName entered");
        Thread.sleep(2000);
        TestUtil.click(SelectModel,SelectModel.getText()+" entered");
        Thread.sleep(2000);
        TestUtil.click(RegYear,RegYear.getText()+" entered");
        Thread.sleep(2000);
        TestUtil.click(FuelType,FuelType.getText()+" entered");
        Thread.sleep(2000);
        TestUtil.click(ClickVariant,"ClickVariant");
        LogUtils.info("Car variant Selection is in process");
        Thread.sleep(4000);
        TestUtil.click(SelectVariant,SelectVariant.getText()+" selected");
        Thread.sleep(2000);
        TestUtil.click(NextButton,"Next Button");
        LogUtils.info("Clicked Next Button and Proceeded to Lead Name Page");
        Thread.sleep(2000);

        return new SaveQuotePage();

    }





}
