package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.baseclass;
import basepkg.reporterclass;
import pagepkg.loginpage;
import pagepkg.productpage;

public class producttest extends baseclass {
	@Test
    public void addAllProducts() throws IOException {

        test = extent.createTest("Product Test");
        
        driver.get(url);

        // LOGIN
        loginpage log = new loginpage(driver);
        log.login("standard_user", "secret_sauce");

        test.pass("Login successful");

        // PRODUCT PAGE
        productpage product = new productpage(driver);

        product.addAllProductsToCart();

        test.pass("All products added to cart");

        // VERIFY PRODUCTS
        int productCount = product.getProductCount();

        if (productCount == 6) {

            test.pass("All 6 products are displayed");

            System.out.println("All 6 products are added to cart");

        } else {

            String screenshotName = "ProductFailed";

            String screenshotPath =
                    reporterclass.screenshotMethod(driver, screenshotName);

            test.fail("Products are not displayed correctly");

            test.addScreenCaptureFromPath(screenshotPath);

            Assert.fail("Expected 6 products but found " + productCount);
        }
    }
	
}
