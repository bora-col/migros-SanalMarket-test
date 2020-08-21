package tests;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.user.LoginPage;
import utils.Browser;
import utils.TestContext;
import java.util.Scanner;
public class AbstractTest
{
    public static TestContext context = new TestContext();
    public static Browser browser = context.doCreateBrowser();
    public static boolean cookie_dismissed = false;
    public static final String validNumber = "XXXXXXXXXX";
    public static final String invalidNumber = "4443332211";
    public static final String invalidOTP = "000000";


    @BeforeClass
    public static void setUpClass()
    {
        browser.get("https://www.migros.com.tr");
    }

    @AfterClass
    public static void tearDownClass()
    {
        if (null != browser)
            browser.close();
    }

    public void loginWithInvalidNumber(String userPhoneNumber) {
        MainPage mainPage = new MainPage(browser);
        if(!browser.isElementDisplayed(mainPage.loginForm))
            browser.waitAndClick(mainPage.loginButton);
        LoginPage loginPage = new LoginPage(browser);
        waitToBeClickableAndClick(loginPage.inputPhoneNumber,3);
        browser.waitAndSendKeys(loginPage.inputPhoneNumber, userPhoneNumber);
        browser.waitAndClick(loginPage.loginButton);
        Assert.assertTrue(browser.isElementDisplayed(loginPage.phoneNumberError));
    }

    public void loginWithInvalidOTP(String userPhoneNumber) {
        MainPage mainPage = new MainPage(browser);
        if(!browser.isElementDisplayed(mainPage.loginForm))
            browser.waitAndClick(mainPage.loginButton);
        LoginPage loginPage = new LoginPage(browser);
        waitToBeClickableAndClick(loginPage.inputPhoneNumber,3);
        browser.waitAndSendKeys(loginPage.inputPhoneNumber, userPhoneNumber);
        browser.waitAndClick(loginPage.loginButton);
        waitToBeClickableAndClick(loginPage.inputVerificationNumber,5);
        browser.waitAndSendKeys(loginPage.inputVerificationNumber, invalidOTP);
        browser.waitAndClick(loginPage.verifyOtpButton);
        Assert.assertTrue(browser.isElementDisplayed(loginPage.OTPerror));
    }


    public void successfulLogin(String userPhoneNumber)
    {
        MainPage mainPage = new MainPage(browser);
        if(!browser.isElementDisplayed(mainPage.loginForm))
            browser.waitAndClick(mainPage.loginButton);
        LoginPage loginPage = new LoginPage(browser);
        waitToBeClickableAndClick(loginPage.inputPhoneNumber,3);
        browser.waitAndSendKeys(loginPage.inputPhoneNumber, userPhoneNumber);
        browser.waitAndClick(loginPage.loginButton);
        //Wait for user to enter the verification code
        System.out.println("Enter Verification Number on the Website.");
        sleep(17);
        browser.waitAndClick(loginPage.verifyOtpButton);
        System.out.println("NAME: " + loginPage.displayName.getText());
        Assert.assertNotEquals("",loginPage.displayName.getText());
    }



    public void clearBasket()
    {
        MainPage mainPage = new MainPage(browser);
        if(browser.isElementDisplayed(mainPage.shoppingBasketButton)){
            System.out.println("Shopping basket visible.");
            waitToBeClickableAndClick(mainPage.shoppingBasketButton,10);
            while (browser.isElementDisplayed(mainPage.trashButton)) {
                browser.waitAndClick(mainPage.trashButton);
            }
            browser.waitAndClick(mainPage.shoppingBasketButton);
        }
        else{
            System.out.println("Shopping basket not visible.");
        }

    }

    public void sleep(int sec){
        try{
            for(int i=sec; i>=0; i--){
                System.out.println(i + " seconds left.");
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void checkAndRemovePopups(AbstractPage page){
        checkAndRemoveSecondPopup(page);
        checkAndRemoveCookiePopup(page);
    }

    public void checkAndRemoveCookiePopup(AbstractPage page){
        if(!cookie_dismissed) {
            try {
                WebDriverWait wait = new WebDriverWait(browser.getDriver(), 7);
                wait.until(ExpectedConditions.elementToBeClickable(page.cookieDismissButton));
                browser.waitAndClick(page.cookieDismissButton);
                cookie_dismissed = true;
            } catch (Exception e) {
                System.out.println("Exception: " + page.cookieDismissButton + " does not exist OR not clickable.");
            }
        }
    }


    public void checkAndRemoveFirstPopup(MainPage mainPage){
        try {
            WebDriverWait wait = new WebDriverWait(browser.getDriver(), 8);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.wis-mfp-content-34011 > button")));
            System.out.println("VISIBLE NOW");
            if (browser.isElementDisplayed(mainPage.firstPopup)) {
                System.out.println("First popup displayed!!!");
                clickElementWithPosition(mainPage.firstPopup, 50, 0);
            }
        }catch(Exception e){
            System.out.println("Exception: " + mainPage.firstPopup + " does not exist OR not clickable.");
        }
    }

    public void checkAndRemoveSecondPopup(AbstractPage page){
        if (browser.isElementDisplayed(page.secondPopup)) {
            System.out.println("Second popup displayed!!!");
            clickElementWithPosition(page.secondPopupClose,0,0);
        }
        else {
            if (browser.isElementDisplayed(page.hiddenAdd))
                removeHiddenPopupDiv();
        }
    }


    public void removeHiddenPopupDiv(){
        JavascriptExecutor js = null;
        if (browser.getDriver() instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) browser.getDriver();
        }
        if(js != null)
            js.executeScript("return document.getElementsByClassName('modal-backdrop fade in')[0].remove();");
    }


    public void waitToBeClickableAndClick(WebElement element, int max_sec){
        try {
            WebDriverWait wait = new WebDriverWait(browser.getDriver(), max_sec);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            browser.waitAndClick(element);
        }catch(Exception e){
            System.out.println("Exception: " + element + " does not exist OR not clickable.");
        }
    }

    public void clickElementWithPosition(WebElement element, int x_offset, int y_offset){
        Actions builder = new Actions(browser.getDriver());
        builder.moveToElement(element, x_offset, y_offset).click().build().perform();
    }

    public void sortByHighestPrice(CategoryPage categoryPage){

        if(!browser.isElementDisplayed(categoryPage.sortByHighestPriceButton)) {
            browser.waitAndClick(categoryPage.sortMenu);
        }
        waitToBeClickableAndClick(categoryPage.sortByHighestPriceButton, 5);
        if(!browser.isElementDisplayed(categoryPage.sortByHighestPriceButton)) {
            browser.waitAndClick(categoryPage.sortMenu);
        }
        waitToBeClickableAndClick(categoryPage.sortByHighestPriceButton, 5);
    }
}
