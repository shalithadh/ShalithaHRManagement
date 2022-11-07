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
public class HomePage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="logoutLink")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr/td[3]/a")
	private WebElement timeTrackBtn;
	
	@FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr/td[4]/a")
	private WebElement taskBtn;
	
	@FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr/td[5]/a")
	private WebElement reportBtn;
	
	@FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr[1]/td[6]/a")
	private WebElement viewEmployeeBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
	//got to view employee page method
	public EmployeePage viewEmployeePage(EmployeePage employeePage) throws Throwable {
		action.JSClick(getDriver(), viewEmployeeBtn);
		Thread.sleep(2500);
		employeePage=new EmployeePage();
		
		//screenshot
		action.screenShot(getDriver(), "EmployeePage - Screen 3");
		
		return employeePage;
	}
	
	//got to view report page method
	public ReportPage viewReportPage(ReportPage reportPage) throws Throwable {
		action.JSClick(getDriver(), reportBtn);
		Thread.sleep(2500);
		reportPage =new ReportPage();
		
		//screenshot
		action.screenShot(getDriver(), "ReportPage - Screen 7");
		
		return reportPage;
	}
	
	//go to view timesheet page method
	public TimeSheetPage viewTimeSheetPage(TimeSheetPage timeSheetPage) throws Throwable {
		action.JSClick(getDriver(), timeTrackBtn);
		Thread.sleep(2500);
		timeSheetPage =new TimeSheetPage();
		
		//screenshot
		action.screenShot(getDriver(), "TimeSheetPage - Screen 9");
		
		return timeSheetPage;
	}
	
	
	//logout method
	public LoginPage login(LoginPage loginPage) throws Throwable {
		action.JSClick(getDriver(), logoutBtn);
		Thread.sleep(2500);
		loginPage=new LoginPage();
		return loginPage;
	}
	
}
