package com.qa.turtlemint.pages.motor;


import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CheckOutPage;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TPPolicyPage extends TestBase {

    public TestUtil tl;

    public TPPolicyPage() {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//div[text()='Got It!']")
    WebElement GotItBtn;

    @FindBy(xpath = "//a[@id='CHOL'][@data-auto = 'CHOL-web']")
    WebElement SelectTWPlan;

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

    @FindBy(xpath = "//label[@data-auto='gender-m-radio']//span[@class='outer']")
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


    @FindBy(xpath = "//span[text() = 'No']")
    WebElement PAOption;

    @FindBy(xpath = "//span[text() = 'I do not have a valid driving license.']")
    WebElement PAReason;


    @FindBy(xpath = "//input[@name='engineNum']")
    WebElement EngineNum;

    @FindBy(xpath = "//input[@name='chassisNum']")
    WebElement ChNum;

    @FindBy(xpath = "//label[normalize-space()='Policy expired more than 90 days ago']")
    WebElement Pyp;

    @FindBy(xpath = "//input[@id='tpPolicyNumber']")
    WebElement TpPolicyNo;

    @FindBy(xpath = "//span[text()='Online']")
    WebElement SelPayOpt;

    @FindBy(xpath = "//button[text()='Make Payment']")
    WebElement MakePay;

    @FindBy(xpath = "//div[text()='Nominee Details']")
    WebElement clickOutSide;

    @FindBy(xpath = "//span[text()='Nominee Date of Birth']")
    WebElement dob;

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void scroll() {js.executeScript("arguments[0].scrollIntoView();",scroll );}

    public CheckOutPage SelectTWPlan() throws InterruptedException {
        GotItBtn.click();
        Thread.sleep(5000);
        SelectTWPlan.click();
        LogUtils.info("Insurer selected on Results Page");
        Thread.sleep(4000);
        return new CheckOutPage();
    }

    public void thirdPartyCheckout(String fname, String lname) throws InterruptedException {
        ClickOntitle.click();
        SelectTitle.click();
        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        email.sendKeys("test@example.com");
        mobile.sendKeys("9098007752");
        driver.findElement(By.xpath("//div[@id='page']/div")).click();
        scroll();
        ClickState.click();
        State.sendKeys("Maharashtra");
        SelectState.click();
        clickele.click();
        City.sendKeys("Mumbai");
        SelectCity.click();
        pin.click();
        Pincode.sendKeys("400065");
        SelectPincode.click();
        addressLine1.sendKeys("Saki Vihar Road");
        addressLine2.sendKeys("Saki Naka Metro Station");
        ConBtn.click();
        LogUtils.info("Contact Details Entered");
        Actions act =  new Actions(driver);
        Thread.sleep(10000);
        SelectGender.click();
        // act.moveToElement(SelectGender).click().perform();
        SelectDOB.sendKeys("12/02/1988");
        Actions act3 =  new Actions(driver);
        act3.moveToElement(clickOutSide).click().perform();
        Actions act4 =  new Actions(driver);
        act4.moveToElement(Nominee).click().perform();
        SelectNomineeRelation.click();
        NomineeName.sendKeys("Mother Test");
        NomineeDOB.sendKeys("12/02/1958");
        dob.click();
        driver.findElement(By.xpath("//div[@id='page']/div")).click();
        PAOption.click();
        PAReason.click();
        Thread.sleep(3000);
        ConBtn.click();
        LogUtils.info("Personal Details Entered");
        EngineNum.sendKeys("230620221135YES");
        ChNum.sendKeys("230620221135YESOK");
        ConBtn.click();
        LogUtils.info("Car Details Entered");
        Thread.sleep(2000);
        Pyp.click();
        ConBtn.click();
        LogUtils.info("Previous Year Policy Details Entered");
        Thread.sleep(2000);
        SelPayOpt.click();
        MakePay.click();
        LogUtils.info("ThirdParty Checkout Done");
    }
}

