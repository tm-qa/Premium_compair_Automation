package com.qa.turtlemint.pages.Mintpro;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.ProductsPage;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MintproGrowPage extends TestBase {

    TestUtil tl = new TestUtil();

    public MintproGrowPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Grow']")
    WebElement GrowButton;


    @FindBy(xpath = "//*[text()='Leads']")
    WebElement LeadsButton;

   // @FindBy(xpath = "//*[text()='Renewals']")
   // WebElement RenewalsButton;

    @FindBy(xpath = "//a[@href='https://app.mintpro.in/vertical-redirect/mintpro?redirect=/renewaldashboard']//span[@class='icon']//img")
    WebElement RenewalsButton;



    @FindBy(xpath = "//span[@class='headerLinkTitle'][normalize-space()='Profile']")
    WebElement ProfileButton;

    @FindBy(xpath = "//span[normalize-space()='Business']")
    WebElement BizButton;

    @FindBy(xpath = "//span[@class='textName'][normalize-space()='Activity Points']")
    WebElement ActivityPointsButton;

    @FindBy(xpath = "//span[contains(text(),'Grow')]")
    WebElement GrowFinal;

    @FindBy(xpath = "//*[text()='My Rewards']")
    WebElement MyRewardButton;


    @FindBy(xpath = "//div[@id='flyy-close-image']")
    WebElement Closereward;


    public ProductsPage ValidateGrowPage() throws Exception {
        TestUtil.click(GrowButton,"First Time Grow Button Clicked");
        TestUtil.click(ProfileButton,"Profile Page Checked now and Screenshot Taken...");
        tl.takeSnapShot(driver,"/tmp/"+tl.getTimeStamp()+ "b.png");
        TestUtil.click(GrowButton,"Grow Button Clicked again to come back");
        TestUtil.click(LeadsButton,"Now Lead Page Verified");
        tl.takeSnapShot(driver,"/tmp/"+tl.getTimeStamp()+ "c.png");
        LogUtils.info("Lead Page's screenshot taken");
        Thread.sleep(6000);
        TestUtil.click(GrowButton,"Grow button clicked after lead page");
//        TestUtil.click(RenewalsButton,"Renewals Page is being checked now...");
//        Thread.sleep(10000);
       // LogUtils.info("Final Time Grow Button Clicked");
//        RenewalsButton.click();
//        driver.get("https://app.mintpro.in/dashboard?filterBy=renewals");
//        LogUtils.info("Renewals Page is being checked now...");
        Thread.sleep(7000);
//        LogUtils.info("Renewals Page verified.");
        tl.takeSnapShot(driver,"/tmp/"+tl.getTimeStamp()+ "d.png");
        TestUtil.click(BizButton,"Trying to select Activity Points");
       TestUtil.click(ActivityPointsButton,"ActivityPoints Page is being checked...");
       Thread.sleep(5000);
        LogUtils.info("ActivityPoints Page verified");
         tl.takeSnapShot(driver,"/tmp/"+tl.getTimeStamp()+ "e.png");
        TestUtil.click(GrowFinal,"Final Grow Page");
        Thread.sleep(5000);
        tl.takeSnapShot(driver,"/tmp/"+tl.getTimeStamp()+ "f.png");




        return new ProductsPage();

    }
}

