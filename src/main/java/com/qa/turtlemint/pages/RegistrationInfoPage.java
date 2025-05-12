package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationInfoPage extends TestBase {

    public RegistrationInfoPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()=' I do not have a registration number ']")
    WebElement ProceedwithoutRegistration;

    @FindBy(xpath = "//input[@type='search']")
    WebElement Search;
    @FindBy(xpath = "//input[@name='regDate-datepicker']")
    WebElement RegistrationDate;
    @FindBy(xpath = "//input[@id='calendarCheckbox']")
   // @FindBy(xpath = "//label[text()='I don't have registration date, it's a new vehicle']")
    WebElement CheckBox;

    @FindBy(id = "container-next-btn")
    WebElement NextButton;

    @FindBy(xpath = "//span[text()='MH-01-Tardeo']")
    WebElement SelectRegLocation;

//    public void ValidateFieldsRegInfoPage()
//    {
//        Search.isDisplayed();
//       // RegistrationDate.isDisplayed();
//      //  CheckBox.isDisplayed();
//      //  NextButton.isDisplayed();
//    }

    public CarDetailsPage CreateQuoteWithoutRegNumber(String no) throws InterruptedException {
        TestUtil.sendKeys(Search,no,"No RegistrationDate");
        Thread.sleep(2000);
        TestUtil.click(SelectRegLocation,"MH01 Selected");
        Thread.sleep(5000);
        Actions act =  new Actions(driver);
        Thread.sleep(2000);
        act.moveToElement(CheckBox).click().perform();
        TestUtil.click(NextButton,"Next Button");
        Thread.sleep(2000);
        return new CarDetailsPage();
    }

    public CarDetailsPage CreateQuoteWithoutRegNumberProceed(String no) throws InterruptedException {
        TestUtil.click(ProceedwithoutRegistration,"I do not have registration clicked");
        TestUtil.sendKeys(Search,no,"No RegistrationDate");
        TestUtil.click(SelectRegLocation,"MH01 Selected");
        Thread.sleep(5000);
        Actions act =  new Actions(driver);
        Thread.sleep(2000);
        act.moveToElement(CheckBox).click().perform();
        TestUtil.click(NextButton,"Next Button Pressed");
        Thread.sleep(2000);
        return new CarDetailsPage();
    }



}
