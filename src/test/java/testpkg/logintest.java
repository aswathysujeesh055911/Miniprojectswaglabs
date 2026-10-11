package testpkg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.baseclass;
import basepkg.reporterclass;
import pagepkg.loginpage;

public class logintest extends baseclass  {
	
	@DataProvider(name="logindata")
	public Object[][] getdata() throws IOException
	{
		String path ="C:\\Users\\Aswathy\\OneDrive\\Desktop\\Selenium Automation\\swaglabs.xlsx";
		return utilities.excelutilities.getTestData(path,"Sheet1");
		
	}
	@Test(dataProvider ="logindata")
	 public void login(String username,String password)throws InterruptedException, IOException {

	        driver.get( "https://www.saucedemo.com/" );

	        test = extent.createTest("Login Test - " + username);

	        loginpage log =
	                new loginpage(driver);


	     // TITLE VERIFICATION
	        String expectedTitle = "Swag Labs";
	        String actualTitle = log.titleverify();

	        System.out.println("Expected Title : " + expectedTitle);
	        System.out.println("Actual Title   : " + actualTitle);

	        if (actualTitle.equals(expectedTitle)) {

	            test.pass("Title verification passed");
	            System.out.println("Title verification passed");

	        } else {

	            String screenshotName = "TitleFailed_" + username;
	            String screenshotPath =
	                    reporterclass.screenshotMethod(driver, screenshotName);

	            test.fail("Title verification failed");
	            test.addScreenCaptureFromPath(screenshotPath);

	            System.out.println("Title verification failed");

	            Assert.fail("Title verification failed");
	        }


	        // LOGO VERIFICATION
	        WebElement logo = log.logoverify();

	        if (logo.isDisplayed()) {

	            test.pass("Swag Labs logo is displayed");
	            System.out.println("Logo verification passed");

	        } else {

	            String screenshotName = "LogoFailed_" + username;
	            String screenshotPath =
	                    reporterclass.screenshotMethod(driver, screenshotName);

	            test.fail("Swag Labs logo is not displayed");
	            test.addScreenCaptureFromPath(screenshotPath);

	            System.out.println("Logo verification failed");

	            Assert.fail("Logo verification failed");
	        }

	        log.login(username,password );

	        Thread.sleep(3000);

	        String currentUrl = driver.getCurrentUrl();


	        System.out.println( "Executed for : " + username);

	        System.out.println(
	                "Redirected to : " + currentUrl);
	        
	        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {

	            test.pass("Login successful for " + username);
	            System.out.println("Login successful for : " + username);

	        } else {

	            String screenshotName = "LoginFailed_" + username;
	            String screenshotPath = reporterclass.screenshotMethod(driver, screenshotName);

	            test.fail("Login failed for " + username);
	            test.addScreenCaptureFromPath(screenshotPath);

	            System.out.println("Login failed for : " + username);

	            Assert.fail("Login failed for : " + username);
	        }
	        
	}

}
