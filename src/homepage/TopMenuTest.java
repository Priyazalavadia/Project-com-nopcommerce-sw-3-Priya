package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {


    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    //1.1 selectMenu method
    public void selectMenu (String menu){

        if (menu == "Computers") {
            //Find computer tab and click
            clickOnElement(By.linkText("Computers"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Computers",title);

        } else if (menu == "Electronics") {
            clickOnElement(By.linkText("Electronics"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Electronics",title);

        } else if (menu == "Apparel") {
            clickOnElement(By.linkText("Apparel"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Apparel",title);

        } else if (menu == "Digital downloads") {
            clickOnElement(By.linkText("Digital downloads"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Digital downloads",title);

        } else if (menu == "Books") {
            clickOnElement(By.linkText("Books"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Books",title);

        } else if (menu == "Jewelry") {
            clickOnElement(By.linkText("Jewelry"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Jewelry",title);

        } else if (menu == "Gift Cards") {
            clickOnElement(By.xpath("//a[contains(text(),'Gift Cards')]"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Gift Cards",title);

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    //1.2 / 1.3 Click on page and verify navigation
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }

    @After
    public void teardown(){
        closeBrowser();
    }
}