package com.inetbanking.testcases;

import com.inetbanking.Utilities.XLSL;
import com.inetbanking.pageobject.BaseClass;
import com.inetbanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase_002 extends BaseClass {


        public LoginTestCase_002() throws IOException {
            super();
        }


        @Test(testName ="LoginTest" ,dataProvider = "ebanking",dataProviderClass = XLSL.class)
        public void LoginTest(String username,String password) {
            LoginPage lp = new LoginPage(driver);
            lp.login(username, password);

            if (isalertpresent() == true) {
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
                Assert.assertTrue(false);
            } else {
                Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
                lp.logout();
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
            }
        }
    }

