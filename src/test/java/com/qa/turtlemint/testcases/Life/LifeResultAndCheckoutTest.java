package com.qa.turtlemint.testcases.Life;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import com.qa.turtlemint.pages.Life.LifeGetQuotePage;
import com.qa.turtlemint.pages.Life.LifeResultPage;
import com.qa.turtlemint.util.RetryAnalyser;
import com.qa.turtlemint.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Test(groups = {"life", "all_verticals"}, description = "Life Vertical End to End")
public class LifeResultAndCheckoutTest extends TestBase {

    public LoginPage Loginpage;
    public OTPScreenPage OtpPage;
    public CreateAnAccountPage createaccount;
    public GrowPage growPage;
    public SellPage sellPage;
    ProductsPage productspage;
    LifeResultPage liferesultpage;
    LifeGetQuotePage lqp;
    public static TestUtil tl;

    public LifeResultAndCheckoutTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws Exception {
        initialization();
        createaccount = new CreateAnAccountPage();
        Loginpage = new LoginPage();
        lqp = new LifeGetQuotePage();
        liferesultpage = new LifeResultPage();

       // Loginpage = createaccount.ValidateCreateAccountButton();
        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
        productspage = growPage.ValidateLogin();
        lqp.LifeRedirection();
    }


    @Test(description ="Life Vertical Login to Payment Page", retryAnalyzer = RetryAnalyser.class)
    public void CompleteResultAndCheckOutPage() throws Exception {
        liferesultpage.LifeResultPage();
        Thread.sleep(3000);
        liferesultpage.LifeCheckoutPage();
    }

    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}
