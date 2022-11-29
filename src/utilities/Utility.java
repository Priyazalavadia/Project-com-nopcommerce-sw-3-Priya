package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }


    //This method will send to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred----> Test failed : ", expectedText, actualText);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
        ///WebElement actualTextMessageElement = driver.findElement(by);
        // return actualTextMessageElement.getText();
    }
    //*******************************************Alert methods***********************************************//
    //This method will switch to alert

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will Accept alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();

    }

    //This method will dismiss alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //This method will String get text from alert
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    //this method will  sendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //**************************************Select Class Methods ********************************//

    //This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);


    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */

    public void selectByContainsTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        selectByContainsTextFromDropDown(by, text);

    }
    public void selectByGetAllOptionFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions
        ) {
            //System.out.println(element.getText());//to print all countries
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }

    //***********Window Handle ***********
    //*********Action Class***********
    //mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)
//****************************************************mouseHover******************************//

    public void mouseHoverToElement(By by) {
        Actions action = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        action.moveToElement(mouseHover).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions action = new Actions(driver);
        WebElement mouseHoverAndClick = driver.findElement(by);
        action.moveToElement(mouseHoverAndClick).click().build().perform();


    }

}


