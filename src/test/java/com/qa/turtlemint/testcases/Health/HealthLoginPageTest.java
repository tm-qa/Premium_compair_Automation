package com.qa.turtlemint.testcases.Health;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CreateAnAccountPage;
import com.qa.turtlemint.pages.GrowPage;
import com.qa.turtlemint.pages.LoginPage;
import com.qa.turtlemint.pages.OTPScreenPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"healthlogin","all_verticals"})
public class HealthLoginPageTest extends TestBase {

    public LoginPage Loginpage;
    public OTPScreenPage OtpPage;
    public GrowPage growPage;
    public CreateAnAccountPage createaccount;

    public HealthLoginPageTest()
    {
        super();
    }

    @BeforeMethod()
    public void start()
    {
        initialization();
        Loginpage = new LoginPage();
        createaccount = new CreateAnAccountPage();
        createaccount.ValidateCreateAccountButton();
    }

    @Test()
    public void LoginFieldTest() throws InterruptedException {
        Loginpage.ValidateLoginPageTitle();
        Assert.assertEquals(driver.getTitle(), "Turtlemint Pro");
        growPage = Loginpage.ValidateLogin(prop.getProperty("username"), prop.getProperty("otp"));
    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}


