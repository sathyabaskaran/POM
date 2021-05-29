package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class ProjectSpecificMethods {
	
	public ChromeDriver driver;
	public String excelfilename;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	public static ExtentTest test,node;
	public String testname,description,author,category;
	
	
	@BeforeSuite
	public void startReport() {
		
		reporter = new ExtentHtmlReporter("./result/report.html");
		
		reporter.setAppendExisting(true);
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);

	}
	
	@BeforeClass
	public void testDetails() {
		 test = extent.createTest(testname, description);
		 test.assignAuthor(author);
		 test.assignCategory(category);

	}
	
	@BeforeMethod
	public  void startApp() {
		 node = test.createNode(testname);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

	}
	
	public int takeSnapshot() throws IOException
	{
		int ranNum= (int)(Math.random()*900000);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./result/images/"+ranNum+".png");
		FileUtils.copyFile(src, target);
		return ranNum;
	}
	
	public void reportStep(String msg , String status)  {
		
		if(status.equalsIgnoreCase("pass"))
		{
			try {
				node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath("./../result/images/"+takeSnapshot()+".png").build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			test.fail(msg);
		}
		

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();

	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();

	}
	
	
	@DataProvider (name = "fetchData")
	public String[][] sendData() throws IOException
	{
		ReadExcelData re = new ReadExcelData();
		String[][] data = re.readData(excelfilename);
		return data;
	}
	

}
