package com.qa.turtlemint.testcases.Mintpro;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.*;
import com.qa.turtlemint.pages.Mintpro.MintproGrowPage;
import com.qa.turtlemint.util.RetryAnalyser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"mintpro", "all_verticals"}, description = "Mintpro Page")
public class MintproGrowPageTest extends TestBase{
    public LoginPage loginPage;
    public OTPScreenPage otpScreenPage;
    public CreateAnAccountPage createAccount;
    public GrowPage growPage;
    public MintproGrowPage mintproGrowPage;
    public ProductsPage productsPage;
    public MintproGrowPageTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        createAccount = new CreateAnAccountPage();
        loginPage = new LoginPage();
        growPage = new GrowPage();
       loginPage = createAccount.ValidateCreateAccountButton();
       growPage = loginPage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
       // productsPage = growPage.ValidateLogin();
        mintproGrowPage = new MintproGrowPage();
//        registrationProfileFlowPage = new RegistrationProfileFlowPage();
    }
    @Test(description = "Mintpro Grow Page Test", retryAnalyzer = RetryAnalyser.class)
    public void GrowPage() throws Exception {
        Thread.sleep(3000);
        mintproGrowPage.ValidateGrowPage();
    }

}
