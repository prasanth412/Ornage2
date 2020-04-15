package com.htc.orange.pages;

import java.io.IOException;

import com.htc.orange.base.BasePage;
import com.htc.orange.pageobjects.DashBoardPageObjects;
import com.htc.orange.utility.MyException;

public class DashboardPage extends BasePage implements DashBoardPageObjects {

	public DashboardPage()  {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AssignLeavePage clickAssignLeave()
	{
		try 
		{
		waitTillElementFound(assignLeaveLink);
		className=this.getClass().getSimpleName();
		snap.capture(className);
			clickOn(assignLeaveLink);
		
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new AssignLeavePage();
	}
	public AdminPage clickAdmin()
	{
		try 
		{
		waitTillElementFound(linkadmin);
		className=this.getClass().getSimpleName();
		snap.capture(className);
			clickOn(linkadmin);
			
		
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new AdminPage();
	}
	public AdminPage clickAdd()
	{
		try 
		{
			waitTillElementFound(btnadd);
				clickOn(btnadd);
		
		}
		catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new AdminPage();
	}

	
	public PIMAddEmployeePage clickPIM()
	{
		try 
		{
		waitTillElementFound(linkpim);
		className=this.getClass().getSimpleName();
		snap.capture(className);
			clickOn(linkpim);
			
		
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new PIMAddEmployeePage();
	}
	public PIMAddEmployeePage clickPIMEmployee()
	{
		try 
		{
		waitTillElementFound(linkemplist);
		className=this.getClass().getSimpleName();
		snap.capture(className);
			clickOn(linkemplist);
			
		
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new PIMAddEmployeePage();
	}
	public PIMAddEmployeePage clickPIMAdd()
	{
		try 
		{
			waitTillElementFound(btnadd);
				clickOn(btnadd);
		
		}
		catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new PIMAddEmployeePage();
	}
	public PIMAddReportPage clickPIMReport()
	{
		try 
		{
		waitTillElementFound(linkreport);
		className=this.getClass().getSimpleName();
		snap.capture(className);
			clickOn(linkreport);
			
		
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new PIMAddReportPage();
	}
	public PIMAddReportPage clickReportAdd()
	{
		try 
		{
		waitTillElementFound(btnadd);
		className=this.getClass().getSimpleName();
		snap.capture(className);
			clickOn(btnadd);
			
		
		} catch (MyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return new PIMAddReportPage();
	}
	

	
	
}
