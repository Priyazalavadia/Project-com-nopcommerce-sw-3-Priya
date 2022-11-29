package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;


public class TestSuite extends Utility {


    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void sortInDescendingOrder() {

        //  1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //	1.2 Click on Desktop
        clickOnElement(By.xpath("//h2//a[@title='Show products in category Desktops']"));

        //	1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Price: Low to High");

        //	1.4 Verify the Product will arrange in Descending order.

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        Actions actions = new Actions(driver);

        //  2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));

        //	2.2 Click on Desktop
        clickOnElement(By.xpath("//h2//a[@title='Show products in category Desktops']"));

        //	2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");

        //	2.4 Click on "Add To Cart"
        Thread.sleep(5000);
        clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));

        //	2.5 Verify the Text "Build your own computer"
        assertVerifyText(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");

        //	2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.id("product_attribute_1"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //	2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        //	2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));

        //	2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));

        //  2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));

        //	2.11 Verify the price "$1,475.00"
        Thread.sleep(1000);
        assertVerifyText(By.id("price-value-1"), "$1,475.00");

        //	2.12 Click on "ADD TO CART" Button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type='button' and @onclick='return AjaxCart.addproducttocart_details(\"/addproducttocart/details/1/1\",\"#product-details-form\"),!1']"));

        //	2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertVerifyText(By.xpath("//div//p[contains(text(),'The product has been added to your ')]"), "The product has been added to your shopping cart");

        //  After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //	2.15 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //	2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//input[@type='text' and @value='1']"));

        Thread.sleep(2000);
        actions.sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.DELETE).perform();

        Thread.sleep(2000);
        actions.sendKeys("2").perform();

        Thread.sleep(2000);
        clickOnElement(By.id("updatecart"));

        //	2.17 Verify the Total"$2,950.00"
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$2,950.00')]"), "$2,950.00");

        //	2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //	2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //	2.20 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //	2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //	2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Ganpati");
        Thread.sleep(500);
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Kailash");
        Thread.sleep(500);
        sendTextToElement(By.id("BillingNewAddress_Email"), "ganpati@gmail.com");
        Thread.sleep(500);
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        Thread.sleep(500);
        clickOnElement(By.id("BillingNewAddress_StateProvinceId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Other");
        Thread.sleep(500);
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        Thread.sleep(500);
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 Downing St");
        Thread.sleep(500);
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "OV16 7BH");
        Thread.sleep(500);
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07900 200004");
        Thread.sleep(500);

        //	2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='Billing.save()']"));

        //	2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //  2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='ShippingMethod.save()']"));

        //  2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentMethod.save()']"));

        //  2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //  2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "MR G K Patel");
        sendTextToElement(By.id("CardNumber"), "0759 2136 2156 5987");

        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");

        clickOnElement(By.id("ExpireYear"));
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");

        sendTextToElement(By.xpath("//input[@id='CardCode']"), "859");

        //  2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentInfo.save()']"));

        //  2.30 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//span[contains(text(),'Payment Method:')]"), "Payment Method:");
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //  2.31 Verify “Shipping Method” is “Next Day Air”
        assertVerifyText(By.xpath("//span[contains(text(),'Shipping Method:')]"), "Shipping Method:");
        assertVerifyText(By.xpath("//ul//li//span[contains(text(),'Next Day Air')]"), "Next Day Air");

        //	2.32 Verify Total is “$2,950.00”
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$2,950.00')]"), "$2,950.00");

        //	2.33 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='ConfirmOrder.save()']"));

        //	2.34 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //	2.35 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),
                "Your order has been successfully processed!");

        //	2.36 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='setLocation(\"/\")']"));

        //  2.37 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

    }

    @After
    public void teardown() {
        closeBrowser();
    }
}