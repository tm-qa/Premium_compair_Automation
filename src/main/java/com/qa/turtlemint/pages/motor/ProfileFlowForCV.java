package com.qa.turtlemint.pages.motor;


import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ProfileFlowForCV extends TestBase {
    public ProfileFlowForCV() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement cartext;

    @FindBy(xpath = "//div[@class=\"getQuote\"]//button")
    WebElement quote;

    @FindBy(xpath = "//input[@placeholder=\"dd/mm/yyyy\"]")
    WebElement calender;

    @FindBy(xpath = "//div[text()='1']")
    WebElement date;

    @FindBy(xpath = "//*[text()=\"Private\"]")
    WebElement Private;

    @FindBy(xpath = "//*[text()=\"Public\"]")
    WebElement Public;

    @FindBy(xpath = "//span[text()='Next']//parent::button")
    WebElement next;

    @FindBy(xpath = "//span[text()='Comprehensive']")
    WebElement Tp;

    @FindBy(xpath = "//span[text()='Comprehensive']")
    WebElement Comprehensive;

    @FindBy(xpath = "//input[@placeholder=\"dd/mm/yyyy\"]")
    WebElement ExpDatePicker;

    @FindBy(xpath = "//div[@class=\"react-datepicker__day react-datepicker__day--030 react-datepicker__day--keyboard-selected react-datepicker__day--today\"]")
    WebElement DateSelect1;

    @FindBy(xpath = "//span[text()='Comprehensive']")
    WebElement PrevtypeTp;

    @FindBy(xpath = "//div[text()='Reliance']")
    WebElement ReliancePreferred;


    @FindBy(xpath = "//span[text()='No']")
    WebElement No;

    @FindBy(xpath = "(//span[text()='No'])[2]")
    WebElement No2;


    @FindBy(xpath = "//div[text()='20%']")
    WebElement select20;

    @FindBy(xpath = "//input[@type=\"search\"]")
    WebElement model;



    @FindBy(xpath = "//div[@title=\"2018\"]")
    WebElement s2021;

    @FindBy(xpath = "//div[text()='Bajaj Allianz']")
    WebElement bajaj;

    @FindBy(xpath = "//*[text()=\"Diesel\"]")
    WebElement Diesel;

    @FindBy(xpath = "//span[text()='Type name and select']//..//input")
    WebElement Var;

    @FindBy(xpath = "//div[@data-auto=\"variant-uiSelect\"]//div[@ng-repeat=\"option in $group.items\"]")
    WebElement VaNewr;



    @FindBy(xpath = "//span[text()='Eg. Truck']//..//input")
    WebElement SelectionType;

    @FindBy(xpath = "(//div[text()='Bulker / Closed'])[1]//..")
    WebElement TaxiType;

    @FindBy(xpath = "//span[text()='No']")
    WebElement no;

    @FindBy(xpath = "(//span[text()='No'])[2]")
    WebElement no1;

    @FindBy(xpath = "//span[contains(text(),'AX BS-II')]")
    WebElement seatingCapacity;

    @FindBy(xpath = "//span[text()='5']")
    WebElement FiveSeater;

    @FindBy(name = "cubicCapacity")
    WebElement cubiccapacity;

    @FindBy(xpath = "//span[contains(text(),'Taxi / Self Drive')]")
    WebElement bodytype;

    @FindBy(xpath = "//*[text()=\"No\"]")
    WebElement n0o;

    @FindBy(xpath = "//*[text()=\"Comprehensive\"]")
    WebElement radiobutton;

    @FindBy(xpath = "//*[text()=\"Yes\"]")
    WebElement yes;

    @FindBy(xpath = "//span[text()='Bajaj Allianz']")
    WebElement bajajj;

    @FindBy(xpath = "//*[text()=\"Type name or select\"]")
    WebElement varient;

    @FindBy(xpath = "(//*[text()=\"N6 iMT (998 CC)\"])[1]")
    WebElement cc;

    @FindBy(xpath = "//*[text()=\"Expiring today or tomorrow\"]")
    WebElement exp;

    @FindBy(xpath = "//a[normalize-space()='11']")
    WebElement dt;


    @FindBy(xpath = "//*[@placeholder=\"Reference Name\"]")
    WebElement leadname;

    @FindBy(xpath = "//span[text()=\"Goods Carrying Vehicles\"]")
    WebElement autos;

    TestUtil tl = new TestUtil();
    Actions act = new Actions(driver);

    public ProfileFlowPage comprehensive() throws InterruptedException {

     //   act.moveToElement(autos).click().build().perform();
        TestUtil.getScreenShot();

        TestUtil.click(autos,"TAXI clicked");

      //  cartext.sendKeys("MH02TP3059");

        tl.GenerateRegNo();

        TestUtil.sendKeys(cartext,"MH10CR2557","MH10CR2557 enterd");
        LogUtils.info("Registration Number entered");
        TestUtil.click(quote,"Clicked on Get Quote");
//        quote.click();
            TestUtil.click(calender,"Calender Clicked");
            Thread.sleep(2000);
            TestUtil.sendKeys(calender,"25/09/2018","Calender Clicked");
            Thread.sleep(2000);
            TestUtil.sendKeys(calender, String.valueOf(Keys.ENTER),"Calender Clicked");
            System.out.println("Try block run");

//        calender.click();
 //       TestUtil.click(date,"Date Selected");
//        date.click();

//        DatePicker.sendKeys("20/05/2019");
//        calender.click();
     //   TestUtil.click(Private,"Private Vehicle Selected");

        TestUtil.click(Public,"Public Vehicle Selected");


//        Private.click();
        TestUtil.click(next,"Next Button Clicked");
        TestUtil.click(Comprehensive,"Comprehensive");
        TestUtil.click(next,"Next Button Clicked");

//        Tp.click();
//        next.click();

        TestUtil.sendKeys(ExpDatePicker,TestUtil.PresentDate(),"Exp Date Calendar Opened");
        Thread.sleep(1000);
        ExpDatePicker.sendKeys(Keys.RETURN);
       // DateSelect1.click();
        Thread.sleep(1000);
        TestUtil.click(PrevtypeTp,"Prev type TP Selected");
        Thread.sleep(1000);
        TestUtil.click(No,"no");
        Thread.sleep(1000);
        TestUtil.click(select20,"select20");
        Thread.sleep(1000);
        TestUtil.click(bajaj,"bajaj");
        Thread.sleep(1000);
        TestUtil.click(No2,"no");
        //next.click();
        TestUtil.click(next,"Next Button Clicked");

        TestUtil.click(ReliancePreferred,"Reliance Preferred Clicked");
        TestUtil.click(next,"Next Button Clicked");
        //ReliancePreferred.click();
        //next.click();

 //       TestUtil.click(pcv,"PCV Selected");

        Thread.sleep(2000);
//        pcv.click();
        TestUtil.sendKeys(model,"TATA","Car Model Typed");
        Thread.sleep(2000);
        TestUtil.sendKeys(model, String.valueOf(Keys.RETURN),"Car Model Typed");

//        model.sendKeys("Dzire");
 //       TestUtil.click(sel,"Car Model Selected");

//        sel.click();
        TestUtil.click(s2021,"Year Selected");

 //       s2020.click();
        TestUtil.click(Diesel,"Diesel selected");
        Thread.sleep(2000);
  //      TestUtil.click(Var,"variant Selected");
        TestUtil.sendKeys(Var,"Ace mega xl","");

        Thread.sleep(2000);
        TestUtil.sendKeys(Var, String.valueOf(Keys.RETURN),"Car Model Typed");

 //       TestUtil.click(VaNewr,"variant Selected");




       // TestUtil.click(seatingCapacity,"AX BS-II Select");
        Thread.sleep(1000);

        TestUtil.click(SelectionType,"SelectionType");
        Thread.sleep(1000);
        TestUtil.sendKeys(SelectionType,"bul","SelectionType");
        Thread.sleep(1000);
        TestUtil.sendKeys(SelectionType,String.valueOf(Keys.RETURN),"SelectionType");
        Thread.sleep(1000);
       // TestUtil.click(TaxiType,"TaxiType");
       // SelectionType.click();
        Thread.sleep(1000);
        //TaxiType.click();
 //       petrol.click();

        TestUtil.click(no,"no Selected");

        TestUtil.click(no1,"no Selected");

 //       TestUtil.sendKeys(cubiccapacity,"1200","1200 CC Selected");

//        cubiccapacity.sendKeys("1200");
 //       Thread.sleep(2000);
//        TestUtil.click(bodytype,"Bodytype Selected");

//        bodytype.click();
        Thread.sleep(2000);
  //      TestUtil.click(no,"Click on Not a Trailer");




        TestUtil.click(next,"Clicked Next Button");

// //       next.click();
//        TestUtil.click(radiobutton,"Radio Button Selected");
//
// //       radiobutton.click();
//        Thread.sleep(2000);
//        next.click();
//        LogUtils.info("Clicked Next Button");

        Thread.sleep(4000);
//        exp.click();
//        Thread.sleep(2000);
//        calender.click();
//        dt.click();
//        Thread.sleep(2000);
//        LogUtils.info("Date Selected");
//        radiobutton.click();
//        Thread.sleep(2000);
//        yes.click();
//        LogUtils.info("Previous Policy Claimed ? Yes Selected!");
//        Thread.sleep(3500);
// //       bajaj.click();
////        Thread.sleep(3500);
//        Thread.sleep(4000);
//        TestUtil.click(next,"Next Button Pressed, now moving to lead name page..");
        TestUtil.sendKeys(leadname,"Automation Test","Lead Name Entered");

 //       leadname.sendKeys("test");
        TestUtil.click(next,"Moving to Results Page...");


        LogUtils.info("Comprehensive Profile Done");
        Thread.sleep(10000);
        return null;
    }
}
