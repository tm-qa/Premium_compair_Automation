package com.qa.turtlemint.testcases;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarDetailsPageTest extends TestBase {

    public LoginPage Loginpage;
    public OTPScreenPage OtpPage;
    public CreateAnAccountPage createaccount;
    public GrowPage growPage;
    public SellPage sellPage;
    ProductsPage productspage;
    RegistrationInfoPage reginfo;
    GetQuotePage gqp;
    CarDetailsPage Cdp;

    public CarDetailsPageTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        createaccount = new CreateAnAccountPage();
        Loginpage = new LoginPage();
        reginfo = new RegistrationInfoPage();
        Cdp = new CarDetailsPage();
        Loginpage = createaccount.ValidateCreateAccountButton();
        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
        productspage = growPage.ValidateLogin();
        gqp = productspage.ValidateMotorFWClick();
        reginfo = gqp.CreateQuoteWithoutRegNumber();
        Thread.sleep(3000);
        Cdp = reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
    }

    @Test
    public void SaveCarDetail() throws InterruptedException {
        Cdp.SaveCarDetails(prop.getProperty("Model"), prop.getProperty("variant"));
    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}
