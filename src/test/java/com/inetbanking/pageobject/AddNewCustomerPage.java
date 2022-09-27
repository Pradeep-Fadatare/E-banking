package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
    WebDriver ldriver;

    public AddNewCustomerPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @CacheLookup
    @FindBy(how= How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
    WebElement lnknewcustomer;

    @CacheLookup
    @FindBy(how= How.NAME, using ="name")
    WebElement txtname;
    @CacheLookup
    @FindBy(how= How.NAME, using ="rad1")
    WebElement btngender;

    @CacheLookup
    @FindBy(how= How.NAME, using ="dob")
    WebElement txtdob;

    @CacheLookup
    @FindBy(how= How.NAME, using ="addr")
    WebElement txtaddress;

    @CacheLookup
    @FindBy(how= How.NAME, using ="city")
    WebElement txtcity;

    @CacheLookup
    @FindBy(how= How.NAME, using ="state")
    WebElement txtstate;

    @CacheLookup
    @FindBy(how= How.NAME, using ="pinno")
    WebElement txtpinno;

    @CacheLookup
    @FindBy(how= How.NAME, using ="telephoneno")
    WebElement txttelephoneno;

    @CacheLookup
    @FindBy(how= How.NAME, using ="emailid")
    WebElement txtemailid;

    @CacheLookup
    @FindBy(how= How.NAME, using ="password")
    WebElement txtpassword;

    @CacheLookup
    @FindBy(how= How.NAME, using ="sub")
    WebElement btnsub;

    public void Addcustomer(String name,String dd,String mm,String yyyy,String address,String city,String state,
                            String pinno,String telephone ,String email,String password){

        lnknewcustomer.click();
        txtname.sendKeys(name);
        btngender.click();
        txtdob.sendKeys(dd);
        txtdob.sendKeys(mm);
        txtdob.sendKeys(yyyy);
        txtaddress.sendKeys(address);
        txtcity.sendKeys(city);
        txtstate.sendKeys(state);
        txtpinno.sendKeys(String.valueOf(pinno));
        txttelephoneno.sendKeys(telephone);
        txtemailid.sendKeys(email);
        txtpassword.sendKeys(password);
        btnsub.click();




    }






}
