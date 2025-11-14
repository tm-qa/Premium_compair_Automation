package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jaxen.pattern.Pattern;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//div[@id=\"cdk-overlay-1\"]//div[@class=\"close-button\"]//img")
    WebElement closedButton;
    @FindBy(xpath = "(//p[text()=\"Motor\"])[1]")
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

    @FindBy(xpath = "//span[text()=\"ACKO GENERAL INSURANCE\"]")
    WebElement ackoinsurer;


    @FindBy(xpath = "//input[@aria-label=\"vehicle_make\"]")
    WebElement make;

    @FindBy(xpath = "//input[@formcontrolname=\"vehicle_model\"]")
    WebElement model;

    @FindBy(xpath = "//mat-select[@formcontrolname=\"vehicle_fuel\"]")
    WebElement fuelType;
    @FindBy(xpath = "//input[@id-automation=\"registration_year_id\"]")
    WebElement registrationyear;


    @FindBy(xpath = "//input[@formcontrolname=\"vehicle_variant\"]")
    WebElement variant;
    @FindBy(xpath = "//a[text()=\"Motor Insurance\"]")
    WebElement motorback;

    @FindBy(xpath = "//mat-select[@formcontrolname=\"ncb_discount\"]")
    WebElement prevYearNCB;

    @FindBy(xpath = "//span[text()=\" 0% \"]")
    WebElement zeroNcb;

    @FindBy(xpath = "//div[contains(@id,\"cdk-accordion-child-1\")]//span[contains(@class,\"mat-checkbox-label\")]")
    WebElement addOn;
    @FindBy(xpath = "//div[@class=\"mat-slider-thumb\"]")
    WebElement slider;
    @FindBy(xpath = "//button[text()=\" Update \"]")
    WebElement update;


    public renewbuy_page() throws IOException {
        PageFactory.initElements(driver, this);
    }


    public void loginRB() throws InterruptedException {
        TestUtil.click(singInWithPassword, "click on sing In with password");
        TestUtil.sendKeys(formEmail, "jagadinsurance@gmail.com", "entered email");
        TestUtil.sendKeys(formPassword, "Jagad@321", "entered password");
        String mathText = quetion.getText();
        System.out.println(mathText);

        String[] parts = quetion.getText().replace("?", "").split(" "); // e.g., "What is 10 * 9"
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[4]);
        String operator = parts[3];
        int totalSum = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 != 0 ? num1 / num2 : 0;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };

        TestUtil.sendKeys(enterSum, String.valueOf(totalSum), "entered sum");
        Thread.sleep(5000);
        TestUtil.click(logIn, "click on login button");
    }

    public void premiumRBComp() throws InterruptedException, IOException {
        //   String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
//          String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
//          String excelPath = "/Users/pi/Documents/registration_data.xlsx";
         String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<String[]> addOnsData = new ArrayList<>();
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations


            Thread.sleep(5000);
            js.executeScript("arguments[0].click();", closedButton);


        js.executeScript("window.scrollBy(0,800)");
        TestUtil.waitUntilVisibilityOfElement(motor);
        js.executeScript("arguments[0].click();", motor);

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(registrationNumber)).sendKeys(reg);
                System.out.println("entered registration number");
                wait.until(ExpectedConditions.elementToBeClickable(getVehicleDetailsIdButton)).click();
                System.out.println("click on vehicle details button");

                Thread.sleep(5000);
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
                TestUtil.waitUntilVisibilityOfElement(prevYearNCB);
                Thread.sleep(2000);
                TestUtil.click(prevYearNCB, "click on prevYearNCB ");
                Thread.sleep(2000);
                TestUtil.waitUntilVisibilityOfElement(zeroNcb);
                Thread.sleep(2000);
                TestUtil.click(zeroNcb, "select 0% ncb");
                Thread.sleep(2000);

                TestUtil.waitUntilVisibilityOfElement(previousinsurer);
                String existingValue = previousinsurer.getAttribute("value");
                System.out.println(existingValue);
                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    previousinsurer.sendKeys("acko");
                    Thread.sleep(2000);
                    TestUtil.click(ackoinsurer, "acko insurer selected");
                }

                String dateValue = policyExiryDate.getAttribute("value");
                String futuredate = TestUtil.ninjaFutureDate(1);
                String newdate = futuredate.replaceAll("-", "");

                if (dateValue == null || dateValue.trim().isEmpty()) {
                    // Date is missing, fill it
                    TestUtil.click(policyExiryDate, "clicked on calendar");
                    TestUtil.click(mand, "");
                    policyExiryDate.clear();
                    TestUtil.sendKeys(policyExiryDate, newdate, "entered");
                    System.out.println("✅ New date entered (blank case): " + newdate);
                } else {
                    // Date already present → clear & enter new date
                    System.out.println("ℹ️ Date already present: " + dateValue + " → Replacing with new date.");
                    TestUtil.click(policyExiryDate, "clicked on calendar");
                    TestUtil.click(mand, "");
                    policyExiryDate.clear();
                    TestUtil.sendKeys(policyExiryDate, newdate, "entered");
                    System.out.println("✅ New date entered (replacement case): " + newdate);
                }

                // ✅ Now click the confirm button just once
                TestUtil.click(aboveDetailsAreCorrectButton, "Clicked on above details are correct button");
                Thread.sleep(15000);

                //  TestUtil.click(slider, "Clicked on slider");

                Actions actions = new Actions(driver);
                for (int i = 0; i < 40; i++) {
                    TestUtil.click(slider, "");
                    actions.sendKeys(Keys.ARROW_LEFT);
                }
                // actions.perform();
                TestUtil.click(update,"Clicked on update");

                Thread.sleep(20000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='insurer-logo']")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'premium-breakup-amount')]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"idv-amount\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class,\"idv-choose-amount\")]")));


                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class='insurer-logo']"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[contains(@class,'premium-breakup-amount')]"));
                List<WebElement> IDVRange = driver.findElements(By.xpath("//span[@class=\"idv-amount\"]"));
                List<WebElement> IDVActual = driver.findElements(By.xpath("//span[contains(@class,\"idv-choose-amount\")]"));


                List<WebElement> addOns = driver.findElements(By.xpath("(//div[contains(@id,\"cdk-accordion-child\")])[2]//span[@class='mat-checkbox-label']"));

                  String numberOnly;
                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement idvrange = IDVRange.get(i);
                        WebElement idvactual = IDVActual.get(i);

                        String srcValue = logo.getAttribute("src");
                        System.out.println(srcValue);

                        try {
                            WebElement ACT = driver.findElement(By.xpath("//*[@src=\""+srcValue+"\"]//..//..//..//div[@class=\"col-lg-6 col-md-6 col-6 idv-range\"]//img//.."));
                            String point = ACT.getText();
                            System.out.println(point);
                            String number = (point.replaceAll("You Earn ₹ ", ""));

                            numberOnly = (number.replaceAll("\\*", ""));

                            System.out.println(numberOnly);

                        } catch (Exception e) {
                            e.getMessage();

                            numberOnly = "0";
                        }


                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");

                        String premiumRaw = premiumBtn.getText().replaceAll("[^0-9]", "");
                        double premiumValue = Double.parseDouble(premiumRaw);
                        double premiumWithGST = premiumValue * 1.18;
                        String premium = String.valueOf(Math.round(premiumWithGST));  // Final value with 18% GST applied

                        String IDVactual = idvactual.getText().replaceAll("[^0-9]", "");

                        String IDVrange = idvrange.getText();

                        String[] numbers = IDVrange.split("₹");

                        String IdvMin = numbers[1].split("-")[0].replaceAll("[^0-9]", "");
                        String IdvMax = numbers[2].replaceAll("[^0-9]", "");


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
                        addOnsData.add(new String[]{reg, addOnName});
                    }
                    System.out.println("addons data added in sheet");
                } else {

                    addOnsData.add(new String[]{reg, "No Add-Ons Found"});
                }


            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
            Thread.sleep(3000);
            driver.get("https://apex.renewbuyinsurance.com/motor/");
        }

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));

        // ✅ Save successful data
        //    String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
//          String outputExcel = "/Users/nitinrathod/Desktop/RenewBuy_COMP_premium" + dateTime + ".xlsx";
//        String outputExcel = "/Users/pi/Desktop/RenewBuy_COMP_premium" + dateTime + ".xlsx";
        String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\RenewBuy_COMP_premium" + dateTime + ".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataRBCOMP_Add1(outputExcel, premiumData, addOnsData);
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
//        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
//         String excelPath = "/Users/pi/Documents/registration_data.xlsx";
         String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        System.out.println(regNumbers);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<String[]> addOnsData = new ArrayList<>();
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations

        Thread.sleep(5000);
        js.executeScript("arguments[0].click();", closedButton);

        js.executeScript("window.scrollBy(0,800)");
        TestUtil.waitUntilVisibilityOfElement(motor);
        js.executeScript("arguments[0].click();", motor);
        System.out.println("Clicked om motor");

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
        System.out.println("New tab open");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(registrationNumber)).sendKeys(reg);
                TestUtil.waitUntilVisibilityOfElement(getVehicleDetailsIdButton);
                TestUtil.click(getVehicleDetailsIdButton, "click on vehicle details button");

                Thread.sleep(5000);
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


                TestUtil.waitUntilVisibilityOfElement(policyExiry);
                TestUtil.click(policyExiry, "click on previous policy expiry dropdown");
                TestUtil.click(policyExiryTypeTP, "Third party policy expiry type selected");
                String prepolicytype = policyExiryTypeTP.getText();
                System.out.println(prepolicytype);

                TestUtil.waitUntilVisibilityOfElement(previousinsurer);
                String existingValue = previousinsurer.getAttribute("value");
                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    previousinsurer.sendKeys("acko");
                    Thread.sleep(2000);
                    TestUtil.click(ackoinsurer, "acko insurer selected");
                }

                String dateValue = policyExiryDate.getAttribute("value");
                String futuredate = TestUtil.ninjaFutureDate(1);
                String newdate = futuredate.replaceAll("-", "");

                if (dateValue == null || dateValue.trim().isEmpty()) {
                    // Date is missing, fill it
                    TestUtil.click(policyExiryDate, "clicked on calendar");
                    TestUtil.click(mand, "");
                    policyExiryDate.clear();
                    TestUtil.sendKeys(policyExiryDate, newdate, "entered");
                    System.out.println("✅ New date entered (blank case): " + newdate);
                } else {
                    // Date already present → clear & enter new date
                    System.out.println("ℹ️ Date already present: " + dateValue + " → Replacing with new date.");
                    TestUtil.click(policyExiryDate, "clicked on calendar");
                    TestUtil.click(mand, "");
                    policyExiryDate.clear();
                    TestUtil.sendKeys(policyExiryDate, newdate, "entered");
                    System.out.println("✅ New date entered (replacement case): " + newdate);
                }

                TestUtil.click(aboveDetailsAreCorrectButton, "Clicked on above details are correct button");
                Thread.sleep(15000);
                TestUtil.click(policytypeTP, "Selected new policy type as TP");
                Thread.sleep(30000);


                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='insurer-logo']")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'premium-breakup-amount')]")));


                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class='insurer-logo']"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[contains(@class,'premium-breakup-amount')]"));


                List<WebElement> addOns = driver.findElements(By.xpath("(//div[contains(@id,\"cdk-accordion-child\")])[2]//span[@class='mat-checkbox-label']"));


                String numberOnly;
                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        // WebElement activityP = activityPoint.get(i);

                        String srcValue = logo.getAttribute("src");
                        try {
                            WebElement ACT = driver.findElement(By.xpath("//*[@src=\"" + srcValue + "\"]//..//..//..//..//div[@class=\"col-lg-6 col-md-6 web-checkbox\"]//img//.."));
                            String point = ACT.getText();
                            String number = (point.replaceAll("You Earn ₹ ", ""));
                            numberOnly = (number.replaceAll("\\*", ""));

                            System.out.println(numberOnly);

                        } catch (Exception e) {
                            e.getMessage();

                            numberOnly = "0";
                        }


                        String[] parts = srcValue.split("/");
                        String insurerName = parts[parts.length - 1].replace(".png", "");

                        String premiumRaw = premiumBtn.getText().replaceAll("[^0-9]", "");
                        double premiumValue = Double.parseDouble(premiumRaw);
                        double premiumWithGST = premiumValue * 1.18;
                        String premium = String.valueOf(Math.round(premiumWithGST));  // Final value with 18% GST applied


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
                        addOnsData.add(new String[]{reg, addOnName});
                    }
                    System.out.println("addons data added in sheet");
                } else {

                    addOnsData.add(new String[]{reg, "No Add-Ons Found"});
                }

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
            Thread.sleep(3000);
            driver.get("https://apex.renewbuyinsurance.com/motor/");
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));
        //✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
//        String outputExcel = "/Users/nitinrathod/Desktop/RenewBuy_TP_premium" + dateTime + ".xlsx";
//        String outputExcel = "/Users/pi/Desktop/RenewBuy_TP_premium" + dateTime + ".xlsx";
        String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\RenewBuy_TP_premium"+dateTime+".xlsx";

        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataRBTP(outputExcel, premiumData, addOnsData);
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

