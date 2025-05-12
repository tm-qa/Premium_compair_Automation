//package com.qa.turtlemint.testcases.TW;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import com.qa.turtlemint.pages.RegistrationProfileFlowPage;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class ProfileFlowTest extends TestBase {
//    public LoginPage loginPage;
//    public OTPScreenPage otpPage;
//    public CreateAnAccountPage createAccount;
//    public GrowPage growPage;
//    //    public SellPage sellPage;
//    public ProductsPage productsPage;
//    public RegistrationProfileFlowPage registrationProfileFlowPage;
//
//    public ProfileFlowTest(){super();}
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        loginPage = new LoginPage();
//        otpPage = new OTPScreenPage();
//        createAccount = new CreateAnAccountPage();
//        growPage = new GrowPage();
//        productsPage = new ProductsPage();
//        loginPage = createAccount.ValidateCreateAccountButton();
//        growPage = loginPage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productsPage = growPage.ValidateLogin();
//        productsPage.ValidateMotorTWClick();
//        registrationProfileFlowPage = new RegistrationProfileFlowPage();
//    }
//
//    @Test()
//    public void comprehensiveProfile() throws InterruptedException {
//        Thread.sleep(5000);
//        registrationProfileFlowPage.comprehensive();
//    }
//
//    @Test()
//    public void ownDamageProfile() throws InterruptedException {
//        Thread.sleep(5000);
//        registrationProfileFlowPage.ownDamage();
//    }
//
//    @Test()
//    public void thirdPartyProfile() throws InterruptedException {
//        Thread.sleep(5000);
//        registrationProfileFlowPage.thirdParty();
//    }
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//
//}