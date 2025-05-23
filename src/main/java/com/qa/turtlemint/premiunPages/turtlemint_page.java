package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class turtlemint_page extends TestBase {

    @FindBy(xpath = "//input[@name=\"mobileNumber\"]")
    WebElement mobileNumber;

    @FindBy(xpath = "//span[text()=\"GET OTP\"]//parent::button")
    WebElement getOtpButton ;


    @FindBy(xpath = "//input[@class=\"OTPInput\"]")
    WebElement getOtp ;

    @FindBy(xpath = "//span[text()=\"Verify OTP\"]")
    WebElement verifyOtp;


    @FindBy(xpath = "//li[@class=\"sellButtonList\"]")
    WebElement sellButton;

    @FindBy(xpath = "//input[@ng-model=\"registrationNumber\"]")
    WebElement registrationNumber;

    @FindBy(xpath = "//button[@ng-disabled=\"!registrationNumber\"]")
    WebElement registrationNumberButton ;

    @FindBy(xpath = "//input[@id=\"policyType-comprehensive\"]//following-sibling::span")
    WebElement policyType;

    @FindBy(xpath = "//label[@for=\"calendarCheckbox\"]")
    WebElement calender ;

    @FindBy(xpath = "//button[text()=\"Save & Continue\"]")
    WebElement saveAndCon ;

        @FindBy(xpath = "//p[text()=\"Car Insurance\"]")
    WebElement carInsurance ;

        @FindBy(xpath = "//div[text()=\"Got It!\"]")
        WebElement gotIt;

    public turtlemint_page() {PageFactory.initElements(driver, this);}

    public void login() throws InterruptedException {
        Thread.sleep(3000);
        TestUtil.sendKeys(mobileNumber , "6999912345","");
        TestUtil.click(getOtpButton , "");
        TestUtil.sendKeys(getOtp , "1234","");
        TestUtil.click(verifyOtp , "");
        TestUtil.click(sellButton , "ed");
        Thread.sleep(3000);
        TestUtil.click(carInsurance , "");
        TestUtil.sendKeys(registrationNumber , "MH43AJ7461", "");
        TestUtil.click(registrationNumberButton ,  "");
        TestUtil.click(policyType , "");
        TestUtil.click(calender , "");
        TestUtil.click(saveAndCon , "");
        Thread.sleep(2000);
        TestUtil.click(gotIt , "");



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class=\"client-logo-img\"]")));

        List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class=\"client-logo-img\"]"));

        List<String> insurerNames = new ArrayList<>();
        List<String> totalPremiums = new ArrayList<>();

        for (WebElement logo : insurerLogos) {
            Thread.sleep(2000);
            String srcValue = logo.getAttribute("src");
            String[] parts = srcValue.split("/");
            String insurerName = parts[parts.length - 1].replace(".png", ""); // Extracting file name without extension
            insurerNames.add(insurerName);
            WebElement premiumElement = logo.findElement(By.xpath("//button[@class=\"premium-breakup-amount cursor-pointer text-center premium-breakup-amount-btn ng-star-inserted\"]"));
            String premium = premiumElement.getText();
            totalPremiums.add(premium);
        }

        System.out.println("Insurer Names and Premiums:");
        for (int i = 0; i < insurerNames.size(); i++) {
            System.out.println("Insurer: " + insurerNames.get(i) + " | Premium: " + totalPremiums.get(i));
        }



    }


//    @FindBy(xpath = "//p[text()=\"Car Insurance\"]")
//    WebElement carInsurance ;
//
//    @FindBy(xpath = "//input[@id='registrationNo']/following::p[contains(text(),'I do not have a registration number')]")
//    WebElement dontHaveRegNo ;
//
//    @FindBy(xpath = "//div[@id=\"rto-uiSelect\"]//input")
//    WebElement enterRto;
//
//    @FindBy(xpath = "//span[text()=\"MH-01-Tardeo\"]")
//    WebElement rto;
//
//    @FindBy(xpath = "//label[@for=\"calendarCheckbox\"]")
//    WebElement registartionDateCheckbox ;
//
//    @FindBy(xpath = "//button[@id=\"container-next-btn\"]")
//    WebElement nextButton;
//
//    @FindBy(xpath = "//div[@data-auto=\"makemodel-uiSelect\"]//input[@type=\"search\"]")
//    WebElement makeModel;
//
//    @FindBy(xpath = "//span[text()=\"2024\"]")
//    WebElement manuafYear ;
//
//    @FindBy(xpath = "//input[@value=\"Petrol\"]//following-sibling::span")
//    WebElement fuelType;
//
//    @FindBy(xpath = "//div[@data-auto=\"variant\"]")
//    WebElement variant;
//
//
//    @FindBy(xpath = "//input[@placeholder=\"Type name or select\"]")
//    WebElement variantEntered;
//
//    @FindBy(xpath = "//input[@id=\"customerName\"]")
//    WebElement customerName;
//
//    @FindBy(xpath = "//span[text()=\"Hyundai I20\"]")
//    WebElement getMakeModel;
//
//    @FindBy(xpath = "//span[text()=\"Asta (1197 CC)\"]")
//    WebElement getVariant;
//
//    @FindBy(xpath = "//input[@id=\"paidUserMobile\"]")
//    WebElement userMobile ;
//
//    @FindBy(xpath = "//input[@id=\"paidUserEmail\"]")
//    WebElement userEmail;
//
//    public turtlemint_page() {PageFactory.initElements(driver, this);}
//
//    public void getPreminum() throws InterruptedException {
//        TestUtil.click(carInsurance , "click on car");
//        Set<String> windowHandles = driver.getWindowHandles();
//        ArrayList<String> tabs = new ArrayList<>(windowHandles);
//        driver.switchTo().window(tabs.get(1));
//        TestUtil.click(dontHaveRegNo , " click sont have registation no");
//        TestUtil.sendKeys(enterRto , "MH-01-Tardeo"," entered rto");
//        TestUtil.click(rto , "select rto");
//        TestUtil.click(registartionDateCheckbox , "click on checkbox");
//        TestUtil.click(nextButton , "click on next button");
//        TestUtil.sendKeys(makeModel , "Hyundai I20","entered make & model");
//        TestUtil.click(getMakeModel , " make model selected");
//        TestUtil.click(manuafYear , "click on mang year");
//        TestUtil.click(fuelType , "select fuel type");
//        Thread.sleep(2000);
//        TestUtil.click(variant , "click on variant");
//        TestUtil.sendKeys(variantEntered , "Asta (1197 CC) ","entered make & model");
//        TestUtil.click(getVariant , "select variant");
//        TestUtil.click(nextButton , "click on next button");
//        TestUtil.sendKeys(customerName , "test lead" , "lead name enterd");
//        TestUtil.sendKeys(userMobile , "6999912345" , "lead name enterd");
//        TestUtil.sendKeys(userEmail , "testtest@test.com" , "lead name enterd");
//        TestUtil.click(nextButton , "click on next button");
//
//    }

}
