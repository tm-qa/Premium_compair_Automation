package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;

import com.qa.turtlemint.premiunPages.insurancedekho_Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class InsuranceDekho extends TestBase
{
    public insurancedekho_Page idp;
    public InsuranceDekho()
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
        idp.loginID("9159358159");
        idp.premiumID();

    }


}
