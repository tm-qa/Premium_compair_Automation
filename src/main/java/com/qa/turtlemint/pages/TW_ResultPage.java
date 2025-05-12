package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.KYC.Kyc;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.turtlemint.util.TestUtil.waitUntilTextToPresent;

public class TW_ResultPage extends TestBase {
    Kyc kyc = new Kyc();
    public TestUtil tl;

    public TW_ResultPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Got It!']")
    WebElement GotItBtn;

    @FindBy(xpath = "//b[text()='Checkout']")
    WebElement CheckoutPageVisible;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement CheckboxforPA;

    @FindBy(xpath = "//a[@data-auto = 'ICICILOMBARD-web']")
    WebElement SelectTWPlan;

    @FindBy(xpath = "//a[@data-auto = 'RELI-mweb']")
    WebElement Reliance;

    @FindBy(xpath="//button[@data-auto='confirm-btn']")
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

    @FindBy(xpath = "//div[@id='registeredState-uiSelect']")
    WebElement ClickState;

    @FindBy(xpath = "//div[@id='registeredState-uiSelect']/input")
    WebElement State;

    @FindBy(xpath = "//span[text()='Maharashtra']")
    WebElement SelectState;

    @FindBy(xpath = "//div[@id='registeredCity-uiSelect']")
    WebElement clickele;

    @FindBy(xpath = "//div[@id='registeredCity-uiSelect']/input")
    WebElement City;

    @FindBy(xpath = "//span[text()='MUMBAI']")
    WebElement SelectCity;

    @FindBy(xpath = "//div[@id='registeredPincode-uiSelect']")
    WebElement pin;

    @FindBy(xpath = "//div[@id='registeredPincode-uiSelect']/input")
    WebElement Pincode;

    @FindBy(xpath = "//span[text()='400065']")
    WebElement SelectPincode;

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

    @FindBy(xpath = "//div[@id='nomineeRel-uiSelect']")
    WebElement Nominee;

    @FindBy(xpath = "//span[text()='Mother']")
    WebElement SelectNomineeRelation;

    @FindBy(xpath = "//input[@name='nomineeName']")
    WebElement NomineeName;

    @FindBy(xpath = "//input[@name='nomineeDOB-datepicker']")
    WebElement NomineeDOB;


    @FindBy(xpath = "//a[text()='5']")
    WebElement five;

    @FindBy(xpath = "//span[text() = 'I do not have a valid driving license.']")
    WebElement PAReason;


    @FindBy(xpath = "//input[@name='engineNum']")
    WebElement EngineNum;

    @FindBy(xpath = "//input[@name='chassisNum']")
    WebElement ChNum;

    @FindBy(xpath = "//span[text()='Online']")
    WebElement SelPayOpt;

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

    public CheckOutPage SelectTWPlan() throws InterruptedException {
        try {
            GotItBtn.click();
            TestUtil.click(GotItBtn,"GotIt Btn");
        }
        catch (Exception E){
            System.out.println("GotIt button not displayed");

        }
            Thread.sleep(7000);
//        TestUtil.click(SelectTWPlan,"Select "+SelectTWPlan.getText() +" Plan");
//        TestUtil.click(ProceedtoBuy,"Proceed to Buy");
//            Thread.sleep(3000);
//            LogUtils.info("Plan Selected!");
//            Thread.sleep(3000);
            return new CheckOutPage();
    }

//    public void onlyTitleSelect(){
//        ClickOntitle.click();
//        SelectTitle.click();
//    }

    public void ContinueButton() throws InterruptedException {
        TestUtil.waitElementToBeClickable(ConBtn);
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ConBtn);
        LogUtils.info("Clicked on continue button");
        Thread.sleep(1000);
        TestUtil.getScreenShot();
    }

    public void CompleteTWCheckOutDetails(String fname, String lname) throws InterruptedException {
        TestUtil.click(SelectTWPlan,"Select "+SelectTWPlan.getText() +" Plan");
        TestUtil.click(ProceedtoBuy,"Proceed to Buy");
        Thread.sleep(3000);
        kyc.KycFormFilling();
        Thread.sleep(8000);
        LogUtils.info("KYC Done");
        ClickOntitle.click();
        SelectTitle.click();
        ConBtn.click();
        LogUtils.info("Address Filled and continue button clicked");
        Actions act4 =  new Actions(driver);
        act4.moveToElement(Nominee).click().perform();

        LogUtils.info("DOB Selected!");
        //Nominee.click();
        SelectNomineeRelation.click();
        NomineeName.sendKeys("Mother Test");
        NomineeDOB.sendKeys("12/02/1958");
        dob.click();
        LogUtils.info("Nominee Details Filled!");
        driver.findElement(By.xpath("//div[@id='page']/div")).click();
//        PAOption.click();
//        PAReason.click();

        Thread.sleep(2000);
//        LogUtils.info("PA Reason No selected. No driver's license!");
        ConBtn.click();
        EngineNum.sendKeys("230620221135YES");
        ChNum.sendKeys("230620221135YESOK");
        LogUtils.info("Engine and Chassis number filled!");
        ConBtn.click();
        SelPayOpt.click();
        LogUtils.info("Payment Option Selected!");
        MakePay.click();
        Thread.sleep(5000);
        LogUtils.info("Make Payment Clicked and Flow Complete!");
        TestUtil.getScreenShot();
    }

    public void CompleteTWCheckOutICIC() throws InterruptedException {
        TestUtil.click(SelectTWPlan,"Select "+SelectTWPlan.getText() +" Plan");
        TestUtil.click(ProceedtoBuy,"Proceed to Buy");
        Thread.sleep(3000);
        kyc.KycFormFilling();
        Thread.sleep(8000);
        LogUtils.info("KYC Done");
        TestUtil.click(ClickOntitle,"Click On title");
        TestUtil.click(SelectTitle,"Select Title");
//        TestUtil.sendKeys(email,"test@example.com","Email Filled!");
//        TestUtil.sendKeys(mobile,"6999912345","6999912345 Filled!");
        ContinueButton();
        TestUtil.waitUntilVisibilityOfElement(NomineeName);
        TestUtil.moveToElement(clickOutSide);
        TestUtil.moveToElement(Nominee);
        LogUtils.info("DOB Selected!");
        Thread.sleep(1000);
        TestUtil.waitElementToBeClickable(SelectNomineeRelation);
        TestUtil.click(SelectNomineeRelation,"Clicked on Nominee Relation...");
        Thread.sleep(1000);
        TestUtil.waitUntilVisibilityOfElement(NomineeName);
        TestUtil.sendKeys(NomineeName,"Mother Test","Nominee name is Entered...");
        TestUtil.waitUntilVisibilityOfElement(NomineeDOB);
        TestUtil.sendKeys(NomineeDOB,"12/02/1958","Nominee DOB is Entered...");
        TestUtil.waitElementToBeClickable(dob);
        TestUtil.click(dob,"DOB is selected...");
        LogUtils.info("Nominee Details Filled!");
        driver.findElement(By.xpath("//div[@id='page']/div")).click();
        ContinueButton();
        TestUtil.waitUntilVisibilityOfElement(EngineNum);
        TestUtil.sendKeys(EngineNum,"230620221135YES","Engine Number is Entered...");
        TestUtil.waitUntilVisibilityOfElement(ChNum);
        TestUtil.sendKeys(ChNum,"230620221135YESOK","Chassis number filled!");
        ContinueButton();
        TestUtil.waitUntilVisibilityOfElement(SelPayOpt);
        TestUtil.waitElementToBeClickable(SelPayOpt);
        TestUtil.click(SelPayOpt,"Clicked on Online Payment Option");
        TestUtil.getScreenShot();
        TestUtil.waitUntilVisibilityOfElement(MakePay);
        TestUtil.click(MakePay, "Make Payment Clicked and Flow Complete!");
        Thread.sleep(2000);
        TestUtil.getScreenShot();
    }
    public void CompleteTWCheckOutReliance() throws InterruptedException {
        TestUtil.click(Reliance,"Select "+Reliance.getText() +" Plan");
        TestUtil.click(ProceedtoBuy,"Proceed to Buy");
        Thread.sleep(3000);
        kyc.KycFormFilling();
        Thread.sleep(8000);
        LogUtils.info("KYC Done");
        TestUtil.click(ClickOntitle,"Click On title");
        TestUtil.click(SelectTitle,"Select Title");
        TestUtil.sendKeys(email,"test@example.com","Email Filled!");
        TestUtil.sendKeys(mobile,"6888812345","6888812345 Filled!");
        TestUtil.click(pin,"");
        Thread.sleep(3000);
        TestUtil.sendKeys(Pincode,"400065","");
        Thread.sleep(3000);
        TestUtil.click(SelectPincode,"");

        TestUtil.click(addressLine1,"addressLine1");
        TestUtil.click(addressLine2,"addressLine2");
        ContinueButton();
        Thread.sleep(2000);
        TestUtil.click(SelectGender,"");
        Thread.sleep(2000);
        TestUtil.click(SelectDOB,"");
        Thread.sleep(2000);
        TestUtil.click(five,"");
        Thread.sleep(2000);
        TestUtil.moveToElement(Nominee);
        TestUtil.click(SelectNomineeRelation,"Clicked on Nominee Relation...");
        Thread.sleep(1000);
        TestUtil.waitUntilVisibilityOfElement(NomineeName);
        TestUtil.sendKeys(NomineeName,"Mother Test","Nominee name is Entered...");
        TestUtil.waitUntilVisibilityOfElement(NomineeDOB);
        TestUtil.sendKeys(NomineeDOB,"12/02/1958","Nominee DOB is Entered...");
        TestUtil.waitElementToBeClickable(dob);
        TestUtil.click(dob,"DOB is selected...");

        ContinueButton();
        TestUtil.waitUntilVisibilityOfElement(EngineNum);
        TestUtil.sendKeys(EngineNum,"230620221135YES","Engine Number is Entered...");
        TestUtil.waitUntilVisibilityOfElement(ChNum);
        TestUtil.sendKeys(ChNum,"230620221135YESOK","Chassis number filled!");
        ContinueButton();
        TestUtil.waitUntilVisibilityOfElement(SelPayOpt);
        TestUtil.waitElementToBeClickable(SelPayOpt);
        TestUtil.click(SelPayOpt,"Clicked on Online Payment Option");
        TestUtil.getScreenShot();
        TestUtil.waitUntilVisibilityOfElement(MakePay);
        TestUtil.click(MakePay, "Make Payment Clicked and Flow Complete!");
        Thread.sleep(2000);
        TestUtil.getScreenShot();
    }
}
