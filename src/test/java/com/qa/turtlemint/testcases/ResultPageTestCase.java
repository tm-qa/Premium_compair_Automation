package com.qa.turtlemint.testcases;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import com.qa.turtlemint.pages.KYC.Kyc;
import com.qa.turtlemint.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"motor","all_verticals"}, description = "Motor Vertical-4 Wheeler End to End Flow")
public class ResultPageTestCase extends TestBase {

    public LoginPage Loginpage;
    public OTPScreenPage OtpPage;
    public CreateAnAccountPage createaccount;
    public GrowPage growPage;
    public SellPage sellPage;
    ProductsPage productspage;
    RegistrationInfoPage reginfo;
    GetQuotePage gqp;
    CarDetailsPage Cdp;
    ResultPage rp;
    SaveQuotePage sqp;
    CheckOutPage cp;
    TestUtil tl;
    Kyc kyc;

    public String name;


    public ResultPageTestCase()
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
        rp = new ResultPage();
        tl =  new TestUtil();
        kyc = new Kyc();

        Loginpage = createaccount.ValidateCreateAccountButton();
        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
        productspage = growPage.ValidateLogin();
        gqp = productspage.ValidateMotorFWClick();
        reginfo = gqp.CreateQuoteWithoutRegNumber();
        Thread.sleep(4000);
        Cdp = reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
        Thread.sleep(4000);
        sqp = Cdp.SaveCarDetails(prop.getProperty("Model"), prop.getProperty("variant"));
        tl.NameGenerator();
        sqp.SaveLead(tl.full_name);
    }

    @Test(description = "FW Login to Payment Screen")
    public void SelectPlanAndCompletePayment() throws InterruptedException {
         Thread.sleep(3000);
            tl.NameGenerator();
            Thread.sleep(3000);
            rp.GotItBtn();
            rp.CompleteCheckOutDetails(tl.firstname, tl.lastname);
    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}
