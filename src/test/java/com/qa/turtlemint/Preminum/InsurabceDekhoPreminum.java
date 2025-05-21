package com.qa.turtlemint.Preminum;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.CarDetailsPage;
import com.qa.turtlemint.pages.CreateAnAccountPage;
import com.qa.turtlemint.pages.LoginPage;
import com.qa.turtlemint.pages.RegistrationInfoPage;
import com.qa.turtlemint.premiunPages.insurancedekho_Page;
import com.qa.turtlemint.premiunPages.renewbuy_page;
import com.qa.turtlemint.premiunPages.turtlemint_page;
import com.qa.turtlemint.util.TestUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.qa.turtlemint.base.TestBase.initialization;

public class InsurabceDekhoPreminum extends TestBase
{
    public insurancedekho_Page insurancedekho;
    public turtlemint_page turtlemint ;
    public renewbuy_page renewbuyPage;
    public LoginPage Loginpage;
    public InsurabceDekhoPreminum()
    {
        super();
    }

    @BeforeMethod()
    public void start() throws InterruptedException, IOException {
        initialization();
        insurancedekho = new insurancedekho_Page();
        turtlemint = new turtlemint_page();
        renewbuyPage = new renewbuy_page();
        Loginpage = new LoginPage();

    }
    @Test
    public void totalPremi () throws InterruptedException {
        Loginpage.LoginInsurancedekho("9159358159");
        insurancedekho.iddekho();

    }
    @Test
    public void totalPremiTm () throws InterruptedException {
        turtlemint.login();
    }
    @Test
    public void totalPremiRenewBuy () throws InterruptedException, IOException {
        renewbuyPage.logIn();
        renewbuyPage.motorPreminum();

    }

}
