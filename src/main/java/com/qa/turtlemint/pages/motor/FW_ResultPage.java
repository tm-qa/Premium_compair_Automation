package com.qa.turtlemint.pages.motor;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.KYC.Kyc;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FW_ResultPage extends TestBase {

    public TestUtil tl;
    Kyc kyc = new Kyc();

    public FW_ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Got It!']")
    WebElement GotItBtn;

    @FindBy(xpath = "//a[@data-auto='NINA-web']")
    WebElement SelectCVPlan;

    @FindBy(xpath = "//img[@src=\"https://assets.insurancehub.turtlefin.io/providers/GENERAL/RELI/RELI.png\"]//parent::div//following-sibling::div//button")
    WebElement SelectCVPlanRel;

    @FindBy(xpath = "//a[@data-auto=\"RELI-web\"]")
    WebElement relTwFW;

    @FindBy(xpath = "//a[@data-auto=\"DIGIT-web\"]")
    WebElement Digit;

    @FindBy(xpath = "//button[@data-auto=\"confirm-btn\"]")
    WebElement ProceedtoBuy;

    @FindBy(xpath = "(//*[@class=\"btn btn-default form-control ui-select-toggle\"])[1]")
    WebElement title;

    @FindBy(xpath = "//*[text()=\"Mr\"]")
    WebElement mr;

    @FindBy(id = "firstName")
    WebElement fn;

    @FindBy(id = "lastName")
    WebElement ln;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "mobile")
    WebElement mbl;

    @FindBy(xpath = "//input[@id='registeredAddressLine1']")
    WebElement address;

    @FindBy(name = "registeredAddressLine2")
    WebElement Adressline2;

    @FindBy(xpath = "//*[text()=\"Continue\"]")
    WebElement continu;

    @FindBy(xpath = "//div[@id='registeredPincode-uiSelect']")
    WebElement pin;

    @FindBy(xpath = "//div[@id='registeredPincode-uiSelect']/input")
    WebElement Pincode;

    @FindBy(xpath = "//span[text()='400065']")
    WebElement SelectPincode;

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    WebElement MahaSelect;

    @FindBy(xpath = "//div[@id='registeredCity-uiSelect']")
    WebElement clickele;

    @FindBy(xpath = "//div[@placeholder=\"Enter State\"]")
    WebElement stateClick;

    @FindBy(xpath = "//div[@placeholder=\"Enter State\"]//parent::div//input")
    WebElement stateentered;

    @FindBy(xpath = "")
    WebElement maharastra;

    @FindBy(xpath = "//div[@id='registeredCity-uiSelect']/input")
    WebElement State;

    @FindBy(xpath = "//span[text()='MUMBAI']")
    WebElement SelectState;


    @FindBy(name = "nomineeName")
    WebElement nomineename;

    @FindBy(name = "nomineeDOB-datepicker")
    WebElement datebtn;

    @FindBy(xpath = "//*[@class=\"ui-datepicker-calendar\"]//tbody//td//a[text()=\"1\"]")
    WebElement Dateofbirth;

    @FindBy(xpath = "(//*[text()=\"NA \"]//parent::span)[1]")
    WebElement relbtn;

    @FindBy(xpath = "//*[text()=\"Son\"]")
    WebElement son;

    @FindBy(xpath = "//*[text()=\"Yes\"]")
    WebElement yes;

    @FindBy(xpath = "//*[@placeholder=\"dd/mm/yyyy\"]")
    WebElement DOBB;

    @FindBy(xpath = "//input[@id='previousPolicyNumber']")
    WebElement prevPolicyNumber;

    @FindBy(xpath = "//span[text()='Select  Insurer']")
    WebElement selectInsurer;

    @FindBy(xpath = "//span[text()='Bajaj Allianz']")
    WebElement prevbajajAllianz;

    @FindBy(xpath = "//span[text()='Online']")
    WebElement onlineclick;

    @FindBy(id = "engineNum")
    WebElement enginno;

    @FindBy(name = "chassisNum")
    WebElement chassisno;

    @FindBy(xpath = "//input[@name=\"odometerReading\"]")
    WebElement odometere;

    @FindBy(xpath = "//*[text()=\"DZIRE DZIRE ZXI , Seating: 5, CC : 1197\"]")
    WebElement varient;

    @FindBy(xpath = "(//*[text()=\"Variant\"])[2]")
    WebElement varbtn;

    @FindBy(xpath = "//input[@id=\"gender-M\"]//parent::label")
    WebElement male;

    @FindBy(id = "dob-datepicker")
    WebElement dobpicker;

    @FindBy(xpath = "//span[text()='Mother']")
    WebElement SelectNomineeRelation;

    @FindBy(xpath = "//div[@id='nomineeRel-uiSelect']")
    WebElement Nominee;

    @FindBy(xpath = "//input[@name='nomineeName']")
    WebElement NomineeName;

    @FindBy(xpath = "//input[@name='nomineeDOB-datepicker']")
    WebElement NomineeDOB;

    @FindBy(xpath = "//a[normalize-space()='12']")
    WebElement DateSelected;

    @FindBy(xpath = "//*[text()=\"Online\"]")
    WebElement online;

    @FindBy(xpath = "//*[text()=\"Make Payment\"]")
    WebElement makepayment;

    @FindBy(xpath = "//*[text()=\"Credit Card/Debit Card\"]")
    WebElement credidordebitcard;

    public void GotItBtn() {
        TestUtil.click(GotItBtn, "Got It Button Clicked");
    }

    public void comprehensiveCheckout(String fname, String lname) throws InterruptedException {
        Thread.sleep(15000);
        //  GotItBtn();
        LogUtils.info("Got It Clicked !");
        SelectCVPlan.click();
        Thread.sleep(3000);
        LogUtils.info("HDFC Selected!");
        ProceedtoBuy.click();
        Thread.sleep(5000);
        title.click();
        mr.click();
        fn.sendKeys(fname);
        ln.sendKeys(lname);
        LogUtils.info("Name Filled!");

        email.sendKeys("test@example.com");
        LogUtils.info("Email Filled!");

        mbl.sendKeys("6999912345");
        LogUtils.info("Mobile Number Filled!");

        address.sendKeys("Saki Vihar Road");
        Adressline2.sendKeys("Saki Naka Metro Station");
        clickele.click();
        State.sendKeys("Mumbai");
        SelectState.click();
        LogUtils.info("Address Filled !");
        pin.click();
        Thread.sleep(2000);
        Pincode.sendKeys("400065");
        SelectPincode.click();
        LogUtils.info("Pin Entered!");
        continu.click();

        relbtn.click();
        Thread.sleep(2000);
        son.click();
        nomineename.sendKeys("test");
        datebtn.click();
        Thread.sleep(2000);
        LogUtils.info("Nominee Details Entered !");
        Dateofbirth.click();
        DOBB.click();
        Dateofbirth.click();
//        yes.click();
        Thread.sleep(2000);
        LogUtils.info("DOB Entered");
        continu.click();


        enginno.sendKeys("230620221135YES");
        chassisno.sendKeys("230620221135YESOK");
        Thread.sleep(2000);
        LogUtils.info("Engine and Chassis number Filled !");
        Thread.sleep(2000);
        continu.click();
        Thread.sleep(2000);
        yes.click();
        Thread.sleep(2000);
        continu.click();
        LogUtils.info("Continue Clicked !");
        Thread.sleep(5000);
        TestUtil.getScreenShot();
    }

    public void comprehensiveCheckoutRel(String fname, String lname) throws InterruptedException {
        // Thread.sleep(15000);
        LogUtils.info("Got It Clicked !");
        TestUtil.click(SelectCVPlanRel, SelectCVPlanRel.getText() + " cliked");
        Thread.sleep(3000);
        TestUtil.click(ProceedtoBuy, ProceedtoBuy.getText() + " cliked");
        Thread.sleep(5000);

        kyc.KycFormFilling();
        Thread.sleep(5000);
        LogUtils.info("KYC Done");
        title.click();
        mr.click();
        TestUtil.click(continu, "continue clicked");
        Thread.sleep(2000);

        TestUtil.sendKeys(NomineeDOB,"12/02/1988","DOB entered");
        //TestUtil.sendKeys(SelectDOB,"12/02/1988","DOB entered");
        TestUtil.click(DateSelected,"Date Selected");
        TestUtil.click(DateSelected,"Date Selected");
        TestUtil.click(Nominee,"Nominee Selected");
        TestUtil.click(SelectNomineeRelation,"Nominee Relation Selected");
        TestUtil.sendKeys(NomineeName,"Test","Nomine Name Entered");
        Thread.sleep(3000);
        TestUtil.click(continu, "continue clicked");

        TestUtil.sendKeys(odometere,"22","odometer");

        enginno.sendKeys("230620221135YES");
        Thread.sleep(2000);
        LogUtils.info("Engine and Chassis number Filled !");
        chassisno.sendKeys("230620221135YESOK");

        Thread.sleep(2000);
        TestUtil.click(continu, "continue clicked");
        Thread.sleep(2000);
        try {
            yes.click();
        }catch (Exception e){

        }
        Thread.sleep(2000);
        prevPolicyNumber.sendKeys("55443214");
        TestUtil.click(selectInsurer, "select Insurer cliked");
        Thread.sleep(1000);
        TestUtil.click(prevbajajAllianz, "prev bajaj Allianz cliked");
        Thread.sleep(2000);
        TestUtil.click(continu, "continue clicked");
        LogUtils.info("Continue Clicked !");
        Thread.sleep(5000);
        TestUtil.click(online, "online clicked");
        Thread.sleep(5000);
        TestUtil.click(makepayment, "make payment clicked");
        TestUtil.getScreenShot();
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void comprehensiveCheckoutRelFW(String fname, String lname) throws InterruptedException {
        Thread.sleep(5000);
        LogUtils.info("Got It Clicked !");
        js.executeScript("arguments[0].click();", relTwFW);
       // TestUtil.click(Digit, Digit.getText()+" Plan Select");
        Thread.sleep(3000);
        TestUtil.click(ProceedtoBuy, "Proceed to Buy");
        Thread.sleep(5000);
        kyc.KycFormFilling();
        Thread.sleep(10000);

        LogUtils.info("KYC Done");

        title.click();
        Thread.sleep(2000);
        mr.click();

        email.sendKeys("test@example.com");
        LogUtils.info("Email Filled!");

        mbl.sendKeys("6999912345");
        LogUtils.info("Mobile Number Filled!");

        Thread.sleep(4000);
        pin.click();
        Thread.sleep(2000);
        pin.click();
        Thread.sleep(2000);
        Pincode.sendKeys("400065");
        Thread.sleep(4000);
        SelectPincode.click();
        LogUtils.info("Pin Entered!");
        Thread.sleep(2000);
        address.sendKeys("Saki Vihar Road");
        Adressline2.sendKeys("Saki Naka Metro Station");
        TestUtil.click(continu, "continue clicked");
        Thread.sleep(2000);
        TestUtil.click(male, "Male clicked");
        TestUtil.sendKeys(dobpicker,"12/02/1994","Dob select");
        Thread.sleep(2000);

        TestUtil.sendKeys(NomineeDOB,"12/02/1988","DOB entered");
        //TestUtil.sendKeys(SelectDOB,"12/02/1988","DOB entered");
        TestUtil.click(DateSelected,"Date Selected");
      //  TestUtil.click(DateSelected,"Date Selected");
        TestUtil.click(Nominee,"Nominee Selected");
        TestUtil.click(SelectNomineeRelation,"Nominee Relation Selected");
        TestUtil.sendKeys(NomineeName,"Test","Nomine Name Entered");
        Thread.sleep(3000);
        TestUtil.click(continu, "continue clicked");
        enginno.sendKeys("230620221135YES");
        Thread.sleep(2000);
        chassisno.sendKeys("230620221135YESOK");
        Thread.sleep(2000);
        LogUtils.info("Engine and Chassis number Filled !");
        TestUtil.click(continu, " continue clicked");
        LogUtils.info("Continue Clicked !");
        Thread.sleep(5000);
        TestUtil.click(online, "Online clicked");
        Thread.sleep(5000);
        makepayment.click();
        Thread.sleep(2000);
        TestUtil.getScreenShot();
    }
}