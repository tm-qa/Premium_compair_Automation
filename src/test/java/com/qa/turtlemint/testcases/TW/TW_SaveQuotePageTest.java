//package com.qa.turtlemint.testcases.TW;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import com.qa.turtlemint.util.TestUtil;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TW_SaveQuotePageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    ProductsPage productspage;
//    RegistrationInfoPage reginfo;
//    GetQuotePage gqp;
//    CarDetailsPage Cdp;
//    ResultPage rp;
//    SaveQuotePage sqp;
//    BikeDetailsPage bdp;
//    TestUtil tl;
//
//    public TW_SaveQuotePageTest()
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
//        tl =  new TestUtil();
//        bdp = new BikeDetailsPage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//        gqp = productspage.ValidateMotorTWClick();
//        reginfo = gqp.CreateQuoteWithoutRegNumber();
//        reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
//        sqp = bdp.SaveBikeDetails(prop.getProperty("TW_Model"), prop.getProperty("TW_Variant"));
//    }
//
//    @Test
//    public void CreateTWLead() throws InterruptedException {
//        tl.NameGenerator();
//        sqp.SaveLead(tl.full_name);
//    }
//
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//}
