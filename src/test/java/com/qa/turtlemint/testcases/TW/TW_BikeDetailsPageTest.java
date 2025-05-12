//package com.qa.turtlemint.testcases.TW;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TW_BikeDetailsPageTest extends TestBase {
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    ProductsPage productspage;
//    RegistrationInfoPage reginfo;
//    GetQuotePage gqp;
//    CarDetailsPage Cdp;
//    BikeDetailsPage bdp;
//
//    public TW_BikeDetailsPageTest()
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
//        Cdp = new CarDetailsPage();
//        bdp = new BikeDetailsPage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//        gqp = productspage.ValidateMotorTWClick();
//        reginfo = gqp.CreateQuoteWithoutRegNumber();
//        reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
//    }
//
//    @Test
//    public void SaveBikeDetail() throws InterruptedException {
//        bdp.SaveBikeDetails(prop.getProperty("TW_Model"), prop.getProperty("TW_Variant"));
//    }
//
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//}
