package com.qa.turtlemint.testcases.all_vertical;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import com.qa.turtlemint.pages.Health.HealthInsuranceOptionPage;
import com.qa.turtlemint.pages.Health.HealthProductsPage;
import com.qa.turtlemint.pages.Health.HealthProfilePage;
import com.qa.turtlemint.pages.Health.HealthResultPage;
import com.qa.turtlemint.pages.Life.LifeGetQuotePage;
import com.qa.turtlemint.pages.Life.LifeResultPage;
import com.qa.turtlemint.pages.motor.CV_ResultPage;
import com.qa.turtlemint.pages.motor.FW_ResultPage;
import com.qa.turtlemint.pages.motor.ProfileFlowForCV;
import com.qa.turtlemint.util.RetryAnalyser;
import com.qa.turtlemint.util.TestUtil;
import com.qa.turtlemint.util.iTestListener;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(iTestListener.class)
@Test(groups = {"Whole_Suite"}, description = "All Verticals end to end")
public class EntireSuite extends TestBase {

    public LoginPage Loginpage;
    public GrowPage growPage;
    public HealthProductsPage hpp;
    ProductsPage productspage;
    RegistrationInfoPage reginfo;
    GetQuotePage gqp;
    CarDetailsPage Cdp;
    ResultPage rp;
    SaveQuotePage sqp;
    TestUtil tl;
    BikeDetailsPage bdp;
    TW_ResultPage trp;
    HealthInsuranceOptionPage hiop;
    HealthProfilePage healthprofilepage;
    HealthResultPage healthresultpage;
    LifeResultPage liferesultpage;
    LifeGetQuotePage lqp;
    CV_ResultPage cvrp;
    ProfileFlowForCV profileFlowPageforCV;
    FW_ResultPage fwCheckout;

    public EntireSuite() {
        super();
    }

    @BeforeMethod(groups = {"FW", "TW", "CV", "Health", "Life"})
    public void start() throws InterruptedException {
        initialization();

        Loginpage = new LoginPage();
        reginfo = new RegistrationInfoPage();
        bdp = new BikeDetailsPage();
        Cdp = new CarDetailsPage();
        rp = new ResultPage();
        tl = new TestUtil();
        trp = new TW_ResultPage();

        healthprofilepage = new HealthProfilePage();
        healthresultpage = new HealthResultPage();
        hpp = new HealthProductsPage();
        hiop = new HealthInsuranceOptionPage();
        lqp = new LifeGetQuotePage();
        liferesultpage = new LifeResultPage();
        cvrp = new CV_ResultPage();
        profileFlowPageforCV = new ProfileFlowForCV();
        fwCheckout = new FW_ResultPage();

        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
        productspage = growPage.ValidateLogin();
    }

    @Test(groups = {"Life"}, description = "Life Smoke Suite")//, retryAnalyzer = RetryAnalyser.class)
    public void LifeResultAndCheckOutPage() throws Exception {
        lqp.LifeRedirection();
        liferesultpage.LifeResultPage();
        Thread.sleep(3000);
        liferesultpage.LifeCheckoutPage();
    }


    @Test//( groups = {"CV"},description = "CV Smoke Suite")//, retryAnalyzer = RetryAnalyser.class)
    public void CVResultAndCheckOutPage() throws InterruptedException {
        gqp = productspage.ValidateMotorCVClick();
        profileFlowPageforCV.comprehensive();
        rp.GotItBtn();
        cvrp.comprehensiveCheckoutRel("test", "ABC");
    }

    @Test(groups = {"FW"}, description = "FW Smoke Suite")//, retryAnalyzer = RetryAnalyser.class)
    public void FWResultAndCheckOutPage() throws InterruptedException {
        gqp = productspage.ValidateMotorFWClick();
        reginfo = gqp.CreateQuoteWithoutRegNumber();
        Thread.sleep(4000);
        Cdp = reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
        Thread.sleep(4000);
        sqp = Cdp.SaveCarDetails(prop.getProperty("Model"), prop.getProperty("variant"));
        tl.NameGenerator();
        sqp.SaveLead(tl.full_name);
        fwCheckout.GotItBtn();
        Thread.sleep(14000);
        fwCheckout.comprehensiveCheckoutRelFW("test", "ABC");
    }

    @Test(groups = {"TW"}, description = "TW Smoke Suite")//, retryAnalyzer = RetryAnalyser.class)
    public void SelectTwPlanAndCompleteCheckout() throws InterruptedException {
        gqp = productspage.ValidateMotorTWClick();
        reginfo = gqp.CreateQuoteWithoutRegNumber();
        Cdp = reginfo.CreateQuoteWithoutRegNumber(prop.getProperty("registrationlocation"));
        sqp = bdp.SaveBikeDetails(prop.getProperty("TW_Model"));
        tl.NameGenerator();
        sqp.SaveLead(tl.full_name);
        tl.NameGenerator();
        trp.SelectTWPlan();
        fwCheckout.comprehensiveCheckoutRelFW("test", "ABC");

    }

    @Test(groups = {"Health"}, description = "Health Smoke Suite")//, retryAnalyzer = RetryAnalyser.class)
    public void HealthResultAndCheckOutPage() throws InterruptedException, IOException {
        hpp.ValidateHealthClick();
        hiop.ValidateHealthInsuranceClick();
        tl.NameGenerator();
        healthprofilepage.CompleteHealthProfile(tl.full_name);
        healthresultpage.SelectPlanWithoutGotIt("Reliance Health Gain");
        healthresultpage.CompleteCheckOutDetails(tl.full_name);
    }


    @AfterMethod()
    public void Close() {
        //   driver.quit();
    }

}