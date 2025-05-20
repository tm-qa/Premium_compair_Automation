package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "mobileNumber")
    WebElement MobileNumber;
    @FindBy(xpath = "//div[@id='common-login']//div[@class='otpLogin']//div[@id='OTPLogin']//input[@type='tel' and @name='mobileNumber' and @autocomplete='phone']")
    WebElement MobileNumberID;


    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ContinueBtn;

    @FindBy(xpath = "//span[text()='GET OTP']")
    WebElement GetOTP;
    @FindBy(xpath = "(//span[text()=\"Start Earning Now\"])[3]")
    WebElement startearning;


    @FindBy(xpath = "//input[@class='OTPInput']")
    WebElement OTPField;

    @FindBy(xpath = "//span[text()='Verify OTP']")
    WebElement VerifyOTPBtn;
    @FindBy(xpath = "//span[text()=\"Verify OTP\"]")
    WebElement VerifyOTPBtnID;




    public LoginPage() {
        PageFactory.initElements(driver, this);

    }

    public String ValidateLoginPageTitle() {
        return driver.getTitle();
    }

    public GrowPage ValidateLogin(String username, String otp) throws InterruptedException {
        String strUrl = driver.getCurrentUrl();
        LogUtils.info("Opened Website: " + strUrl);
        TestUtil.sendKeys(MobileNumber, username, "Mobile Number Entered");
        TestUtil.click(GetOTP, "Continue pressed");
        TestUtil.sendKeys(OTPField, otp, "OTP Entered");
        TestUtil.click(VerifyOTPBtn, "Login Successful");
        Thread.sleep(8000);
        TestUtil.getScreenShot();

        return new GrowPage();
    }

    public void LoginInsurancedekho(String username, String otp) throws InterruptedException {
        String strUrl = driver.getCurrentUrl();
        LogUtils.info("Opened Website: " + strUrl);
        Thread.sleep(3000);
       // TestUtil.click(MobileNumberID,"");
        TestUtil.sendKeys(MobileNumberID, username, "Mobile Number Entered");
       // MobileNumberID.sendKeys(username + Keys.ENTER);
        TestUtil.click(startearning, "Start earning pressed");
        Thread.sleep(25000);
        TestUtil.click(VerifyOTPBtnID, "Login Successful");
        Thread.sleep(8000);
        TestUtil.getScreenShot();

    }

}
