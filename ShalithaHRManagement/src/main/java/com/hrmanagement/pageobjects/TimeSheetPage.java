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


public class TimeSheetPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr[2]/td[2]/div[4]/a")
	private WebElement approveTimeTrackBtn;
	
	@FindBy(xpath="//*[@id=\"approveTTTable\"]/tbody[2]/tr[1]/td[7]/input")
	private WebElement checkRowsToApprove;
	
	@FindBy(xpath="//*[@id=\"approveButton\"]")
	private WebElement approvalBtn;
	
	@FindBy(xpath="//*[@id=\"approveTTTable\"]/tbody[2]/tr[1]/td[6]/a")
	private WebElement revokeRows;
	
	@FindBy(xpath="//*[@id=\"rejectButton\"]")
	private WebElement rejectBtn;
	
	
	public TimeSheetPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//go to approve timesheet page method
	public void viewApproveTimesheetPage() throws Throwable {
		action.JSClick(getDriver(), approveTimeTrackBtn);
		Thread.sleep(1500);
		//screenshot
		action.screenShot(getDriver(), "Approval TimeSheetPage - Screen 10");
		Thread.sleep(2500);
	}
	
	//approve selected rows method
	public void approveTimesheets() throws Throwable {
		//select rows
		action.JSClick(getDriver(), checkRowsToApprove);
		//screenshot
		action.screenShot(getDriver(), "Select Rows for Approval - Screen 11");
		Thread.sleep(2500);
		
		//approve selected rows
		action.JSClick(getDriver(), approvalBtn);
		//screenshot
		action.screenShot(getDriver(), "Approval - Screen 12");	
		Thread.sleep(2500);
		
		//revoke approved data
		action.JSClick(getDriver(), revokeRows);	
		//screenshot
		action.screenShot(getDriver(), "Revoke Approval Rows - Screen 13");		
		Thread.sleep(2500);
	}
	
	//reject selected rows method
	public void rejectTimesheets() throws Throwable {
		//select rows
		action.JSClick(getDriver(), checkRowsToApprove);		
		//screenshot
		action.screenShot(getDriver(), "Select Rows for Rejection - Screen 14");	
		Thread.sleep(2500);
		
		//reject selected rows
		action.JSClick(getDriver(), rejectBtn);	
		//screenshot
		action.screenShot(getDriver(), "Rejection - Screen 15");	
		Thread.sleep(2500);
		
		//revoke rejected data
		action.JSClick(getDriver(), revokeRows);	
		//screenshot
		action.screenShot(getDriver(), "Revoke Rejection Rows - Screen 16");	
		Thread.sleep(2500);
	}
	
	
}
