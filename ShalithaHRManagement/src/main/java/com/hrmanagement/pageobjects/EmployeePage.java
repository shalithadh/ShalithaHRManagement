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

public class EmployeePage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"userListTableContainer\"]/div/table/tbody/tr[11]/td[9]")
	private WebElement selectControlStatus;
	
	@FindBy(xpath="//*[@id=\"userListTabs\"]/div/div[3]/div")
	private WebElement selectSickLeaveTab;
	
	@FindBy(xpath="//*[@id=\"userListTableContainer\"]/div/table/tbody/tr[11]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")
	private WebElement selectEmployee;
	
	@FindBy(xpath="//*[@id=\"container\"]/div[12]/div[1]/div[3]")
	private WebElement closeEmployeeProfBtn;
	
	@FindBy(xpath="//*[@id=\"userListTableContainer\"]/div/table/tbody/tr[11]/td[9]")
	private WebElement reviewLeaveBtn;
	
	@FindBy(xpath="//*[@id=\"usersManagementBodyTagId\"]/div[18]/div[1]/a")
	private WebElement closeReviewLeaveBtn;
	
	public EmployeePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//verify whether employee row is control is "On"
	public boolean getEmployeeControlStatus() throws Throwable {
		boolean employeeControlStatus=action.isDisplayed(getDriver(), selectControlStatus);
		return employeeControlStatus;
	}
	
	
	//go to view employee profile method
	public void viewEmployeeProfile() throws Throwable {
		
		action.JSClick(getDriver(), selectSickLeaveTab);
		Thread.sleep(2500);
		
		//screenshot
		action.screenShot(getDriver(), "EmployeeProfilePage - Screen 4");
		
		action.JSClick(getDriver(), selectEmployee);
		Thread.sleep(2500);
		
		//screenshot
		action.screenShot(getDriver(), "View Employee Profile - Screen 5");
	}
	
	//go to close employee profile popup method
	public void closeEmployeeProfilePopUp() throws Throwable {
		action.JSClick(getDriver(), closeEmployeeProfBtn);
		Thread.sleep(2500);
	}
	
	//go to review employee leaves method
	public void reviewEmployeeLeave() throws Throwable {
		action.JSClick(getDriver(), reviewLeaveBtn);
		Thread.sleep(2500);
		//screenshot
		action.screenShot(getDriver(), "Review Employee Leaves - Screen 6");
	}
	
	//go to close review employee leaves method
	public void closeEmployeeLeavePopUp() throws Throwable {
		action.JSClick(getDriver(), closeReviewLeaveBtn);
		Thread.sleep(2500);
	}
	
	
}
