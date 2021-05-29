package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods {
	
	
	public FindLeadsPage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	public FindLeadsPage clickPhoneTab() {
		
		try {
			driver.findElementByXPath("//span[text()='Phone']").click();
			reportStep("Phone tab is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"Phone tab is not clicked", "fail");
		}
		
		return this;
		
	}
	
	public FindLeadsPage enterPhoneNumber(String phone) {
		
		try {
			driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phone);
			reportStep("Phone number is entered", "pass");
		} catch (Exception e) {
			reportStep(e+"Phone number is not entered", "fail");
		}
		return this;

	}
	
	public FindLeadsPage clickFindLeadsButton() throws InterruptedException {
		
		try {
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			reportStep("Find Leads button is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"Find Leads button is not clicked", "fail");
		}
		Thread.sleep(2000);
		return this;

	}
	
	public ViewLeadPage clickFirstResult() {
		
		try {
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
			reportStep("First result is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"First result is not clicked", "fail");
		}

		return new ViewLeadPage(driver);
	}
}
