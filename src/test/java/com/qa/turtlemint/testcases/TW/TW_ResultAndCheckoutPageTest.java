package com.qa.turtlemint.testcases.TW;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import com.qa.turtlemint.pages.motor.ComprehensivePolicyPage;
import com.qa.turtlemint.pages.motor.ODPolicyPage;
import com.qa.turtlemint.pages.motor.ProfileFlowPage;
import com.qa.turtlemint.pages.motor.TPPolicyPage;
import com.qa.turtlemint.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"motor","all_verticals"}, description = "Motor Vertical-2 Wheeler End to End Flow")
public class TW_ResultAndCheckoutPageTest extends TestBase {

    public LoginPage Loginpage;
    public OTPScreenPage OtpPage;
    public CreateAnAccountPage createaccount;
    public GrowPage growPage;
    public SellPage sellPage;
    public ProfileFlowPage profileFlowPage; //Added
    public ComprehensivePolicyPage comprehensivePolicyPage;
    public ODPolicyPage ODPolicyPage;
    public TPPolicyPage TPPolicyPage;
    ProductsPage productspage;
    RegistrationInfoPage reginfo;

    GetQuotePage gqp;
    CarDetailsPage Cdp;
    ResultPage rp;
    SaveQuotePage sqp;
    CheckOutPage cp;
    TestUtil tl;
    BikeDetailsPage bdp;
    TW_ResultPage trp;

    public String name;

    public TW_ResultAndCheckoutPageTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        createaccount = new CreateAnAccountPage();
        Loginpage = new LoginPage();
        reginfo = new RegistrationInfoPage();
        bdp = new BikeDetailsPage();
        Cdp = new CarDetailsPage();
        rp = new ResultPage();
        tl =  new TestUtil();
        trp = new TW_ResultPage();
        profileFlowPage = new ProfileFlowPage();
        comprehensivePolicyPage = new ComprehensivePolicyPage();

        Loginpage = createaccount.ValidateCreateAccountButton();
        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
        productspage = growPage.ValidateLogin();
        gqp = productspage.ValidateMotorTWClick();

    }

    @Test(description = "TW Login to Payment Screen")
    public void SelectTwPlanAndCompleteCheckout() throws InterruptedException {
        reginfo = gqp.CreateQuoteWithoutRegNumber();
        Cdp = reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
        sqp = bdp.SaveBikeDetails(prop.getProperty("TW_Model"));

        tl.NameGenerator();
        sqp.SaveLead(tl.full_name);
        trp.SelectTWPlan();
        tl.NameGenerator();
        trp.CompleteTWCheckOutDetails(tl.firstname, tl.lastname);
    }

//    @Test
//    public void twComprehensivePolicy() throws InterruptedException {
//        profileFlowPage.comprehensive();
//        trp.SelectTWPlan();
//        tl.NameGenerator();
//        comprehensivePolicyPage.comprehensiveCheckout(tl.firstname, tl.lastname);
//    }

//    @Test
//    public void twOwnDamagePolicy() throws InterruptedException {
//        profileFlowPage.ownDamage();
//        trp.SelectTWPlan();
//        tl.NameGenerator();
//        ODPolicyPage.ownDamageCheckout(tl.firstname,tl.lastname);
//    }
//
//    @Test
//    public void twThirdPartyPolicy() throws InterruptedException {
//        profileFlowPage.thirdParty();
//        trp.SelectTWPlan();
//        tl.NameGenerator();
//        TPPolicyPage.thirdPartyCheckout(tl.firstname, tl.lastname);
//    }

    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}