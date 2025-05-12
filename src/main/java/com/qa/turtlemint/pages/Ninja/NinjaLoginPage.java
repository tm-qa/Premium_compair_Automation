package com.qa.turtlemint.pages.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class NinjaLoginPage extends TestBase {
    TestUtil tl = new TestUtil();
    @FindBy(xpath = "//span/a[@id='google-signin-button']")
    WebElement SignInbtn;
    @FindBy(xpath = "//input[@aria-label=\"Employee ID\"]")
    WebElement Employe;
    @FindBy(xpath = "//span[text()='Next']")
    WebElement Nextbtn1;
    @FindBy(xpath = "//div[@id='password']/div/div/div/input[@type='password']")
    WebElement Password;
    @FindBy(xpath = "//div[@id='passwordNext']")
    WebElement Nextbtn2;

    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement emailgoogle;

    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement passworgoogle;


    public NinjaLoginPage() {
        PageFactory.initElements(driver, this);
    }
//    public void NinjaValidateLogin(String NinjaEmail, String NinjaPassword) throws Exception {
//        driver.get("https://ninja.turtlemint.com/login");
//
//      //  driver.get(prop.getProperty("pmurl"));
//      //  driver.get(System.getProperty("ninjaurl"));
//
//        String strUrl = driver.getCurrentUrl();
//        LogUtils.info("Opened Ninja Website: " + strUrl);
//        Thread.sleep(6000);
//        SignInbtn.click();
//        LogUtils.info("Clicked on Sign In with Google Button");
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> it=windows.iterator();
//        String p = it.next();
//        String c = it.next();
//        driver.switchTo().window(c);
//        LogUtils.info("Switched to child window");
//        Email.sendKeys(NinjaEmail);
//        LogUtils.info("Email Entered");
//        tl.takeSnapShot(driver, "/tmp/"+tl.getTimeStamp()+ "Aninja.png");
//        //  tl.takeSnapShot(driver, "/tmp/"+tl.getTimeStamp()+ "Bninja.png");
//        Nextbtn1.click();
//        LogUtils.info("Clicked on Next button");
//        Password.sendKeys(NinjaPassword);
//        LogUtils.info("Password entered");
//        Nextbtn2.click();
//        Thread.sleep(16000);
//        LogUtils.info("Clicked on Next button after password");
//        driver.switchTo().window(p);
//        LogUtils.info("Switched Back to Parent window");
//        Thread.sleep(3000);
//        TestUtil.getScreenShot();
//    }

    public void NinjaValidateLogin(String NinjaEmail, String NinjaPassword) throws Exception {
        driver.get("https://accounts.google.com/");
        Thread.sleep(3000);

        TestUtil.sendKeys(emailgoogle, "automationtesting@turtlemint.com", "email Id entered");
        Thread.sleep(3000);
        TestUtil.sendKeys(emailgoogle, String.valueOf(Keys.RETURN), "email Id entered");
        Thread.sleep(3000);
        TestUtil.sendKeys(passworgoogle, "Turtle@2k26", "Password entered");
        Thread.sleep(3000);
        TestUtil.sendKeys(passworgoogle, String.valueOf(Keys.RETURN), "Password entered");
        Thread.sleep(5000);

//        try {
//            Thread.sleep(3000);
//            TestUtil.getScreenShot();
//            TestUtil.sendKeys(Employe, "FBS4825", "Employee ID entered");
//            Thread.sleep(3000);
//            TestUtil.sendKeys(Employe, String.valueOf(Keys.RETURN), "Password entered");
//            Thread.sleep(8000);
//        } catch (Exception e) {
//            System.out.println("********");
//        }

        Thread.sleep(3000);

        TestUtil.getScreenShot();
        driver.get(System.getProperty("ninjaurl"));
//         driver.get(prop.getProperty("url"));
        Thread.sleep(5000);
        TestUtil.click(SignInbtn, "Sign in button clicked");
        Thread.sleep(10000);
        TestUtil.getScreenShot();
    }
}