package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.LoginPage;
import com.qa.turtlemint.premiunPages.policybazarpage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class policybazar extends TestBase {

    policybazarpage pb;
    LoginPage lp;

    public policybazar()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        pb = new policybazarpage();
        lp = new LoginPage();

    }
    @Test
    public void totalPremi () throws InterruptedException {
        pb.pbdetails();
    }
}

