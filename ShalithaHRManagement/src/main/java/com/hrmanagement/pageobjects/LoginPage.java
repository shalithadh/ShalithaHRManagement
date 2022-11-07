/**
 * 
 */
package com.hrmanagement.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmanagement.actiondriver.Action;
import com.hrmanagement.base.BaseClass;

/**
 * @author Shalitha Dhananjaya IndexNo -19550154
 *  
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(name="pwd")
	private WebElement password;

	@FindBy(id="loginButton")
	private WebElement logInBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		
		//screenshot
		action.screenShot(getDriver(), "LoginPage - Screen 1");
		Thread.sleep(1500);
		
		action.JSClick(getDriver(), logInBtn);
		Thread.sleep(2500);
		homePage=new HomePage();
		
		//screenshot
		action.screenShot(getDriver(), "HomePage - Screen 2");
		
		return homePage;
	}
	
	
}






