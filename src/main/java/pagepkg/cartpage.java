package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class cartpage {
	WebDriver driver;


    @FindBy(className = "inventory_item_name")
    List<WebElement> cartProducts;

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    public cartpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getProductCount() {
        return cartProducts.size();
    }

    public void clickCheckout() {
        checkout.click();
    }

    public void clickContinueShopping() {
        continueShopping.click();
    }
}
