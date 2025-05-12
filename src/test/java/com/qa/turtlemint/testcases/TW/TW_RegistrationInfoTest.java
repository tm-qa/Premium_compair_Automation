//package com.qa.turtlemint.testcases.TW;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TW_RegistrationInfoTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    ProductsPage productspage;
//    RegistrationInfoPage reginfo;
//    GetQuotePage gqp;
//
//    public TW_RegistrationInfoTest()
//    {
//        super();
//    }
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        reginfo = new RegistrationInfoPage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//        gqp = productspage.ValidateMotorTWClick();
//        reginfo = gqp.CreateQuoteWithoutRegNumber();
//    }
//
//
//
//    @Test
//    public void VerifyAndEnterRegistrationInfo() throws InterruptedException {
//        reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
//    }
//
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//}
//
//
//
