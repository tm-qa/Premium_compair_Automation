package com.qa.turtlemint.testcases.Ninja;

import com.qa.turtlemint.base.TestBase;

import com.qa.turtlemint.pages.Ninja.NinjaLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"ninja_login","ninja"},description = "Ninja Login")
public class NinjaLoginPageTest extends TestBase {

    public NinjaLoginPage ninjaloginpage;


    public NinjaLoginPageTest()
    {
        super();
    }

    @BeforeMethod()
    public void start()
    {
        initialization();
        ninjaloginpage = new NinjaLoginPage();

    }

    @Test(description = "Ninja Login Functionality Test")
    public void LoginFieldTest() throws Exception {
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}

