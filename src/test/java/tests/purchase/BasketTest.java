package tests.purchase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import pages.user.LoginPage;
import tests.AbstractTest;



public class BasketTest extends AbstractTest
{

    @Test
    public void testBasketWithDiapersAndLoginWhenNeeded() {
        System.out.println("RUNNING: testBasketWithDiapersAndLoginWhenNeeded()");
        MainPage mainPage = new MainPage(browser);
        checkAndRemoveCookiePopup(mainPage);
        browser.waitAndClick(mainPage.babyToyMenu); //page refreshed
        checkAndRemoveCookiePopup(mainPage);
        browser.waitAndClick(mainPage.diaperCategory); //page refreshed
        CategoryPage categoryPage = new CategoryPage(browser);
        checkAndRemoveCookiePopup(categoryPage);
        browser.waitAndClick(categoryPage.brandChoice); //page refreshed
        checkAndRemoveCookiePopup(categoryPage);
        sortByHighestPrice(categoryPage);
        browser.getDriver().navigate().refresh(); //page refreshed
        checkAndRemoveCookiePopup(categoryPage);
        browser.waitAndClick(categoryPage.size); //page refreshed
        checkAndRemoveCookiePopup(categoryPage);
        browser.waitAndClick(categoryPage.addBasket);
        successfulLogin(validNumber);
        checkAndRemoveFirstPopup(mainPage);
        checkAndRemovePopups(categoryPage);
        clearBasket();
        browser.waitAndClick(categoryPage.addBasket);
        browser.waitAndClick(mainPage.shoppingBasketButton);
        while (browser.isElementDisplayed(mainPage.progressBarText)){
            browser.waitAndClick(mainPage.plusButton);
        }
        browser.waitAndClick(mainPage.goToBasketButton); //page refreshed
        BasketPage basketPage = new BasketPage(browser);
        checkAndRemovePopups(basketPage);
        if (browser.isElementDisplayed(basketPage.skipPopupButton)) {
            browser.waitAndClick(basketPage.skipPopupButton);
        }
        browser.waitAndClick(basketPage.bagChoice);
        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket); //page refreshed
        checkAndRemovePopups(basketPage);
        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }

    @Test
    public void testBasketWithDiapersLoginFirst() {
        System.out.println("RUNNING: testBasketWithDiapers()");
        successfulLogin(validNumber);
        MainPage mainPage = new MainPage(browser);
        checkAndRemoveFirstPopup(mainPage);
        checkAndRemovePopups(mainPage);
        clearBasket();
        browser.waitAndClick(mainPage.babyToyMenu); //page refreshed
        checkAndRemovePopups(mainPage);
        browser.waitAndClick(mainPage.diaperCategory); //page refreshed
        CategoryPage categoryPage = new CategoryPage(browser);
        checkAndRemovePopups(categoryPage);
        browser.waitAndClick(categoryPage.brandChoice); //page refreshed
        checkAndRemovePopups(categoryPage);
        sortByHighestPrice(categoryPage);
        browser.getDriver().navigate().refresh(); //page refreshed
        checkAndRemovePopups(categoryPage);
        browser.waitAndClick(categoryPage.size); //page refreshed
        checkAndRemovePopups(categoryPage);
        browser.waitAndClick(categoryPage.addBasket);
        browser.waitAndClick(mainPage.shoppingBasketButton);
        while (browser.isElementDisplayed(mainPage.progressBarText)){
            browser.waitAndClick(mainPage.plusButton);
        }
        browser.waitAndClick(mainPage.goToBasketButton); //page refreshed
        BasketPage basketPage = new BasketPage(browser);
        checkAndRemovePopups(basketPage);
        if (browser.isElementDisplayed(basketPage.skipPopupButton)) {
            browser.waitAndClick(basketPage.skipPopupButton);
        }
        browser.waitAndClick(basketPage.bagChoice);
        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket); //page refreshed
        checkAndRemovePopups(basketPage);
        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }

    @Test
    public void testBasketWithMeatLoginFirst()
    {
        System.out.println("RUNNING: testBasketWithDiapers()");
        successfulLogin(validNumber);
        MainPage mainPage = new MainPage(browser);
        checkAndRemoveFirstPopup(mainPage);
        checkAndRemovePopups(mainPage);
        clearBasket();
        browser.waitAndClick(mainPage.meatFishChichkenMenu); //page refreshed
        checkAndRemovePopups(mainPage);
        browser.waitAndClick(mainPage.meatCategory); //page refreshed
        CategoryPage categoryPage = new CategoryPage(browser);
        checkAndRemovePopups(categoryPage);
        browser.waitAndSendKeys(categoryPage.productSearch, "Dana Yemeklik");
        browser.waitAndClick(categoryPage.addBasket);
        browser.waitAndClick(mainPage.shoppingBasketButton);
        while (browser.isElementDisplayed(mainPage.progressBarText)) {
            browser.waitAndClick(mainPage.plusButton);
        }
        browser.waitAndClick(mainPage.goToBasketButton); //page refreshed
        BasketPage basketPage = new BasketPage(browser);
        checkAndRemovePopups(basketPage);
        if (browser.isElementDisplayed(basketPage.skipPopupButton)) {
            browser.waitAndClick(basketPage.skipPopupButton);
        }
        browser.waitAndClick(basketPage.purchaseNote);
        browser.waitAndSendKeys(basketPage.inputNote, "120 gramlık paketler şeklinde hazırlanmasını istiyorum");
        browser.waitAndClick(basketPage.bagChoice);
        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket); //page refreshed
        checkAndRemovePopups(basketPage);
        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }
    
}
