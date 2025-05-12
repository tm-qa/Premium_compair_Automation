package com.qa.turtlemint.testcases.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.Ninja.NinjaLoginPage;
import com.qa.turtlemint.pages.Ninja.NinjaMISMotorPage;
import com.qa.turtlemint.util.RetryAnalyser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"ninja_mis","ninja"}, description = "Ninja MIS End to End Flow")
public class NinjaMISMotorTest extends TestBase {

    public NinjaMISMotorPage mismotorpage;
    public NinjaLoginPage ninjaloginpage;


    public NinjaMISMotorTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws Exception {
        initialization();
        ninjaloginpage= new NinjaLoginPage();
        mismotorpage=new NinjaMISMotorPage();
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

    }

    @Test(description = "Ninja MIS Flow Test", retryAnalyzer = RetryAnalyser.class)
    public void SaveCarDetail() throws InterruptedException {

        mismotorpage.NinjaMISFlow();

    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}
