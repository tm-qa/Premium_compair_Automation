package com.qa.turtlemint.pages.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NinjaBranchIssuanceTWPage extends TestBase {

    TestUtil tl = new TestUtil();

    @FindBy(xpath = "//a[contains(text(),'Policy Issuance')]")
    WebElement IssuanceBtn;

    @FindBy(xpath = "//button[@class='_md-nav-button md-accent md-button md-ink-ripple md-unselected']")
    WebElement ReportASale;

    @FindBy(xpath = "//button[@type='button'][@data-auto='new-branch-button']")
    WebElement Plusbtn;

    @FindBy(xpath = "//md-select[@id='$$vertical']")
    WebElement VerticlDropdown;

    @FindBy(id = "insurer")
    WebElement InsurerDropdown;

    @FindBy(xpath = "//button[normalize-space()='Proceed']")
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

    @FindBy(xpath = "//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")
    WebElement StartDate;

    @FindBy(xpath = "//md-datepicker[@name='policyEndDate']")
    WebElement EndDatePicker;

    @FindBy(xpath = "//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")
    WebElement EndDate;

    @FindBy(xpath = "//input[@id='netPremium']")
    WebElement NetPremium;

    @FindBy(xpath = "//md-datepicker[@name='policyIssuanceDate']/button")
    WebElement PolicyIssuanceDatePicker;

    @FindBy(xpath = "//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")
    WebElement PolicyIssuanceDate;

    @FindBy(id = "policyNumber")
    WebElement PolicyNumber;

    @FindBy(xpath = "//input[@type='file']")
    WebElement FileUpload;

    @FindBy(xpath = "//md-radio-button[@value='POLICY']")
    WebElement PolicyTag;

    @FindBy(xpath = "//button[normalize-space()='Done']")
    WebElement FileTagDone;

    @FindBy(xpath = "//div[@class='ng-scope layout-align-center-center layout-column'][1]")
    WebElement IssuanceSave;

    @FindBy(xpath = "//input[@placeholder=\"Enter policy number\"]")
    WebElement enterpolicyno;

    @FindBy(xpath = "//md-select[@data-auto=\"assistedBy-select\"]")
    WebElement Assisted;

    @FindBy(xpath = "//md-option[@value=\"SELF_MANAGED\"]")
    WebElement Selfmanaged;


    public NinjaBranchIssuanceTWPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void NinjaBranchIssuanceFlow() throws InterruptedException {
        LogUtils.info("Logged In successfully");
        IssuanceBtn.click();
        LogUtils.info("Clicked on Issuance button");
        ReportASale.click();
        LogUtils.info("Clicked on ReportSale button");
        Plusbtn.click();
        Thread.sleep(3000);
        LogUtils.info("Clicked on Branch Issuance button to create entry");
        VerticlDropdown.click();
        Thread.sleep(2000);
        LogUtils.info("Vertical selected");
        vertical_list();
        Thread.sleep(2500);
        InsurerDropdown.click();
        Thread.sleep(500);
        LogUtils.info("Insurer Selected");
        insurer_list();
        LogUtils.info("Showing Insurer list");
        TestUtil.sendKeys(enterpolicyno,TestUtil.generateRandomPolicyNo(7),"");
        TestUtil.getScreenShot();
        CreateSale.click();
        LogUtils.info("Clicked on Create Sale button");
        tl.GenerateRegNo();
        LogUtils.info("RegNumber Generated");
        Thread.sleep(2000);
        System.out.println(tl.RegNo + "----------------");
        RegNo.sendKeys(tl.RegNo);
        LogUtils.info("RegNumber sent to field");
        Thread.sleep(2000);
        SaleCloseDatePicker.click();
        LogUtils.info("Sale Closer date picker opened");
        Thread.sleep(3000);
        SaleCloseDate.click();
        Thread.sleep(2000);
        PartnerName.sendKeys("mr automation test");
        LogUtils.info("Name Sent to field");
        Thread.sleep(2000);
        PartnerName.sendKeys(Keys.ARROW_DOWN);
        PartnerName.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Mobile.sendKeys("7980000000");
        eMail.sendKeys("automationtesting@turtlemint.com");
        PolicyNumber.sendKeys("prod_car_BI_PO_"+tl.RegNo);
        PolicyIssuanceDatePicker.click();
        PolicyIssuanceDate.click();
        StartDatePicker.click();
        LogUtils.info("Start date picker is clicked");
        Thread.sleep(500);
        StartDate.click();
        EndDatePicker.click();
        Thread.sleep(500);
        EndDate.click();
        LogUtils.info("End date picker is selected");
        NetPremium.sendKeys("100");
        LogUtils.info("Net premium is set");
    //    TestUtil.click(Assisted, "Click on Assisted");
        Thread.sleep(2000);
    //    TestUtil.click(Selfmanaged, "Click on  Selfmanaged");
        TestUtil.getScreenShot();
        //FileUpload.sendKeys("/Users/hemant/Downloads/dog.png");
       FileUpload.sendKeys("/home/ubuntu/storage/dog.png");
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
        LogUtils.info("Entry added successfully in system");
        TestUtil.getScreenShot();

    }

    public void vertical_list()
    {
        List<WebElement> vertical_menu=driver.findElements(By.xpath("//md-select-menu[contains(@class,'_md md-overflow')]//md-content//md-option"));
        System.out.println("Vertical Menu = " +vertical_menu.size());


        for(int i=0;i<vertical_menu.size();i++)
        {
            System.out.println(vertical_menu.get(i).getText());
            if(vertical_menu.get(i).getText().contains("TW"))
            {
                vertical_menu.get(i).click();
                break;
            }
        }
    }

    public void insurer_list()
    {
        List<WebElement> insurerlist=driver.findElements(By.xpath("//li[@class='ng-scope']"));

        System.out.println("Insurer List = " +insurerlist.size());

        for(int k=0;k<insurerlist.size();k++)
        {
            if(insurerlist.get(k).getText().contains("HDFC Ergo"))
            {
                insurerlist.get(k).click();
            }
        }
    }

}