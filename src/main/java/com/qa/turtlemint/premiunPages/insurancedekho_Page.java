package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class insurancedekho_Page extends TestBase {

    @FindBy(xpath = "//p[text()=\"Car\"]")
    WebElement selectcar;

    @FindBy(xpath = "//label[text()=\"Enter your car number ex DL12AB2345\"]")
    WebElement registrationNumber;
    @FindBy(xpath = "//input[@name=\"regNo\"]")
    WebElement regiNumber;
    @FindBy(xpath = "//button[text()=\"Get Vehicle Details\"]")
    WebElement getvehicledetails;
    @FindBy(xpath = "//button[text()=\"Confirm & Get Quotes\"]")
    WebElement confandgetquotes;
    @FindBy(xpath = "//button[text()=\"Confirm & Proceed\"]")
    WebElement confirm;
    @FindBy(xpath = "//label[text()=\"Policy Expiry Date\"]//..//input")
    WebElement calendar;

    @FindBy(xpath = "//h3[text()=\"Policy Expiry Date\"]//..//li[not(contains(@class,\" year disabled\"))]")
    WebElement currentyear;
    @FindBy(xpath = "(//h3[text()=\"Policy Expiry Date\"]//..//li[not(contains(@class,\" month disabled\"))])[4]")
    WebElement currentmonth;
    @FindBy(xpath = "(//li[@class=\"active day\"]//following-sibling::li)[1]")
    WebElement currentdate;
    @FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiFilledInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-ftr4jk\"])[2]")
    WebElement previousdrop;
    @FindBy(xpath = "//li[text()=\"Comprehensive\"]")
    WebElement comp;
    @FindBy(xpath = " //li[text()=\"Third Party\"]")
    WebElement Tp;
    @FindBy(xpath = "//div[@id='common-login']//div[@class='otpLogin']//div[@id='OTPLogin']//input[@type='tel' and @name='mobileNumber' and @autocomplete='phone']")
    WebElement MobileNumberID;
    @FindBy(xpath = "(//span[text()=\"Start Earning Now\"])[3]")
    WebElement startearning;
    @FindBy(xpath = "//p[text()=\"Registration Year \"]//span")
    WebElement registrationyear;
    @FindBy(xpath = "//p[text()=\"Fuel Type \"]//span")
    WebElement fuelType;
    @FindBy(xpath = "//p[text()=\"Variant \"]//span")
    WebElement variant;
    @FindBy(xpath = "//div[@class=\"motorNumber\"]//p//span")
    WebElement modelmodel;
    @FindBy(xpath = "//a[text()=\"Sell\"]")
    WebElement sell;

    public insurancedekho_Page() {
        PageFactory.initElements(driver, this);
    }

    public void loginID(String username) throws InterruptedException {
        String strUrl = driver.getCurrentUrl();
        LogUtils.info("Opened Website: " + strUrl);
        Thread.sleep(3000);
        TestUtil.sendKeys(MobileNumberID, username, "Mobile Number Entered");
        TestUtil.click(startearning, "Start earning pressed");
        Thread.sleep(25000);
        TestUtil.getScreenShot();

    }

    public void premiumIDCOMP() throws InterruptedException {

        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectcar);
        TestUtil.click(selectcar, "Clicked on car");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(5000);

         String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
        //String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();
        System.out.println(regNumbers);


        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(regiNumber));
                TestUtil.sendKeys(regiNumber,reg,"entered registration number");
                Thread.sleep(6000);
                TestUtil.click(getvehicledetails,"click on vehicle details button");

                Thread.sleep(10000);
                String vehicleMakeModel = modelmodel.getText();
                String vehicleVariant = variant.getText();
                String vehicleFuel = fuelType.getText();
                String regisdate = registrationyear.getText();

                TestUtil.click(confandgetquotes, "Clicked on confirm and get quotes");
                Thread.sleep(5000);
                String existingValue1 = calendar.getText();
                if (existingValue1 == null || existingValue1.trim().isEmpty() )
                {
                    actions.moveToElement(calendar).doubleClick().perform();
                    Thread.sleep(2000);
                    TestUtil.click(currentyear, "selected year");
                    Thread.sleep(2000);
                    TestUtil.click(currentmonth, "selected month");
                    Thread.sleep(2000);
                    TestUtil.click(currentdate, "selected date");
                    Thread.sleep(3000);
                }
                String existingValue = previousdrop.getText();

                if (existingValue == null || existingValue.trim().isEmpty())
                {
                    Thread.sleep(2000);
                    TestUtil.click(previousdrop,"Clicked on previous policy type dropdown");
                    actions.moveToElement(previousdrop).doubleClick().perform();
                    Thread.sleep(3000);
                    TestUtil.click(comp, "selected comprehensive");
                    Thread.sleep(3000);
                }
                String prevpolicytype = "Comprehensive";
                System.out.println(prevpolicytype);
                Thread.sleep(2000);

                TestUtil.click(confirm, "Clicked on confirmed to get quotes");
                Thread.sleep(30000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class=\"quoteButton\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//span[@class=\"idvRangeValue\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[@class=\"idvCoverValue\"]//span")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='pointEarn']/p[position() mod 2 = 1]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[@class=\"quoteButton\"]"));
                List<WebElement> IDVRange = driver.findElements(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//span[@class=\"idvRangeValue\"]"));
                List<WebElement> IDVActual = driver.findElements(By.xpath("//h2[@class=\"idvCoverValue\"]//span"));
                List<WebElement> actpoint = driver.findElements(By.xpath("//div[@class='pointEarn']/p[position() mod 2 = 1]"));


                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement idvrange = IDVRange.get(i);
                        WebElement idvactual = IDVActual.get(i);
                        WebElement activityp = actpoint.get(i);

                        String insurerName = logo.getText();
                        String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                        String premiumIDV = idvactual.getText().replaceAll("[^0-9]", "");

                        String IDVrange =  idvrange.getText();

                        String[] numbers = IDVrange.split("₹");

                        String IdvMin = numbers[1].split("-")[0].replaceAll("[^0-9]", "");
                        String IdvMax = numbers[2].replaceAll("[^0-9]", "");

                        String actp = activityp.getText().trim();
                        if (actp.equals("NILpoints")) {
                            actp = "0";
                        } else {
                            actp = actp.replace("points", "").trim();
                        }
                        System.out.println("Points value: " + actp);

                        String[] row = {
                                reg,
                                vehicleMakeModel,
                                vehicleVariant,
                                vehicleFuel,
                                prevpolicytype,
                                regisdate,
                                insurerName,
                                premiumIDV,
                                premium,
                                actp,
                                IdvMin,
                                IdvMax


                        };
                        premiumData.add(row);
                    }
                    System.out.println("All data captured and added in sheet");
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }


            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
            driver.get("https://pos.insurancedekho.com/core/sell/car");
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(4000);
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
         String outputExcel = "/Users/nitinrathod/Desktop/InsuranceDekho_COMP_premium" + dateTime + ".xlsx";
       // String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\RenewBuy_COMP_premium"+dateTime+".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataIDCOMP(outputExcel, premiumData);
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





    public void premiumIDTP() throws InterruptedException {

        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectcar);
        TestUtil.click(selectcar, "");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(4000);

        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
     //   String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";

        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();
        System.out.println(regNumbers);


        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(regiNumber));
                TestUtil.sendKeys(regiNumber,reg,"entered registration number");
                Thread.sleep(6000);
                TestUtil.click(getvehicledetails,"click on vehicle details button");

                Thread.sleep(10000);
                String vehicleMakeModel = modelmodel.getText();
                String vehicleVariant = variant.getText();
                String vehicleFuel = fuelType.getText();
                String regisdate = registrationyear.getText();

                TestUtil.click(confandgetquotes, "click on confirm and get quotes");
                Thread.sleep(5000);
                String existingValue1 = calendar.getText();
                if (existingValue1 == null || existingValue1.trim().isEmpty() ) {
                    actions.moveToElement(calendar).doubleClick().perform();
                    Thread.sleep(2000);
                    TestUtil.click(currentyear, "selected year");
                    Thread.sleep(2000);
                    TestUtil.click(currentmonth, "selected month");
                    Thread.sleep(2000);
                    TestUtil.click(currentdate, "selected date");
                    Thread.sleep(3000);
                }
                String existingValue = previousdrop.getText();

                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    System.out.println(existingValue + "blank");
                    TestUtil.click(previousdrop,"");
                    System.out.println("first click");
                    actions.moveToElement(previousdrop).doubleClick().perform();
                    Thread.sleep(3000);
                    TestUtil.click(Tp, "selected comp");
                    Thread.sleep(3000);
                }
                String prevpolicytype = "Third Party";
                System.out.println(prevpolicytype);

                TestUtil.click(confirm, "Clicked on confirm to get quotes");
                Thread.sleep(30000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class=\"quoteButton\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='pointEarn']/p[position() mod 2 = 1]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[@class=\"quoteButton\"]"));
                List<WebElement> actpoint = driver.findElements(By.xpath("//div[@class='pointEarn']/p[position() mod 2 = 1]"));

                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement activityp = actpoint.get(i);


                        String insurerName = logo.getText();
                        String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                        String actp = activityp.getText().trim();
                        if (actp.equals("NILpoints")) {
                            actp = "0";
                        } else {
                            actp = actp.replace("points", "").trim();
                        }
                        System.out.println("Points value: " + actp);

                        String[] row = {
                                reg,
                                vehicleMakeModel,
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


            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
            driver.get("https://pos.insurancedekho.com/core/sell/car");
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(4000);
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
         String outputExcel = "/Users/nitinrathod/Desktop/InsuranceDekho_TP_premium" + dateTime + ".xlsx";
       // String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\RenewBuy_COMP_premium"+dateTime+".xlsx";

        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataIDTP(outputExcel, premiumData);
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