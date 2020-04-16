package com.htc.orange.pages;

import org.openqa.selenium.By;

import com.htc.orange.base.BasePage;

import com.htc.orange.pageobjects.LeaveEntitlementPageObjects;

public class LeaveEntitlementPage extends BasePage implements LeaveEntitlementPageObjects
{
	public LeaveEntitlementPage()
	{
		super();
	}
	
	public void enterleaveEmp(String text) throws Exception
	{
		clear(txtempname);
		typeselect(txtempname,text);
		sleep();
		
	}
	public void enterEntitlement(String text) throws Exception
	{
		clear(txtentitlement);
		type(txtentitlement,text);
		sleep();
		
	}
	public void selectLeaveType(String text) throws Exception
	{
		
		selectElementByVisibleText(drpdwnleavetype, text);
		sleep();
		
	}
	public void selectLeavePeriod(String text) throws Exception
	{
		selectElementByVisibleText(drpdwnleaveperiod, text);
		sleep();
		
	}
	public void clickSave() throws Exception
	{
		clickOn(btnsave);
		sleep();
		
	}

	

}
