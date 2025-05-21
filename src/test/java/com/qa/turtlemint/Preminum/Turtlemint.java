package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.premiunPages.turtlemint_page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Turtlemint extends TestBase {

    public turtlemint_page tmp;

    public Turtlemint() {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException, IOException {
        initialization();
        tmp = new turtlemint_page();


    }

    @Test
    public void PremiumTm() throws InterruptedException {
        tmp.logintm();
        tmp.premiumtm();
    }
}
