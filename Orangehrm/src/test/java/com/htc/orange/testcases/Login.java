package com.htc.orange.testcases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.htc.orange.base.Base;
import com.htc.orange.base.BasePage;
import com.htc.orange.dataprovider.MyDataProvider;
import com.htc.orange.pages.AssignLeavePage;
import com.htc.orange.pages.LoginPage;
import com.htc.orange.utility.MyException;

public class Login extends Base {
	
	@BeforeMethod
	public void setup()
	{
		
		login=new LoginPage();
		
	}
	@Test(dataProvider="LoginCredentials", dataProviderClass = MyDataProvider.class)
	public void loginPageTest(Map<Object, Object> map) 
	{
	String username=(String) map.get("username");
	String password=(String) map.get("password");
	

	dashboard=login.userLogin(username, password);
		
	}

	@Test(dependsOnMethods="loginPageTest")
	public void DashBoardTest()
	{
		assignLeave=dashboard.clickAssignLeave();
	}

	@Test(dataProvider="AssignLeaveProvider",dataProviderClass=MyDataProvider.class,dependsOnMethods="DashBoardTest")
	public void assignPageTest(Map<Object,Object> map)
	{
		String emp=(String) map.get("empname");
		String leave=(String) map.get("leavetype");
		String fromDate=(String) map.get("fromdate");
		String toDate=(String) map.get("todate");
		String duration=(String) map.get("duration");
		String comm=(String) map.get("comment");
		String parDay=(String) map.get("partialday");
		
		
		pim=assignLeave.fillAssignLeaveForm(emp, leave, fromDate, toDate, duration, comm,parDay);
	}
	
	@Test(dataProvider="PIMProvider",dataProviderClass=MyDataProvider.class)
	public void PimPageTest(Map<Object,Object> map)
	{
		pim.navigateToPIMModule();
		String ename=(String) map.get("empToSearch");
		pim.findEmpDetail(ename);
	}
	
	}
