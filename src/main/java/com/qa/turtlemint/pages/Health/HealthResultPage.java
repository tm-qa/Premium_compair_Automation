package com.qa.turtlemint.pages.Health;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CheckOutPage;
import com.qa.turtlemint.pages.KYC.Kyc;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HealthResultPage extends TestBase {

    public TestUtil tl;

    public HealthResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Got It!']")
    WebElement GotItBtn;

    @FindBy(xpath = "//button[@id='CTA_MXBPRA']")
    WebElement StarHealthPlan;

    @FindBy(xpath = "//span[text()='Buy Now']")
    WebElement ClickBuyNow;

    @FindBy(xpath = "//input[@placeholder=\"Enter mobile number\"]")
    WebElement MobileNo;

    @FindBy(xpath = "//input[@placeholder=\"Enter Email Id\"]")
    WebElement Mailid;

    @FindBy(xpath = "//input[@id='insuredMembers.0.mobile']")
    WebElement Selfmobile;

    @FindBy(xpath = "//button[@id=\"continue-button-active\"]")
    WebElement ConBtn;

    @FindBy(id="insuredMembers.0.dob")
    WebElement dobinsurer;

    @FindBy(xpath = "//td[@title=\"2003-04-29\"]")
    WebElement d29select;

    @FindBy(xpath = "//input[@id=\"insuredMembers.0.height_feet\"]")
    WebElement HeightInFeet;

    @FindBy(xpath = "//input[@id='insuredMembers.0.height_inches']")
    WebElement HeightInInch;

    @FindBy(xpath = "//input[@id=\"insuredMembers.0.weight\"]")
    WebElement Weight;

    @FindBy(xpath = "//span[text()='Online']")
    WebElement SelPayOpt;

    @FindBy(xpath = "//input[@id='alternateMobile']")
    WebElement scroll;

    @FindBy(xpath = "//input[@id=\"insuredMembers.0.education\"]")
    WebElement education1;

    @FindBy(xpath = "//input[@id=\"insuredMembers.0.occupation\"]")
    WebElement occupationdropdown;

    @FindBy(xpath = "//input[@id=\"addrLine1\"]")
    WebElement NivaAddrLine1;

    @FindBy(xpath = "//input[@id=\"addrLine2\"]")
    WebElement NivaAddrLine2;

    @FindBy(xpath = "//article[text()='Copy Link']//parent::div")
    WebElement copylink;

    @FindBy(xpath = "//article[text()=\"Copy Link\"]")
    WebElement copyURLLink;

    @FindBy(xpath = "//input[@class=\"ant-checkbox-input\"]")
    WebElement checkmark;

    @FindBy(xpath = "//span[text()=\"Approve\"]/parent::button")
    WebElement Approve;


    @FindBy(xpath = "//input[@placeholder=\"1234\"]")
    WebElement otp;

    @FindBy(xpath = "//span[text()=\"Verify\"]/parent::button")
    WebElement verifyotp;

    @FindBy(xpath = "//button[@aria-label=\"Close\"and @class=\"ant-modal-close\"]")
    WebElement closecrossbutton;


    @FindBy(xpath = "//input[@id=\"proposer.nomineeRelation\"]")
    WebElement nomineeisMy;

    @FindBy(xpath = "//input[@id=\"proposer.nomineeName\"]")
    WebElement nomineenamedetail;

    @FindBy(xpath = "//input[@id=\"proposer.nomineeDob\"]")
    WebElement dobdetails;

    @FindBy(xpath = "//input[@placeholder=\"Address\"]")
    WebElement nomineAdress;

    @FindBy(xpath = "//input[@id=\"proposer.nomineeAddressCheck\"]")
    WebElement checkmarkniva;

    @FindBy(xpath = "")
    WebElement hdfcPlan;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.maskedAccountNo\"]")
    WebElement MaskedAccountNumberInputField;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.accountNo\"]")
    WebElement AccountNumberInputField;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.accountType_saving\"]")
    WebElement AccountTypeSavings;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.ifscNo\"]")
    WebElement IFSCNumberInputNo;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.bankName\"]")
    WebElement BankName;

    @FindBy(xpath = "//input[@id=\"attachment+proposerBankDetails.proposerBankDetailsDocument\"]")
    WebElement BankDocumentUpload;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.accountHolderName\"]")
    WebElement HDFCAccHolderName;

    @FindBy(xpath = "//input[@id=\"proposerBankDetails.bankName\"]")
    WebElement HDFCEnterBankName;

    @FindBy(xpath = "//span[text()=\"Saving\"]")
    WebElement SavingSelection;

    @FindBy(xpath = "//div[@title=\"Bank Of Maharashtra\"]")
    WebElement SelectFinalBankOfMaharashtra;

    @FindBy(xpath = "//button[@id=\"continue-button-active\"]")
    WebElement Continue;


    Kyc kyc = new Kyc();


    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions act = new Actions(driver);

    public void scroll() {
        js.executeScript("arguments[0].scrollIntoView();", scroll);
    }


    public void VewDetaisandBuynow(String planename) throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h5[text()='" + planename + "']//parent::div//parent::div/parent::div//span[text()='View Details']")).click();
        Thread.sleep(9000);
        LogUtils.info("Clicked View details Button");

    }

    public void SelectPlanWithoutGotIt(String insurer) throws InterruptedException, IOException {

        //   TestUtil.click(GotItBtn,"GotIt Btn");
        Thread.sleep(9000);
        TestUtil.getScreenShot();
        VewDetaisandBuynow(insurer);
        //TestUtil.click(StarHealthPlan,"Star Plan Selected");

        TestUtil.click(ClickBuyNow, "Click Buy Now");

    }

    public CheckOutPage SelectPlan() throws InterruptedException {

        Thread.sleep(2000);
        try {
            GotItBtn.click();
        } catch (Exception e) {
            System.out.println("Error:********************* " + e.getMessage());
        }
        Thread.sleep(12000);
        TestUtil.getScreenShot();
        TestUtil.click(StarHealthPlan, "Star Plan Selected");
        LogUtils.info("View Details of Plan Clicked");
        Thread.sleep(5000);
        ClickBuyNow.click();
        LogUtils.info("Clicked on Buy Now");
        return new CheckOutPage();
    }

    public void checkmarks() throws InterruptedException {
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size = AllCheckboxes.size();
        for (int i = 0; i < size; i++) {
            Thread.sleep(3000);
            AllCheckboxes.get(i).click();
        }
        Thread.sleep(3000);
        TestUtil.click(SelPayOpt, "Waiting for payment link....");
        Thread.sleep(3000);
        TestUtil.click(ConBtn, "Final continue clicked");
        Thread.sleep(8000);
        TestUtil.getScreenShot();
    }

    public void share_payment_link() throws InterruptedException {
        Thread.sleep(18000);
        TestUtil.click(copylink, "Copy link clicked");
        //  Thread.sleep(3000);
        String copiedText = copyURLLink.getAttribute("data-test-value");
        System.out.println("copied link is " + copiedText);
        //  driver.switchTo().newWindow(SafariDriver.WindowType.TAB);
        TestUtil.click(closecrossbutton, "close share window button");

        driver.get(copiedText);
        Thread.sleep(3000);

    }

    public void do_payment(String Approved_OR_reject) throws InterruptedException {
        Thread.sleep(10000);
        act.moveToElement(checkmark).click().build().perform();
        if (Approved_OR_reject == "A") {
            Thread.sleep(8000);
            act.moveToElement(Approve).click().build().perform();
            LogUtils.info("Approve clicked");
            Thread.sleep(15000);
            TestUtil.sendKeys(otp, "1234", "OTP entered");
            TestUtil.click(verifyotp, "verify OTP");
            Thread.sleep(8000);
            TestUtil.getScreenShot();
            //  icicpayment();

        } else {

        }
    }

    public void CompleteCheckOutDetails(String name) throws InterruptedException {
        kyc.KycForHealth();
        LogUtils.info("KYC Done");
        TestUtil.sendKeys(MobileNo, "6999912345", "Filling Form, Phone Number Entered");
        TestUtil.sendKeys(Mailid, "test@example.com", "Email Entered");

        TestUtil.sendKeys(NivaAddrLine1, "AddrLine1", "Addr1 Entered");
        TestUtil.sendKeys(NivaAddrLine2, "AddrLine1", "Addr2 Entered");
        TestUtil.click(ConBtn, "Email Entered and Continue Button Clicked");

        TestUtil.click(dobinsurer,"");
        Thread.sleep(2000);
        TestUtil.click(d29select,"");
        Thread.sleep(2000);
        TestUtil.sendKeys(HeightInFeet, "5", "");
        TestUtil.sendKeys(HeightInInch, "5", "");
        TestUtil.sendKeys(Weight, "55", "Weight Provided as 55 Kgs");

//        TestUtil.sendKeys(education1, "Graduate" + Keys.ENTER, "Graduate entered");
//        Thread.sleep(3000);
        TestUtil.sendKeys(occupationdropdown, "Salaried" + Keys.ENTER, "Selected occupation");

//        TestUtil.sendKeys(Selfmobile, "6999912345", "Mobile No entered");

        TestUtil.sendKeys(nomineeisMy, "br" + Keys.ENTER, "relationship entered");
        TestUtil.sendKeys(nomineenamedetail, "auto test test", "nomiee name entered");
        TestUtil.waitUntilVisibilityOfElement(dobdetails);
        TestUtil.sendKeys(dobdetails, "12/02/2005" + Keys.ENTER, "DOB entered");
        js.executeScript("arguments[0].click();", checkmarkniva);
        LogUtils.info("clicked checkmar...");
        ConBtn.click();

        Thread.sleep(3000);
      //  HDFCBankDetailsSlide();
        Thread.sleep(3000);
        ConBtn.click();

        Thread.sleep(14000);
//        ConBtn.click();
//        Thread.sleep(3000);
 //       checkmarks();

        TestUtil.click(SelPayOpt, "Waiting for payment link....");
        Thread.sleep(3000);
        TestUtil.click(ConBtn, "Final continue clicked");
        share_payment_link();
        do_payment("A");
        Thread.sleep(2000);
        TestUtil.getScreenShot();
    }
    public void HDFCBankDetailsSlide () throws InterruptedException {
        TestUtil.sendKeys(HDFCAccHolderName,"Auto Test","Entering Account Holder Name");
        Thread.sleep(2000);
        TestUtil.sendKeys(MaskedAccountNumberInputField,"1234567890123","Entering account Number(Masked)");
        Thread.sleep(2000);
        TestUtil.sendKeys(AccountNumberInputField,"1234567890123","Entering account number");
        //TestUtil.click(AccountTypeSavings,"Selecting account type as Savings");
        Thread.sleep(2000);
        TestUtil.click(SavingSelection,"Selecting accout type as Savings");
        Thread.sleep(2000);
        TestUtil.sendKeys(IFSCNumberInputNo,"MAHB0000001","Entering IFSC Number");
        Thread.sleep(2000);
        TestUtil.click(HDFCEnterBankName,"Clicked on Bank Name Field");
        Thread.sleep(3000);
        TestUtil.sendKeys(HDFCEnterBankName,"Bank Of Maharashtra","Entering Bank name");
        Thread.sleep(3000);
        TestUtil.click(SelectFinalBankOfMaharashtra,"Selected bank of maharashtra");
        Thread.sleep(3000);
        TestUtil.click(Continue, "continue clicked");
        Thread.sleep(2000);
    }
}