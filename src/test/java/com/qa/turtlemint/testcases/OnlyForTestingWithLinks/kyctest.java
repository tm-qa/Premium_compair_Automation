package com.qa.turtlemint.testcases.OnlyForTestingWithLinks;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CreateAnAccountPage;
import com.qa.turtlemint.pages.GrowPage;
import com.qa.turtlemint.pages.KYC.Kyc;
import com.qa.turtlemint.pages.LoginPage;
import com.qa.turtlemint.pages.OTPScreenPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class kyctest extends TestBase {
    public LoginPage Loginpage;
    public OTPScreenPage OtpPage;
    public GrowPage growPage;
    public CreateAnAccountPage createaccount;
    Kyc kyc;

    public kyctest()
    {
        super();
    }

    @BeforeMethod()
    public void start()
    {
        initialization();
        Loginpage = new LoginPage();
        kyc = new Kyc();

        createaccount = new CreateAnAccountPage();
        createaccount.ValidateCreateAccountButton();
    }

    @Test
    public void LoginFieldTest() throws InterruptedException {
        driver.get("https://kyc.turtlemint.com/insurance/kyc/form?applicationId=44fdce18-4824-4336-94d8-e2e74ae614f7&broker=turtlemint&token=ZXlKaGJHY2lPaUpJVXpVeE1pSjkuZXlKemRXSWlPaUkwTkdaa1kyVXhPQzAwT0RJMExUUXpNell0T1RSa09DMWxNbVUzTkdGbE5qRTBaamM2TkRJek9UWmlNR010TkdKaFl5MDBZVFJpTFdJd01ESXRNbUZsWXprM016Qm1NMkV3SWl3aVpYaHdJam94TmpjeU56TXhORFEwTENKcFlYUWlPakUyTnpJM016RXhORFFzSW1wMGFTSTZJa2RXTlZkUFZFaElRbEFpZlEuZ0QtWnBhVDFSY3Nod2gtT01rbmxMNHhRVmJtYXNQdGYxRnZINEE5aTVYYVFJeHVOU2hTelJVZ2pfaGJmTnVtSUNFNTczM3l3cWRrRk1FX3lJQ1JieVE=");
        kyc.KycFormFilling();
    }


    @AfterMethod()
    public void Close()
    {
        driver.quit();
    }

}

