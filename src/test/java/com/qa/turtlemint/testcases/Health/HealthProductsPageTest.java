//package com.qa.turtlemint.testcases.Health;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import com.qa.turtlemint.pages.Health.HealthProductsPage;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class HealthProductsPageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    public HealthProductsPage hppt;
//    ProductsPage productspage;
//
//    public HealthProductsPageTest() {
//        super();
//    }
//
//    @BeforeTest()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        hppt = new HealthProductsPage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//    }
//
//    @Test
//    public void ValidateFWRedirection() throws InterruptedException {
//        hppt.ValidateVerticals();
//        hppt.ValidateHealthClick();
//    }
//
//    @AfterTest()
//    public void Close() {
//        driver.quit();
//    }
//}
