package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jaxen.pattern.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class renewbuy_page extends TestBase {


    @FindBy(xpath = "//button[text()=\" Sign In with Password \"]")
    WebElement singInWithPassword ;

    @FindBy(xpath = "//input[@id=\"form_email\"]")
    WebElement formEmail ;

    @FindBy(xpath = "//input[@id=\"form_password\"]")
    WebElement formPassword ;

    @FindBy(xpath = "//input[@placeholder=\"Enter answer\"]//preceding-sibling::label")
    WebElement quetion ;

    @FindBy(xpath = "//input[@id=\"sum\"]")
    WebElement enterSum;

    @FindBy(xpath = "//button[text()=\" Log In \"]")
    WebElement logIn;

    @FindBy(xpath = "//div[@class=\"close-button\"]//img")
    WebElement closedButton;
    @FindBy(xpath = "//div[text()=\" Motor \"]")
    WebElement motor ;
    @FindBy(xpath = "//input[@id-automation=\"registration_number\"]")
    WebElement registrationNumber;

    @FindBy(xpath = "//button[@id-automation=\"getVehicleDetailsId\"]")
    WebElement getVehicleDetailsIdButton;

    @FindBy(xpath = "(//span[text()=\" Above details are correct \"]//parent::button)[1]")
    WebElement aboveDetailsAreCorrectButton;

    @FindBy(xpath = "//mat-select[@formcontrolname=\"policy_expiry\"]")
    WebElement policyExiry;

    @FindBy(xpath = "//span[text()=\" 1 Year Third Party Damage \"]")
    WebElement policyExiryType;

    @FindBy(xpath = "//input[@aria-label=\"previous_insurer\"]")
    WebElement previousinsurer;

    @FindBy(xpath = "//span[text()=\"ACKO GENERAL INSURANCE\"]")
    WebElement ackoinsurer;



    @FindBy(xpath = "//input[@formcontrolname=\"vehicle_make\"]")
    WebElement make;

    @FindBy(xpath = "//input[@formcontrolname=\"vehicle_model\"]")
    WebElement model;

    @FindBy(xpath = "//mat-select[@formcontrolname=\"vehicle_fuel\"]")
    WebElement fuelType;

    @FindBy(xpath = "//mat-option[@class=\"mat-option mat-focus-indicator ng-star-inserted\"]")
    WebElement variant;
    @FindBy(xpath = "//a[text()=\"Motor Insurance\"]")
    WebElement motorback;

    //a[text()="Motor Insurance"]



    public renewbuy_page() throws IOException {
        PageFactory.initElements(driver, this);}


    public void logIn(){
        TestUtil.click(singInWithPassword , "click on sing In with password");
        TestUtil.sendKeys(formEmail , "jagadinsurance@gmail.com", "entered email");
        TestUtil.sendKeys(formPassword , "Jagad@321", "entered password");
        String mathText = quetion.getText();
        System.out.println(mathText);

        String[] numbers = mathText.split("\\D+");

        int num1 = Integer.parseInt(numbers[1]);
        int num2 = Integer.parseInt(numbers[2]);
        int sum = num1 + num2;
        String totalSum = String.valueOf(sum);
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        TestUtil.sendKeys(enterSum ,totalSum , "entered sum");
        TestUtil.click(logIn , "click on login button");

    }
    public void motorPreminum() throws InterruptedException, IOException {


        String excelPath = "/Users/nitinrathod/Downloads/Premium_compair_Automation/src/test/resources/registration_data.xlsx";
        List<String> regNumbers = TestUtil.getRegistrationNumbers(excelPath);
            System.out.println(regNumbers);

            TestUtil.click(closedButton, "click on close button");
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,800)");
            js.executeScript("arguments[0].click();", motor);

            Set<String> windowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(windowHandles);
            driver.switchTo().window(tabs.get(1));


            for (String reg : regNumbers) {

            //  Use registration number from Excel
            TestUtil.sendKeys(registrationNumber, reg, "entered registration number");
            TestUtil.click(getVehicleDetailsIdButton, "click on vehicle details button");

            // The rest of your test logic remains the same
            String vehicleMake = make.getText();
            String vehicleModel = model.getText();
            String vehicleVariant = variant.getText();
            String vehicleFuel = fuelType.getText();

            TestUtil.click(policyExiry, "click");
            TestUtil.click(policyExiryType, "expiry type");

                String existingValue = previousinsurer.getAttribute("value");
                System.out.println(existingValue);

                    if (existingValue == null || existingValue.trim().isEmpty()) {
                        System.out.println(existingValue);
                        Thread.sleep(2000);
                        // Value not present → send keys
                        previousinsurer.sendKeys("acko");
                        Thread.sleep(2000);
                        TestUtil.click(ackoinsurer,"");

                    } else {
                        // Value present → move forward
                        System.out.println("Existing value: " + existingValue);
                    }


            TestUtil.click(aboveDetailsAreCorrectButton, "confirm vehicle");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='insurer-logo']")));

            List<WebElement> insurerLogos = driver.findElements(By.xpath("//img[@class='insurer-logo']"));
            List<String> insurerNames = new ArrayList<>();
            List<String> totalPremiums = new ArrayList<>();

            for (WebElement logo : insurerLogos) {
                Thread.sleep(6000);
                String srcValue = logo.getAttribute("src");
                String[] parts = srcValue.split("/");
                String insurerName = parts[parts.length - 1].replace(".png", "");
                insurerNames.add(insurerName);
                Thread.sleep(7000);

                WebElement premiumElement = logo.findElement(By.xpath("//button[@class=\"premium-breakup-amount cursor-pointer text-center premium-breakup-amount-btn ng-star-inserted\"]"));
                String premium = premiumElement.getText();
                totalPremiums.add(premium);
                Thread.sleep(12000);
            }

            System.out.println("Insurer Names and Premiums:");
            for (int i = 0; i < insurerNames.size(); i++) {
                System.out.println("Insurer: " + insurerNames.get(i) + " | Premium: " + totalPremiums.get(i));
                Thread.sleep(4000);
            }
                TestUtil.click(motorback,"click back");

        }


    }
}
