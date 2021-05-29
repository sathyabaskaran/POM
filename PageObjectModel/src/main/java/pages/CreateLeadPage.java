package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {
	
	
	public CreateLeadPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public CreateLeadPage enterCompanyName(String cmpnyname) {
		
		try {
			driver.findElementById("createLeadForm_companyName").sendKeys(cmpnyname);
			reportStep("Company name is entered successfully", "pass");
		} catch (Exception e) {
			reportStep(e+"Company name is not entered", "fail");
		}

		return this;
	}
	
	public CreateLeadPage enterFirstName(String firstname) {
		
		try {
			driver.findElementById("createLeadForm_firstName").sendKeys(firstname);
			reportStep("First name is entered successfully", "pass");
			
		} catch (Exception e) {
			reportStep(e+"First name is not entered", "fail");
		}

		return this;
	}
	
	public CreateLeadPage enterLastName(String lastname) {
		
		try {
			driver.findElementById("createLeadForm_lastName").sendKeys(lastname);
			reportStep("Last name is entered successfully", "pass");
		} catch (Exception e) {
			reportStep(e+"Last name is not entered", "fail");
		}

		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton() {
		
		try {
			driver.findElementByName("submitButton").click();
			reportStep("Create Lead button is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"Create lead button is not clicked", "fail");
		}
		
		return new ViewLeadPage(driver);

	}

}
