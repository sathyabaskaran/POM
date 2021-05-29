package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	public HomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public MyHomePage clickCRMSFALink() {
		
		try {
			driver.findElementByLinkText("CRM/SFA").click();
			reportStep("CRMSFA link is clicked", "pass");
		} catch (Exception e) {
			reportStep(e+"CRMSFA linked is not clicked", "fail");
		}
		
		return new MyHomePage(driver);

	}

}
