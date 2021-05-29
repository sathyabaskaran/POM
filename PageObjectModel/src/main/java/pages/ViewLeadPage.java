package pages;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {

	public ViewLeadPage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	public ViewLeadPage validateCompanyName(String cmpnyname) {

		new SoftAssert().assertTrue(driver.findElementById("viewLead_companyName_sp").getText().contains(cmpnyname));

		return this;

	}

	public ViewLeadPage validateFirstName(String firstname) {

		new SoftAssert().assertTrue(driver.findElementById("viewLead_firstName_sp").getText().contains(firstname));

		return this;

	}

	public ViewLeadPage clickEditButton()
	{
		try {
			driver.findElementByLinkText("Edit").click();
			reportStep("Edit button is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"Edit button is not clicked", "fail");
		}
		
		return this;
		
	}

	public ViewLeadPage updateFirstName(String newname) {
		driver.findElementById("updateLeadForm_firstName").clear();
		driver.findElementById("updateLeadForm_firstName").sendKeys(newname);
		
		return this;

	}
	
	public ViewLeadPage clickUpdateButton() {
		
		driver.findElementByName("submitButton").click();
		return this;

	}

}
