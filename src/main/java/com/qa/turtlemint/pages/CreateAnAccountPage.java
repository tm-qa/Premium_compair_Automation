package com.qa.turtlemint.pages;

import com.qa.turtlemint.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends TestBase {

    @FindBy(xpath = "//span[text()='Create an account/ Sign in']")
    WebElement CreateAccountButton;

    public CreateAnAccountPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String ValidateTitle()
    {
       return driver.getTitle();
    }

    public boolean ValidateLoginField()
    {
        return CreateAccountButton.isDisplayed();
    }

    public LoginPage ValidateCreateAccountButton()
    {
        CreateAccountButton.click();
        return new LoginPage();
    }

}
