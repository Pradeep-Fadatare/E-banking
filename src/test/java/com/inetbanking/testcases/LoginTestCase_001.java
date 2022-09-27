package com.inetbanking.testcases;

import com.inetbanking.pageobject.BaseClass;
import com.inetbanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase_001 extends BaseClass {

    public LoginTestCase_001() throws IOException {
        super();
    }

    @Test
    public void logintest(){
        LoginPage lp=new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
    }
}
