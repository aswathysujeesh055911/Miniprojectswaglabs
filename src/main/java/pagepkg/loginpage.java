package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver driver;
	
	 @FindBy(id = "user-name")
	    WebElement username;

	    @FindBy(id = "password")
	    WebElement password;

	    @FindBy(name = "login-button")
	    WebElement login;

	    
	    @FindBy(className = "login_logo")
	    WebElement logo;


	    public loginpage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }


	   
	    public WebElement logoverify() {

	        return logo;
	    }


	    
	    public String titleverify() {

	        return driver.getTitle();
	    }


	    public void login(String uname, String pwd) {

	        username.sendKeys(uname);

	        password.sendKeys(pwd);

	        login.click();
	    }

}
