package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.premiunPages.policybazar_page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PolicyBazarTP extends TestBase {

    policybazar_page pbp;

    public PolicyBazarTP() {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        pbp = new policybazar_page();


    }

    @Test
    public void totalPremi() throws InterruptedException, IOException {
        driver.get("https://www.pbpartners.com/");
        pbp.logininPB();
        pbp.premiumPBTP();
    }
}

