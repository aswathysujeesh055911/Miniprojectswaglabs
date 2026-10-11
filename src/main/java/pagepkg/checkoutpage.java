package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage {
	 WebDriver driver;

	    @FindBy(id = "first-name")
	    WebElement firstName;

	    @FindBy(id = "last-name")
	    WebElement lastName;

	    @FindBy(id = "postal-code")
	    WebElement postalCode;

	    @FindBy(id = "continue")
	    WebElement continueButton;

	    @FindBy(id = "finish")
	    WebElement finishButton;

	    public checkoutpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterCustomerDetails(String fname, String lname, String pcode) {

	        firstName.sendKeys(fname);
	        lastName.sendKeys(lname);
	        postalCode.sendKeys(pcode);
	    }

	    public void clickContinue() {
	        continueButton.click();
	    }

	    public void clickFinish() {
	        finishButton.click();
	    }
}
