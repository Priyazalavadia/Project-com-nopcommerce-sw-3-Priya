package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics”Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        // 1.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //  2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //  2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //  2.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

        // 	2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='picture']//a[@title='Show details for Nokia Lumia 1020']"));

        //2.6 Verify the text “Nokia Lumia 1020
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //2.7 Verify the price “$349.00”
        assertVerifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");

        // 2.8 Change quantity to 2
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));


        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.

        assertVerifyText(By.xpath("//div[@id='bar-notification']/div/p"), "The product has been added to your shopping cart");
        Thread.sleep(1000);


        clickOnElement(By.xpath("//span[@title='Close']"));

        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//div[@class='page-title']/h1[1]"), "Shopping cart");

        //2.13 Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        String qty = text.getAttribute("value");
        Assert.assertEquals("", "2", qty);

        // 2.14 Verify the Total $698.00
        assertVerifyText(By.xpath("//span[@class='product-subtotal']"), "$698.00");

        //2.15 click on checkbox “I agree with the terms of service
        clickOnElement(By.id("termsofservice"));

        // 2.16 Click on checkout
        clickOnElement(By.id("checkout"));
        //  2.17 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.18 Click on "Register" tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text "Register"
        assertVerifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.id("FirstName"), "Prime");
        sendTextToElement(By.id("LastName"), "Testing");

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "10");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "November");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1990");
        sendTextToElement(By.id("Email"), "rainbow3@gmail.com");

        sendTextToElement(By.id("Password"), "test123");
        sendTextToElement(By.id("ConfirmPassword"), "test123");

        //2.21 Click on "Register" button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        Thread.sleep(3000);
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24  Verify the text “Shopping cart”
        assertVerifyText(By.xpath("//span[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.25 click on checkbox "I agree with the terms of service"
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on "Checkout"
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Prime");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Testing");
        sendTextToElement(By.id("BillingNewAddress_Email"), "rainbow3@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "london");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "100 camrose Ave");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA8 6AG");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567890");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 click on Radio Button "2nd Day Air($0.00)"
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on 'Continue'
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        //2.31 Select Radio Button 'Credit Card'
       clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
       clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));

       //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id(" //select[@id='CreditCardType']"),"Visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"),"xyz");
        sendTextToElement(By.id("CardNumber"),"3252 7814 7648 5333");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"01");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2030");
        sendTextToElement(By.id("CardCode"),"111");

        //2.34 Click on "Continue Checkout
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        //2.35 Verify “Payment Method” is “Credit Card”
         assertVerifyText(By.xpath("//span[contains(text(),'Payment Method:')]"), "Credit Card");

         //2.36 Verify “Shipping Method” is “2nd Day Air”
        assertVerifyText(By.xpath("//li[@class='shipping-method']"),"2nd Day Air");

        //2.37 Verify Total is “$698.00”
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"), "$698.00");

        //2.38  Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the text Thank You
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");

        //2.40 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42  Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();

        Assert.assertEquals("https://demo.nopcommerce.com/", url);

    }
}
