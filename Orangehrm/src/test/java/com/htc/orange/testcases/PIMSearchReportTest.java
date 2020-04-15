package com.htc.orange.testcases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.htc.orange.base.Base;
import com.htc.orange.dataprovider.MyDataProvider;
import com.htc.orange.pages.LoginPage;

public class PIMSearchReportTest extends Base

{
	@BeforeMethod
	public void setup()
	{
		
		login=new LoginPage();
		
	}
	@Test(dataProvider="LoginCredentials", dataProviderClass = MyDataProvider.class)
	public void T001_loginPageTest(Map<String, String> testdata) throws Exception 
	{
	 String username=(String) testdata.get("username");
	 String password=(String) testdata.get("password");
	 dashboard=login.userLogin(username, password);
	
		
	}
	
	@Test(dependsOnMethods="T001_loginPageTest")
	public void T002_DashBoardTest()
	{
		pimaddemp=dashboard.clickPIM();
		pimaddreport=dashboard.clickPIMReport();
		
	}
	@Test(dependsOnMethods="T002_DashBoardTest",dataProvider="PIMSearchReport",dataProviderClass=MyDataProvider.class)
	public void T003_searchReportTest(Map<String,String> testdata) throws Exception
	{
		pimsearchreport.enterReportName(testdata.get("RepName"));
		pimsearchreport.clickSearch();
		pimsearchreport.clickRun();
	}

	
}
