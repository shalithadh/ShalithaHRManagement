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


public class ReportPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"configs\"]/tbody/tr[1]/td[2]/table")
	private WebElement attendanceReportBtn;
	
	public ReportPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//go to attendance report method
	public void viewAttendanceReport() throws Throwable {
		action.click(getDriver(), attendanceReportBtn);
		//screenshot
		action.screenShot(getDriver(), "AttendanceReportPage - Screen 8");
		Thread.sleep(2500);
	}

}
