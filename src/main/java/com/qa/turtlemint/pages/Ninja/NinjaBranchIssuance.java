package com.qa.turtlemint.pages.Ninja;

import com.qa.turtlemint.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;



public class NinjaBranchIssuance extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'Policy Issuance')]")
    WebElement IssuanceBtn;

    @FindBy(xpath = "//button[@class='_md-nav-button md-accent md-button md-ink-ripple md-unselected']")
    WebElement ReportASale;

    @FindBy(xpath = "//button[@class='md-icon-button md-button ng-scope md-ink-ripple']")
    WebElement Plusbtn;

    @FindBy(xpath = "//md-select[@id='$$vertical']")
    WebElement VerticlDropdown;

    //List Required in Function
    @FindBy(xpath = "//md-select-menu[contains(@class,'_md md-overflow')]//md-content//md-option")
    WebElement VerticalList;

    @FindBy(id = "policyIssuanceStatus")
    WebElement  PolicyIssuanceDropdown;


    //List Required in Function
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option")
    WebElement PolicyIssuaceList;

    @FindBy(id = "insurer")
    WebElement InsurerDropdown;

    @FindBy(xpath = "//li[@class='ng-scope']")
    WebElement InsurerList;

    @FindBy(xpath = "//button[contains(text(),'Create Sale')]")
    WebElement CreateSale;

    @FindBy(name = "registrationNumber")
    WebElement RegNo;

    @FindBy(xpath = "//div/md-datepicker[@id='saleCloseDate']")
    WebElement SaleCloseDatePicker;

    @FindBy(xpath = "//*[@id='md-0-month-2022-6-6']/span")
    WebElement SaleCloseDate;

    @FindBy(id = "policyType")
    WebElement PolicyTypeDropdown;

    //List need to add in method
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option")
    WebElement PolicyTypeList;

    @FindBy(id = "partnerName")
    WebElement PartnerName;

    @FindBy(xpath = "//button[@class='md-icon-button md-button md-ink-ripple']")
    WebElement PolicyFieldSectionArrow;

    @FindBy(id = "proposerFName")
    WebElement FName;

    @FindBy(id = "proposerLName")
    WebElement LName;

    @FindBy(id = "proposerMobile")
    WebElement Mobile;

    @FindBy(xpath = "//input[@id='pincode']")
    WebElement Pincode;

    @FindBy(id = "//input[@id='manufactureYear']")
    WebElement ManufacturingYear;


    @FindBy(xpath = "//md-datepicker[@name='policyStartDate']")
    WebElement StartDatePicker;

    @FindBy(xpath = "//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")
    WebElement StartDate;

    @FindBy(xpath = "//md-datepicker[@name='policyEndDate']")
    WebElement EndDatePicker;

    @FindBy(xpath = "//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")
    WebElement EndDate;

//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;
//
//    @FindBy(xpath = "")
//    WebElement ;







//    public NinjaBranchIssuance()
//    {
//        PageFactory.initElements(driver, this);
//    }
//
//    public void NinjaValidateLogin(String NinjaUrl, String NinjaEmail, String NinjaPassword) throws InterruptedException {
//
//        driver.get(NinjaUrl);
//        SignInbtn.click();
//
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> it=windows.iterator();
//        String p=it.next();
//        String c=it.next();
//
//        driver.switchTo().window(c);
//        Thread.sleep(1000);
//
//        Email.sendKeys(NinjaEmail);
//        Nextbtn1.click();
//        Password.sendKeys(NinjaPassword);
//        Nextbtn2.click();
//
//        driver.switchTo().window(p);
//        Thread.sleep(10000);
//

}