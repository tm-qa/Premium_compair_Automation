package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.premiunPages.policybazarpage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class policybazar extends TestBase {

    policybazarpage pb;

    public policybazar()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        pb = new policybazarpage();

    }
    @Test
    public void totalPremi () throws InterruptedException {
        pb.pbdetails();
    }
}

