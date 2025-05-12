package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TW_RegistrationInfoPage extends TestBase {

    public TW_RegistrationInfoPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    WebElement Search;

    @FindBy(xpath = "//input[@name='regDate-datepicker']")
    WebElement RegistrationDate;
    @FindBy(xpath = "//input[@id='calendarCheckbox']")
    // @FindBy(xpath = "//label[text()='I don't have registration date, it's a new vehicle']")
    WebElement CheckBox;

    @FindBy(id = "container-next-btn")
    WebElement NextButton;

    @FindBy(xpath = "//span[text()='MH-01-Mumbai Central- Location- Tardeo']")
    WebElement SelectRegLocation;


    public BikeDetailsPage CreateQuoteWithoutRegNumber(String no) throws InterruptedException {
        Search.sendKeys(no);
        SelectRegLocation.click();
        //Thread.sleep(5000);
        Actions act =  new Actions(driver);
        act.moveToElement(CheckBox).click().perform();
        NextButton.click();
        return new BikeDetailsPage();

    }

}
