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
    @FindBy(xpath = "//span[text()=\"VIEW QUOTES\"]//parent::button")
    WebElement viewpquotes;
    @FindBy(xpath = "//input[@name='Existing Policy Expiry Date']")
    WebElement calendar;
    @FindBy(xpath = "//img[@alt=\"policybazaar\"]")
    WebElement resultback;
    @FindBy(xpath = "//label[text()=\"Third Party Only\"]//following-sibling::label[@class=\"switch\"]")
   WebElement newpolicytypeTP ;
    @FindBy(xpath = "//label[text()=\"Third Party\"]//following-sibling::label[@class=\"switch\"]")
    WebElement prepolicytypeTP ;


    @FindBy(xpath = "//label[text()='Make Model']/following-sibling::div//div[contains(@class, 'customSelectSingleValue')]")
    WebElement makemodel ;

    @FindBy(xpath = "//label[text()='FUEL']/following-sibling::div//div[contains(@class, 'customSelectSingleValue')]")
    WebElement fuletype ;

    @FindBy(xpath = "//label[text()='Variant']/following-sibling::div//div[contains(@class, 'customSelectSingleValue')]")
    WebElement variant ;

    @FindBy(xpath = "//input[@name=\"Registration Date\"]")
    WebElement registartiondate ;
    @FindBy(xpath = "//label[text()='Previous Insurer']/following-sibling::div//div[contains(@class, 'customSelectInput')]")
    WebElement prepolicytypeinsurer ;

    //img[@class="imgLogo"]
    //span[@class="btnContent premium-text"]
    //p[text()="IDV"]//parent::div//div







    public policybazar_page() {
        PageFactory.initElements(driver, this);
    }

    public void logininPB() throws InterruptedException {
        TestUtil.sendKeys(mobileno,"9975655749","Mobile number entered");
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.moveToElement(getotp).doubleClick().perform();

        System.out.println("OTP sent");

    }


    public void premiumPBComp() throws InterruptedException, IOException {
        // String excelPath = "/Users/sayali/Documents/insurer/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        String excelPath = "/Users/nitinrathod/Documents/registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);

        List<String[]> premiumData = new ArrayList<>(); // successful data
        List<String> failedRegs = new ArrayList<>();    // failed registrations

        Thread.sleep(25000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        js.executeScript("arguments[0].click();", selectCar);

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        for (String reg : regNumbers) {
            try {
                TestUtil.sendKeys(regisnumber, reg, "entered registration number");
                Thread.sleep(2000);
                TestUtil.click(viewprice, "click on vehicle details button");

                Thread.sleep(4000);
                String vehicleMakemodel = makemodel.getText();
                String vehicleVariant = variant.getText();
                String vehicleFuel = fuletype.getText();
                String regisdate = registartiondate.getAttribute("value");
                String prevpolicytype = "Comprehensive";

                Thread.sleep(4000);
                String existingValue = calendar.getAttribute("value");
                if (existingValue == null || existingValue.trim().isEmpty()) {
                    Thread.sleep(2000);
                    String futuredate = TestUtil.ninjaFutureDate(3);
                    System.out.println(futuredate);
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = outputFormat.format(inputFormat.parse(futuredate));
                    System.out.println(formattedDate);
                    TestUtil.sendKeys(calendar, formattedDate+Keys.ENTER, "entered");
                    Thread.sleep(2000);
                }

                String existingValue1 = prepolicytypeinsurer.getAttribute("value");
                if (existingValue1 == null || existingValue1.trim().isEmpty()) {
                    Thread.sleep(2000);
                    prepolicytypeinsurer.sendKeys("acko");
                    Thread.sleep(2000);
                    TestUtil.sendKeys(prepolicytypeinsurer,"Bajaj Allianz"+Keys.ENTER, "");
                }


                TestUtil.click(viewpquotes, "confirm vehicle");
                Thread.sleep(15000);

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class=\"imgLogo\"]")));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"btnContent premium-text\"]")));

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=\"IDV\"]//parent::div//div")));

                List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class=\"imgLogo\"]"));
                List<WebElement> insurerPremiums = driver.findElements(By.xpath("//span[@class=\"btnContent premium-text\"]"));

                List<WebElement> IDVActual = driver.findElements(By.xpath("//p[text()=\"IDV\"]//parent::div//div"));

                if (insurerLogos.size() == insurerPremiums.size()) {
                    for (int i = 0; i < insurerLogos.size(); i++) {
                        WebElement logo = insurerLogos.get(i);
                        WebElement premiumBtn = insurerPremiums.get(i);
                        WebElement idvactual = IDVActual.get(i);

                        String insurerName = logo.getAttribute("alt");
                        String premium = premiumBtn.getText().replaceAll("[^0-9]", "");
                        String IDVactual = idvactual.getText().replaceAll("[^0-9]", "");


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


                        };
                        premiumData.add(row);
                    }
                } else {
                    System.err.println("Mismatch in insurer and premium count for Reg: " + reg);
                    failedRegs.add(reg);
                }

                TestUtil.click(resultback, "click back");
                TestUtil.click(selectCar,"");

            } catch (Exception e) {
                System.err.println("❌ Failed for Reg Number: " + reg);
                e.printStackTrace();
                failedRegs.add(reg);
            }
        }
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        // ✅ Save successful data
        //   String outputExcel = "/Users/sayali/Desktop/RenewBuy_premium" + dateTime + ".xlsx";
       // String outputExcel = "/Users/nitinrathod/Desktop/RenewBuy_COMP_premium" + dateTime + ".xlsx";
        String outputExcel = "C:\\Users\\pradeep.u_turtlemint\\Downloads\\RenewBuy_COMP_premium" + dateTime + ".xlsx";
        if (!premiumData.isEmpty()) {
            TestUtil.writePremiumDataRBCOMP(outputExcel, premiumData);
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
