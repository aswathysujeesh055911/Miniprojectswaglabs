package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
	 WebDriver driver;

	 @FindBy(css = ".inventory_item")
	    List<WebElement> products;

	    @FindBy(css = ".inventory_item button")
	    List<WebElement> addToCartButtons;

	    @FindBy(className = "shopping_cart_link")
	    WebElement cart;

	    public productpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void addAllProductsToCart() {

	        for (WebElement button : addToCartButtons) {
	            button.click();
	        }
	    }

	    public int getProductCount() {
	        return products.size();
	    }

	    public void openCart() {
	        cart.click();
	    }
	
}