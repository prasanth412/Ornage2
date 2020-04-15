package com.htc.orange.pageobjects;

import org.openqa.selenium.By;

public interface PIMSearchReportPageObjects
{
	By txtreportname= By.cssSelector("input#search_search");
	By btnsearch= By.className("searchBtn");
	By btnrun= By.xpath("//table[@id='resultTable']//tbody//tr//td[3]//a");
	
}
