package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;

import com.qa.turtlemint.premiunPages.insurancedekho_Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class InsuranceDekhoCOMP extends TestBase
{
    public insurancedekho_Page idp;
    public InsuranceDekhoCOMP()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException, IOException {
        initialization();
        idp = new insurancedekho_Page();


    }
    @Test
    public void totalPremi () throws InterruptedException {
        driver.get("https://pos.insurancedekho.com");
       // idp.loginID("9159358159");
        idp.loginID("7822002281");
        idp.premiumIDCOMP();

    }


}
