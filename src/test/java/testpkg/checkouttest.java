package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.baseclass;
import basepkg.reporterclass;
import pagepkg.cartpage;
import pagepkg.checkoutpage;
import pagepkg.loginpage;
import pagepkg.productpage;

public class checkouttest extends baseclass{
	
	@Test
    public void checkoutTest() throws IOException, InterruptedException {

        test = extent.createTest("Checkout Test");
        
        driver.get(url);

        // LOGIN
        loginpage log = new loginpage(driver);
        log.login("standard_user", "secret_sauce");

        test.pass("Login successful");

        // PRODUCT PAGE
        productpage product = new productpage(driver);

        product.addAllProductsToCart();

        test.pass("All products added to cart");

        // OPEN CART
        product.openCart();

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

            test.fail("Products are not present in cart");

            test.addScreenCaptureFromPath(screenshotPath);

            Assert.fail(
                    "Expected 6 products but found " + productCount
            );
        }

        // CLICK CHECKOUT
        cart.clickCheckout();
        
        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("checkout-step-one.html")) {

            test.pass("Checkout page opened successfully");

        } else {

            String screenshotName = "CheckoutPageFailed";

            String screenshotPath =
                    reporterclass.screenshotMethod(driver, screenshotName);

            test.fail("Checkout page was not opened");

            test.addScreenCaptureFromPath(screenshotPath);

            Assert.fail("Checkout page was not opened");
        }

        // CHECKOUT PAGE
        checkoutpage checkout = new checkoutpage(driver);
        Thread.sleep(2000);

        checkout.enterCustomerDetails(
                "Aswathy",
                "Sujeesh",
                "691305"
        );

        test.pass("Customer details entered successfully");

        // CONTINUE
        checkout.clickContinue();
        
       
        currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("checkout-step-two.html")) {

            test.pass("Checkout overview page opened successfully");

        } else {

            String screenshotName = "CheckoutOverviewFailed";

            String screenshotPath =
                    reporterclass.screenshotMethod(driver, screenshotName);

            test.fail("Checkout overview page was not opened");

            test.addScreenCaptureFromPath(screenshotPath);

            Assert.fail("Checkout overview page was not opened");
        }

        // FINISH
        checkout.clickFinish();

        currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("checkout-complete.html")) {

            test.pass("Order completed successfully");

            System.out.println("Order completed successfully");

        } else {

            String screenshotName = "OrderFailed";

            String screenshotPath =
                    reporterclass.screenshotMethod(driver, screenshotName);

            test.fail("Order was not completed");

            test.addScreenCaptureFromPath(screenshotPath);

            Assert.fail("Order was not completed");
        }
    }
}