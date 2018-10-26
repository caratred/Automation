package Basic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Sendmail 
{
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeTest
	public void navigate() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("http://www.way2testing.com"); 
	Thread.sleep(3000);
	report=new ExtentReports("./Reports/TestReport.html");
	}
	@Test(priority = 0)
	public void title()
	{
	logger=report.startTest("Verifytitle");
	logger.log(LogStatus.INFO, "test started ");
	System.out.println("Your Title is :" + driver.getTitle());
	String title = driver.getTitle();
	if(title.equalsIgnoreCase(" Online Software Testing: Software Testing"))
	{
	logger.log(LogStatus.PASS, "Test Verified");
	}
	else
	{
	logger.log(LogStatus.FAIL, "Test Failed");
	}
	report.endTest(logger);
	//Flush the data to report
	report.flush();
	}
	@Test(priority = 1)
	public void clicklink(){
	//Create object for Report with filepath
	//report=new ExtentReports("./Reports/TestReport.html");
	//Start the test
	logger=report.startTest("Verifylink");
	//Log the status in report
	logger.log(LogStatus.INFO, "Test started ");
	driver.findElement(By.xpath(".//*[@id='post-body-751561208295527719']/div[1]/table/tbody/tr[6]/td[1]/a/img")).click();
	//Pass the test in report
	logger.log(LogStatus.PASS, "Link Verified");
	//End the test
	report.endTest(logger);
	//Flush the data to report
	report.flush();
	}
	}

