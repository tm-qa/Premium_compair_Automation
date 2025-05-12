package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.KYC.Kyc;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends TestBase {

    public TestUtil tl;
    Kyc kyc = new Kyc();

    public ResultPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Got It!']")
    WebElement GotItBtn;

    @FindBy(xpath = "//a[@data-auto= 'ICICILOMBARD-web']")
    WebElement SelectPlan;

    @FindBy(xpath="//button[text()='Proceed To Buy']")
    WebElement ProceedtoBuy;

    @FindBy(xpath = "//div[@id='title-uiSelect']")
    WebElement ClickOntitle;

    @FindBy(xpath = "//span[text()='Mr']")
    WebElement SelectTitle;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastname;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='mobile']")
    WebElement mobile;

    @FindBy(xpath = "//div[@id='registeredCity-uiSelect']")
    WebElement clickele;

    @FindBy(xpath = "//div[@id='registeredCity-uiSelect']/input")
    WebElement State;

    @FindBy(xpath = "//span[text()='MUMBAI']")
    WebElement SelectState;

    @FindBy(xpath = "//div[@id='registeredPincode-uiSelect']")
    WebElement pin;

    @FindBy(xpath = "//div[@id='registeredPincode-uiSelect']/input")
    WebElement Pincode;

    @FindBy(xpath = "//span[text()='400065']")
    WebElement SelectPincode;

    @FindBy(xpath = "//*[text()=\"Enter State\"]//parent::span")
    WebElement StateSelector;

    @FindBy(xpath = "//*[@class=\"tm-fields-select-container ng-scope showDesktopForMobile registeredState-field\"]//div//input")
    WebElement StateEntery;

    @FindBy(xpath ="//span[@class='ng-binding ng-scope']")
    WebElement MahaSelect;

    @FindBy(xpath = "//input[@id='alternateMobile']")
    WebElement scroll;

    @FindBy(xpath = "//input[@name='registeredAddressLine1']")
    WebElement addressLine1;

    @FindBy(xpath = "//input[@name='registeredAddressLine2']")
    WebElement addressLine2;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement ConBtn;


    @FindBy(xpath = "//span[text()='Male']")
    WebElement SelectGender;

    @FindBy(xpath = "//input[@name='dob-datepicker']")
    WebElement SelectDOB;

    @FindBy(xpath = "//a[normalize-space()='12']")
    WebElement DateSelected;

    @FindBy(xpath = "//span[text() = 'No']")
    WebElement PAOption;

    @FindBy(xpath = "//span[text() = 'I do not have a valid driving license.']")
    WebElement PAReason;

//    @FindBy(xpath = "//label[@data-auto='paownerdriver-true-radio']")
//    WebElement RadioBtn;

    @FindBy(xpath = "//div[@id='nomineeRel-uiSelect']")
    WebElement Nominee;

    @FindBy(xpath = "//span[text()='Mother']")
    WebElement SelectNomineeRelation;

    @FindBy(xpath = "//input[@name='nomineeName']")
    WebElement NomineeName;

    @FindBy(xpath = "//input[@name='nomineeDOB-datepicker']")
    WebElement NomineeDOB;

    @FindBy(xpath = "//span[text() = 'No']")
    WebElement PAOptiosn;

    @FindBy(xpath = "//span[text() = 'I do not have a valid driving license.']")
    WebElement PAReasson;


    @FindBy(xpath = "//input[@name='engineNum']")
    WebElement EngineNum;

    @FindBy(xpath = "//input[@name='chassisNum']")
    WebElement ChNum;

    @FindBy(xpath = "//span[text()='Net Banking']")
    WebElement SelPayOpt;

    @FindBy(xpath = "//*[text()=\"Online\"]")
    WebElement online;



    @FindBy(xpath = "//button[text()='Make Payment']")
    WebElement MakePay;

    @FindBy(xpath = "//div[text()='Nominee Details']")
    WebElement clickOutSide;

    @FindBy(xpath = "//span[text()='Nominee Date of Birth']")
    WebElement dob;


    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void scroll()
    {
        js.executeScript("arguments[0].scrollIntoView();",scroll );
    }

//    public CheckOutPage SelectPlan() throws Exception {
//      //  tl.takeSnapShot(driver, "/tmp/MOTORSCREENSHOT"+tl.getTimeStamp());
//        TestUtil.click(GotItBtn,"Got It Button Clicked");
//        TestUtil.click(SelectPlan,"Selected Plan");
//        return new CheckOutPage();
//    }

    public void GotItBtn(){
        TestUtil.click(GotItBtn,"Got It Button Clicked");
    }

    public void CompleteCheckOutDetails(String fname, String lname) throws InterruptedException {
        Thread.sleep(8000);
        TestUtil.click(SelectPlan,"Clicked on Buy Button");
        Thread.sleep(3000);
        TestUtil.click(ProceedtoBuy,"Clicked on Proceed to Buy");
        Thread.sleep(4000);
        kyc.KycFormFilling();
        Thread.sleep(8000);
        LogUtils.info("KYC Done");
        TestUtil.click(ClickOntitle,"Clicked on Title Mr.");
        TestUtil.click(SelectTitle,"Selected Title Successfully");
        Thread.sleep(3000);
        TestUtil.click(ConBtn,"Continue Button Clicked after entering all fields");
        Thread.sleep(3000);
        TestUtil.sendKeys(NomineeDOB,"12/02/1988","DOB entered");
        //TestUtil.sendKeys(SelectDOB,"12/02/1988","DOB entered");
        TestUtil.click(DateSelected,"Date Selected");
        TestUtil.click(DateSelected,"Date Selected");
        TestUtil.click(Nominee,"Nominee Selected");
        TestUtil.click(SelectNomineeRelation,"Nominee Relation Selected");
        TestUtil.sendKeys(NomineeName,"Test","Nomine Name Entered");
        Thread.sleep(3000);
        ConBtn.click();
        TestUtil.sendKeys(EngineNum,"230620221135YES","Engine Number Entered");
        TestUtil.sendKeys(ChNum,"230620221135YESOK","Chassis Number Entered");
        //TestUtil.click(ConBtn,"Clicked ContinueBtn third time");
        Thread.sleep(5000);
        ConBtn.click();
       // TestUtil.click(ConBtn,"Clicked ContinueBtn fourth time");
        Thread.sleep(10000);
        online.click();
        LogUtils.info("Selected Online Payment Method");
        Thread.sleep(10000);
        MakePay.click();
        Thread.sleep(10000);
        LogUtils.info("Make Payment Click and Flow Completed");
        TestUtil.getScreenShot();
    }
}