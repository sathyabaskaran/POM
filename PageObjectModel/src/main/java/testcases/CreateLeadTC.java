package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateLeadTC extends ProjectSpecificMethods{

	@BeforeTest
	public void setTestDetails()
	{
		excelfilename = "CreateLead";
		testname = "CreateLead";
		description = "create lead in test leaf application";
		author = "sathya";
		category = "sanity";
	}
	
	@Test(dataProvider = "fetchData")
	public  void createNewLead(String username,String password,String cmpnyname,String firstname,String lastname) {
		
		new LoginPage(driver)
		.enterUserName(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCRMSFALink()
		.clickLeadsLink()
		.clickCreateLeadLink()
		.enterCompanyName(cmpnyname)
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.clickCreateLeadButton()
		.validateCompanyName(cmpnyname)
		.validateFirstName(firstname);

	}
}
