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
    @FindBy(xpath = "//input[@id=\"previousPolicyType-COMPREHENSIVE\"]//following-sibling::span[text()=\"Comprehensive\"]//..//input")
    WebElement comptxt;

    @FindBy(xpath = "//input[@id=\"previousPolicyType-SAOD\"]//following-sibling::span[text()=\"Standalone Own Damage\"]")
    WebElement saod;
    @FindBy(xpath = "//input[@id=\"previousPolicyType-SAOD\"]//following-sibling::span[text()=\"Standalone Own Damage\"]//..//input")
    WebElement saodtext;


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
    WebElement updateedresult;
    @FindBy(xpath = "//div[@class=\"flex layout-align-space-between ng-scope\"]")
    WebElement gettext;
    @FindBy(xpath = "//span[text()=\"Check Activity Points\"]")
    WebElement actpointtext;
    @FindBy(xpath = "//button[@class=\"close ng-click-active\"]")
    WebElement actclose;
    @FindBy(xpath = "//div[@class=\"addonlink\"]")
    WebElement addonmore;
    @FindBy(xpath = "//span[@class=\"set-title\"]")
    WebElement addons;

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

        // String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
        // String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);

        List<String[]> premiumData = new ArrayList<>();
        List<String[]> ActivityP = new ArrayList<>();
        List<String[]> ActivityP2 = new ArrayList<>();
        List<String> failedRegs = new ArrayList<>();
        List<String[]> maxIDV = new ArrayList<>();
        List<String[]> addOnsData = new ArrayList<>();

        TestUtil.waitUntilVisibilityOfElement(sellButton);
        TestUtil.click(sellButton, "sell");
        TestUtil.waitUntilVisibilityOfElement(carInsurance);
        TestUtil.click(carInsurance, "car");
        int count = 0;
        for (String reg : regNumbers) {
            try {
                TestUtil.waitUntilVisibilityOfElement(registrationNumber);
                TestUtil.sendKeys(registrationNumber, reg, "");
                TestUtil.waitUntilVisibilityOfElement(registrationNumberButton);
                TestUtil.click(registrationNumberButton, "");
                TestUtil.click(policyTypecomp, "");

                String existingValue = calender.getAttribute("value");
                System.out.println(existingValue);

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    String futuredate = TestUtil.ninjaFutureDate(1);
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

                String prepolicytype = "";

                if (TestUtil.isVisible(previousPolicyTypeCOMP)) {
                    TestUtil.click(previousPolicyTypeCOMP, "Selected 1 year TP policy type");
                    prepolicytype = comptxt.getAttribute("value");
                } else if (TestUtil.isVisible(saod)) {
                    js.executeScript("arguments[0].click();", saod);
                    System.out.println("Selected SAOD policy type");
                    prepolicytype = saodtext.getAttribute("value");
                } else {
                    System.out.println("❌ No TP policy option found.");
                }

                System.out.println("Selected Policy Type: " + prepolicytype);

                Thread.sleep(3000);
                TestUtil.click(prevClaim, "select prev Claim as No");
                Thread.sleep(3000);
                TestUtil.click(ncb, "click on ncb dropdown");
                Thread.sleep(3000);
                TestUtil.click(zeroNCB, " NCB : 0% selected");


                try {

                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    List<WebElement> insurerElements = driver.findElements(By.xpath("//div[@data-auto='previousinsurer-uiSelect']//span"));

                    if (!insurerElements.isEmpty()) {
                        WebElement previousinsureruiSelect = insurerElements.get(0);
                        shortWait.until(ExpectedConditions.visibilityOf(previousinsureruiSelect));
                        String selectedValue = previousinsureruiSelect.getText().trim();
                        System.out.println("Current selected value: " + selectedValue);

                        if (selectedValue.isEmpty() || selectedValue.equalsIgnoreCase("Select")) {
                            System.out.println("No value is selected, selecting one from dropdown.");
                            TestUtil.click(previousinsureruiSelect, "Clicking to open dropdown");
                            WebElement option = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Bajaj Allianz\"]")));
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
                Thread.sleep(5000);
                TestUtil.click(saveAndCon, "");
                Thread.sleep(3000);
                if (count == 0 && gotIt.isDisplayed()) {
                    TestUtil.click(gotIt, "");
                }
                Thread.sleep(25000);
                js.executeScript("arguments[0].click();", editButton);
                String vehicleMakeModel = makeModel.getText();
                String vehicleFuelType = fuel.getText();
                String vehicleVarient = variant.getText();
                String resgistrationdate = resgisdate.getText();
                Thread.sleep(2000);
                System.out.println(vehicleMakeModel + " ---" + vehicleFuelType + "--- " + vehicleVarient + " ____" + prepolicytype);
                TestUtil.click(closedButton, "");

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

                        String[] row = {reg, vehicleMakeModel, vehicleFuelType, vehicleVarient, prepolicytype, resgistrationdate, insurerName, premiumidv, premium};
                        premiumData.add(row);
                    }
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }

                TestUtil.click(actpointtext, "");
                Thread.sleep(5000);
                List<WebElement> Activitypt = driver.findElements(By.xpath("//div[@class=\"flex layout-align-space-between ng-scope\"]"));
                for (int i = 0; i < Activitypt.size(); i++) {
                    WebElement actp = Activitypt.get(i);
                    String ACTp = actp.getText();
                    System.out.println("Activity Text for reg: " + reg + " index: " + i + " -> '" + ACTp + "'");
                    String[] numbers = ACTp.split("\\r?\\n");

                    if (numbers.length == 2) {
                        String MinIDVactInsurer = numbers[0].trim();
                        String MinIDVactPoints = numbers[1].trim();

                        String[] row = {reg, MinIDVactInsurer, MinIDVactPoints};
                        ActivityP.add(row);
                    } else {
                        System.err.println("Unexpected format in activity points for reg: " + reg + " index: " + i);
                    }

                }

                TestUtil.click(actclose, "");
                Thread.sleep(2000);

                String currentUrl = driver.getCurrentUrl();
                String[] parts1 = currentUrl.split("/");
                String id = parts1[parts1.length - 1];  // Get the last part after the last "/"
                System.out.println("Extracted ID: " + id);

                Actions actions = new Actions(driver);
                actions.moveToElement(hoverIn).perform();
                   TestUtil.click(addonmore,"");
                List<WebElement> addOns = driver.findElements(By.xpath("(//div[@class=\"sidePanelCommonHeaderContent clearfix\"])[2]//a//span[@class=\"set-title\"]"));

                if (addOns.size() > 0) {
                    for (WebElement addOn : addOns) {
                        String addOnName = addOn.getText().trim();
                        addOnsData.add(new String[] { reg, addOnName,id });
                        System.out.println(addOnName);
                    }

                    System.out.println("addons data added in sheet");

                } else {

                    addOnsData.add(new String[] { reg, "No Add-Ons Found" });
                }

                actions.moveToElement(hoverIn).perform();
                actions.moveToElement(isMaxId).perform();
                TestUtil.click(isMaxId, "click on max id");
                actions.moveByOffset(50, 0).perform();
                actions.moveToElement(hoverOut).perform();
                TestUtil.click(updateedresult, "ejd");
                Thread.sleep(25000);

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
                        String[] parts2 = srcValue.split("/");
                        String insurerName = parts2[parts2.length - 1].replace(".png", "");

                        String premium1 = premiumBtn.getText().replace(",", "").replace("₹", "").trim();
                        String premiumidv1 = idvElement.getText().replace(",", "").replace("₹", "").trim();

                        String[] row1 = {reg, vehicleMakeModel, vehicleFuelType, vehicleVarient, prepolicytype, resgistrationdate, insurerName, premiumidv1, premium1,

                        };
                        maxIDV.add(row1);
                    }
                }
                Thread.sleep(5000);
                TestUtil.click(actpointtext, "");
                Thread.sleep(5000);
                List<WebElement> Activitypt1 = driver.findElements(By.xpath("//div[@class=\"flex layout-align-space-between ng-scope\"]"));
                for (int i = 0; i < Activitypt1.size(); i++) {
                    WebElement actp1 = Activitypt1.get(i);
                    String ACTp1 = actp1.getText();
                    System.out.println("Activity Text for reg: " + reg + " index: " + i + " -> '" + ACTp1 + "'");
                    String[] numbers = ACTp1.split("\\r?\\n");

                    if (numbers.length == 2) {
                        String MaxIDVactInsurer = numbers[0].trim();
                        String MaxIDVactPoints = numbers[1].trim();

                        String[] row = {reg, MaxIDVactInsurer, MaxIDVactPoints};
                        ActivityP2.add(row);
                    } else {
                        System.err.println("Unexpected format in activity points for reg: " + reg + " index: " + i);
                    }

                }
                TestUtil.click(actclose, "");
                Thread.sleep(2000);

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }

            count++;
            driver.get("https://pro.turtlemint.com/car-insurance/create");
        }


        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));

        // ✅ Save successful data
        // String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
        String outputExcel = "/Users/nitinrathod/Desktop/Turtlemint_COMP_premium" + dateTime + ".xlsx";
       //  String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\Turtlemint_COMP_premium" + dateTime + ".xlsx";


        TestUtil.writeCombinedSheetTM_Comp(outputExcel, premiumData, maxIDV, ActivityP, ActivityP2,addOnsData);
        // Optional: Print or save failed registrations
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
        }
    }


    //-------------------------------TP----------------------------------------------


    public void Tppremiumtm() throws InterruptedException {

        // String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
       String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
       //   String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);
        List<String[]> addOnsData = new ArrayList<>();
        List<String[]> ActivityP = new ArrayList<>();
        List<String[]> premiumData = new ArrayList<>();
        List<String> failedRegs = new ArrayList<>();
        TestUtil.waitUntilVisibilityOfElement(sellButton);
        TestUtil.click(sellButton, "Clicked on sell button");
        TestUtil.waitUntilVisibilityOfElement(carInsurance);
        TestUtil.click(carInsurance, "Clicked on car insurance");
        int count = 0;
        for (String reg : regNumbers) {
            try {
                TestUtil.waitUntilVisibilityOfElement(registrationNumber);
                TestUtil.sendKeys(registrationNumber, reg, "Started loop from first registration number");
                TestUtil.waitUntilVisibilityOfElement(registrationNumberButton);
                TestUtil.click(registrationNumberButton, "Clicked on get quotes");
                TestUtil.click(policyTypetp, "Selected policy type as TP");

                String existingValue = calender.getAttribute("value");
                System.out.println(existingValue);

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    String futuredate = TestUtil.ninjaFutureDate(1);
                    System.out.println(futuredate);
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
                    System.out.println(formattedDate);
                    TestUtil.sendKeys(calender, formattedDate, "Date entered");
                    Thread.sleep(2000);
                    TestUtil.click(random, "");
                }

                Thread.sleep(3000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", previousPolicyTypeTP);
                Thread.sleep(2000);

                try {

                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    List<WebElement> insurerElements = driver.findElements(By.xpath("//div[@data-auto='previousinsurer-uiSelect']//span"));

                    if (!insurerElements.isEmpty()) {
                        WebElement previousinsureruiSelect = insurerElements.get(0);

                        shortWait.until(ExpectedConditions.visibilityOf(previousinsureruiSelect));

                        String selectedValue = previousinsureruiSelect.getText().trim();
                        System.out.println("Current selected value: " + selectedValue);

                        if (selectedValue.isEmpty() || selectedValue.equalsIgnoreCase("Select")) {
                            System.out.println("No value is selected, selecting one from dropdown.");

                            TestUtil.click(previousinsureruiSelect, "Clicking to open dropdown");

                            WebElement option = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Bajaj Allianz\"]")));
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
                Thread.sleep(5000);
                TestUtil.click(saveAndCon, "");
                Thread.sleep(3000);
                if (count == 0 && gotIt.isDisplayed()) {
                    TestUtil.click(gotIt, "");
                }
                Thread.sleep(25000);
                js.executeScript("arguments[0].click();", editButton);
                String vehicleMakeModel = makeModel.getText();
                String vehicleFuelType = fuel.getText();
                String vehicleVarient = variant.getText();
                String prePolicy = "Third Party";
                String resgistrationdate = resgisdate.getText();

                System.out.println(vehicleMakeModel + " ---" + vehicleFuelType + "--- " + vehicleVarient + " ____" + prePolicy);
                Thread.sleep(2000);
                TestUtil.click(closedButton, "");

                String currentUrl = driver.getCurrentUrl();
                String[] parts2 = currentUrl.split("/");
                String id = parts2[parts2.length - 1];  // Get the last part after the last "/"
                System.out.println("Extracted ID: " + id);


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

                        String[] row = {reg, vehicleMakeModel, vehicleFuelType, vehicleVarient, prePolicy, resgistrationdate, insurerName, premium,id};
                        premiumData.add(row);
                    }
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }
                TestUtil.waitUntilVisibilityOfElement(actpointtext);
                TestUtil.click(actpointtext, "");
                Thread.sleep(5000);
                List<WebElement> Activitypt = driver.findElements(By.xpath("//div[@class=\"flex layout-align-space-between ng-scope\"]"));
                for (int i = 0; i < Activitypt.size(); i++) {
                    WebElement actp = Activitypt.get(i);
                    String ACTp = actp.getText();
                    System.out.println("Activity Text for reg: " + reg + " index: " + i + " -> '" + ACTp + "'");
                    String[] numbers = ACTp.split("\\r?\\n");

                    if (numbers.length == 2) {
                        String MinIDVactInsurer = numbers[0].trim();
                        String MinIDVactPoints = numbers[1].trim();
                        String[] row = {reg, MinIDVactInsurer, MinIDVactPoints,id};
                        ActivityP.add(row);
                    } else {
                        System.err.println("Unexpected format in activity points for reg: " + reg + " index: " + i);
                    }

                }
                TestUtil.click(actclose, "");
                Thread.sleep(2000);
                Actions actions = new Actions(driver);
                actions.moveToElement(hoverIn).perform();
              //  TestUtil.click(addonmore,"");
                List<WebElement> addOns = driver.findElements(By.xpath("(//div[@class=\"sidePanelCommonHeaderContent clearfix\"])[2]//a//span[@class=\"set-title\"]"));

                if (addOns.size() > 0) {
                    for (WebElement addOn : addOns) {
                        String addOnName = addOn.getText().trim();
                        if (!addOnName.isEmpty()) {
                            addOnsData.add(new String[]{reg, addOnName});
                            System.out.println(addOnName);
                        }
                    }
                    System.out.println("addons data added in sheet");

                }
            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }

            count++;
            driver.get("https://pro.turtlemint.com/car-insurance/create");
        }

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));

        // ✅ Save successful data
        //  String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
       String outputExcel = "/Users/nitinrathod/Desktop/Turtlemint_TP_premium" + dateTime + ".xlsx";
      //  String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\Turtlemint_TP_premium" + dateTime + ".xlsx";

        TestUtil.writePremiumDataTm(outputExcel, premiumData,ActivityP,addOnsData );
        // Optional: Print or save failed registrations
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
        }
    }


}

