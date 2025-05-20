package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CarDetailsPage;
import com.qa.turtlemint.pages.CreateAnAccountPage;
import com.qa.turtlemint.pages.LoginPage;
import com.qa.turtlemint.pages.RegistrationInfoPage;
import com.qa.turtlemint.premiunPages.insurancedekho_Page;
import com.qa.turtlemint.util.TestUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.turtlemint.base.TestBase.initialization;

public class InsurabceDekhoPreminum extends TestBase
{
    public insurancedekho_Page insurancedekho;
    LoginPage lp;

    public InsurabceDekhoPreminum()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException {
        initialization();
        insurancedekho = new insurancedekho_Page();
        lp = new LoginPage();

    }
    @Test
    public void totalPremi () throws InterruptedException {
        lp.LoginInsurancedekho("9159358159","");
        insurancedekho.iddekho();
    }
}
