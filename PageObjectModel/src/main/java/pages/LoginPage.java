package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{

	
	public LoginPage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	//MethodName:  Action + Object

	public LoginPage enterUserName(String username) {

		try {
			driver.findElementById("username").sendKeys(username);
			reportStep("Username is entered successfully","pass");
		} catch (Exception e) {
			
			reportStep( "Username is not entered", "fail");
			
		}

		return this;
	}

	public LoginPage enterPassword(String password) {

		try {
			driver.findElementById("password").sendKeys(password);
			reportStep("Password is entered successfully","pass");
		} catch (Exception e) {
			reportStep(e + "Password is not entered", "fail");
		}

		return this;
	}

	public HomePage clickLoginButton() {

		try {
			driver.findElementByClassName("decorativeSubmit").click();
			reportStep("Login button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep(e +"Login button is not clicked","fail");
		}

		return new HomePage(driver);

	}

}
