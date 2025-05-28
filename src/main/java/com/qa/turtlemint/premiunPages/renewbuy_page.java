package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jaxen.pattern.Pattern;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;

import static java.util.Collections.replaceAll;

public class renewbuy_page extends TestBase {


    @FindBy(xpath = "//button[text()=\" Sign In with Password \"]")
    WebElement singInWithPassword;

    @FindBy(xpath = "//input[@id=\"form_email\"]")
    WebElement formEmail;

    @FindBy(xpath = "//input[@id=\"form_password\"]")
    WebElement formPassword;

    @FindBy(xpath = "//input[@placeholder=\"Enter answer\"]//preceding-sibling::label")
    WebElement quetion;

    @FindBy(xpath = "//input[@id=\"sum\"]")
    WebElement enterSum;

    @FindBy(xpath = "//button[text()=\" Log In \"]")
    WebElement logIn;

    @FindBy(xpath = "//div[@class=\"close-button\"]//img")
    WebElement closedButton;
    @FindBy(xpath = "//div[text()=\" Motor \"]")
    WebElement motor;
    @FindBy(xpath = "//input[@id-automation=\"registration_number\"]")
    WebElement registrationNumber;

    @FindBy(xpath = "//button[@id-automation=\"getVehicleDetailsId\"]")
    WebElement getVehicleDetailsIdButton;

    @FindBy(xpath = "(//span[text()=\" Above details are correct \"]//parent::button)[1]")
    WebElement aboveDetailsAreCorrectButton;
    @FindBy(xpath = "//div[@class=\"mat-ripple mat-tab-label mat-focus-indicator ng-star-inserted\"]")
    WebElement policytypeTP;

    //div[@class="mat-ripple mat-tab-label mat-focus-indicator ng-star-inserted"]

    @FindBy(xpath = "//mat-select[@formcontrolname=\"policy_expiry\"]")
    WebElement policyExiry;

    @FindBy(xpath = "//span[text()=\" 1 Year Third Party Damage \"]")
    WebElement policyExiryTypeTP;
    @FindBy(xpath = "//span[text()=\" 3 Year Third Party Damage \"]")
    WebElement policyExiryTypeTP3;

    @FindBy(xpath = "//span[text()=\" Comprehensive (1 Year Own Damage + 1 Year Third Party Damage) \"]")
    WebElement policyExiryTypeCOMP;
    @FindBy(xpath = "//input[@id-automation=\"policy_expiry_date\"]")
    WebElement policyExiryDate;
    @FindBy(xpath = "//p[text()=\" I don't know the previous policy details \"]")
    WebElement mand;
    @FindBy(xpath = "//mat-error[text()=\" This is a required field. \"]")
    WebElement error;


    @FindBy(xpath = "//input[@aria-label=\"previous_insurer\"]")
    WebElement previousinsurer;

    @FindBy(xpath = "//span[text()=\"Bajaj Allianz General Insurance\"]")
    WebElement bajajinsurer;


    @FindBy(xpath = "//input[@aria-label=\"vehicle_make\"]")
    WebElement make;

    @FindBy(xpath = "//input[@formcontrolname=\"vehicle_model\"]")
    WebElement model;

    @FindBy(xpath = "//mat-select[@formcontrolname=\"vehicle_fuel\"]")
    WebElement fuelType;
    @FindBy(xpath = "//input[@id-automation=\"registration_year_id\"]")
    WebElement registrationyear;



    @FindBy(xpath = "//input[@aria-label=\"vehicle_variant\"]")
    WebElement variant;
    @FindBy(xpath = "//a[text()=\"Motor Insurance\"]")
    WebElement motorback;

    @FindBy(xpath = "//mat-select[@formcontrolname=\"ncb_discount\"]")
    WebElement prevYearNCB ;

    @FindBy(xpath = "//span[text()=\" 0% \"]")
    WebElement zeroNcb ;

    @FindBy(xpath = "//div[contains(@id,\"cdk-accordion-child-1\")]//span[contains(@class,\"mat-checkbox-label\")]")
    WebElement addOn;


    public renewbuy_page() throws IOException {
        PageFactory.initElements(driver, this);
    }


    public void loginRB() {
        TestUtil.click(singInWithPassword, "click on sing In with password");
        TestUtil.sendKeys(formEmail, "jagadinsurance@gmail.com", "entered email");
        TestUtil.sendKeys(formPassword, "Jagad@321", "entered password");
        String mathText = quetion.getText();
        System.out.println(mathText);

        String[] numbers = mathText.split("\\D+");

        int num1 = Integer.parseInt(numbers[1]);
        int num2 = Integer.parseInt(numbers[2]);
        int sum = num1 + num2;
        String totalSum = String.valueOf(sum);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        TestUtil.sendKeys(enterSum, totalSum, "entered sum");
        TestUtil.click(logIn, "click on login button");
    }

    public void premiumRBComp() throws InterruptedException, IOException {
        //   String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
      //  String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);

        List<String[]> addOnsData = new ArrayList<>();
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations

        try {
            TestUtil.click(closedButton, "click on close button");
            Thread.sleep(3000);
        }catch (Exception e){}

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        js.executeScript("arguments[0].click();", motor);

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(registrationNumber));
                System.out.println("entered registration number");
                wait.until(ExpectedConditions.elementToBeClickable(getVehicleDetailsIdButton));
                System.out.println("click on vehicle details button");

                Thread.sleep(4000);
                String vehicleMake = make.getAttribute("value");
                String vehicleModel = model.getAttribute("value");
                String vehicleVariant = variant.getAttribute("value");
                String vehicleFuel = fuelType.getText();
                String regisdate = registrationyear.getAttribute("value");

                System.out.println(vehicleMake);
                System.out.println(vehicleModel);
                System.out.println(vehicleVariant);
                System.out.println(vehicleFuel);
                System.out.println(regisdate);


                TestUtil.click(policyExiry, "click on previous policy expiry dropdown");
                TestUtil.click(policyExiryTypeCOMP, "comprehensive policy expiry type selected");

                String prepolicytype = policyExiryTypeCOMP.getText();
                Thread.sleep(3000);
                TestUtil.click(prevYearNCB , "click on prevYearNCB ");
                Thread.sleep(3000);
                TestUtil.click(zeroNcb , "select 0% ncb");

                Thread.sleep(4000);
                String existingValue = previousinsurer.getAttribute("value");
                System.out.println(existingValue);
                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    previousinsurer.sendKeys("bajaj");
                    Thread.sleep(2000);
                    TestUtil.click(bajajinsurer, "");
                }
                String dateValue = policyExiryDate.getAttribute("value");
                if (dateValue == null || dateValue.trim().isEmpty()) {
                    // Date is missing, fill it before clicking confirm
                    TestUtil.click(policyExiryDate, "clicked on calendar");
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    String newdate = futuredate.replaceAll("-", "");
                    TestUtil.click(mand, "");
                    policyExiryDate.clear();
                    TestUtil.sendKeys(policyExiryDate, newdate, "entered");
                    System.out.println("✅ New date entered: " + newdate);
                } else {
                    System.out.println("ℹ️ Date already present: " + dateValue);
                }

               // ✅ Now click the confirm button just once
                TestUtil.click(aboveDetailsAreCorrectButton, "Clicked on above details are correct button");


                Thread.sleep(2000);
              //  TestUtil.click(aboveDetailsAreCorrectButton, "Clicked on above details are correct button");
                Thread.sleep(30000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='insurer-logo']")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'premium-breakup-amount')]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"idv-amount\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class,\"idv-choose-amount\")]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"payout-value pb-2\"]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class='insurer-logo']"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[contains(@class,'premium-breakup-amount')]"));
                List<WebElement> IDVRange = driver.findElements(By.xpath("//span[@class=\"idv-amount\"]"));
                List<WebElement> IDVActual = driver.findElements(By.xpath("//span[contains(@class,\"idv-choose-amount\")]"));
                List<WebElement> activityPoint = driver.findElements(By.xpath("//div[@class=\"payout-value pb-2\"]"));

                List<WebElement> addOns = driver.findElements(By.xpath("(//div[contains(@id,\"cdk-accordion-child\")])[2]//span[@class='mat-checkbox-label']"));


                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement idvrange = IDVRange.get(i);
                        WebElement idvactual = IDVActual.get(i);
                        WebElement activityP = activityPoint.get(i);

                        String srcValue = logo.getAttribute("src");
                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");


                        String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                        String IDVactual = idvactual.getText().replaceAll("[^0-9]", "");

                        String IDVrange =  idvrange.getText();

                        String[] numbers = IDVrange.split("₹");

                        String IdvMin = numbers[1].split("-")[0].replaceAll("[^0-9]", "");
                        String IdvMax = numbers[2].replaceAll("[^0-9]", "");

                        String actP = activityP.getText().trim();
                        String numberOnly = "0";

                        if (actP.matches("^\\d+.*")) {
                            numberOnly = actP.split("\\*")[0].trim();
                        }
                        System.out.println(numberOnly);

                        String[] row = {
                                reg,
                                vehicleMake,
                                vehicleModel,
                                vehicleVariant,
                                vehicleFuel,
                                prepolicytype,
                                regisdate,
                                insurerName,
                                IDVactual,
                                premium,
                                numberOnly,
                                IdvMin,
                                IdvMax

                        };
                        premiumData.add(row);
                    }
                    System.out.println("Premium and vehicle details data added in sheet");
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }

                if (addOns.size() > 0) {
                    for (WebElement addOn : addOns) {
                        String addOnName = addOn.getText().trim();
                        addOnsData.add(new String[] { reg, addOnName });
                    }
                    System.out.println("addons data added in sheet");
                } else {

                    addOnsData.add(new String[] { reg, "No Add-Ons Found" });
                }

                Thread.sleep(10000);

                driver.get("https://apex.renewbuyinsurance.com/motor/");

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }


        }

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));

        // ✅ Save successful data
        //    String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
            String outputExcel = "/Users/nitinrathod/Desktop/RenewBuy_COMP_premium" + dateTime + ".xlsx";
     //   String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\RenewBuy_COMP_premium"+dateTime+".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataRBCOMP_Add1(outputExcel, premiumData , addOnsData);
            System.out.println("✅ Premium data written to Excel successfully.");
        } else {
            System.out.println("⚠️ No premium data collected to write.");
        }

        // Optional: print failed registration numbers
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
        }
    }



    //-----------------------------------TP-----------------------------------------


    public void premiumRBTp() throws InterruptedException, IOException {
        // String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
         String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
      //  String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        List<String[]> addOnsData = new ArrayList<>();
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations

        TestUtil.click(closedButton, "click on close button");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        js.executeScript("arguments[0].click();", motor);
        System.out.println("Clicked om motor");

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
        System.out.println("New tab open");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(registrationNumber));
                TestUtil.sendKeys(registrationNumber,reg,"entered registration number");
                wait.until(ExpectedConditions.elementToBeClickable(getVehicleDetailsIdButton));
               TestUtil.click(getVehicleDetailsIdButton,"click on vehicle details button");

                Thread.sleep(4000);
                String vehicleMake = make.getAttribute("value");
                String vehicleModel = model.getAttribute("value");
                String vehicleVariant = variant.getAttribute("value");
                String vehicleFuel = fuelType.getText();
                String regisdate = registrationyear.getAttribute("value");
                System.out.println(vehicleMake);
                System.out.println(vehicleModel);
                System.out.println(vehicleVariant);
                System.out.println(vehicleFuel);
                System.out.println(regisdate);



//                TestUtil.click(policyExiry, "click on previous policy expiry dropdown");
//                TestUtil.click(policyExiryTypeTP, "Third party policy expiry type selected");
//                String prepolicytype = policyExiryTypeTP.getText();
//                System.out.println(prepolicytype);

                TestUtil.click(policyExiry, "Clicked on previous policy expiry dropdown");

                String prepolicytype = "";

                if (TestUtil.isVisible(policyExiryTypeTP)) {
                    TestUtil.click(policyExiryTypeTP, "Selected 1 year TP policy type");
                    prepolicytype = policyExiryTypeTP.getText();
                } else if (TestUtil.isVisible(policyExiryTypeTP3)) {
                    TestUtil.click(policyExiryTypeTP3, "Selected 3 year TP policy type");
                    prepolicytype = policyExiryTypeTP3.getText();
                } else {
                    System.out.println("❌ No TP policy option found.");
                }

                System.out.println("Selected Policy Type: " + prepolicytype);


                Thread.sleep(4000);
                String existingValue = previousinsurer.getAttribute("value");
                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    previousinsurer.sendKeys("bajaj");
                    Thread.sleep(2000);
                    TestUtil.click(bajajinsurer, "Bajaj insurer selected");
                }

                String dateValue = policyExiryDate.getAttribute("value");
                if (dateValue == null || dateValue.trim().isEmpty()) {
                    // Date is missing, fill it before clicking confirm
                    TestUtil.click(policyExiryDate, "clicked on calendar");
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    String newdate = futuredate.replaceAll("-", "");
                    TestUtil.click(mand, "");
                    policyExiryDate.clear();
                    TestUtil.sendKeys(policyExiryDate, newdate, "entered");
                    System.out.println("✅ New date entered: " + newdate);
                } else {
                    System.out.println("ℹ️ Date already present: " + dateValue);
                }

                TestUtil.click(aboveDetailsAreCorrectButton, "Clicked on above details are correct button");
                Thread.sleep(15000);
                TestUtil.click(policytypeTP, "Selected new policy type as TP");
                Thread.sleep(30000);



                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='insurer-logo']")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'premium-breakup-amount')]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"payout-value pb-2\"]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class='insurer-logo']"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[contains(@class,'premium-breakup-amount')]"));
                List<WebElement> activityPoint = driver.findElements(By.xpath("//div[@class=\"payout-value pb-2\"]"));

                List<WebElement> addOns = driver.findElements(By.xpath("(//div[contains(@id,\"cdk-accordion-child\")])[2]//span[@class='mat-checkbox-label']"));



                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement activityP = activityPoint.get(i);


                        String srcValue = logo.getAttribute("src");
                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");
                        String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                        String actP = activityP.getText().trim();
                        String numberOnly = "0";

                        if (actP.matches("^\\d+.*")) {
                            numberOnly = actP.split("\\*")[0].trim();
                        }

                        String[] row = {
                                reg,
                                vehicleMake,
                                vehicleModel,
                                vehicleVariant,
                                vehicleFuel,
                                prepolicytype,
                                regisdate,
                                insurerName,
                                premium,
                                numberOnly


                        };
                        premiumData.add(row);
                    }
                    System.out.println("all data added in sheet");
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }
                if (addOns.size() > 0) {
                    for (WebElement addOn : addOns) {
                        String addOnName = addOn.getText().trim();
                        addOnsData.add(new String[] { reg, addOnName });
                    }
                    System.out.println("addons data added in sheet");
                } else {

                    addOnsData.add(new String[] { reg, "No Add-Ons Found" });
                }

                Thread.sleep(3000);
                driver.get("https://apex.renewbuyinsurance.com/motor/");

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));
        //✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
          String outputExcel = "/Users/nitinrathod/Desktop/RenewBuy_TP_premium" + dateTime + ".xlsx";
       // String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\RenewBuy_TP_premium"+dateTime+".xlsx";

        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataRBTP(outputExcel, premiumData,addOnsData);
            System.out.println("✅ Premium data written to Excel successfully.");
        } else {
            System.out.println("⚠️ No premium data collected to write.");
        }

        // Optional: print failed registration numbers
        if (!failedRegs.isEmpty()) {
            System.out.println("Failed registrations:");
            for (String reg : failedRegs) {
                System.out.println(reg);
            }
        }
    }


}

