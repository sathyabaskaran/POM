package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods {
	
	
	public MyLeadsPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public CreateLeadPage clickCreateLeadLink() {
	
		try {
			driver.findElementByLinkText("Create Lead").click();
			reportStep("Create Lead link is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"Create Lead link is not clicked", "fail");
		}
		
		return new CreateLeadPage(driver);

	}
	
	public FindLeadsPage clickFindLeadsLink()
	{
		try {
			driver.findElementByLinkText("Find Leads").click();
			reportStep("Find Leads link is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"Find leads link is not clicked", "fail");
		}
		
		return new FindLeadsPage(driver);
	}

}
