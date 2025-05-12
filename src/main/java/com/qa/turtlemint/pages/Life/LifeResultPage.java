package com.qa.turtlemint.pages.Life;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CheckOutPage;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LifeResultPage extends TestBase {

    TestUtil tl = new TestUtil();

    public LifeResultPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//Button[text()='OK, GOT IT!']")
    WebElement OkGotItBtn;

    @FindBy(xpath = "//button[text()='Got it!']")
    WebElement GotItBtn;

    @FindBy(xpath = "//button[@id=\"listItem-P71-viewDetails\"]")
    WebElement ViewDetails;

    @FindBy(id = "listItem-P84-viewDetails")
    WebElement maxLife;


    @FindBy(xpath = "//button[@id='details-page-buy-now-btn']")
    WebElement BuyNow;

//    @FindBy(xpath = "//button[@data-auto=\"viewdetail-TATAAIALI-Sampoorna Raksha Supreme (SRS)\"]")
//    WebElement ViewDetails;
//
    @FindBy(xpath = "//*[@data-icon=\"close\"]")
    WebElement closePopup;

    @FindBy(xpath = "//span[text()='Mr.']")
    WebElement Title;

    @FindBy(xpath = "//input[@id='insuredMemberFName']")
    WebElement firstname;

    @FindBy(xpath = "//input[@id='insuredMemberLName']")
    WebElement lastname;

    @FindBy(xpath = "//input[@id='insuredMemberEmail'] ")
    WebElement email;

    @FindBy(xpath = "//input[@id='insuredMemberMobile']")
    WebElement mobile;

    @FindBy(xpath = "//input[@id=\"insuredMemberRegisteredAddress1\"]")
    WebElement Adress1;

    @FindBy(xpath = "//input[@id=\"insuredMemberRegisteredAddress2\"]")
    WebElement Adress2;

    @FindBy(xpath = "//input[@id=\"insurerSpecificInfo.insuredMemberAnnualIncome_MAX\"]")
    WebElement insuredMemberAnnualIncome_MAX;
//
//    @FindBy(xpath = "//span[text()='Married']")
//    WebElement married;

    @FindBy(xpath = "//div[@id='insuredMemberMaritalStatus-uiSelect']")
    WebElement maritalStatus;

    @FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='Married']")
    WebElement isMarried;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//a[normalize-space()='Preview']")
    WebElement previewBtn;

    @FindBy(xpath = "//span[@class='checkmark']")
    WebElement checkBox;

    @FindBy(xpath = "//button[normalize-space()='Approve']")
    WebElement approve;

    @FindBy(xpath = "//input[@id='otp']")
    WebElement enterOtp;

    @FindBy(xpath = "//span[normalize-space()='Verify']")
    WebElement verifyOtp;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//button[normalize-space()='Proceed to payment']")
    WebElement proceedPayment;

    @FindBy(xpath = "//input[@enterfn=\"userApprovalDisclaimerEnterFn\"]//..//..")
    WebElement checkmark;

    @FindBy(xpath = "//span[text()='Pay Premium']")
    WebElement Paypremium;

    @FindBy(xpath = "//button[@id=\"continue-button-active\"]")
    WebElement submitandproceed;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public CheckOutPage LifeResultPage() throws InterruptedException {
        Thread.sleep(5000);

    //    driver.navigate().refresh();
    //    Thread.sleep(14000);
      TestUtil.click(ViewDetails,"Icici View Details Clicked");
        return new CheckOutPage();
    }


    public void LifeCheckoutPage() throws Exception {
        LogUtils.info("Waiting to click BuyNow..");
        Thread.sleep(2000);
        WebElement scroll = driver.findElement(By.xpath("//span[text()='Total premium ']"));

        js.executeScript("window.scrollBy(0,250)", scroll);
//        tl.takeSnapShot(driver, "/tmp/"+tl.getTimeStamp()+ ".png");
//        LogUtils.info("Took SnapShot...");
//        boolean result = driver.findElement(By.xpath("//button[@id='details-page-buy-now-btn']")).isDisplayed();
//        LogUtils.info("Result: " + result);
//        TestUtil.click(closePopup,"Close Popup");
        TestUtil.click(BuyNow,"Buy Now");
       // BuyNow.click();
        //TestUtil.click(continueBtn,"Continue Button Clicked");
        //TestUtil.click(Title,"Form Filling Started");
        // firstname.sendKeys("Life");
        lastname.sendKeys("test");
        mobile.sendKeys("6888812345");
        email.sendKeys("test@test.com");
        TestUtil.sendKeys(Adress1,"flat no Address 1 i select","Adress 1 entered");
        TestUtil.sendKeys(Adress2,"Address 2 is select","Adress 2 entered");
 //       TestUtil.sendKeys(insuredMemberAnnualIncome_MAX,"500000","500000");
//        TestUtil.click(maritalStatus,"");
//        TestUtil.click(isMarried,"");
//        TestUtil.click(continueBtn,"Form Filling completed and clicked on continue");
        Thread.sleep(3000);
        TestUtil.click(checkmark,"checkmark  Checked");
        Thread.sleep(2000);
        TestUtil.click(submitandproceed,"Submit Button Clicked");
        Thread.sleep(6000);
        TestUtil.click(Paypremium,"pay premium clicked");
        Thread.sleep(5000);
        TestUtil.getScreenShot();

    }
}
