package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class insurancedekho_Page extends TestBase {

    @FindBy(xpath = "//p[text()=\"Car\"]")
    WebElement selectcar;

    @FindBy(xpath = "//label[text()=\"Enter your car number ex DL12AB2345\"]")
    WebElement registrationNumber;
    @FindBy(xpath = "//button[text()=\"Get Vehicle Details\"]")
    WebElement getvehicledetails;
    @FindBy(xpath = "//button[text()=\"Confirm & Get Quotes\"]")
    WebElement confandgetquotes;
    @FindBy(xpath = "//label[text()=\"Policy Expiry Date\"]")
    WebElement calendar;
    @FindBy(xpath = "//label[text()=\"Previous Insurer\"]")
    WebElement previousinsurer;
    @FindBy(xpath = "//div[text()=\"View Plans\"]")
    WebElement viewplans ;


    @FindBy(xpath = "//h2[text()=\"Select Brand\"]")
    WebElement selectBrand;

    @FindBy(xpath = "//a[@title=\"Maruti\"]")
    WebElement selectMake;

    @FindBy(xpath = "//div[@title=\"Alto 800\"]")
    WebElement selectModel;

    @FindBy(xpath = "//li[text()=\"Petrol\"]")
    WebElement fule;

    @FindBy(xpath = "//li[text()=\"LX  (796 cc)\"]")
    WebElement variantType;

    @FindBy(xpath = "//li[text()=\"2025\"]")
    WebElement regYear;

    @FindBy(xpath = "//input[@id=\"customerName\"]")
    WebElement customerName;

    @FindBy(xpath = "//input[@id=\"mobileNumber\"]")
    WebElement mobileNumber;

    @FindBy(xpath = "//input[@type=\"checkbox\"]//parent::*//parent::div")
    WebElement checkbox;

    @FindBy(xpath = "//span[text()=\"View Prices\"]")
    WebElement viewPricesButton;

    @FindBy(xpath = "//a[text()=\"I don't know my expiry date\"]")
    WebElement expiryDate;

    @FindBy(xpath = "//input[@id=\"previous_insurer\"]")
    WebElement previousInsurer;

    @FindBy(xpath = "//li[@data-name=\"Bajaj Allianz\"]")
    WebElement selectPreviousInsurer;

    @FindBy(xpath = "//button[@name=\"submitBtn\"]")
    WebElement confirmDetailsButton;

    @FindBy(xpath = "//input[@id=\"prevPolicy\"]")
    WebElement prevPolicy;

    @FindBy(xpath = "//li[@data-value=\"Within 7 to 15 days\"]")
    WebElement after15days;

    @FindBy(xpath = "//div[@class=\"centerRadio\"]//child::div//child::div//following-sibling::div//child::div[@name=\"previous_claimundefined\"]//child::label//div[text()=\"No\"]")
    WebElement claim;
    @FindBy(xpath = "//div[@class=\"centerRadio\"]//child::div//child::div//following-sibling::div//child::div[@name=\"owner_changedundefined\"]//child::label//div[text()=\"No\"]")
    WebElement carowner;

    @FindBy(xpath = "//div[text()=\"View Plans\"]")
    WebElement viewPlnas;


    public insurancedekho_Page() {
        PageFactory.initElements(driver, this);
    }

    public void iddekho() throws InterruptedException {
        TestUtil.click(selectcar,"");
        Thread.sleep(3000);
        registrationNumber.click();
        System.out.println("CLICK");
        TestUtil.sendKeys(registrationNumber,"MH21DE3232","");
        Thread.sleep(3000);
        TestUtil.click(getvehicledetails,"");
        Thread.sleep(5000);
        TestUtil.click(customerName,"");
        TestUtil.click(mobileNumber,"");
        TestUtil.click(checkbox,"");
        TestUtil.click(viewPricesButton,"");
        Thread.sleep(5000);
        TestUtil.click(claim,"");
        TestUtil.click(carowner,"");
        TestUtil.click(viewplans,"");
        Thread.sleep(5000);


    }

    public void insuranceDekho() throws InterruptedException {
        Thread.sleep(3000);
        TestUtil.sendKeys(registrationNumber, "MH21DE3232", "enter registration no");
        Thread.sleep(3000);
        TestUtil.click(selectMake, "click on make");
        TestUtil.click(selectModel, "select model");
        TestUtil.click(fule, "select fuel");
        TestUtil.click(variantType, "select variant");
        TestUtil.click(regYear, "select reg year");
        TestUtil.sendKeys(customerName, "customer name", "enter name");
        TestUtil.sendKeys(mobileNumber, "6543217869", "enter mb no");
        TestUtil.click(checkbox, "chick on checkbox");
        TestUtil.click(viewPricesButton, "click on view button");
    }

    public void conformDetails() {
        TestUtil.click(expiryDate, " click on I know my expiry date");
        TestUtil.click(prevPolicy, "");
        TestUtil.click(after15days, "");
        TestUtil.click(previousInsurer, " click on prev insurer");
        TestUtil.click(selectPreviousInsurer, "select prev insurer");
        TestUtil.click(confirmDetailsButton, "gf");
        TestUtil.click(claim, "");
        TestUtil.click(viewPlnas, "");
    }


}
