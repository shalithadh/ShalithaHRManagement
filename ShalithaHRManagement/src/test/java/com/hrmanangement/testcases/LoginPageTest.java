/**
 * 
 */
package com.hrmanangement.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrmanagement.base.BaseClass;
import com.hrmanagement.dataprovider.DataProviders;
import com.hrmanagement.pageobjects.HomePage;
import com.hrmanagement.pageobjects.LoginPage;
import com.hrmanagement.utility.Log;

/**
 * @author Shalitha Dhananjaya IndexNo -19550154
 *
 */
public class LoginPageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.getProperty("browser")); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		loginPage  = new LoginPage();
		Log.startTestCase("loginTest");
		Log.info("Enter Username and Password");
		//login method
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="https://demo.actitime.com/user/submit_tt.do";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Success");
	    
	    
	    //logout method
	    Thread.sleep(3000);
	    homePage  = new HomePage();
	    loginPage = homePage.login(loginPage);
	    Log.info("LogOut is Success");
	    Log.endTestCase("loginTest");
	    
	}

}
