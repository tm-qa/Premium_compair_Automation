//package com.qa.turtlemint.testcases.Life;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import com.qa.turtlemint.pages.Life.LifeGetQuotePage;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class LifeGetQuotePageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    ProductsPage productspage;
//    LifeGetQuotePage lqp;
//
//    public LifeGetQuotePageTest()
//    {
//        super();
//    }
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        lqp = new LifeGetQuotePage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//    }
//
//    @Test
//    public void createLifeLead() throws InterruptedException {
//        lqp.LifeRedirection();
//    }
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//
//}