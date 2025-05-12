//package com.qa.turtlemint.testcases.Ninja;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//
//import java.awt.*;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//public class BranchIssuanceMotor {
//    public static void main(String[] args) throws InterruptedException, AWTException {
//
//
//        System.setProperty("webdriver.chrome.driver", "/Users/dhanashri_gujar/Downloads/chromedriver");
//        WebDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//        driver.manage().window().maximize();
//
//
//        driver.get("https://ninja.turtlemint.com/");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//span/a[@id='google-signin-button']")).click();
//        Thread.sleep(1000);
//
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> it=windows.iterator();
//        String p=it.next();
//        String c=it.next();
//
//        driver.switchTo().window(c);
//        Thread.sleep(1000);
//
//
//        //For entering the values in email field
//        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("automationtesting@turtlemint.com");
//
//        //Click on Next after entering the email
//        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
//
//        //For entering the values in password field
//        driver.findElement(By.xpath("//div[@id='password']/div/div/div/input[@type='password']")).sendKeys("Turtle@2019");
//
//        //Click on Next after entering the password
//        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
//        Thread.sleep(2000);
//
//        //To return to the parent screen
//        driver.switchTo().window(p);
//        Thread.sleep(1000);
//
//
//        //for Clicking on `Policy Issuance` option
//        driver.findElement(By.xpath("//a[contains(text(),'Policy Issuance')]")).click();
//
//        //for Clicking on `Report A Sale` tab
//        driver.findElement(By.xpath("//button[@class='_md-nav-button md-accent md-button md-ink-ripple md-unselected']")).click();
//
//        //for Clicking on `+`(plus icon)
//        driver.findElement(By.xpath("//button[@class='md-icon-button md-button ng-scope md-ink-ripple']")).click();
//
//
//
//        //To Click on vertical dropwdown
//        driver.findElement(By.xpath("//md-select[@id='$$vertical']")).click();
//        Thread.sleep(500);
//
//        List<WebElement> vertical_menu=driver.findElements(By.xpath("//md-select-menu[contains(@class,'_md md-overflow')]//md-content//md-option"));
//        System.out.println("Vertical Menu = " +vertical_menu.size());
//
////needs to be added in framework
//        for(int i=0;i<vertical_menu.size();i++)
//        {
//            System.out.println(vertical_menu.get(i).getText());
//            if(vertical_menu.get(i).getText().contains("Motor"))
//            {
//                vertical_menu.get(i).click();
//                break;
//            }
//        }
//
//
//
//
//        //To Click on Issuance Status
//        driver.findElement(By.id("policyIssuanceStatus")).click();
//        Thread.sleep(500);
//
//        List<WebElement> Issuance_menu=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option"));
//        System.out.println("Issuance Status = " +Issuance_menu.size());
//
//        for(int j=0;j<Issuance_menu.size();j++)
//        {
//            System.out.println(Issuance_menu.get(j).getText());
//
//            if(Issuance_menu.get(j).getText().contains("Waiting for insurer"))
//            {
//                Issuance_menu.get(j).click();
//                break;
//            }
//
//        }
//
//        //To Click on insurer
//        //driver.findElement(By.xpath("//input[@id='insurer']")).click();
//        Thread.sleep(500);
//
//
//        driver.findElement(By.id("insurer")).click();
////list need to be added in framework
//        List<WebElement> insurerlist=driver.findElements(By.xpath("//li[@class='ng-scope']"));
//
//        System.out.println("Insurer List = " +insurerlist.size());
//
//        for(int k=0;k<insurerlist.size();k++)
//        {
//            if(insurerlist.get(k).getText().contains("HDFC Ergo"))
//            {
//                insurerlist.get(k).click();
//            }
//        }
//
//
//
//
//
//        //To click on 'Create Sale'
//        driver.findElement(By.xpath("//button[contains(text(),'Create Sale')]")).click();
//
//
//        //To enter the form fields
//        driver.findElement(By.name("registrationNumber")).sendKeys("MH01qs1235");
//
//        //To select the sales date
//        driver.findElement(By.xpath("//div/md-datepicker[@id='saleCloseDate']")).click();
//        //If want to change the date need to change the last digit of code month is july
//        driver.findElement(By.xpath("//*[@id='md-0-month-2022-6-6']/span")).click();
//        Thread.sleep(1000);
//
//        //To select the policy type
//        driver.findElement(By.id("policyType")).click();
//        Thread.sleep(1000);
//
//        //Liost needs to be added in framework
//        List<WebElement> policy_type=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option"));
//        System.out.println("Policy Type = " + policy_type.size());
//
//        for(int l=0; l<policy_type.size();l++)
//        {
//            if(policy_type.get(l).getText().contains("Comprehensive"))
//            {
//                policy_type.get(l).click();
//            }
//        }
//
//        //To search the partner
//        WebElement parnter_name=driver.findElement(By.id("partnerName"));
//        parnter_name.sendKeys("Automation");
//        Thread.sleep(2000);
//        parnter_name.sendKeys(Keys.ARROW_DOWN);
//        parnter_name.sendKeys(Keys.ENTER);
//
//        //To Click on arrow of Policy fields
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//button[@class='md-icon-button md-button md-ink-ripple']")).click();
//
//        //To enter the policy fields
//        driver.findElement(By.id("proposerFName")).sendKeys("Car");
//        driver.findElement(By.id("proposerLName")).sendKeys("Testing");
//        driver.findElement(By.id("proposerMobile")).sendKeys("8976050500");
//        driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys("400001");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@id='manufactureYear']")).sendKeys("2017");
//
//        driver.findElement(By.xpath("//md-datepicker[@name='policyStartDate']")).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")).click();
//
//        driver.findElement(By.xpath("//md-datepicker[@name='policyEndDate']")).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")).click();
//
//        driver.findElement(By.xpath("//input[@id='odPremium']")).sendKeys("1");
//        driver.findElement(By.xpath("//input[@id='netOdPremium']")).sendKeys("1");
//        driver.findElement(By.xpath("//input[@id='basicTpPremium']")).sendKeys("1");
//        driver.findElement(By.xpath("//input[@id='tpPremium']")).sendKeys("1");
//        driver.findElement(By.xpath("//input[@id='netPremium']")).sendKeys("1");
//        driver.findElement(By.xpath("//input[@id='serviceTax']")).sendKeys("1");
//        driver.findElement(By.xpath("//input[@id='grossPremium']")).sendKeys("1");
//
//        Thread.sleep(1000);
//
//        //To click on Payment mode radio button
//        List<WebElement> payment_mode= driver.findElements(By.xpath("//md-card[@class='issuance-form _md'][4]//md-radio-button"));
//        System.out.println("Payment Mode = " + payment_mode.size());
//
//        for (int m=0;m<payment_mode.size();m++)
//        {
//            if (payment_mode.get(m).getText().contains("Cheque"))
//            {
//                payment_mode.get(m).click();
//            }
//        }
//
//        //To click on check details
//        driver.findElement(By.id("chequeDetails")).sendKeys("Testing");
//        Thread.sleep(1000);
//
//        //To select the payment status
//        driver.findElement(By.id("paymentStatus")).click();
//        driver.findElement(By.xpath("//md-option[contains(@value,'COMPLETED')]")).click();
//
//
//        //To select the completion date
//        driver.findElement(By.xpath("//md-datepicker[(@name='paymentCompleteDate')]/button[@class='md-datepicker-button md-icon-button md-button md-ink-ripple']")).click();
//        //If we want to change month/week/date we can do change in- tbody-month/ tr-week/ td-date
//        driver.findElement(By.xpath("//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")).click();
//        Thread.sleep(1000);
//
//        //To click on checkbox
//        driver.findElement(By.xpath("//md-checkbox[@id='paymentVerified']//div[@class='md-container md-ink-ripple']")).click();
//
//
//        //To click on Issuance status
//        driver.findElement(By.xpath("//md-select[@id='policyIssuanceStatus']/md-select-value")).click();
//        driver.findElement(By.xpath("//div[text()='Issued'][1]")).click();
//
//        driver.findElement(By.xpath("//md-datepicker[@name='policyIssuanceDate']/button")).click();
//        //If we want to change month/week/date we can do change in- tbody-month/ tr-week/ td-date
//        driver.findElement(By.xpath("//table[@class='md-calendar']/tbody[4]/tr[2]/td[4]/span[@class='md-calendar-date-selection-indicator']")).click();
//        Thread.sleep(1000);
//
//        //To send policy number
//        driver.findElement(By.id("policyNumber")).sendKeys("prod_car_BI_PO_01_060722");
//
//
//        //To Select file
//        WebElement fileupload=  driver.findElement(By.xpath("//input[@type='file']"));
//        Thread.sleep(1000);
//        fileupload.sendKeys("/Users/dhanashri_gujar/Downloads/test.jpeg");
//
////To tag the file
//        driver.findElement(By.xpath("//md-radio-button[@value='POLICY']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Done']")).click();
//        Thread.sleep(2000);
//
//        //To click on Save button
//        driver.findElement(By.xpath("//div[@class='ng-scope layout-align-center-center layout-column'][1]")).click();
//
//
//
//
//        driver.quit();
//    }
//}