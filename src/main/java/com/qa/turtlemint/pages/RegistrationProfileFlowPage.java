package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationProfileFlowPage extends TestBase {
    public RegistrationProfileFlowPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@placeholder='Ex- MH04BF1122']")
    WebElement RegistrationNumber;

    @FindBy (xpath = "//button[normalize-space()='Get Quote']")
    WebElement GetQuote;

    @FindBy (xpath = "//input[@id='registrationDate-datepicker']")
    WebElement DatePicker;

    @FindBy (xpath = "//a[normalize-space()='20']")
    WebElement SelectDate;

    @FindBy (xpath = "//button[@id='container-next-btn']")
    WebElement Next;

    @FindBy (xpath = "//input[@aria-label='Select box']")
    WebElement MakeModel;

    //  @FindBy (xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='Honda Activa']")
    @FindBy (xpath = "//span[text()='Hero Power']")
    WebElement Activa;

    @FindBy (xpath = "//span[contains(text(),'2019')]")
    WebElement ManufacturingYear;

    @FindBy (xpath = "//span[@class='outer']")
    WebElement FuelType;

    @FindBy (xpath = "//span[@class='ui-select-placeholder text-muted ng-binding']")
    WebElement Variant;

    @FindBy (xpath = "//span[contains(text(),'GXL (65 CC)')]")
    WebElement SelectVariant;

    @FindBy (xpath = "//label[@data-auto='policytype-od-radio']")
    WebElement OwnDamage;

    @FindBy (xpath = "//label[@data-auto='policytype-comprehensive-radio']")
    WebElement Comprehensive;

    @FindBy (xpath = "//label[@data-auto='policytype-tp-radio']")
    WebElement ThirdParty;

    @FindBy (xpath = "//span[contains(text(),'Expiring today or tomorrow')]")
    WebElement ExpiringTodayTomorrow;

    @FindBy (xpath = "//span[contains(text(),'Expiring in few days')]")
    WebElement ExpiringFewDays;

    @FindBy (xpath = "//span[contains(text(),'Expired, less than 90 days ago')]")
    WebElement ExpiringLessThan90Days;

    @FindBy (xpath = "//span[contains(text(),'Expired, more than 90 days ago')]")
    WebElement ExpiringMoreThan90Days;

    @FindBy (xpath = "//input[@id='expiryDate-datepicker']")
    WebElement ExpiryDate;

    @FindBy (xpath = "//label[@data-auto='previouspolicytype-comprehensive-radio']")
    WebElement PreviousPolicy;

    @FindBy (xpath = "//label[@data-auto='previouspolicytype-ltod-radio']")
    WebElement PreviousPolicyOD;

    @FindBy (xpath = "//label[@data-auto='prevclaim-false-radio']")
    WebElement PrevClaim;

    @FindBy (xpath = "//span[contains(text(),'20%')]")
    WebElement PrevPolicyNcb;

    @FindBy (xpath = "//span[contains(text(),'Acko General Insurance')]")
    WebElement PrevPolicyInsurer;

    @FindBy (xpath = "//input[@name='customerName']")
    WebElement LeadName;

    public void comprehensive() throws InterruptedException {
        Thread.sleep(5000);
        RegistrationNumber.sendKeys("MH02TP3059");
        GetQuote.click();
        DatePicker.sendKeys("20/05/2019");
        SelectDate.click();
        Next.click();
        MakeModel.sendKeys("Hero Power");
        Activa.click();
        ManufacturingYear.click();
        FuelType.click();
        Variant.click();
        SelectVariant.click();
        Next.click();
        Comprehensive.click();
        Next.click();
        ExpiringFewDays.click();
        ExpiryDate.click();
        SelectDate.click();
        Thread.sleep(3000);
        PreviousPolicy.click();
        PrevClaim.click();
        PrevPolicyNcb.click();
        PrevPolicyInsurer.click();
        Next.click();
        Thread.sleep(3000);
        LeadName.sendKeys("Test");
        Next.click();
        Thread.sleep(10000);
    }
    public void thirdParty() throws InterruptedException {
        Thread.sleep(5000);
        RegistrationNumber.sendKeys("MH02TP3059");
        GetQuote.click();
        DatePicker.sendKeys("20/05/2019");
        SelectDate.click();
        Next.click();
        MakeModel.sendKeys("Hero Power");
        Activa.click();
        ManufacturingYear.click();
        FuelType.click();
        Variant.click();
        SelectVariant.click();
        Next.click();
        ThirdParty.click();
        Next.click();
        ExpiringMoreThan90Days.click();
//        ExpiryDate.click();
//        SelectDate.click();
//        PreviousPolicy.click();
//        PrevClaim.click();
//        PrevPolicyNcb.click();
//        PrevPolicyInsurer.click();
        Next.click();
        Thread.sleep(3000);
        LeadName.sendKeys("Test");
        Next.click();
        Thread.sleep(10000);
    }

    public void ownDamage() throws InterruptedException {
        Thread.sleep(5000);
        RegistrationNumber.sendKeys("MH02TP3059");
        GetQuote.click();
        DatePicker.sendKeys("20/05/2019");
        SelectDate.click();
        Next.click();
        MakeModel.sendKeys("Hero Power");
        Activa.click();
        ManufacturingYear.click();
        FuelType.click();
        Variant.click();
        SelectVariant.click();
        Next.click();
        OwnDamage.click();
        Next.click();
        ExpiringTodayTomorrow.click();
        ExpiryDate.click();
        SelectDate.click();
        Thread.sleep(3000);
        PreviousPolicyOD.click();
        PrevClaim.click();
        PrevPolicyNcb.click();
        PrevPolicyInsurer.click();
        Next.click();
        Thread.sleep(3000);
        LeadName.sendKeys("Test");
        Next.click();
        Thread.sleep(10000);
    }
}