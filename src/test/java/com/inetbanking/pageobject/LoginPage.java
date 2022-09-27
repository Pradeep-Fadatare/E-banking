package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtusername;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtpassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnlogin;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement logoutbtn;

    public void login(String username,String password){
        txtusername.sendKeys(username);
        txtpassword.sendKeys(password);
        btnlogin.click();
    }

    public void logout(){
        logoutbtn.click();
    }
}
