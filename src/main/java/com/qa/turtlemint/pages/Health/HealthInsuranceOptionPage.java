package com.qa.turtlemint.pages.Health;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.GetQuotePage;
import com.qa.turtlemint.pages.ProductsPage;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthInsuranceOptionPage extends TestBase {
    @FindBy(xpath ="//div[text()='Health Insurance']")
    WebElement HealthInsurance;

    public HealthInsuranceOptionPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateProductsPageTitle()
    {
        return driver.getTitle();
    }

    public ProductsPage ValidateLogin() throws InterruptedException {

        return new ProductsPage();

    }

    public HealthProfilePage ValidateHealthInsuranceClick() throws InterruptedException {
        Thread.sleep(5000);
        TestUtil.click(HealthInsurance,"Health Insurance");
        return new HealthProfilePage();
    }
}
