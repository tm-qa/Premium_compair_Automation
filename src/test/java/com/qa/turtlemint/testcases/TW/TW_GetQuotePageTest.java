//package com.qa.turtlemint.testcases.TW;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TW_GetQuotePageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    ProductsPage productspage;
//    GetQuotePage gqp;
//
//    public TW_GetQuotePageTest()
//    {
//        super();
//    }
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        gqp = new GetQuotePage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//        productspage.ValidateMotorFWClick();
//
//    }
//
//    @Test
//    public void LeadWithOutRegNum() throws InterruptedException {
//        gqp.ValidateFieldsOnGetQuotePage();
//        gqp.CreateQuoteWithoutRegNumber();
//    }
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//
//}
