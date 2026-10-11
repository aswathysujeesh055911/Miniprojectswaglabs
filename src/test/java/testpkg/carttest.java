package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.baseclass;
import basepkg.reporterclass;
import pagepkg.cartpage;
import pagepkg.loginpage;
import pagepkg.productpage;

public class carttest extends baseclass {
	@Test
    public void cartTest() throws IOException, InterruptedException {

        test = extent.createTest("Cart Test");
        driver.get(url);

        // LOGIN
        loginpage log = new loginpage(driver);
        log.login("standard_user", "secret_sauce");

        test.pass("Login successful");

        // PRODUCT PAGE
        productpage product = new productpage(driver);

        product.addAllProductsToCart();

        test.pass("All products are present in the cart ");

        // OPEN CART
        product.openCart();
        Thread.sleep(1000);
        
        test.pass("Cart opened successfully");

        // CART PAGE
        cartpage cart = new cartpage(driver);
        
        Thread.sleep(2000);

        int productCount = cart.getProductCount();

        if (productCount == 6) {

            test.pass("All 6 products are present in cart");

            System.out.println("All 6 products are present in cart");

        } else {

            String screenshotName = "CartVerificationFailed";

            String screenshotPath =
                    reporterclass.screenshotMethod(driver, screenshotName);

            test.fail("All 6 products are not present in cart");

            test.addScreenCaptureFromPath(screenshotPath);

            Assert.fail(
                    "Expected 6 products but found " + productCount
            );
        }
    }
}
