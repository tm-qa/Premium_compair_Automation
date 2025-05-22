package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.premiunPages.renewbuy_page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class RenewBuy extends TestBase {

    public renewbuy_page rbp;

    public RenewBuy() {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException, IOException {
        initialization();
        rbp = new renewbuy_page();


    }

    @Test
    public void PremiumRB() throws InterruptedException, IOException {
        driver.get("https://partners.renewbuy.com/v2/");
        rbp.loginRB();
        rbp.premiumRB();

    }
}
