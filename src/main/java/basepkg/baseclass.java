package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class baseclass {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
    public String url = "https://www.saucedemo.com/";

    @BeforeSuite
	public void browserlaunch()
	{
	
    	extent = reporterclass.sam();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);
    }

    @AfterSuite
    public void teardown() {

        driver.quit();

        extent.flush();
    }
	
	}



