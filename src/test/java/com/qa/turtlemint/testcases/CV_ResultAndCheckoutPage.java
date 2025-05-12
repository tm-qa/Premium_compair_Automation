package com.qa.turtlemint.testcases;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import com.qa.turtlemint.pages.motor.CV_ResultPage;
import com.qa.turtlemint.pages.motor.ProfileFlowForCV;
import com.qa.turtlemint.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"motor","all_verticals","cv"}, description = "Motor Vertical-CV End to End Flow")
public class CV_ResultAndCheckoutPage extends TestBase{


        public LoginPage Loginpage;
        public OTPScreenPage OtpPage;
        public CreateAnAccountPage createaccount;
        public GrowPage growPage;
        public SellPage sellPage;
        public ProfileFlowForCV profileFlowPage; //Added

        public CV_ResultPage comprehensivePolicyPage;
        public com.qa.turtlemint.pages.motor.ODPolicyPage ODPolicyPage;
        public com.qa.turtlemint.pages.motor.TPPolicyPage TPPolicyPage;
        ProductsPage productspage;
        RegistrationInfoPage reginfo;

        GetQuotePage gqp;
        CarDetailsPage Cdp;
        ResultPage rp;
        SaveQuotePage sqp;
        CheckOutPage cp;
        TestUtil tl;
        BikeDetailsPage bdp;
        CV_ResultPage trp;

        public String name;

        public CV_ResultAndCheckoutPage()
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
            trp = new CV_ResultPage();
            profileFlowPage = new ProfileFlowForCV(); //Added
            comprehensivePolicyPage = new CV_ResultPage();
//        ODPolicyPage = new ODPolicyPage();
//        TPPolicyPage = new TPPolicyPage();
            Loginpage = createaccount.ValidateCreateAccountButton();
            growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
            productspage = growPage.ValidateLogin();
            gqp = productspage.ValidateMotorCVClick();

        }

    @Test(description = "CV Login to Payment Screen")
    public void CVComprehensivePolicy() throws InterruptedException {
        profileFlowPage.comprehensive();
        trp.GotItBtn();
        trp.comprehensiveCheckoutRel("test","ABC");
        //tl.NameGenerator();
        //comprehensivePolicyPage.comprehensiveCheckout(tl.firstname, tl.lastname);
    }
    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }

    }
