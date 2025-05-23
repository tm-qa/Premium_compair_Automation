package com.qa.turtlemint.util;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.qa.turtlemint.base.TestBase.driver;

public class TestUtil {

    public static long Page_load_time = 60;
    public static long implicit_wait = 60;

    public String firstname;
    public String lastname;

    public String full_name;
    public String RegNo;
    public static String plno;


    public String NameGenerator()
    {
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        firstname = firstname.replaceAll("[^a-zA-Z0-9]", " ");
        lastname = faker.name().lastName();
        lastname = lastname.replaceAll("[^a-zA-Z0-9]", " ");
        full_name = firstname +" "+ lastname;
        full_name = full_name.replaceAll("[^a-zA-Z0-9]", " ");
        return full_name;
    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        return timeStamp;
    }

    public static void waitUntilTextToPresent(WebElement element, String text,String msg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        LogUtils.info(msg);

    }

    public static void moveToElement(WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

    }

    public static void waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40000));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static String ninjaFutureDate(int days) {
        LocalDateTime currentDateTime = LocalDateTime.now().plusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateTimeFormatter.format(currentDateTime);
    }

    public void GenerateRegNo ()
    {
        int alpha1 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int alpha2 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        // int alpha3 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int digit1 = (int)(Math.random() * 10);
        int digit2 = (int)(Math.random() * 10);
        int digit3 = (int)(Math.random() * 10);
        int digit4 = (int)(Math.random() * 10);
        RegNo = ("MH01" + (char)(alpha1) + ((char)(alpha2)) +
                + digit1 + digit2 + digit3 + digit4);
        System.out.println(RegNo + "IN test UTIL");
    }

    public static void click(WebElement element, String msg){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        LogUtils.info(msg);
    }

    public static void sendKeys(WebElement element, String keys, String msg){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(keys);
        LogUtils.info(msg);
    }

    public static void getScreenShot() {
        try {
            // Call getScreenshotAs method to create image file
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File f = scrShot.getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot "+ getTimeStamp(), FileUtils.openInputStream(f));
        }

        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static void getFullPageScreenShot() throws IOException{
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] t  = Shutterbug.shootPage(driver, Capture.FULL,true).getBytes();
        Allure.addAttachment("FULL SCREENSHOT " + getTimeStamp() , new ByteArrayInputStream(t));
    }


    public static String PastDate(int days) {
        LocalDateTime currentDateTime = LocalDateTime.now().minusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(currentDateTime);
    }
    public static String PresentDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(currentDateTime);

    }
    public static String generateRandomPolicyNo(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        plno = sb.toString();
        return plno;
    }
    public static List<String> getRegistrationNumbers(String filePath) {
        List<String> regNumbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            int regColIndex = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase("RegistrationNumber")) {
                    regColIndex = i;
                    break;
                }
            }

            if (regColIndex == -1) {
                throw new RuntimeException("RegistrationNumber column not found");
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(regColIndex);
                    if (cell != null) {
                        regNumbers.add(cell.toString().trim());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return regNumbers;
    }
    public static void writePremiumDataRBCOMP(String filePath, List<String[]> dataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "Make", "Model", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer","IDV_premium", "Premium","IDV_Range"};
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

        // Data rows
        int rowIndex = 1;
        for (String[] rowData : dataRows) {
            Row row = sheet.createRow(rowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePremiumDataRBTP(String filePath, List<String[]> dataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "Make", "Model", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer", "Premium"};
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

        // Data rows
        int rowIndex = 1;
        for (String[] rowData : dataRows) {
            Row row = sheet.createRow(rowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePremiumDataTm(String filePath, List<String[]> dataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = {
                "RegistrationNumber", "Make and Model", "Fuel","Variant", "Previous Policy Type", "Registration Date", "Insurer", "Premium","PremiumIDV"
        };
        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }

        // Data rows
        int rowIndex = 1;
        for (String[] rowData : dataRows) {
            Row row = sheet.createRow(rowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
