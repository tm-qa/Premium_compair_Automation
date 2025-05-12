package com.qa.turtlemint.testcases.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.Ninja.NinjaBranchIssuanceMotorPage;
import com.qa.turtlemint.pages.Ninja.NinjaLoginPage;
import com.qa.turtlemint.pages.Ninja.NinjaMISMotorPage;
import com.qa.turtlemint.util.RetryAnalyser;
import com.qa.turtlemint.util.iTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(iTestListener.class)
@Test(groups = {"Ninja_Suite"}, description = "Ninja entire smoke suite")

public class NinjaFull extends TestBase {

    public NinjaBranchIssuanceMotorPage branchissuance;
    public NinjaLoginPage ninjaloginpage;
    public NinjaMISMotorPage mismotorpage;


    @BeforeMethod()
    public void start() throws Exception {
        initialization();
        ninjaloginpage = new NinjaLoginPage();
        branchissuance = new NinjaBranchIssuanceMotorPage();
        mismotorpage = new NinjaMISMotorPage();

       // ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

    }

    @Test(groups = {"Ninjalogin"},description = "Ninja Login Functionality Test")
    public void LoginFieldTest() throws Exception {
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));
        System.out.println("Ninja Login Flow Completed");

    }

    @Test(groups = {"tw"},description = "Ninja Branch Issuance FW Flow Test", retryAnalyzer = RetryAnalyser.class)
    public void MotorBIFlowMotor() throws Exception {
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

        branchissuance.NinjaBranchIssuanceFlow();
    }

    @Test(groups = {"motorBI"},description = "Ninja Branch TW Issuance Flow Test", retryAnalyzer = RetryAnalyser.class)
    public void MotorBIFlowTW() throws Exception {
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

        branchissuance.NinjaBranchIssuanceFlow();
    }


    @Test(priority = 0, groups = {"mis"},description = "Ninja MIS Flow Test", retryAnalyzer = RetryAnalyser.class)
    public void MisDetail() throws Exception {
        ninjaloginpage.NinjaValidateLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));

        mismotorpage.NinjaMISFlow();
    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }
}
