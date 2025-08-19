package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.apache.commons.beanutils.converters.LongArrayConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class insurancedekho_Page extends TestBase {

    @FindBy(xpath = "//p[text()=\"Car\"]")
    WebElement selectcar;

    @FindBy(xpath = "//label[text()=\"Enter your car number ex DL12AB2345\"]")
    WebElement registrationNumber;
    @FindBy(xpath = "//input[@name=\"regNo\"]")
    WebElement regiNumber;
    @FindBy(xpath = "//button[text()=\"Get Vehicle Details\"]")
    WebElement getvehicledetails;
    @FindBy(xpath = "//button[text()=\"Get Quotes\"]")
    WebElement getdetails;

    @FindBy(xpath = "//button[text()=\"Confirm & Get Quotes\"]")
    WebElement confandgetquotes;
    @FindBy(xpath = "//button[text()=\"Confirm & Proceed\"]")
    WebElement confirm;
    @FindBy(xpath = "//label[text()=\"Policy Expiry Date\"]//..//input")
    WebElement calendar;
    @FindBy(xpath = "//label[text()=\"Previous Insurer\"]//..//input")
    WebElement preinsurer;
    @FindBy(xpath = "//li[text()=\"ACKO\"]")
    WebElement ackoinsurer;



    @FindBy(xpath = "//div[@class=\"filterBtn7 filterBtn active\"]")
    WebElement addOnButton;

    @FindBy(xpath = "//div[@class=\"planList insurerList bonus addOne insurerDropdown\"]")
    WebElement insurerDropdown;

    @FindBy(xpath = "//div[@class=\"addoneListWrapper \"]//h2[1]")
    WebElement addoneListWrapper;
    @FindBy(xpath = "//span[text()=\"2025\"]")
    WebElement year;


    @FindBy(xpath = "//h3[text()=\"Policy Expiry Date\"]//..//li[not(contains(@class,\" year disabled\"))]")
    WebElement currentyear;
    @FindBy(xpath = "(//h3[text()=\"Policy Expiry Date\"]//..//li[not(contains(@class,\" month disabled\"))])[4]")
    WebElement currentmonth;
    @FindBy(xpath = "(//li[@class=\"active day\"]//following-sibling::li)[1]")
    WebElement currentdate;
    @FindBy(xpath = "//label[text()=\"Previous Policy Type\"]//..//input")
    WebElement previousdrop;
    @FindBy(xpath = "//li[contains(@class, 'MuiAutocomplete-option') and contains(text(), 'Comprehensive')]")
    WebElement comp;
    @FindBy(xpath = " //li[text()=\"Third Party\"]")
    WebElement Tp;
    @FindBy(xpath = "//label[text()=\"Mobile Number\"]//parent::div//input")
    WebElement MobileNumberID;
    @FindBy(xpath = "(//button[text()=\"Start Earning Now\"])[1]")
    WebElement startearning;
    @FindBy(xpath = "//p[text()=\"Registration Year \"]//span")
    WebElement registrationyear;
    @FindBy(xpath = "//label[text()=\"Registration Date\"]//..//input")
    WebElement registrationyear1;

    @FindBy(xpath = "//p[text()=\"Fuel Type \"]//span")
    WebElement fuelType;
    @FindBy(xpath = "//label[text()=\"Fuel Type*\"]//..//input")
    WebElement fuelType1;

    @FindBy(xpath = "//p[text()=\"Variant \"]//span")
    WebElement variant;
    @FindBy(xpath = "//label[text()=\"Variant\"]//..//input")
    WebElement variant1;

    @FindBy(xpath = "//div[@class=\"motorNumber\"]//p//span")
    WebElement modelmodel;
    @FindBy(xpath = "//label[text()=\"Make Model\"]//..//input")
    WebElement modelmodel1;

    @FindBy(xpath = "//a[text()=\"Sell\"]")
    WebElement sell;
    @FindBy(xpath = "//div[@class=\"filterBtn1 filterBtn active\"]")
    WebElement predrop;
    @FindBy(xpath = "//label[@for=\"third_party\"]")
    WebElement predropTP;





    public insurancedekho_Page() {
        PageFactory.initElements(driver, this);
    }

    public void loginID(String username) throws InterruptedException {
        String strUrl = driver.getCurrentUrl();
        LogUtils.info("Opened Website: " + strUrl);
        Thread.sleep(3000);
        TestUtil.sendKeys(MobileNumberID, username, "Mobile Number Entered");
        Thread.sleep(3000);
        TestUtil.click(startearning, "Start earning pressed");
        Thread.sleep(25000);

    }



    public void premiumIDCOMP() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TestUtil.waitUntilVisibilityOfElement(selectcar);
        js.executeScript("arguments[0].click();", selectcar);
        TestUtil.click(selectcar, "Clicked on car");
        Thread.sleep(2000);
        driver.navigate().refresh();
//         String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
          String excelPath = "/Users/pi/Documents/registration_data.xlsx";
       // String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();
        List<String[]> addOnsData = new ArrayList<>();
        System.out.println(regNumbers);


        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(regiNumber));
                TestUtil.sendKeys(regiNumber,reg,"entered registration number");
                TestUtil.waitUntilVisibilityOfElement(getvehicledetails);
                TestUtil.click(getvehicledetails,"click on vehicle details button");
                Thread.sleep(4000);
                String vehicleMakeModel ="" ;
                String vehicleVariant="";
                String vehicleFuel="";
                String regisdate ="";

                Thread.sleep(4000);
                List<WebElement> confQuotesBtnList = driver.findElements(By.xpath("//button[text()=\"Confirm & Get Quotes\"]"));
                if (!confQuotesBtnList.isEmpty() && confQuotesBtnList.get(0).isDisplayed()) {
                    Thread.sleep(3000);
                     vehicleMakeModel = modelmodel.getText();
                     vehicleVariant = variant.getText();
                     vehicleFuel = fuelType.getText();
                     regisdate = registrationyear.getText();
                    confQuotesBtnList.get(0).click();
                } else {
                    WebElement getDetails = driver.findElement(By.xpath("//button[text()=\"Get Quotes\"]"));
                    if (getDetails.isDisplayed()) {
                        Thread.sleep(3000);
                        vehicleMakeModel = modelmodel1.getAttribute("value");
                        vehicleVariant = variant1.getAttribute("value");
                        vehicleFuel = fuelType1.getAttribute("value");
                        regisdate = registrationyear1.getAttribute("value");

                        getDetails.click();
                        TestUtil.waitUntilVisibilityOfElement(preinsurer);
                        TestUtil.sendKeys(preinsurer,"acko","clicked on prev insurer dropdown");
                        TestUtil.click(ackoinsurer,"clicked acko prev insurer");
                    } else {
                        System.out.println("Neither button is available.");
                    }
                }
                Thread.sleep(20000);
                TestUtil.waitUntilVisibilityOfElement(calendar);
                String existingValue1 = calendar.getAttribute("value");
                LogUtils.info(existingValue1);
                if (existingValue1 == null )
                {
                    js.executeScript("arguments[0].click();", calendar);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentyear);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentmonth);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentdate);
                    System.out.println("New date is entered");
                }
                else {
                    // Date already present → clear & enter new date
                    System.out.println("ℹ️ Date already present: " + existingValue1 + " → Replacing with new date.");
                    int day = LocalDate.now().getDayOfMonth();
                    System.out.println(day);
                    int da =day+1;
                    LogUtils.info(String.valueOf(da));
                    js.executeScript("arguments[0].click();", calendar);
                    Thread.sleep(2000);
                    TestUtil.click(year,"");
                    js.executeScript("arguments[0].click();", calendar);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentyear);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentmonth);
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//li[text()=\""+da+"\"]")).click();

                    System.out.println("Existing date removed and "+da+" entered new date");
                }
                TestUtil.waitUntilVisibilityOfElement(previousdrop);
                TestUtil.click(previousdrop,"clicked");

                TestUtil.waitUntilVisibilityOfElement(comp);
                    TestUtil.click(comp,"selectec comp");

                    Thread.sleep(3000);

                String prevpolicytype = "Comprehensive";
                System.out.println(prevpolicytype);
                TestUtil.waitUntilVisibilityOfElement(confirm);
                TestUtil.click(confirm, "Clicked on confirmed to get quotes");
                Thread.sleep(30000);


                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class=\"quoteButton\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//span[@class=\"idvRangeValue\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[@class=\"idvCoverValue\"]//span")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='pointEarn']//span)[position() mod 2 = 1]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[@class=\"quoteButton\"]"));
                List<WebElement> IDVRange = driver.findElements(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//span[@class=\"idvRangeValue\"]"));
                List<WebElement> IDVActual = driver.findElements(By.xpath("//h2[@class=\"idvCoverValue\"]//span"));
                List<WebElement> actpoint = driver.findElements(By.xpath("(//div[@class='pointEarn']//span)[position() mod 2 = 1]"));

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
                TestUtil.click( addOnButton , "");
                System.out.println( " clicke on add on button "  );


                actions.moveToElement(insurerDropdown);

                Thread.sleep(3000);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class,'checkInsurence')]")));
                List<WebElement> addOns = driver.findElements(By.xpath("//span[contains(@class,'checkInsurence')]"));

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
            driver.get("https://pos.insurancedekho.com/core/sell/car");
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(2000);
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy---HH-mm-ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
//        String outputExcel = "/Users/nitinrathod/Desktop/InsuranceDekho_COMP_premium" + dateTime + ".xlsx";
        String outputExcel = "/Users/pi/Desktop/InsuranceDekho_COMP_premium" + dateTime + ".xlsx";
        //String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\InsuranceDekho_COMP_premium"+dateTime+".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataIDCOMP(outputExcel, premiumData,addOnsData);
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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TestUtil.waitUntilVisibilityOfElement(selectcar);
        js.executeScript("arguments[0].click();", selectcar);
        TestUtil.click(selectcar, "");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
//         String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
          String excelPath = "/Users/pi/Documents/registration_data.xlsx";
       // String excelPath = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\registration_data.xlsx";

        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();
        List<String[]> addOnsData = new ArrayList<>();
        System.out.println(regNumbers);


        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {

                wait.until(ExpectedConditions.elementToBeClickable(regiNumber));
                TestUtil.sendKeys(regiNumber,reg,"entered registration number");
                TestUtil.waitUntilVisibilityOfElement(getvehicledetails);
                TestUtil.click(getvehicledetails,"click on vehicle details button");
                Thread.sleep(4000);
                String vehicleMakeModel ="" ;
                String vehicleVariant="";
                String vehicleFuel="";
                String regisdate ="";

                Thread.sleep(4000);
                List<WebElement> confQuotesBtnList = driver.findElements(By.xpath("//button[text()=\"Confirm & Get Quotes\"]"));
                if (!confQuotesBtnList.isEmpty() && confQuotesBtnList.get(0).isDisplayed()) {
                    Thread.sleep(3000);
                    vehicleMakeModel = modelmodel.getText();
                    vehicleVariant = variant.getText();
                    vehicleFuel = fuelType.getText();
                    regisdate = registrationyear.getText();
                    confQuotesBtnList.get(0).click();
                } else {
                    WebElement getDetails = driver.findElement(By.xpath("//button[text()=\"Get Quotes\"]"));
                    if (getDetails.isDisplayed()) {
                        Thread.sleep(3000);
                        vehicleMakeModel = modelmodel1.getAttribute("value");
                        vehicleVariant = variant1.getAttribute("value");
                        vehicleFuel = fuelType1.getAttribute("value");
                        regisdate = registrationyear1.getAttribute("value");

                        getDetails.click();
                        Thread.sleep(3000);
                        TestUtil.sendKeys(preinsurer,"acko","clicked on prev insurer dropdown");
                        TestUtil.click(ackoinsurer,"clicked bajaj prev insurer");
                    } else {
                        System.out.println("Neither button is available.");
                    }
                }
                Thread.sleep(3000);
                TestUtil.waitUntilVisibilityOfElement(calendar);
                String existingValue1 = calendar.getAttribute("value");
                LogUtils.info(existingValue1);
                if (existingValue1 == null )
                {
                    js.executeScript("arguments[0].click();", calendar);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentyear);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentmonth);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentdate);
                    System.out.println("New date is entered");
                }
                else {
                    // Date already present → clear & enter new date
                    System.out.println("Date already present: " + existingValue1 + " → Replacing with new date.");
                    int day = LocalDate.now().getDayOfMonth();
                    System.out.println(day);
                    int da =day+1;
                    LogUtils.info(String.valueOf(da));
                    js.executeScript("arguments[0].click();", calendar);
                    Thread.sleep(2000);
                    TestUtil.click(year,"");
                    js.executeScript("arguments[0].click();", calendar);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentyear);
                    Thread.sleep(2000);
                    js.executeScript("arguments[0].click();", currentmonth);
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//li[text()=\""+da+"\"]")).click();

                    System.out.println("Existing date removed and "+da+" entered new date");
                }
                Thread.sleep(3000);
                TestUtil.click(previousdrop,"clicked");

                TestUtil.waitUntilVisibilityOfElement(Tp);
                TestUtil.click(Tp,"selectec TP");
                String prevpolicytype = "Third Party";
                System.out.println(prevpolicytype);
                TestUtil.waitUntilVisibilityOfElement(confirm);
                TestUtil.click(confirm, "Clicked on confirmed to get quotes");
                Thread.sleep(20000);

                TestUtil.click(predrop,"");
                TestUtil.click(predropTP,"");

                Thread.sleep(25000);
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class=\"quoteButton\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='pointEarn']//span)[position() mod 2 = 1]")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//span[@class=\"insurerNameAndButtonWrapper\"]//h2"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//button[@class=\"quoteButton\"]"));
                List<WebElement> actpoint = driver.findElements(By.xpath("(//div[@class='pointEarn']//span)[position() mod 2 = 1]"));

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
                TestUtil.click( addOnButton , "");
                System.out.println( " clicke on add on button "  );


                actions.moveToElement(insurerDropdown);

                Thread.sleep(3000);
                js.executeScript("document.body.style.zoom='50%'");
                Thread.sleep(3000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class,'checkInsurence')]")));
                List<WebElement> addOns = driver.findElements(By.xpath("//span[contains(@class,'checkInsurence')]"));

                System.out.println("Total Add-ons found: " + addOns.size());
                System.out.println(" start adding add ons");

                if (!addOns.isEmpty()) {
                    for (WebElement addon : addOns) {
                        String addOnName = addon.getText().trim();
                        addOnsData.add(new String[] { reg, addOnName });
                        System.out.println(addOnsData);
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
            driver.get("https://pos.insurancedekho.com/core/sell/car");
            Thread.sleep(2000);
            //driver.navigate().refresh();
            Thread.sleep(2000);
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
//         String outputExcel = "/Users/nitinrathod/Desktop/InsuranceDekho_TP_premium" + dateTime + ".xlsx";
        String outputExcel = "/Users/pi/Desktop/InsuranceDekho_TP_premium" + dateTime + ".xlsx";
       // String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Desktop\\ALLBrokerdata\\InsuranceDekho_TP_premium"+dateTime+".xlsx";

        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataIDTP(outputExcel, premiumData,addOnsData);
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