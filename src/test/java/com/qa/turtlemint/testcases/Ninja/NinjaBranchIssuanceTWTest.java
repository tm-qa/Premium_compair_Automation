package com.qa.turtlemint.testcases.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.Ninja.NinjaBranchIssuanceTWPage;
import com.qa.turtlemint.pages.Ninja.NinjaLoginPage;
import com.qa.turtlemint.util.RetryAnalyser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test(groups = {"ninja_bi", "ninja","ninja_bi_tw"}, description = "Ninja Branch Issuance End to End Flow")
public class NinjaBranchIssuanceTWTest extends TestBase {

    public NinjaBranchIssuanceTWPage branchissuance;
    public NinjaLoginPage ninjaloginpage;


    public NinjaBranchIssuanceTWTest()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws Exception {
        initialization();
        ninjaloginpage= new NinjaLoginPage();
        branchissuance=new NinjaBranchIssuanceTWPage();
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

    }

    @Test(description = "Ninja Branch Issuance TW Flow Test",retryAnalyzer = RetryAnalyser.class)
    public void MotorBIFlow() throws InterruptedException {

        branchissuance.NinjaBranchIssuanceFlow();



    }

    @AfterMethod()
    public void Close()
    {driver.quit();}
}