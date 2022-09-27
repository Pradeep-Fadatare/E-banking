package com.inetbanking.testcases;

import com.inetbanking.Utilities.XLSL;
import com.inetbanking.pageobject.AddNewCustomerPage;
import com.inetbanking.pageobject.BaseClass;
import com.inetbanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddCustomer_001 extends BaseClass {

    public AddCustomer_001() throws IOException {
        super();
    }

    @Test(testName ="addnewcust" ,dataProvider = "ebanking",dataProviderClass = XLSL.class)
    public void addnewcust(String name,String dd,String mm,String yyyy,String address,String city,String state,
                           String pinno,String telephone ,String email,String password){
        LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"),prop.getProperty("password"));

        AddNewCustomerPage anc=new AddNewCustomerPage(driver);
        anc.Addcustomer(name,dd,mm,yyyy,address,city,state,pinno,telephone,email,password);

        if (isalertpresent() == true) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        } else {
            boolean rslt=driver.getPageSource().contains("Customer Registered Successfully !!!");
            driver.switchTo().defaultContent();
        }
    }
}
