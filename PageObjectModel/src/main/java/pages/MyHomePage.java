package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {
	
	public MyHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public MyLeadsPage clickLeadsLink() {
		
		try {
			driver.findElementByLinkText("Leads").click();
			reportStep("Leads tab is clicked successfully", "pass");
		} catch (Exception e) {
			reportStep(e+"Leads tab is not clicked", "fail");
		}
		
		return new MyLeadsPage(driver);

	}

}
