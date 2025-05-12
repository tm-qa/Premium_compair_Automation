package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OTPScreenPage extends TestBase {

    @FindBy(xpath = "//input[@class='OTPInput']")
    WebElement OTPField;

    @FindBy(xpath = "//span[text()='Verify OTP']")
    WebElement VerifyOTPBtn;


    public OTPScreenPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateOTPPageTitle()
    {
        return driver.getTitle();
    }

    public GrowPage ValidateLogin(String otp)
    {
        OTPField.sendKeys(otp);
        VerifyOTPBtn.click();

        return new GrowPage();
    }

}
