package com.qa.turtlemint.pages.Life;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LifeGetQuotePage extends TestBase {

    TestUtil tl = new TestUtil();

    public LifeGetQuotePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Life']")
    WebElement TermLifeButton;

    @FindBy(xpath = "//div[text()='Term Life']")
    WebElement TermLifeSecondButton;

    @FindBy(xpath = "//p[text()='Quotes & BI']")
    WebElement QuotesAndBI;

    @FindBy(xpath = "//p[text()='Term Insurance']")
    WebElement termLifeButton;

    @FindBy(xpath = "//label[@id='Radio-M']")
    WebElement GenderButton;

    @FindBy(xpath = "//input[@placeholder=\"Enter Date\"]")
    WebElement calender;

    @FindBy(xpath = "//option[@value=\"2000\"]//parent::select")
    WebElement yearselect;

    @FindBy(xpath = "//option[@value=\"2\"]//parent::select")
    WebElement monthselect;



//    @FindBy(xpath = "//select[@class=\"sc-iQKALj gwKrYD\"]")
//    WebElement yearselect;
//
//    @FindBy(xpath = "(//select[@class=\"sc-iQKALj gwKrYD\"])[2]")
//    WebElement monthselect;

    @FindBy(xpath = "//div[@aria-label=\"Choose Wednesday, August 5th, 1992\"]")
    WebElement dateselect_5Aug;

    @FindBy(xpath = "//input[@placeholder='Enter Date']")
    WebElement DatePicker;

    @FindBy(xpath = "//div[@aria-label='Choose Tuesday, February 1st, 2005']")
    WebElement SelectDate;

    @FindBy(xpath = "//label[@id='Radio-false']")
    WebElement SmokeChewTobacco;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement Next;

    @FindBy(xpath = "//input[@name='customerName']")
    WebElement LeadName;

    @FindBy(xpath = "//input[@placeholder='Pincode']")
    WebElement Pincode;

    @FindBy(xpath = "//span[text()='Select Occupation']")
    WebElement SelectOccupation;

    @FindBy(xpath = "//li[text()='Salaried']")
    WebElement Selfemployed;

    @FindBy(xpath = "//span[text()='Select Educational Qualification']")
    WebElement SelectEducationalQualification;

    @FindBy(xpath = "//li[text()='Graduate and above']")
    WebElement Graduateandabove;

    @FindBy(xpath = "//div[@name=\"coverAmount\"]")
    WebElement coveramt;

    @FindBy(xpath = "//li[@value=\"15000000\"]")
    WebElement coveramtselect;


    public void datepicker(String year, String Month, WebElement Date) throws InterruptedException {
        TestUtil.click(calender, "caleder select");
        Select yearSelect = new Select(yearselect);
        yearSelect.selectByValue(year);
        Thread.sleep(1000);
        Select monthSelect = new Select(monthselect);
        monthSelect.selectByVisibleText(Month);
        Thread.sleep(1000);
        TestUtil.click(Date, "5 aug date select");
        Thread.sleep(1000);
    }

    public void LifeRedirection() throws Exception {
        Thread.sleep(8000);
        TestUtil.click(TermLifeButton, "Term Life Button");
        Thread.sleep(3000);
        TestUtil.click(termLifeButton, "Term LifeButton");
        // TermLifeSecondButton.click();
        Thread.sleep(5000);
        TestUtil.click(GenderButton, "Selected gender");
        datepicker("1992", "Aug", dateselect_5Aug);
        TestUtil.click(SmokeChewTobacco, "Smoke Chew Tobacco");
        Thread.sleep(2000);
        TestUtil.sendKeys(Pincode,"400001","Pincode Entered");
        Thread.sleep(2000);
        TestUtil.click(Next, "Next clicked");
        TestUtil.click(SelectOccupation, "SelectOccupation");
        TestUtil.click(Selfemployed, "Salaried");
        TestUtil.click(SelectEducationalQualification, "SelectEducationalQualification");
        TestUtil.click(Graduateandabove, "Graduateandabove");
        TestUtil.click(coveramt,"coveramt clicked");
        TestUtil.click(coveramtselect,"1.5 cr coveramt clicked");


        TestUtil.click(Next, "Next clicked");
        //SmokeChewTobacco.click();
//        Next.click();
//        Next.click();
        LogUtils.info("Selected the Sum Required for Life Term Insurance and Clicked Next Button");
        Thread.sleep(4000);
        TestUtil.sendKeys(LeadName,"Life Test","Lead Name entered");
       // LeadName.sendKeys("Life Test");
        Thread.sleep(4000);
      //  TestUtil.click(Next, "Entered Name and Next clicked");
         Next.click();
         LogUtils.info("next buton clicked");
        //LogUtils.info("Entered Name and Clicked Next");
    }
}
