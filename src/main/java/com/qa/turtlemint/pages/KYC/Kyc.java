package com.qa.turtlemint.pages.KYC;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Kyc extends TestBase {

    @FindBy(xpath = "//input[@value='true']")
    WebElement IndividualSelect;

    @FindBy(xpath = "//input[@id='kyc-form_dob']")
    WebElement DOBField;

    @FindBy(xpath = "//input[@id='kyc-form_pan']")
    WebElement PanNo;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement ContinueBtn;

    @FindBy(xpath = "//span[text()='Confirm']")
    WebElement KYCconfirm;


    public Kyc()
    {
        PageFactory.initElements(driver, this);
    }


    public void KycFormFilling() throws InterruptedException {
        Thread.sleep(7000);
        LogUtils.info("KYC Start");
        IndividualSelect.click();
        TestUtil.click(DOBField,"DOB Field Clicked");
        DOBField.sendKeys("02/05/2000","DOB Entered");
        TestUtil.sendKeys(PanNo,"BNUPT2084B","Pan Number Entered");
        TestUtil.click(ContinueBtn,"KYC Form Filled Successfully and Continue Button pressed");
        Thread.sleep(30000);
        TestUtil.click(KYCconfirm,"KYC confirm clicked");
        Thread.sleep(5000);
    }

    public void KycForHealth() throws InterruptedException {
        Thread.sleep(10000);
        TestUtil.click(DOBField,"DOB Field Clicked");
        DOBField.sendKeys("02/05/2000","DOB Entered");
        TestUtil.sendKeys(PanNo,"BNUPT2084B","Pan Number Entered");
        TestUtil.click(ContinueBtn,"KYC Form Filled Successfully and Continue Button pressed");
        Thread.sleep(10000);
        TestUtil.click(KYCconfirm,"KYC confirm clicked");
        Thread.sleep(5000);
//        try {
//            OVDdetailsdocumentsnivabupa();
//        }catch (Exception e){
//            System.out.println("ckyc working");
//        }

    }



    @FindBy(xpath = "//h4[text()='Upload Document']//following ::span[text()='Continue'][1]")
    WebElement ContinueBt2;
    @FindBy(xpath = "//h4[text()='Upload Document']")
    WebElement radioBT2;

    @FindBy(xpath = "//mat-form-field[@appearance=\"outline\"]")
    WebElement Selectdropdown;

    @FindBy(xpath = "//span[@class='mat-option-text']")
    List<WebElement> FecthDropdown;



    @FindBy(xpath = "//button[@title=\"Yes\"]")
    WebElement yesBT;

    @FindBy(xpath = "//button[text()=' Submit ']")
    WebElement SubmittedBT;

    @FindBy(xpath = "//label[text()='browse']")
    WebElement BrowserBT;
    @FindBy(xpath = "//span[text()='Proceed to verify']")
    WebElement Proceedtoverify;
    @FindBy(xpath = "//button[@type='button']")
    WebElement confirmBt;

    public static void OvdUploadFile(String YourFileLocationFolder) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys( YourFileLocationFolder);
        Thread.sleep(1000);
    }
    public void OVDdetailsdocumentsnivabupa() throws InterruptedException {
        Thread.sleep(2000);
        TestUtil.click(radioBT2, "Clicked on radio button");
        Thread.sleep(3000);
        TestUtil.click(ContinueBt2, "Clicked on Continue Button");
        Thread.sleep(3000);
        TestUtil.click(Selectdropdown, "selected decoments");
        Thread.sleep(3000);
        for (WebElement dropdownresult : FecthDropdown) {
            if (dropdownresult.getText().equals("Aadhaar")) {
                System.out.println("We are inside loop:" + dropdownresult);
                dropdownresult.click();
                System.out.println("We are in if section");
                break;
            }
        }

        Thread.sleep(3000);
        if (yesBT.isDisplayed() && yesBT.isEnabled()) {
            TestUtil.click(yesBT, "clicked yes Bt");
        }
        Thread.sleep(3000);
       // OvdUploadFile("/home/ubuntu/storage/Aadharfront.jpg");
        OvdUploadFile("/Users/tejasbahadure/Downloads/Aadharfront.jpg");
        Thread.sleep(2000);
        LogUtils.info("Aadhar fornt page uploaded");
       // OvdUploadFile("/home/ubuntu/storage/Aadharback.jpg");
        OvdUploadFile("/Users/tejasbahadure/Downloads/Aadharback.jpg");
        LogUtils.info("Aadhar Back page uploaded");
        Thread.sleep(10000);
        TestUtil.getScreenShot();
        TestUtil.click(SubmittedBT, "clicked submitted");
        Thread.sleep(5000);
        try {
            TestUtil.click(BrowserBT, "clicked browserBT");
        } catch (StaleElementReferenceException e) {
            TestUtil.click(BrowserBT, "clicked browserBT");
        }
      // OvdUploadFile("/home/ubuntu/storage/images.jpg");
        OvdUploadFile("/Users/tejasbahadure/Downloads/dog.jpg");
        LogUtils.info("profile photo uploaded");
        Thread.sleep(3000);
        TestUtil.click(Proceedtoverify, "PROCEEDTO VERIFY");
        Thread.sleep(4000);
        TestUtil.getScreenShot();
        TestUtil.click(confirmBt, "Confirm");
    }


}