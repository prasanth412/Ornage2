package com.htc.orange.pages;

import java.awt.event.KeyEvent;
import java.io.IOException;

import com.htc.orange.base.BasePage;
import com.htc.orange.pageobjects.AssignLeavePageObjects;
import com.htc.orange.utility.MyException;

public class AssignLeavePage extends BasePage implements AssignLeavePageObjects {

	boolean res;
	public AssignLeavePage()
	{
		super();
	}
	
	public PIMPage fillAssignLeaveForm(String empname,String type,String fdate,String tdate,String dur,String comm, String parDay)

	{	waitTillElementFound(empNameTxtField);
		type(empNameTxtField,empname);
		pressEnter();
		selectElementByVisibleText(leaveType,type);
		clear(fromDate);
		threadSleep();
		type(fromDate,fdate);
		threadSleep();
		clear(toDate);
		threadSleep();
		type(toDate,tdate);
		rob.keyPress(KeyEvent.VK_ENTER);
		waitTillElementFound(partialDay);
		selectElementByVisibleText(partialDay,parDay);
		//selectElementByVisibleText(duration,dur);
		type(comment,comm);
		
		try {
			className=this.getClass().getSimpleName();
			
			clickOn(assignBtn);
			res=checkElementVisible(popupOkayBtn);
			if(res==true)
			{
				clickOn(popupOkayBtn);
			}
			snap.capture(className);
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PIMPage();
	}

}
