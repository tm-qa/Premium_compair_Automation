//package com.qa.turtlemint.testcases.TW;
//
//import com.qa.turtlemint.base.TestBase;
//import com.qa.turtlemint.pages.*;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TW_ProductsPageTest extends TestBase {
//
//    public LoginPage Loginpage;
//    public OTPScreenPage OtpPage;
//    public CreateAnAccountPage createaccount;
//    public GrowPage growPage;
//    public SellPage sellPage;
//    ProductsPage productspage;
//
//    public TW_ProductsPageTest()
//    {
//        super();
//    }
//
//    @BeforeMethod()
//    public void start() throws InterruptedException {
//        initialization();
//        createaccount = new CreateAnAccountPage();
//        Loginpage = new LoginPage();
//        Loginpage = createaccount.ValidateCreateAccountButton();
//        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
//        productspage = growPage.ValidateLogin();
//
//    }
//
//    @Test
//    public void ProductsPageDetails() throws InterruptedException {
//
//        productspage.ValidateProductsPageTitle();
//        System.out.println(driver.getTitle());
//        Assert.assertEquals(driver.getTitle(), "Start Selling Mintpro");
//        productspage.ValidateVerticals();
//        productspage.ValidateMotorTWClick();
//        Thread.sleep(10000);
//        Assert.assertEquals(driver.getTitle(), "Two Wheeler Insurance");
//
//    }
//
//    @AfterMethod()
//    public void Close()
//    {
//        driver.quit();
//    }
//}
//
