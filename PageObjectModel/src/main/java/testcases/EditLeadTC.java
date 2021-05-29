package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class EditLeadTC extends ProjectSpecificMethods {
	
	
	@BeforeTest
	public void setFileName() {
		excelfilename = "EditLead";

	}
	
	@Test(dataProvider="fetchData")
	public void editLeadDetails(String username,String password,String phnno,String newname) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCRMSFALink()
		.clickLeadsLink()
		.clickFindLeadsLink()
		.clickPhoneTab()
		.enterPhoneNumber(phnno)
		.clickFindLeadsButton()
		.clickFirstResult()
		.clickEditButton()
		.updateFirstName(newname)
		.clickUpdateButton()
		.validateFirstName(newname);

	}

}
