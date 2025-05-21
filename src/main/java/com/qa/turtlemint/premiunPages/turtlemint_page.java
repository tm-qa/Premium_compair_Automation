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
    WebElement getOtpButton;


    @FindBy(xpath = "//input[@class=\"OTPInput\"]")
    WebElement getOtp;

    @FindBy(xpath = "//span[text()=\"Verify OTP\"]")
    WebElement verifyOtp;


    @FindBy(xpath = "//li[@class=\"sellButtonList\"]")
    WebElement sellButton;

    @FindBy(xpath = "//input[@ng-model=\"registrationNumber\"]")
    WebElement registrationNumber;

    @FindBy(xpath = "//button[@ng-disabled=\"!registrationNumber\"]")
    WebElement registrationNumberButton;

    @FindBy(xpath = "//input[@id=\"policyType-comprehensive\"]//following-sibling::span")
    WebElement policyType;

    @FindBy(xpath = "//input[@id=\"previousPolicyType-COMPREHENSIVE\"]//following-sibling::span[text()=\"Comprehensive\"]")
    WebElement previousPolicyType;

    @FindBy(xpath = "//input[@id=\"prevClaim-false\"]//following-sibling::span")
    WebElement prevClaim ;

    @FindBy(xpath = "//span[@aria-label=\"Select box activate\"]")
    WebElement ncb ;

    @FindBy(xpath = "//span[text()=\"0%\"]")
    WebElement zeroNCB;

    @FindBy(xpath = "//input[@id=\"expiryDate-datepicker\"]")
    WebElement calender;

    @FindBy(xpath = "//button[text()=\"Save & Continue\"]")
    WebElement saveAndCon;

    @FindBy(xpath = "//p[text()=\"Car Insurance\"]")
    WebElement carInsurance;

    @FindBy(xpath = "//div[text()=\"Got It!\"]")
    WebElement gotIt;
    @FindBy(xpath = "//div[@class=\"logo\"]")
    WebElement logoback;
    @FindBy(xpath = "//a[text()=\"Edit\"]")
    WebElement editButton;

    @FindBy(xpath = "//li[@ng-if=\"motorDetail.make && motorDetail.model\"]//p[@ng-click=\"onCopylink()\"]")
    WebElement makeModel ;
    @FindBy(xpath = "//li[@ng-if=\"motorDetail.fuel\"]//p[@ng-click=\"onCopylink()\"]")
    WebElement fuel;
    @FindBy(xpath = "//li[@ng-if=\"motorDetail.variant\"]//p[@ng-click=\"onCopylink()\"]")
    WebElement variant;

    @FindBy(xpath = "//li[@ng-if=\"config.policyType\"]//p[@class=\"ng-binding\"]")
    WebElement getPolicyType;
    public turtlemint_page() {
        PageFactory.initElements(driver, this);
    }

    public void login() throws InterruptedException {

      //  String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        String excelPath = "/Users/nitinrathod/Downloads/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);

        List<String[]> premiumData = new ArrayList<>();
        List<String> failedRegs = new ArrayList<>();

        Thread.sleep(3000);
        TestUtil.sendKeys(mobileNumber, "6999912345", "");
        TestUtil.click(getOtpButton, "");
        TestUtil.sendKeys(getOtp, "1234", "");
        TestUtil.click(verifyOtp, "");
        TestUtil.click(sellButton, "ed");
        Thread.sleep(3000);
        TestUtil.click(carInsurance, "");

        for (String reg : regNumbers) {
            try {
                TestUtil.sendKeys(registrationNumber, reg, "picked 1st");
                TestUtil.click(registrationNumberButton, "");
                TestUtil.click(policyType, "");

                String existingValue = calender.getAttribute("value");
                System.out.println(existingValue);

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    System.out.println(futuredate);
                    TestUtil.sendKeys(calender, futuredate, "entered");
                    Thread.sleep(2000);
                }
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id=\"previousPolicyType-COMPREHENSIVE\"]//following-sibling::span[text()=\"Comprehensive\"]")));


                TestUtil.click(previousPolicyType , "select previous Policy Type as Comprehensive");
                TestUtil.click(prevClaim , "select prev Claim as No");
                TestUtil.click(ncb , "click on ncb dropdown");
                TestUtil.click(zeroNCB , " NCB : 0% selected");

                TestUtil.click(saveAndCon, "");
                Thread.sleep(2000);
                TestUtil.click(gotIt, "");

                Thread.sleep(6000);
                TestUtil.click(editButton , "click on edit button");
                String vehicleMakeModel = makeModel.getText();
                String vehicleFuelType = fuel.getText();
                String vehicleVarient = variant.getText();
                String prePolicy = getPolicyType.getText();




                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class=\"client-logo-img\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class=\"client-logo-img\"]"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]"));

                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);

                        String srcValue = logo.getAttribute("src");
                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");
                        String premium = premiumBtn.getText();

                        String[] row = {
                                reg,
                                vehicleMakeModel,
                                vehicleFuelType,
                                vehicleVarient,
                                prePolicy,
                                insurerName,
                                premium
                        };
                        premiumData.add(row);
                    }
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }

            // Move to next
            TestUtil.click(logoback, "");
            Thread.sleep(4000);
            TestUtil.click(sellButton, "");
            Thread.sleep(2000);
            TestUtil.click(carInsurance, "");
            System.out.println("jwh");
        }

        // ✅ Write success data to Excel
    //    String outputExcel = "/Users/sayali/Desktop/TM_premium_output.xlsx";
        String outputExcel = "/Users/nitinrathod/Desktop/premium_output.xlsx";
        TestUtil.writePremiumDataTm(outputExcel, premiumData);
        // Optional: Print or save failed registrations
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
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

