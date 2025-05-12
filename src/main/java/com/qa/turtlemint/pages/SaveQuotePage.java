package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveQuotePage extends TestBase {

    public SaveQuotePage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Save your quote now']")
    WebElement SaveQuoteLbl;

    @FindBy(xpath = "//input[@id='customerName']")
    WebElement name;

    @FindBy(id = "container-next-btn")
    WebElement NextButton;

    public ResultPage SaveLead(String LeadName) throws InterruptedException {

        TestUtil.sendKeys(name,LeadName,"Lead Name entered");
        TestUtil.click(NextButton,"Next Button");
        return new ResultPage();

    }
}
