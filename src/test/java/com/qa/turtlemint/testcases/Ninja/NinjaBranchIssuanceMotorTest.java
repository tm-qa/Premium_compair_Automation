package com.qa.turtlemint.testcases.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.Ninja.NinjaBranchIssuanceMotorPage;
import com.qa.turtlemint.pages.Ninja.NinjaLoginPage;
import com.qa.turtlemint.util.RetryAnalyser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


@Test(groups = {"ninja_bi", "ninja"}, description = "Ninja Branch Issuance End to End Flow")
public class NinjaBranchIssuanceMotorTest extends TestBase {

    public NinjaBranchIssuanceMotorPage branchissuance;
    public NinjaLoginPage ninjaloginpage;


    public NinjaBranchIssuanceMotorTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws Exception {
        initialization();
        ninjaloginpage= new NinjaLoginPage();
        branchissuance=new NinjaBranchIssuanceMotorPage();
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

    }

    @Test(description = "Ninja Branch Issuance Motor Flow Test",retryAnalyzer = RetryAnalyser.class)
    public void MotorBIFlow() throws InterruptedException, IOException {
        branchissuance.NinjaBranchIssuanceFlow();

    }

    @AfterMethod()
    public void Close()
    { driver.quit();
    }
}