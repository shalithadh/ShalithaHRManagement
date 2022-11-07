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
import com.hrmanagement.pageobjects.EmployeePage;
import com.hrmanagement.pageobjects.HomePage;
import com.hrmanagement.pageobjects.LoginPage;
import com.hrmanagement.utility.Log;

/**
 * @author Shalitha Dhananjaya IndexNo -19550154
 *
 */

public class EmployeePageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private EmployeePage employeePage;
	
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.getProperty("browser")); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void employeeTest(String uname, String pswd) throws Throwable {
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
	    
	    //view employee profiles method
	    Thread.sleep(3000);
	    homePage  = new HomePage();
	    employeePage = homePage.viewEmployeePage(employeePage);
	    Log.info("Viewing Employee Profiles List is Successful");
	    
	    employeePage = new EmployeePage();
	    Log.info("Verifying Employee control status");
	    
	    //view a employee profile method
	    Thread.sleep(2500);
	    employeePage.viewEmployeeProfile();
	    Log.info("Viewing a Employee Profiles is Successful");
	    
	    //close the selected employee profile popup method
	    Thread.sleep(2500);
	    employeePage.closeEmployeeProfilePopUp();
	    Log.info("Close the selected employee profile is Successful");
	    
	    //review a employee leave method
	    Thread.sleep(2500);
	    employeePage = new EmployeePage();
	    employeePage.reviewEmployeeLeave();
	    Log.info("Reviewing Employee Leaves is Successful");
	    
	    //close the selected employee leave popup method
	    Thread.sleep(2500);
	    employeePage.closeEmployeeLeavePopUp();
	    Log.info("Close the selected employee leaves popup is Successful");
	    
	    
	    //logout method
	    Thread.sleep(3000);
	    homePage  = new HomePage();
	    loginPage = homePage.login(loginPage);
	    Log.info("LogOut is Successful");
	    Log.endTestCase("loginTest");
	    
	}
}
