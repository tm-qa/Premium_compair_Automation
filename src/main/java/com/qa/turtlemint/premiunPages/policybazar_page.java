package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class policybazar_page extends TestBase {

    @FindBy(xpath = "//input[@id=\"user\"]")
    WebElement mobileno;
    @FindBy(xpath = "//button[text()=\"Send OTP\" and @id=\"send-otp-id\"]")
    WebElement getotp;


    @FindBy(xpath = "//small[text()=\"Car\"]//parent::a")
    WebElement selectCar;
    @FindBy(xpath = "//input[@id=\"regNoTextBox\"]")
    WebElement regisnumber;
    @FindBy(xpath = "//button[@id=\"btnGetQuotes\"]")
    WebElement viewprice;
    @FindBy(xpath = "//button[text()=\"View Quotes\"]//parent::button")
    WebElement viewpquotes;
    @FindBy(xpath = "//div[text()='Policy Expiry Date']//..//div//div//div//input")
    WebElement calendar;
    @FindBy(xpath = "//img[@alt=\"policybazaar\"]")
    WebElement resultback;
    @FindBy(xpath = "(//button[text()=\"See all \"])[1]")
    WebElement seeall;
    @FindBy(xpath = "(//span[text()=\"Third Party\"]//following-sibling::input)[1]")
    WebElement newpolicytypeTP;
    @FindBy(xpath = "//li[text()=\"0%\"]")
    WebElement prevNCBzero;


    @FindBy(xpath = "(//div[text()='Make Model']/following-sibling::div//div//div//div)[1]")
    WebElement makemodel;

    @FindBy(xpath = "//div[text()='Fuel']/following-sibling::div//div[contains(@class, 'customSelectSingleValue')]")
    WebElement fuletype;

    @FindBy(xpath = "//div[text()='Variant']/following-sibling::div//div[contains(@class, 'customSelectSingleValue')]")
    WebElement variant;

    @FindBy(xpath = "//div[text()=\"Registration Date\"]")
    WebElement registartiondate;
    @FindBy(xpath = "//div[text()=\"Previous Insurer\"]//..//div[@class=\"customSelectSingleValue css-1dimb5e-singleValue\"]")
    WebElement prepolicytypeinsurer;
    @FindBy(xpath = "//button[text()=\"Clear all\"]")
    WebElement clear;




    public policybazar_page() {
        PageFactory.initElements(driver, this);
    }

    public void logininPB() throws InterruptedException {

        Thread.sleep(10000);
        TestUtil.sendKeys(mobileno, "9975655749", "Mobile number entered");
//        TestUtil.sendKeys(mobileno, "9923177694", "Mobile number entered");

        Actions actions = new Actions(driver);
        actions.moveToElement(getotp).doubleClick().perform();

        System.out.println("OTP sent");
        Thread.sleep(60000);


    }


    public void premiumPBComp() throws InterruptedException, IOException {
        // String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        String excelPath = "/Users/nitinrathod/Documents/registration_data1.xlsx";
        // String excelPath = "/Users/pi/Documents/registration_data.xlsx";
        //String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);

        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations
        List<String[]> addOnsData = new ArrayList<>();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("arguments[0].click();", selectCar);

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

       Thread.sleep(5000);
        List<WebElement> loginButtons = driver.findElements(By.xpath("//button[text()='Login']"));

        if (!loginButtons.isEmpty()) {
            WebElement loginregi = loginButtons.get(0);
            Actions actions = new Actions(driver);
            actions.moveToElement(loginregi).click().perform();
            System.out.println("Login button found and clicked.");
            Thread.sleep(40000);
        } else {
            System.out.println("Login button not visible, continuing...");
        }
        for (String reg : regNumbers) {
            try {
                TestUtil.waitUntilVisibilityOfElement(regisnumber);
                TestUtil.sendKeys(regisnumber, reg, "entered registration number");
                TestUtil.waitUntilVisibilityOfElement(viewprice);
                TestUtil.click(viewprice, "click on vehicle details button");

                Thread.sleep(5000);
                Actions act =  new Actions(driver);
                act.moveToElement(makemodel).build().perform();
                String vehicleMakemodel = makemodel.getText();
                act.moveToElement(variant).build().perform();
                System.out.println(vehicleMakemodel);
                String vehicleVariant = variant.getText();
                System.out.println(vehicleVariant);
                act.moveToElement(fuletype).build().perform();
                String vehicleFuel = fuletype.getText();
                System.out.println(vehicleFuel);
                act.moveToElement(registartiondate).build().perform();
                String regisdate = registartiondate.getText();
                System.out.println(regisdate);
                String prevpolicytype = "Comprehensive";

                Thread.sleep(3000);
//                String existingValue = calendar.getAttribute("value");
//                System.out.println(existingValue);
//                if (existingValue == null || existingValue.trim().isEmpty()) {
//                    Thread.sleep(6000);
//                    String futuredate = TestUtil.ninjaFutureDate(3);
//                    System.out.println(futuredate);
//                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
//                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
//                    String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
//                    System.out.println(formattedDate);
//                    TestUtil.sendKeys(calendar, formattedDate + Keys.ENTER, "entered");
//                }

                String existingValue = calendar.getAttribute("value");
                System.out.println(" Existing value: " + existingValue);

                // Calculate future date once
                String futuredate = TestUtil.ninjaFutureDate(3);
                System.out.println(" Future raw date: " + futuredate);

                SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
                System.out.println(" Formatted date: " + formattedDate);

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    // Case: No date present → just enter new one
                    Thread.sleep(6000);
                    TestUtil.sendKeys(calendar, formattedDate + Keys.ENTER, "entered");
                    System.out.println(" New date entered (blank case): " + formattedDate);
                } else {
                    // Case: Date already present → clear & enter new one
                    System.out.println(" Replacing existing date: " + existingValue + " → " + formattedDate);
                    calendar.clear();
                    Thread.sleep(2000);
                    TestUtil.sendKeys(calendar, formattedDate + Keys.ENTER, "entered");
                    System.out.println(" New date entered (replacement case): " + formattedDate);
                }


                Thread.sleep(3000);
                String existingValue1 = prepolicytypeinsurer.getText();
                System.out.println(existingValue1);
                if (existingValue1 == null || existingValue1.trim().isEmpty()) {

                    Thread.sleep(4000);
                    TestUtil.sendKeys(prepolicytypeinsurer, "Bajaj Allianz" + Keys.ENTER, "");
                }

                TestUtil.click(prevNCBzero,"NCB selected as zero");

                Thread.sleep(3000);
                TestUtil.click(viewpquotes, "confirm vehicle");
                Thread.sleep(30000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class=\"imgLogo\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"btnContent premium-text\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=\"IDV\"]//parent::div//div")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=\"Activity Points\"]//..//div[@class=\"headingV3 fontNormal\"]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class=\"imgLogo\"]"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//span[@class=\"btnContent premium-text\"]"));
                List<WebElement> IDVActual = driver.findElements(By.xpath("//p[text()=\"IDV\"]//parent::div//div"));
                List<WebElement> actpoint = driver.findElements(By.xpath("//p[text()=\"Activity Points\"]//..//div[@class=\"headingV3 fontNormal\"]"));

                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        try {
                            WebElement logo = insurerLogos.get(i);
                            WebElement premiumBtn = insurerPremiums.get(i);
                            WebElement idvactual = IDVActual.get(i);
                              WebElement activityp = actpoint.get(i);
                            // ✅ Safely handle missing activity points
//                            String actp = "N/A";
//                            if (i < actpoint.size()) {
//                                WebElement activityp = actpoint.get(i);
//                                actp = activityp.getText().trim();
//                            } else {
//                                System.out.println("⚠️ Activity Points not found for index: " + i);
//                            }

                            // Alt-based insurer name handling
                            String insurerName = logo.getAttribute("alt").trim();
                            if (insurerName.equalsIgnoreCase("insurer")) {
                                insurerName = "Zuno";
                            }

                            String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                            String IDVactual = idvactual.getText().replaceAll("[^0-9]", "");
                            String actp = activityp.getText().trim();
                            System.out.println(actp);


                            String[] row = {
                                    reg,
                                    vehicleMakemodel,
                                    vehicleVariant,
                                    vehicleFuel,
                                    prevpolicytype,
                                    regisdate,
                                    insurerName,
                                    IDVactual,
                                    premium,
                                    actp

                            };
                            premiumData.add(row);
                        } catch (Exception e) {
                            System.out.println("❌ Failed to capture row data for index " + i + " in reg: " + reg);
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }
                TestUtil.click(seeall, "clicked on see all addons");

                Thread.sleep(3000);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=\"Addons\"]//parent::div//following-sibling::div//p//span[not(contains(@class,\"smallerFont subtext displayBlock\"))]")));
                List<WebElement> addOns = driver.findElements(By.xpath("//p[text()=\"Addons\"]//parent::div//following-sibling::div//p//span[not(contains(@class,\"smallerFont subtext displayBlock\"))]"));

                Thread.sleep(3000);
                System.out.println("Total Add-ons found: " + addOns.size());
                System.out.println(" start adding add ons");

                if (!addOns.isEmpty()) {
                    for (WebElement addon : addOns) {
                        String addOnName = addon.getText().trim();
                        addOnsData.add(new String[] { reg, addOnName });
                    }
                    System.out.println("Add-ons data added to sheet");
                } else {
                    System.out.println("No add-ons found");
                }

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
           // count++;
            Thread.sleep(3000);
            driver.get("https://pbpci.policybazaar.com/?token=o5aMAq6qZ1tLXTODNpDyVbk4MP6pWDnq6hhpN5u%2BmyLrjVGEAn3q7aWL1EWfn%2F8x3QItQRKLV160CZRStA1EzIIjjmh7Rk2wGIclsW0Jh4e8iyJC4B9lkYuTyQwkEaUnucjjquqjcRe1ovoaKdaNpspQRski64oLh7G%2FfumRACxGqPdATVxm9m0OebluKryJjMW939MPhfj2%2FPnBUywm1w%3D%3D&_gl=1*1lkn6ek*_ga*MTM5MzQ1MjQ5LjE3NDcyOTU5MTY.*_ga_HJQ0E2N5FF*czE3NDk0NTU2NTgkbzkkZzEkdDE3NDk0NjEyODAkajIyJGwwJGgw");
            Thread.sleep(3000);
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
       String outputExcel = "/Users/nitinrathod/Desktop/PolicyBazar_COMP_premium" + dateTime + ".xlsx";
         // String outputExcel = "/Users/pi/Desktop/PolicyBazar_COMP_premium" + dateTime + ".xlsx";
        // String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\PolicyBazar_COMP_premium"+dateTime+".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataPBCOMP(outputExcel, premiumData,addOnsData);
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


    public void premiumPBTP() throws InterruptedException, IOException {
        // String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
        // String excelPath = "/Users/pi/Documents/registration_data.xlsx";
        //String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);

        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations
        List<String[]> addOnsData = new ArrayList<>();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        TestUtil.waitUntilVisibilityOfElement(selectCar);
        js.executeScript("arguments[0].click();", selectCar);

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(5000);
        List<WebElement> loginButtons = driver.findElements(By.xpath("//button[text()='Login']"));

        if (!loginButtons.isEmpty()) {
            WebElement loginregi = loginButtons.get(0);
            Actions actions = new Actions(driver);
            actions.moveToElement(loginregi).click().perform();
            System.out.println("Login button found and clicked.");
            Thread.sleep(40000);
        } else {
            System.out.println("Login button not visible, continuing...");
        }

        for (String reg : regNumbers) {
            try {
                TestUtil.waitUntilVisibilityOfElement(regisnumber);
                TestUtil.sendKeys(regisnumber, reg, "entered registration number");
                TestUtil.waitUntilVisibilityOfElement(viewprice);
                TestUtil.click(viewprice, "click on vehicle details button");

                WebElement tpToggle = driver.findElement(By.xpath("(//span[text()='Third Party']//following-sibling::input)[1]"));

                if (tpToggle.isSelected()) {
                    System.out.println("Third Party is already selected.");
                } else {
                    System.out.println("Selecting Third Party...");
                    tpToggle.click();
                }

                Thread.sleep(5000);
                Actions act =  new Actions(driver);
                act.moveToElement(makemodel).build().perform();
                String vehicleMakemodel = makemodel.getText();
                act.moveToElement(variant).build().perform();
                System.out.println(vehicleMakemodel);
                String vehicleVariant = variant.getText();
                System.out.println(vehicleVariant);
                act.moveToElement(fuletype).build().perform();
                String vehicleFuel = fuletype.getText();
                System.out.println(vehicleFuel);
                act.moveToElement(registartiondate).build().perform();
                String regisdate = registartiondate.getText();
                System.out.println(regisdate);
                String prevpolicytype = "Third Party";

                Thread.sleep(3000);
                String existingValue = calendar.getAttribute("value");
                System.out.println(existingValue);
                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(6000);
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    System.out.println(futuredate);
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
                    System.out.println(formattedDate);
                    TestUtil.sendKeys(calendar, formattedDate + Keys.ENTER, "entered");

                }
                Thread.sleep(3000);
                TestUtil.click(newpolicytypeTP,"");

                Thread.sleep(3000);
                TestUtil.click(viewpquotes, "confirm vehicle");
                Thread.sleep(15000);
                TestUtil.click(clear,"Removed PA addon");
                Thread.sleep(25000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class=\"imgLogo\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"btnContent premium-text\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=\"Activity Points\"]//..//div[@class=\"headingV3 fontNormal\"]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class=\"imgLogo\"]"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//span[@class=\"btnContent premium-text\"]"));
                List<WebElement> actpoint = driver.findElements(By.xpath("//p[text()=\"Activity Points\"]//..//div[@class=\"headingV3 fontNormal\"]"));

                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement activityp = actpoint.get(i);
//                        // ✅ Safely handle missing activity points
//                        String actp = "N/A";
//                        if (i < actpoint.size()) {
//                            WebElement activityp = actpoint.get(i);
//                            actp = activityp.getText().trim();
//                        } else {
//                            System.out.println("⚠️ Activity Points not found for index: " + i);
//                        }

                        String insurerName = logo.getAttribute("alt").trim();
                        if (insurerName.equalsIgnoreCase("insurer")) {
                            insurerName = "Zuno";
                        }
                        String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                        String actp = activityp.getText().trim();
                        System.out.println(actp);


                        String[] row = {
                                reg,
                                vehicleMakemodel,
                                vehicleVariant,
                                vehicleFuel,
                                prevpolicytype,
                                regisdate,
                                insurerName,
                                premium,
                                actp

                        };
                        premiumData.add(row);
                    }
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }

                Thread.sleep(3000);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=\"Accident covers\"]//parent::div//following-sibling::div//p//span[not(contains(@class,\"smallerFont subtext displayBlock\"))]")));
                List<WebElement> addOns = driver.findElements(By.xpath("//p[text()=\"Accident covers\"]//parent::div//following-sibling::div//p//span[not(contains(@class,\"smallerFont subtext displayBlock\"))]"));

                Thread.sleep(3000);
                System.out.println("Total Add-ons found: " + addOns.size());
                System.out.println(" start adding add ons");

                if (!addOns.isEmpty()) {
                    for (WebElement addon : addOns) {
                        String addOnName = addon.getText().trim();
                        addOnsData.add(new String[] { reg, addOnName });
                    }
                    System.out.println("Add-ons data added to sheet");
                } else {
                    System.out.println("No add-ons found");
                }

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
            Thread.sleep(3000);
            driver.get("https://pbpci.policybazaar.com/?token=o5aMAq6qZ1tLXTODNpDyVbk4MP6pWDnq6hhpN5u%2BmyLrjVGEAn3q7aWL1EWfn%2F8x3QItQRKLV160CZRStA1EzIIjjmh7Rk2wGIclsW0Jh4e8iyJC4B9lkYuTyQwkEaUnucjjquqjcRe1ovoaKdaNpspQRski64oLh7G%2FfumRACxGqPdATVxm9m0OebluKryJjMW939MPhfj2%2FPnBUywm1w%3D%3D&_gl=1*1lkn6ek*_ga*MTM5MzQ1MjQ5LjE3NDcyOTU5MTY.*_ga_HJQ0E2N5FF*czE3NDk0NTU2NTgkbzkkZzEkdDE3NDk0NjEyODAkajIyJGwwJGgw");
            Thread.sleep(3000);
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
        String outputExcel = "/Users/nitinrathod/Desktop/PolicyBazar_TP_premium" + dateTime + ".xlsx";
        // String outputExcel = "/Users/pi/Desktop/PolicyBazar_TP_premium" + dateTime + ".xlsx";
        // String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\PolicyBazar_TP_premium"+dateTime+".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataPBTP(outputExcel, premiumData,addOnsData);
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
