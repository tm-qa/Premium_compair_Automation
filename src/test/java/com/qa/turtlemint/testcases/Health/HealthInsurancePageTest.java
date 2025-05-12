//package com.qa.turtlemint.testcases.Health;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import com.qa.turtlemint.pages.Health.HealthInsuranceOptionPage;
//import com.qa.turtlemint.pages.Health.HealthProductsPage;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class HealthInsurancePageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    public HealthProductsPage hpp;
//    ProductsPage productspage;
//    HealthInsuranceOptionPage hiop;
//
//    public HealthInsurancePageTest()
//    {
//        super();
//    }
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        hpp = new HealthProductsPage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//        hpp.ValidateHealthClick();
//        hiop = new HealthInsuranceOptionPage();
//
//    }
//
//    @Test
//    public void ValidateHealthRedirection() throws InterruptedException {
//        hiop.ValidateHealthInsuranceClick();
//
//    }
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//}
