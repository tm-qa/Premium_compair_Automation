package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "mobileNumber")
    WebElement MobileNumber;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ContinueBtn;

    @FindBy(xpath = "//span[text()='GET OTP']")
    WebElement GetOTP;

    @FindBy(xpath = "//input[@class='OTPInput']")
    WebElement OTPField;

    @FindBy(xpath = "//span[text()='Verify OTP']")
    WebElement VerifyOTPBtn;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateLoginPageTitle()
    {
        return driver.getTitle();
    }

    public GrowPage ValidateLogin(String username, String otp) throws InterruptedException {
        String strUrl = driver.getCurrentUrl();
        LogUtils.info("Opened Website: " + strUrl);
        TestUtil.sendKeys(MobileNumber,username,"Mobile Number Entered");
        TestUtil.click(GetOTP,"Continue pressed");
        TestUtil.sendKeys(OTPField,otp,"OTP Entered");
        TestUtil.click(VerifyOTPBtn,"Login Successful");
        Thread.sleep(8000);
        TestUtil.getScreenShot();

        return new GrowPage();
    }

}
