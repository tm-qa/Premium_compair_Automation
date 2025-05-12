package com.qa.turtlemint.pages.Health;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthProfilePage extends TestBase {

    @FindBy(xpath ="//span[text()='Male']")
    WebElement SelectGender;

    @FindBy(xpath ="//span[text()='Bike']")
    WebElement tw;

    @FindBy(xpath ="//span[text()='Self']")
    WebElement SelectInsuredPerson;

    @FindBy(xpath ="//label[text()='Wife']")
    WebElement SelectInsuredPersonWife;

    @FindBy(xpath ="//span[text()='Next']//parent::button")
    WebElement NextBtn;

    @FindBy(xpath = "//input[@type='search']")
    WebElement SelfClick;

    @FindBy(xpath ="//div[text()='22 years']")
    WebElement SelectSelfAge;

    @FindBy(xpath = "//input[@inputmode=\"numeric\"]")
    WebElement Pincode;

    @FindBy(xpath = "//span[text()='Skip']")
    WebElement SkipBtn;

    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    WebElement Name;
   @FindBy(xpath = "//span[@class=\"ant-select-selection-placeholder\"]//parent::div//input")
   WebElement SearchAge;
    public HealthProfilePage()
    {
        PageFactory.initElements(driver, this);
    }


    public HealthResultPage CompleteHealthProfile(String LeadName) throws InterruptedException {

        TestUtil.click(SelectGender,"Gender Selected");
        TestUtil.click(SelectInsuredPerson,"Insured Person Selected");
        TestUtil.click(NextBtn,"Next Button Clicked...");
        Thread.sleep(2000);
        TestUtil.click(SelfClick,"");
        TestUtil.click(SelectSelfAge,"");
        TestUtil.click(NextBtn,"Age Screen Passed");
        //TestUtil.click(NextBtn,"Child planning screen Passed");
        TestUtil.click(NextBtn,"Diseases Screen Passed");
        TestUtil.sendKeys(Pincode,"400001","Pincode Entered");
        TestUtil.click(NextBtn,"");// Pin code screen
//        TestUtil.click(SkipBtn,"Skipped Preferred Hospital");// Preferred hospital
//        TestUtil.click(SkipBtn,"");// income
        TestUtil.sendKeys(Name,LeadName,"Name Passed on the Lead Name Page");
        TestUtil.click(NextBtn,"");//name screen

        return new HealthResultPage();

    }

}
