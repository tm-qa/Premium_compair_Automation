package com.qa.turtlemint.pages.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;



public class NinjaBranchIssuanceMotorPage extends TestBase {

    TestUtil tl = new TestUtil();

    public String ReqIDmotor;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//button[@class='_md-nav-button md-accent md-button md-ink-ripple md-unselected']")
    WebElement ReportASale;

    @FindBy(xpath = "//button[@type='button'][@data-auto='new-branch-button']")
    WebElement Plusbtn;

    @FindBy(xpath = "//md-select[@id='$$vertical']")
    WebElement VerticlDropdown;

    @FindBy(id = "insurer")
    WebElement InsurerDropdown;

    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    WebElement CreateSale;

    @FindBy(name = "registrationNumber")
    WebElement RegNo;

    @FindBy(xpath = "//div/md-datepicker[@id='saleCloseDate']")
    WebElement SaleCloseDatePicker;

    @FindBy(xpath = "//td[@class='md-calendar-date md-calendar-date-today md-focus']")
    WebElement SaleCloseDate;

    @FindBy(id = "partnerName")
    WebElement PartnerName;

    @FindBy(id = "proposerMobile")
    WebElement Mobile;

    @FindBy(id = "proposerEmail")
    WebElement eMail;

    @FindBy(xpath = "//md-datepicker[@name='policyStartDate']")
    WebElement StartDatePicker;

    @FindBy(xpath = "//md-datepicker[@name='policyEndDate']//parent::div//input")
    WebElement EndDatePicker;

    @FindBy(xpath = "//input[@id='netPremium']")
    WebElement NetPremium;

    @FindBy(xpath = "//md-datepicker[@name='policyIssuanceDate']/button")
    WebElement PolicyIssuanceDatePicker;

    @FindBy(xpath = "//td[@class='md-calendar-date md-calendar-date-today md-focus']")
    WebElement PolicyIssuanceDate;

    @FindBy(id = "policyNumber")
    WebElement PolicyNumber;

    @FindBy(xpath = "//input[@type='file']")
    WebElement FileUpload;

    @FindBy(xpath = "//md-radio-button[@value='POLICY']")
    WebElement PolicyTag;

    @FindBy(xpath = "//button[normalize-space()='Done']")
    WebElement FileTagDone;

    @FindBy(xpath = "//button[text()='Save Issuance']")
    WebElement IssuanceSave;

    @FindBy(xpath = "//td[@class=\"md-calendar-date md-calendar-date-today md-focus\"]")
    WebElement Today;

    @FindBy(xpath = "//input[@data-auto=\"serviceTax-number\"]")
    WebElement serviceTaxnumber;

    @FindBy(xpath = "//input[@data-auto=\"grossPremium-number\"]")
    WebElement grossPremiumnumber;
    @FindBy(xpath = "//input[@id='requestId']")//
    WebElement RequestID;
    @FindBy(xpath = "//input[@id=\"policyNo\"]")
    WebElement PolicyNumberReportSale;
    @FindBy(xpath = "//md-select[@data-auto=\"assistedBy-select\"]")
    WebElement Assisted;
    @FindBy(xpath = "//md-option[@value=\"SELF_MANAGED\"]")
    WebElement Selfmanaged;
    @FindBy(xpath = "//a[contains(text(),'Policy Issuance')]")
    WebElement IssuanceBtn;

    public NinjaBranchIssuanceMotorPage() {
        PageFactory.initElements(driver, this);
    }

    public void vertical_list() {
        List<WebElement> vertical_menu = driver.findElements(By.xpath("//md-select-menu[contains(@class,'_md md-overflow')]//md-content//md-option"));
        System.out.println("Vertical Menu = " + vertical_menu.size());


        for (int i = 0; i < vertical_menu.size(); i++) {
            System.out.println(vertical_menu.get(i).getText());
            if (vertical_menu.get(i).getText().contains("Motor")) {
                vertical_menu.get(i).click();
                break;
            }
        }
    }

    public void insurer_list() {
        List<WebElement> insurerlist = driver.findElements(By.xpath("//li[@class='ng-scope']"));

        System.out.println("Insurer List = " + insurerlist.size());

        for (int k = 0; k < insurerlist.size(); k++) {
            if (insurerlist.get(k).getText().contains("Acko General")) {
                insurerlist.get(k).click();
            }
        }
    }

    public void NinjaBranchIssuanceFlow() throws InterruptedException, IOException {
        TestUtil.click(IssuanceBtn, "Policy Insuance Selected");
        Thread.sleep(3000);
        ReportASale.click();
        LogUtils.info("Clicked on ReportSale button");
       // TestUtil.click(Plusbtn,"plus clicked");
        Thread.sleep(4000);
        Plusbtn.click();
        Thread.sleep(3000);
        LogUtils.info("Clicked on Branch Issuance button to create entry");
        VerticlDropdown.click();
        Thread.sleep(2000);
        LogUtils.info("Vertical selected");
        vertical_list();
        Thread.sleep(2500);
        InsurerDropdown.click();
        Thread.sleep(1000);
        InsurerDropdown.sendKeys("Acko General");
        LogUtils.info("Insurer Selected");
        insurer_list();
        LogUtils.info("Showing Insurer list");
        String policyNo = TestUtil.generateRandomPolicyNo(7);
        System.out.println(policyNo);
        TestUtil.sendKeys(PolicyNumberReportSale, policyNo, "Policy number entered on Report a sale page");
        CreateSale.click();
        Thread.sleep(5000);
        LogUtils.info("Clicked on Create Sale button");
        Thread.sleep(2000);
        ReqIDmotor = RequestID.getAttribute("value");
        System.out.println("Request ID : " + ReqIDmotor);
        tl.GenerateRegNo();
        LogUtils.info("RegNumber Generated");
        String RegistrationNumber = tl.RegNo;
        System.out.println(RegistrationNumber + "----------------");
        RegNo.sendKeys(RegistrationNumber);
        LogUtils.info("RegNumber sent to field");
        Thread.sleep(2000);
        SaleCloseDatePicker.click();
        LogUtils.info("Sale Closer date picker opened");
        Thread.sleep(3000);
        SaleCloseDate.click();
        Thread.sleep(2000);
        String partnerN = "Automation test";
        String partnersaNity = "mr automation";

        String mobileNo = "7980000000";
        String email = "automationtesting@turtlemint.com";
        String policyNob = "prod_car_BI_PO_" +RegistrationNumber;
        TestUtil.getScreenShot();
      //  PartnerName.sendKeys(partnerN);

        PartnerName.sendKeys(partnersaNity);

        LogUtils.info("Name Sent to field");
        Thread.sleep(10000);
        PartnerName.sendKeys(Keys.ARROW_DOWN);
      //  PartnerName.sendKeys(Keys.ARROW_UP);
        PartnerName.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Mobile.sendKeys(mobileNo);
        eMail.sendKeys(email);
        PolicyNumber.sendKeys(policyNob);
        PolicyIssuanceDatePicker.click();
        Thread.sleep(2000);
        PolicyIssuanceDate.click();
        TestUtil.getScreenShot();
        TestUtil.click(StartDatePicker, "");
        Thread.sleep(2000);
        TestUtil.click(Today, "Selected for risk start date");
        Thread.sleep(3000);
        EndDatePicker.click();
        Thread.sleep(5000);
        EndDatePicker.sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        EndDatePicker.sendKeys(TestUtil.ninjaFutureDate(364));
        Thread.sleep(2000);
        EndDatePicker.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        LogUtils.info("End date picker is selected");
        NetPremium.sendKeys("1");
        LogUtils.info("Net premium is set");
        TestUtil.sendKeys(serviceTaxnumber, "2", "service Tax number entered");
        TestUtil.sendKeys(grossPremiumnumber, "3", "gross Premium number entered");
//        TestUtil.click(Assisted, "Click on Assisted");
        Thread.sleep(2000);
//        TestUtil.click(Selfmanaged, "Click on  Selfmanaged");
        TestUtil.getScreenShot();
        //  FileUpload.sendKeys("/Users/tejasbahadure/Downloads/dog.png");
      FileUpload.sendKeys("/home/ubuntu/storage/dog.png");
//   FileUpload.sendKeys("/Users/sayali/Desktop/abcd.pdf");
        LogUtils.info("Policy copy file uploaded to Server Location --> /home/ubuntu/storage/dog.png");
        Thread.sleep(4000);
        TestUtil.getScreenShot();
        PolicyTag.click();
        LogUtils.info("Policy tag selected");
        FileTagDone.click();
        Thread.sleep(2500);
        TestUtil.getScreenShot();
        LogUtils.info("File Tagging done");
        Thread.sleep(2000);
        IssuanceSave.click();
        LogUtils.info("Details saved successfully");
        TestUtil.getFullPageScreenShot();
    }

}