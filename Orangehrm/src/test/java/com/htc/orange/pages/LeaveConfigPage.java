package com.htc.orange.pages;

import com.htc.orange.base.BasePage;
import com.htc.orange.pageobjects.LeaveConfigPageObjects;

public class LeaveConfigPage extends BasePage implements LeaveConfigPageObjects
{
	
	public void enterLeaveTypeName(String text) throws Exception
	{
		clear(txtname);
		type(txtname,text);
		sleep();
		
	}
	public void clickAdd() throws Exception
	{
		clickOn(btnadd);
		sleep();
		
	}
	public void clickSave() throws Exception
	{
		clickOn(btnsave);
		sleep();
		
	}
}
