package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


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
    WebElement policyTypecomp;
    @FindBy(xpath = "//input[@id=\"policyType-tp\"]//following-sibling::span")
    WebElement policyTypetp;


    @FindBy(xpath = "//input[@id=\"previousPolicyType-TP\"]//following-sibling::span[text()=\"Third Party\"]")
    WebElement previousPolicyTypeTP;
    @FindBy(xpath = "//input[@id=\"previousPolicyType-COMPREHENSIVE\"]//following-sibling::span[text()=\"Comprehensive\"]")
    WebElement previousPolicyTypeCOMP;


    @FindBy(xpath = "//input[@id=\"prevClaim-false\"]//following-sibling::span")
    WebElement prevClaim;

    @FindBy(xpath = "//span[@aria-label=\"Select box activate\"]")
    WebElement ncb;

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
    @FindBy(xpath = "//input[@name=\"isMaxIdv\"]//..\n")
    WebElement maxidv;

    @FindBy(xpath = "//div[@class=\"logo\"]")
    WebElement logoback;
    @FindBy(xpath = "//a[text()=\"Edit\"]")
    WebElement editButton;

    @FindBy(xpath = "//li[@ng-if=\"motorDetail.make && motorDetail.model\"]//p[@ng-click=\"onCopylink()\"]")
    WebElement makeModel;
    @FindBy(xpath = "//li[@ng-if=\"motorDetail.fuel\"]//p[@ng-click=\"onCopylink()\"]")
    WebElement fuel;
    @FindBy(xpath = "//li[@ng-if=\"motorDetail.variant\"]//p[@ng-click=\"onCopylink()\"]")
    WebElement variant;

    @FindBy(xpath = "//li[@ng-if=\"config.policyType\"]//p[@class=\"ng-binding\"]")
    WebElement getPolicyType;
    @FindBy(xpath = "//li[@ng-if=\"motorDetail.registrationDate\"]//p[@class=\"ng-binding\"]")
    WebElement resgisdate;
    @FindBy(xpath = "//a[text()=\" Update Results\"]")
    WebElement updateresult;

    @FindBy(xpath = "//span[@class=\"bold vehicleIdv ng-binding\"]")
    WebElement premiumIDV;


    @FindBy(xpath = "//span[@ng-click=\"infoCar = !infoCar\"]")
    WebElement closedButton;

    @FindBy(xpath = "//div[@data-auto=\"previousinsurer-uiSelect\"]//span")
    WebElement previousinsureruiSelect;

    @FindBy(xpath = "//span[text()=\"Bajaj Allianz\"]")
    WebElement getPreviousinsureruiSelect;
    @FindBy(xpath = "(//img[@class=\"img-file\"])[2]")
    WebElement random;
    @FindBy(xpath = "//div[@ng-mouseenter=\"hoverIn()\"]")
    WebElement hoverIn;
    @FindBy(xpath = "//div[contains(@class,'maskOnMouseOut')]")
    WebElement hoverOut;


    @FindBy(xpath = "//input[@name=\"isMaxIdv\"]//parent::label[text()=\" Maximum IDV \"]")
    WebElement isMaxId;

    @FindBy(xpath = "//a[text()=\" Update Results\"]")
    WebElement updateedresult ;


    public turtlemint_page() {
        PageFactory.initElements(driver, this);
    }


    public void logintm() {
        TestUtil.sendKeys(mobileNumber, "6999912345", "");
        TestUtil.click(getOtpButton, "");
        TestUtil.sendKeys(getOtp, "1234", "");
        TestUtil.click(verifyOtp, "");
    }


    public void Comppremiumtm() throws InterruptedException {

       String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
//        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);

        List<String[]> premiumData = new ArrayList<>();
        List<String> failedRegs = new ArrayList<>();
        List<String[]> maxIDV = new ArrayList<>();
        Thread.sleep(3000);
        TestUtil.click(sellButton, "ed");
        Thread.sleep(3000);
        TestUtil.click(carInsurance, "");

        for (String reg : regNumbers) {
            try {
                Thread.sleep(3000);
                TestUtil.sendKeys(registrationNumber, reg, "picked 1st");
                Thread.sleep(3000);
                TestUtil.click(registrationNumberButton, "");
                TestUtil.click(policyTypecomp, "");

                String existingValue = calender.getAttribute("value");
                System.out.println(existingValue);

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    System.out.println(futuredate);
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
                    System.out.println(formattedDate);
                    TestUtil.sendKeys(calender, formattedDate, "entered");
                    Thread.sleep(2000);
                    TestUtil.click(random, "");
                }

                Thread.sleep(2000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", previousPolicyTypeCOMP);
                Thread.sleep(2000);
                TestUtil.click(prevClaim, "select prev Claim as No");
                TestUtil.click(ncb, "click on ncb dropdown");
                TestUtil.click(zeroNCB, " NCB : 0% selected");


                try {

                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

                    List<WebElement> insurerElements = driver.findElements(
                            By.xpath("//div[@data-auto='previousinsurer-uiSelect']//span")
                    );

                    if (!insurerElements.isEmpty()) {
                        WebElement previousinsureruiSelect = insurerElements.get(0);

                        shortWait.until(ExpectedConditions.visibilityOf(previousinsureruiSelect));

                        String selectedValue = previousinsureruiSelect.getText().trim();
                        System.out.println("Current selected value: " + selectedValue);

                        if (selectedValue.isEmpty() || selectedValue.equalsIgnoreCase("Select")) {
                            System.out.println("No value is selected, selecting one from dropdown.");

                            TestUtil.click(previousinsureruiSelect, "Clicking to open dropdown");

                            WebElement option = shortWait.until(ExpectedConditions.elementToBeClickable(
                                    By.xpath("//span[text()=\"Bajaj Allianz\"]")
                            ));
                            TestUtil.click(option, "Selecting Bajaj from dropdown");
                        }
                    } else {
                        System.out.println("Previous insurer dropdown is not present on this page.");
                    }

                } catch (TimeoutException e) {
                    System.out.println("Timed out waiting for the previous insurer field or dropdown option.");
                } catch (StaleElementReferenceException e) {
                    System.out.println("The element became stale, retry logic can be added here.");
                } catch (Exception e) {
                    System.out.println("Unexpected error occurred: " + e.getMessage());
                }

                TestUtil.click(saveAndCon, "");
                try {
                    TestUtil.click(gotIt, "");
                } catch (Exception e) {
                    System.out.println("'Got It' button not present, skipping.");
                }

                Thread.sleep(15000);
                js.executeScript("arguments[0].click();", editButton);
                String vehicleMakeModel = makeModel.getText();
                String vehicleFuelType = fuel.getText();
                String vehicleVarient = variant.getText();
                String prePolicy = getPolicyType.getText();
                String resgistrationdate = resgisdate.getText();
                System.out.println(vehicleMakeModel + " ---" + vehicleFuelType + "--- " + vehicleVarient + " ____" + prePolicy);
                TestUtil.click(closedButton, "");
                Thread.sleep(15000);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='logoArea col-xs-6 col-sm-3 text-left']//img[contains(@class, 'client-logo-img')]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"bold vehicleIdv ng-binding\"]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//div[@class='logoArea col-xs-6 col-sm-3 text-left']//img[contains(@class, 'client-logo-img')]"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]"));
                List<WebElement> premiumIdv = driver.findElements(By.xpath("//span[@class=\"bold vehicleIdv ng-binding\"]"));

                System.out.println("Logos found: " + insurerLogos.size());
                System.out.println("Premiums found: " + insurerPremiums.size());
                System.out.println("Premiums IDV: " + premiumIdv.size());

                if (insurerLogos.size() == insurerPremiums.size() && insurerLogos.size() == premiumIdv.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement idvElement = premiumIdv.get(i);

                        String srcValue = logo.getAttribute("src");
                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");

                        String premium = premiumBtn.getText().replace(",", "").replace("₹", "").trim();
                        String premiumidv = idvElement.getText().replace(",", "").replace("₹", "").trim();

                        String[] row = {
                                reg,
                                vehicleMakeModel,
                                vehicleFuelType,
                                vehicleVarient,
                                prePolicy,
                                resgistrationdate,
                                insurerName,
                                premiumidv,
                                premium,


                        };
                        premiumData.add(row);
                    }
                }

              ///////////////


                else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }
                Actions actions = new Actions(driver);
                actions.moveToElement(hoverIn).perform();
                TestUtil.click(isMaxId , "click on max id");
                actions.moveByOffset(50 , 0).perform();
                actions.moveToElement(hoverOut).perform();
                TestUtil.click(updateedresult , "ejd");

                Thread.sleep(15000);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='logoArea col-xs-6 col-sm-3 text-left']//img[contains(@class, 'client-logo-img')]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"bold vehicleIdv ng-binding\"]")));

                List<WebElement> insurerLogos1 = driver.findElements(By.xpath("//div[@class='logoArea col-xs-6 col-sm-3 text-left']//img[contains(@class, 'client-logo-img')]"));
                List<WebElement> insurerPremiums1 = driver.findElements(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]"));
                List<WebElement> premiumIdv1 = driver.findElements(By.xpath("//span[@class=\"bold vehicleIdv ng-binding\"]"));

                System.out.println("Logos found: " + insurerLogos1.size());
                System.out.println("Premiums found: " + insurerPremiums1.size());
                System.out.println("Premiums IDV: " + premiumIdv1.size());

                if (insurerLogos1.size() == insurerPremiums1.size() && insurerLogos1.size() == premiumIdv1.size()) {
                    for (int i = 0; i < insurerLogos1.size(); i++) {
                        WebElement logo = insurerLogos1.get(i);
                        WebElement premiumBtn = insurerPremiums1.get(i);
                        WebElement idvElement = premiumIdv1.get(i);

                        String srcValue = logo.getAttribute("src");
                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");

                        String premium1 = premiumBtn.getText().replace(",", "").replace("₹", "").trim();
                        String premiumidv1 = idvElement.getText().replace(",", "").replace("₹", "").trim();

                        String[] row1 = {

                                insurerName,
                                premiumidv1,
                                premium1,

                        };
                        maxIDV.add(row1);
                    }
                }



                /////

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

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        // ✅ Save successful data
       String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
//        String outputExcel = "/Users/nitinrathod/Desktop/Turtlemint_premium" + dateTime + ".xlsx";

        TestUtil.writeCombinedSheet(outputExcel, premiumData , maxIDV);
        // Optional: Print or save failed registrations
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
        }
    }

//----------------------------------------------------





   //-------------------------------TP----------------------------------------------


    public void Tppremiumtm() throws InterruptedException {

        String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
//        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);

        List<String[]> premiumData = new ArrayList<>();
        List<String> failedRegs = new ArrayList<>();
        Thread.sleep(3000);
        TestUtil.click(sellButton, "Clicked on sell button");
        Thread.sleep(3000);
        TestUtil.click(carInsurance, "Clicked on car insurance");

        for (String reg : regNumbers) {
            try {
                Thread.sleep(3000);
                TestUtil.sendKeys(registrationNumber, reg, "Started loop from first registration number");
                Thread.sleep(3000);
                TestUtil.click(registrationNumberButton, "Clicked on get quotes");
                TestUtil.click(policyTypetp, "Selected policy type as TP");

                String existingValue = calender.getAttribute("value");
                System.out.println(existingValue);

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    System.out.println(futuredate);
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
                    System.out.println(formattedDate);
                    TestUtil.sendKeys(calender, formattedDate, "Date entered");
                    Thread.sleep(2000);
                    TestUtil.click(random, "");
                }

                Thread.sleep(2000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", previousPolicyTypeTP);
                Thread.sleep(2000);
//                TestUtil.click(prevClaim, "select prev Claim as No");
//                TestUtil.click(ncb, "click on ncb dropdown");
//                TestUtil.click(zeroNCB, " NCB : 0% selected");

                try {

                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

                    List<WebElement> insurerElements = driver.findElements(
                            By.xpath("//div[@data-auto='previousinsurer-uiSelect']//span")
                    );

                    if (!insurerElements.isEmpty()) {
                        WebElement previousinsureruiSelect = insurerElements.get(0);

                        shortWait.until(ExpectedConditions.visibilityOf(previousinsureruiSelect));

                        String selectedValue = previousinsureruiSelect.getText().trim();
                        System.out.println("Current selected value: " + selectedValue);

                        if (selectedValue.isEmpty() || selectedValue.equalsIgnoreCase("Select")) {
                            System.out.println("No value is selected, selecting one from dropdown.");

                            TestUtil.click(previousinsureruiSelect, "Clicking to open dropdown");

                            WebElement option = shortWait.until(ExpectedConditions.elementToBeClickable(
                                    By.xpath("//span[text()=\"Bajaj Allianz\"]")
                            ));
                            TestUtil.click(option, "Selecting Bajaj from dropdown");
                        }
                    } else {
                        System.out.println("Previous insurer dropdown is not present on this page.");
                    }

                } catch (TimeoutException e) {
                    System.out.println("Timed out waiting for the previous insurer field or dropdown option.");
                } catch (StaleElementReferenceException e) {
                    System.out.println("The element became stale, retry logic can be added here.");
                } catch (Exception e) {
                    System.out.println("Unexpected error occurred: " + e.getMessage());
                }

                TestUtil.click(saveAndCon, "");
                try {
                    TestUtil.click(gotIt, "");
                } catch (Exception e) {
                    System.out.println("'Got It' button not present, skipping.");
                }
                Thread.sleep(20000);
                js.executeScript("arguments[0].click();", editButton);
                String vehicleMakeModel = makeModel.getText();
                String vehicleFuelType = fuel.getText();
                String vehicleVarient = variant.getText();
                String prePolicy = getPolicyType.getText();
                System.out.println(vehicleMakeModel + " ---" + vehicleFuelType + "--- " + vehicleVarient + " ____" + prePolicy);
                TestUtil.click(closedButton, "");
                Thread.sleep(15000);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='logoArea col-xs-6 col-sm-3 text-left']//img[contains(@class, 'client-logo-img')]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//div[@class='logoArea col-xs-6 col-sm-3 text-left']//img[contains(@class, 'client-logo-img')]"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//div[@class=\"priceArea hidden-xs text-center\"]//span[contains(@ng-if , \"multiPlanDropDown[insurer.insurerProvider\")]"));

                System.out.println("Logos found: " + insurerLogos.size());
                System.out.println("Premiums found: " + insurerPremiums.size());

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

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        // ✅ Save successful data
          String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
//        String outputExcel = "/Users/nitinrathod/Desktop/Turtlemint_premium" + dateTime + ".xlsx";

        TestUtil.writePremiumDataTm(outputExcel, premiumData);
        // Optional: Print or save failed registrations
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
        }
    }



}

