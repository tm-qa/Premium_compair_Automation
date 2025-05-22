package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.premiunPages.turtlemint_page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TurtlemintCOMP extends TestBase {

    public turtlemint_page tmp;

    public TurtlemintCOMP() {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException, IOException {
        initialization();
        tmp = new turtlemint_page();

    }

    @Test
    public void PremiumTm() throws InterruptedException {
        driver.get("https://app.mintpro.in/signup");
        tmp.logintm();
        tmp.Comppremiumtm();
    }
}
