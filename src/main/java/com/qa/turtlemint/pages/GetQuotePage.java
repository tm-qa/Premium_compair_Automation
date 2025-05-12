package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetQuotePage extends TestBase {
    public GetQuotePage()
    {
        PageFactory.initElements(driver, this);
    }

   // @FindBy(xpath = "//span[text()='Have the Registration Number?']")
  //  WebElement RegistrationNumberLbl;

    @FindBy(xpath = "//input[@type='text']")
    WebElement RegistrationNumberField;

  //  @FindBy(xpath = "//button[text()=' Get Quote']")
  //  WebElement GetQuoteBtn;

    @FindBy(xpath = "//div[text()='Quote without vehicle number']")
    WebElement WithoutRegNumberLink;


    public RegistrationInfoPage CreateQuoteWithoutRegNumber() throws InterruptedException {
        TestUtil.click(WithoutRegNumberLink,"Without RegNumber Link");
        return new RegistrationInfoPage();
    }



}
