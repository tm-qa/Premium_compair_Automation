//package com.qa.turtlemint.testcases.Health;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import com.qa.turtlemint.pages.Health.HealthInsuranceOptionPage;
//import com.qa.turtlemint.pages.Health.HealthProductsPage;
//import com.qa.turtlemint.pages.Health.HealthProfilePage;
//import com.qa.turtlemint.pages.Health.HealthResultPage;
//import com.qa.turtlemint.util.TestUtil;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class HealthProfilePageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    public HealthProductsPage hpp;
//    ProductsPage productspage;
//    HealthInsuranceOptionPage hiop;
//    HealthProfilePage healthprofilepage;
//    HealthResultPage healthresultpage;
//    TestUtil tl;
//
//    public HealthProfilePageTest() {
//        super();
//    }
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        hpp = new HealthProductsPage();
//        healthprofilepage = new HealthProfilePage();
//        tl = new TestUtil();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//        hpp.ValidateHealthClick();
//        hiop = new HealthInsuranceOptionPage();
//        hiop.ValidateHealthInsuranceClick();
//    }
//
//    @Test
//    public void ProfilePage() throws InterruptedException {
//        tl.NameGenerator();
//        healthprofilepage.CompleteHealthProfile(tl.full_name);
//    }
//
//    @AfterMethod()
//    public void Close() {
//        driver.quit();
//    }
//}
