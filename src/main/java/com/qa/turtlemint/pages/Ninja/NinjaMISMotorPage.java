package com.qa.turtlemint.pages.Ninja;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NinjaMISMotorPage extends TestBase {

    @FindBy(xpath = "(//a[@data-auto=\"mis-module\"])[2]")
    WebElement MISBtn;

    @FindBy(xpath = "//div[@id=\"root\"]//span[@class=\"anticon\"]//img[@alt=\"Plus\"]")
    WebElement AddNewtASale;

    @FindBy(xpath = "//input[@id=\"createMISEntry_productCategory\"]//parent::span//parent::div")
    WebElement productCategory;

    @FindBy(xpath = "//input[@id=\"createMISEntry_policyStatus\"]//parent::span//parent::div")
    WebElement policyStatus;

    @FindBy(xpath = "//input[@id=\"createMISEntry_insurer\"]")
    WebElement insurerss;

    @FindBy(xpath = "//input[@id=\"createMISEntry_vehicleType\"]//parent::span//parent::div")
    WebElement vehicleType;

    @FindBy(xpath = "//div[@title=\"TW\"]")
    WebElement twVerticle;
    @FindBy(xpath = "//div[@title=\"Issued\"]")
    WebElement issued;
    @FindBy(xpath = "//div[@title=\"NAVI General Insurance\"]")
    WebElement insurerHdfc;
    @FindBy(xpath = "//div[@id=\"createMISEntry_vehicleType_list\"]//following-sibling::div//div[@title=\"TW\"]")
    WebElement vehicleTypeList;

    @FindBy(xpath = "//button[text()=\"Create Sale\"]")
    WebElement createSaleButton;
    @FindBy(xpath = "//input[@id=\"Motor_turtlemintBrokerCode\"]//parent::span")
    WebElement turtlemintBrokerCode;
    @FindBy(xpath = "//input[@name=\"policyNumber\"]")
    WebElement policyNumber;
    @FindBy(xpath = "//input[@id=\"Motor_businessType\"]//parent::span")
    WebElement businessType;
    @FindBy(xpath = "//div[@title=\"New\"]")
    WebElement getBusinessType;
    @FindBy(xpath = "//input[@id=\"Motor_issuanceDate\"]")
    WebElement issuanceDate;
    @FindBy(xpath = "//a[text()=\"Today\"]")
    WebElement getIssuanceDate;
    @FindBy(xpath = "//input[@id=\"Motor_proposer.title\"]//parent::span")
    WebElement proposerTitle;
    @FindBy(xpath = "//div[@title=\"Mr\"]")
    WebElement getProposerTitle;

    @FindBy(xpath = "//input[@name=\"proposer.fName\"]")
    WebElement customerFirstName;
    @FindBy(xpath = "//input[@name=\"proposer.mobile\"]")
    WebElement customerMobile;
    @FindBy(xpath = "//input[@name=\"proposer.email\"]")
    WebElement customerEmail;
    @FindBy(xpath = "//input[@name=\"proposer.address\"]")
    WebElement customerAddress;
    @FindBy(xpath = "//input[@name=\"Registration Pincode\"]")
    WebElement pincode;
    @FindBy(xpath = "//input[@name=\"proposer.registrationCity\"]")
    WebElement customerCity;
    @FindBy(xpath = "//input[@name=\"proposer.registrationState\"]")
    WebElement CustomerState;
    @FindBy(xpath = "//input[@id=\"Motor_productName\"]//parent::span")
    WebElement productName;
    @FindBy(xpath = "//div[@title=\"Comprehensive\"]")
    WebElement getProductName;

    @FindBy(xpath = "//input[@id=\"Motor_vehicleSubType\"]//parent::span")
    WebElement vehicleSubType;
    @FindBy(xpath = "//div[@title=\"Bike\"]")
    WebElement getVehicleSubType;

    @FindBy(xpath = "//input[@id=\"registrationNo\"]")
    WebElement registrationNo;


    @FindBy(xpath = "//div[@id=\"Motor_policyRisk.rtoLocation\"]//input")
    WebElement rtoLocation;
    @FindBy(xpath = "//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[1]")
    WebElement selectRto;
    @FindBy(xpath = "//div[@id=\"Motor_makemodel\"]//input")
    WebElement makeModel;
    @FindBy(xpath = "//div[text()=\"TVS Star City Plus\"]")
    WebElement tvs;
    @FindBy(xpath = "//input[@id=\"cubicCapacity\"]")
    WebElement capacity;
    @FindBy(xpath = "//input[@id=\"fuelType\"]")
    WebElement fuelType;
    @FindBy(xpath = "//input[@id=\"manufactureYear\"]")
    WebElement manufYear;
    @FindBy(xpath = "//input[@id=\"engineNo\"]")
    WebElement engineNo;
    @FindBy(xpath = "//input[@id=\"chassisNo\"]")
    WebElement classisNo;
    @FindBy(xpath = "//input[@id=\"seatingCapacity\"]")
    WebElement seatingCap;
    @FindBy(xpath = "//input[@id=\"NCB\"]")
    WebElement ncb;
    @FindBy(xpath = "//input[@id=\"SumInsured\"]")
    WebElement sumInsured;

    @FindBy(xpath = "//input[@id=\"BasicODPremium\"]")
    WebElement basucOd;
    @FindBy(xpath = "//input[@id=\"Total OD Premium\"]")
    WebElement totalOdPremium;
    @FindBy(xpath = "//input[@id=\"BasicTPPremium\"]")
    WebElement getBasicTPPremium;


    @FindBy(xpath = "//input[@id=\"TotalTPPremium\"]")
    WebElement getTotalOdPremium;

    @FindBy(xpath = "//input[@id=\"NetPremium\"]")
    WebElement netPremium;
    @FindBy(xpath = "//input[@id=\"ServiceTax\"]")
    WebElement serviceTax;
    @FindBy(xpath = "//input[@id=\"GrossPremium\"]")
    WebElement grossPreminum;
    @FindBy(xpath = "//input[@id=\"Motor_manualQCStatus\"]")
    WebElement qcStatus;
    @FindBy(xpath = "//div[text()=\"Pending\"]")
    WebElement qcSttausDone;
    @FindBy(xpath = "//input[@id=\"Motor_channelType\"]")
    WebElement channelType;
    @FindBy(xpath = "//div[text()=\"Website\"]")
    WebElement website;

    @FindBy(xpath = "(//button[@class=\"ant-picker-header-prev-btn\"])[3]")
    WebElement pastDate;
    @FindBy(xpath = "//input[@type=\"file\"]")
    WebElement uplodFile;
    @FindBy(xpath = "//span[text()=\"Policy\"]")
    WebElement selectTag;
    @FindBy(xpath = "//button[text()=\"OK\"]")
    WebElement ok;
    @FindBy(xpath = "//button[text()=\"Save Sale\"]")
    WebElement saveSale;
    @FindBy(xpath = "(//div[text()=\"24\"])[3]")
    WebElement getSalesdate;




    public NinjaMISMotorPage() {
        PageFactory.initElements(driver, this);
    }

    public void NinjaMISFlow() throws InterruptedException {
        Thread.sleep(2000);
        TestUtil.click(MISBtn,"click on mis button");
        Thread.sleep(2000);
        TestUtil.getScreenShot();
        System.out.println(driver.getCurrentUrl());
        String a  = driver.getCurrentUrl();
        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
        driver.get(a);
        TestUtil.click(AddNewtASale, "MIS Button clicked");
      TestUtil.click(productCategory,"click");
      TestUtil.getScreenShot();
//      TestUtil.click(twVerticle, "jhsgd");
//      TestUtil.click(policyStatus,"click on policy status ");
//      TestUtil.click(issued,"click on issued");
//      TestUtil.sendKeys(insurerss , "NAVI General Insurance","NAVI General Insurance");
//      TestUtil.click(insurerHdfc,"click on vehicle type");
//      TestUtil.click(vehicleType,"click on vehicle type");
//      TestUtil.click(vehicleTypeList,"tw");
//      TestUtil.click(createSaleButton , "click on create a sale button");
//      Thread.sleep(200);
//
//      TestUtil.click(turtlemintBrokerCode,"gdg");
//        Thread.sleep(2000);
//        String policyNumb = TestUtil.generateRandomPolicyNo(12);
//      TestUtil.sendKeys(policyNumber,policyNumb,"enter policy number");
//      TestUtil.click(businessType, "click on business type");
//        TestUtil.click(getBusinessType, "select business type");
//        Thread.sleep(1000);
//        TestUtil.click(issuanceDate,"jhgsad");
//        Thread.sleep(1000);
//        TestUtil.click(getIssuanceDate,"shgdj");
//
//        TestUtil.click(proposerTitle,"click on proposer Title");
//        TestUtil.click(getProposerTitle,"click on proposer Title");
//        Thread.sleep(2000);
//        TestUtil.sendKeys(customerFirstName,"automation test","enter customer 1st name");
//        TestUtil.sendKeys(customerMobile,"69999912345","enter mobile number");
//        TestUtil.sendKeys(customerEmail,"test@test.com","enter mobile number");
//        TestUtil.sendKeys(customerAddress,"address entered","enter mobile number");
//        TestUtil.sendKeys(pincode,"400017","enter mobile number");
//
//        TestUtil.click(productName,"click on product name");
//        TestUtil.click(getProductName,"entered product name");
//
//        TestUtil.click(vehicleSubType,"click on vehicle sub type");
//        TestUtil.click(getVehicleSubType,"select vehicle sub type");
//
//        TestUtil.sendKeys(registrationNo,policyNumb,"registration no");
//
//        TestUtil.sendKeys(rtoLocation,"pune","click on rto location");
//      Thread.sleep(2000);
//        TestUtil.sendKeys(makeModel,"TVS Star City Plus","click on make model");
//        TestUtil.click(tvs,"click on tvs");
//        Thread.sleep(2000);
//        TestUtil.sendKeys(capacity,"3","capacity");
//        TestUtil.sendKeys(fuelType,"petrol","fuel type");
//        TestUtil.sendKeys(manufYear,"2019","enterd manuafacturing year");
//        TestUtil.sendKeys(engineNo,policyNumb,"engine no");
//        TestUtil.sendKeys(classisNo,policyNumb,"classic number");
//        TestUtil.sendKeys(seatingCap,"2","seating capacity");
////        TestUtil.click(riskStratDate,"jhgsd");
////        Thread.sleep(2000);
////        TestUtil.click(today,"ghg");
////
////        TestUtil.click(endDate,"click on end date");
////        endDate.sendKeys(TestUtil.ninjaFutureDate(400),"wedw");
////        endDate.sendKeys(Keys.TAB);;
//
//
//        TestUtil.sendKeys(ncb,"1","ncb");
//        TestUtil.sendKeys(sumInsured,"1","sum");
//
//        TestUtil.sendKeys(basucOd,"1","basic od");
//        TestUtil.sendKeys(totalOdPremium,"1","total od");
//        TestUtil.sendKeys(getBasicTPPremium,"1"," basic TP premium");
//        TestUtil.sendKeys(getTotalOdPremium,"1","total od ");
//        TestUtil.sendKeys(netPremium,"1","net prenium");
//        TestUtil.sendKeys(serviceTax,"1","");
//        TestUtil.sendKeys(grossPreminum,"1","gross");
//        TestUtil.click(qcStatus,"qc");
//        TestUtil.click(qcSttausDone,"done");
//        TestUtil.click(channelType,"channel type");
//        TestUtil.click(website," website");
////        TestUtil.click(tenant,"click on tenant");
////        TestUtil.click(turtlemint,"click on turtlemint");
//
//        uplodFile.sendKeys("/home/ubuntu/storage/dog.pdf");
////        uplodFile.sendKeys("/Users/sayali/Desktop/abcd.pdf");
//        TestUtil.click(selectTag,"click on policy tag");
//        TestUtil.click(ok,"click on ok");
////        salesCloseDate.click();
////        Thread.sleep(2000);
////        pastDate.click();getSalesdate.click();
//        TestUtil.click(saveSale,"click on save sale");
//
//



    }

}


