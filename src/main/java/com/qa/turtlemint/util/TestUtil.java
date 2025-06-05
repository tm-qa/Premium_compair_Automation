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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;

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
    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
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

    public static void writePremiumDataRBCOMP_Add(String filePath, List<String[]> premiumDataRows, List<String[]> addOnsDataRows) {
        Workbook workbook = new XSSFWorkbook();

        // ---- Sheet 1: Premium Data ----
        Sheet premiumSheet = workbook.createSheet("PremiumData");

        // Header row for premium
        Row premiumHeader = premiumSheet.createRow(0);
        String[] headers = {
                "RegistrationNumber", "Make", "Model", "Variant", "Fuel",
                "Previous_Policy_Type", "Registration_Date", "Insurer",
                "IDV_premium", "Premium", "Activity Points", "IDVmin", "IDVmax"
        };
        for (int i = 0; i < headers.length; i++) {
            premiumHeader.createCell(i).setCellValue(headers[i]);
        }

        // Data rows for premium
        int premiumRowIndex = 1;
        for (String[] rowData : premiumDataRows) {
            Row row = premiumSheet.createRow(premiumRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size premium sheet columns
        for (int i = 0; i < headers.length; i++) {
            premiumSheet.autoSizeColumn(i);
        }

        // ---- Sheet 2: Add Ons ----
        Sheet addOnSheet = workbook.createSheet("AddOns");

        int addOnRowIndex = 0;
        for (String[] rowData : addOnsDataRows) {
            Row row = addOnSheet.createRow(addOnRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size add-ons column
        addOnSheet.autoSizeColumn(0);

        // ---- Write to File ----
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
            System.out.println("✅ Excel file written: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Failed to write Excel file: " + e.getMessage());
        }
    }


    public static void writePremiumDataRBCOMP(String filePath, List<String[]> dataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "Make", "Model", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer","IDV_premium", "Premium","Activity_Points" , "IDVmin", "IDVmax"};
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

    public static void writePremiumDataRBTP(String filePath, List<String[]> dataRows , List<String[]> addOnsDataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "Make", "Model", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer", "Premium","Activity_Points"};
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

        Sheet addOnSheet = workbook.createSheet("AddOns");

        int addOnRowIndex = 0;
        for (String[] rowData : addOnsDataRows) {
            Row row = addOnSheet.createRow(addOnRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }


        addOnSheet.autoSizeColumn(0);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
            System.out.println("✅ Excel file written: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Failed to write Excel file: " + e.getMessage());
        }
    }

    public static void writePremiumDataIDCOMP(String filePath, List<String[]> dataRows,List<String[]> addOnsDataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "MakeModel", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer","IDV_premium", "Premium","Activity_Points","IDVmin","IDVmax"};
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

        // ---- Sheet 2: Add Ons ----
        Sheet addOnSheet = workbook.createSheet("AddOns");

        int addOnRowIndex = 0;
        for (String[] rowData : addOnsDataRows) {
            Row row = addOnSheet.createRow(addOnRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size add-ons column
        addOnSheet.autoSizeColumn(0);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writePremiumDataIDTP(String filePath, List<String[]> dataRows, List<String[]> addOnsDataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "MakeModel", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer","Premium","Activity_Points"};
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
        // ---- Sheet 2: Add Ons ----
        Sheet addOnSheet = workbook.createSheet("AddOns");

        int addOnRowIndex = 0;
        for (String[] rowData : addOnsDataRows) {
            Row row = addOnSheet.createRow(addOnRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size add-ons column
        addOnSheet.autoSizeColumn(0);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePremiumDataTm(String filePath, List<String[]> dataRows,List<String[]> ActivityP,List<String[]>addOnsData) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = {
                "RegistrationNumber", "Make and Model", "Fuel","Variant", "Previous Policy Type", "Registration Date", "Insurer", "Premium"
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
        // === Sheet 2: ActivityPoints (only MinIDV data as per current main method) ===
        Sheet activitySheet = workbook.createSheet("ActivityPoints");
        // Header matches what you currently have in your ActivityP rows (3 columns)
        String[] activityHeaders = {"Reg No", "Insurer", "ActivityPoints"};
        Row activityHeaderRow = activitySheet.createRow(0);
        for (int i = 0; i < activityHeaders.length; i++) {
            activityHeaderRow.createCell(i).setCellValue(activityHeaders[i]);
        }

        int activityRowIndex = 1;
        for (String[] rowData : ActivityP) {
            Row row = activitySheet.createRow(activityRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size columns for better readability
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < activityHeaders.length; i++) {
            activitySheet.autoSizeColumn(i);
        }
        // Example: Add-ons
        Sheet addOnsSheet = workbook.createSheet("AddOns");
        rowIndex = 0;
        for (String[] rowData : addOnsData) {
            Row row = addOnsSheet.createRow(rowIndex++);
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

    public static void writePremiumDataPBCOMP(String filePath, List<String[]> dataRows) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PremiumData");

        // Header row
        Row header = sheet.createRow(0);
        String[] headers = { "RegistrationNumber", "MakeModel", "Variant", "Fuel","Previous_Policy_Type","Registration_Date", "Insurer","IDV_premium", "Premium"};
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

//    public static void writeCombinedSheetTM_Comp(String filePath, List<String[]> premiumData, List<String[]> maxIDV) {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Premium and Max IDV Data");
//
//
//        String[] headers = {
//                "RegistrationNumber", "Make and Model", "Fuel","Variant", "Previous Policy Type", "Registration Date", "Insurer",
//                "Min_IDV" , "MinIDV_Premium","Insurer",
//                "Max_IDV" , "MaxIDV_Premium"
//        };
//
//
//        Row headerRow = sheet.createRow(0);
//        for (int i = 0; i < headers.length; i++) {
//            headerRow.createCell(i).setCellValue(headers[i]);
//        }
//
//
//        int maxRows = Math.max(premiumData.size(), maxIDV.size());
//
//
//        for (int i = 0; i < maxRows; i++) {
//            Row row = sheet.createRow(i + 1); // +1 because row 0 is header
//
//            if (i < premiumData.size()) {
//                String[] premiumRow = premiumData.get(i);
//                for (int j = 0; j < premiumRow.length; j++) {
//                    row.createCell(j).setCellValue(premiumRow[j]);
//                }
//            }
//
//            if (i < maxIDV.size()) {
//                String[] idvRow = maxIDV.get(i);
//                for (int j = 0; j < idvRow.length; j++) {
//                    row.createCell(9 + j).setCellValue(idvRow[j]); // Starting after premium columns
//                }
//            }
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(filePath)) {
//            workbook.write(fos);
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void writeCombinedSheetTM_Comp(String excelPath, List<String[]> premiumData, List<String[]> maxIDV, List<String[]> ActivityP, List<String[]> ActivityP2, List<String[]> addOnsData) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {

            // === Sheet 1: premiumData (combined min and max premiums) ===
            XSSFSheet sheet = workbook.createSheet("premiumData");

            String[] headers = {
                    "Reg No", "Make & Model", "Fuel", "Variant", "Pre Policy Type", "Reg Date",
                    "MIN_Insurer", "MIN_IDV", "MIN_Premium",
                    "MAX_Insurer", "MAX_IDV", "MAX_Premium"
            };

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Map key based on first 6 columns (common data)
            Map<String, List<String[]>> minMap = new LinkedHashMap<>();
            for (String[] row : premiumData) {
                String key = String.join("|", Arrays.copyOfRange(row, 0, 6));
                minMap.computeIfAbsent(key, k -> new ArrayList<>()).add(row);
            }

            Map<String, List<String[]>> maxMap = new LinkedHashMap<>();
            for (String[] row : maxIDV) {
                String key = String.join("|", Arrays.copyOfRange(row, 0, 6));
                maxMap.computeIfAbsent(key, k -> new ArrayList<>()).add(row);
            }

            int rowNum = 1;
            for (String key : minMap.keySet()) {
                List<String[]> minRows = minMap.getOrDefault(key, new ArrayList<>());
                List<String[]> maxRows = maxMap.getOrDefault(key, new ArrayList<>());

                int maxLen = Math.max(minRows.size(), maxRows.size());
                for (int i = 0; i < maxLen; i++) {
                    Row row = sheet.createRow(rowNum++);

                    String[] common = key.split("\\|");
                    for (int j = 0; j < common.length; j++) {
                        row.createCell(j).setCellValue(common[j]);
                    }

                    if (i < minRows.size()) {
                        String[] min = minRows.get(i);
                        row.createCell(6).setCellValue(min[6]); // MIN_Insurer
                        row.createCell(7).setCellValue(min[7]); // MIN_IDV
                        row.createCell(8).setCellValue(min[8]); // MIN_Premium
                    }

                    if (i < maxRows.size()) {
                        String[] max = maxRows.get(i);
                        row.createCell(9).setCellValue(max[6]);  // MAX_Insurer
                        row.createCell(10).setCellValue(max[7]); // MAX_IDV
                        row.createCell(11).setCellValue(max[8]); // MAX_Premium
                    }
                }
            }

            // === Sheet 2: ActivityPoints (only MinIDV data as per current main method) ===
            XSSFSheet activitySheet = workbook.createSheet("ActivityPointsMIN");

            // Header matches what you currently have in your ActivityP rows (3 columns)
            String[] activityHeaders = {"Reg No", "MinIDVInsurer", "MinIDVActivityPoints"};
            Row activityHeaderRow = activitySheet.createRow(0);
            for (int i = 0; i < activityHeaders.length; i++) {
                activityHeaderRow.createCell(i).setCellValue(activityHeaders[i]);
            }

            int activityRowIndex = 1;
            for (String[] rowData : ActivityP) {
                Row row = activitySheet.createRow(activityRowIndex++);
                for (int i = 0; i < rowData.length; i++) {
                    row.createCell(i).setCellValue(rowData[i]);
                }
            }

            // Auto-size columns for better readability
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            for (int i = 0; i < activityHeaders.length; i++) {
                activitySheet.autoSizeColumn(i);
            }

            // === Sheet 3: ActivityPointsMAx (only MinIDV data as per current main method) ===
            XSSFSheet activitySheet1 = workbook.createSheet("ActivityPointsMAX");

            // Header matches what you currently have in your ActivityP rows (3 columns)
            String[] activityHeaders1 = {"Reg No", "MaxIDVInsurer", "MaxIDVActivityPoints"};
            Row activityHeaderRow1 = activitySheet1.createRow(0);
            for (int i = 0; i < activityHeaders1.length; i++) {
                activityHeaderRow1.createCell(i).setCellValue(activityHeaders1[i]);
            }

            int activityRowIndex1 = 1;
            for (String[] rowData : ActivityP2) {
                Row row = activitySheet1.createRow(activityRowIndex1++);
                for (int i = 0; i < rowData.length; i++) {
                    row.createCell(i).setCellValue(rowData[i]);
                }
            }

            // Auto-size columns for better readability
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            for (int i = 0; i < activityHeaders1.length; i++) {
                activitySheet.autoSizeColumn(i);
            }

            // Example: Add-ons
            Sheet addOnsSheet = workbook.createSheet("AddOns");
            rowNum = 0;
            for (String[] rowData : addOnsData) {
                Row row = addOnsSheet.createRow(rowNum++);
                for (int i = 0; i < rowData.length; i++) {
                    row.createCell(i).setCellValue(rowData[i]);
                }
            }

            // Write workbook to file
            try (FileOutputStream fileOut = new FileOutputStream(excelPath)) {
                workbook.write(fileOut);
            }

            System.out.println("✅ Excel successfully written to: " + excelPath);

        } catch (IOException e) {
            System.err.println("❌ Error writing Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }









    public static void writePremiumDataRBCOMP_Add1(String filePath, List<String[]> premiumDataRows, List<String[]> addOnsDataRows) {
        Workbook workbook = new XSSFWorkbook();

        // ---- Sheet 1: Premium Data ----
        Sheet premiumSheet = workbook.createSheet("PremiumData");

        // Header row for premium
        Row premiumHeader = premiumSheet.createRow(0);
        String[] headers = {
                "RegistrationNumber", "Make", "Model", "Variant", "Fuel",
                "Previous_Policy_Type", "Registration_Date", "Insurer",
                "IDV_premium", "Premium", "Activity Points", "IDVmin", "IDVmax"
        };
        for (int i = 0; i < headers.length; i++) {
            premiumHeader.createCell(i).setCellValue(headers[i]);
        }

        // Data rows for premium
        int premiumRowIndex = 1;
        for (String[] rowData : premiumDataRows) {
            Row row = premiumSheet.createRow(premiumRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size premium sheet columns
        for (int i = 0; i < headers.length; i++) {
            premiumSheet.autoSizeColumn(i);
        }

        // ---- Sheet 2: Add Ons ----
        Sheet addOnSheet = workbook.createSheet("AddOns");

        int addOnRowIndex = 0;
        for (String[] rowData : addOnsDataRows) {
            Row row = addOnSheet.createRow(addOnRowIndex++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size add-ons column
        addOnSheet.autoSizeColumn(0);

        // ---- Write to File ----
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
            System.out.println("✅ Excel file written: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Failed to write Excel file: " + e.getMessage());
        }
    }


}
