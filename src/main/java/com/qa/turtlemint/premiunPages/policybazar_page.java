package com.qa.turtlemint.premiunPages;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Set;

public class policybazar_page extends TestBase {


    @FindBy(xpath = "//small[text()=\"Car\"]//parent::a")
    WebElement selectCar;
    @FindBy(xpath = "//input[@id=\"regNoTextBox\"]")
    WebElement regisnumber;
    @FindBy(xpath = "//button[@id=\"btnGetQuotes\"]")
    WebElement viewprice;
    @FindBy(xpath = "//span[text()=\"VIEW QUOTES\"]//parent::button")
    WebElement viewpquotes;
    @FindBy(xpath = "//input[@name='Existing Policy Expiry Date']")
    WebElement calendar;
    @FindBy(xpath = "//option[text()='2025']")
    WebElement year;
    @FindBy(xpath = "//option[text()='January']")
    WebElement month;
    @FindBy(xpath = "//label[text()=\"Third Party Only\"]//following-sibling::label[@class=\"switch\"]")
   WebElement tpcomptoggle ;

    public policybazar_page() {
        PageFactory.initElements(driver, this);
    }

    public void logininPB(){

    }

public void premiumPB(){
    TestUtil.click(selectCar,"");
    Set<String> windowHandles = driver.getWindowHandles();
    ArrayList<String> tabs = new ArrayList<>(windowHandles);
    driver.switchTo().window(tabs.get(1));
    TestUtil.sendKeys(regisnumber,"MH43AJ7461","");
    TestUtil.click(viewprice,"");
    String futuredate = TestUtil.ninjaFutureDate(3);
    TestUtil.sendKeys(calendar,futuredate,"entered");
    TestUtil.click(viewpquotes,"");

   }

}
