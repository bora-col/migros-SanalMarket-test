package tests.user;

import org.junit.Assert;
import org.junit.Test;
import pages.user.LoginPage;
import tests.AbstractTest;

public class LoginTest extends AbstractTest{
    @Test
    public void testLoginInvalidNumber() {
        loginWithInvalidNumber(invalidNumber);
        LoginPage loginPage = new LoginPage(browser);
        browser.waitAndClick(loginPage.closeLoginForm);
        Assert.assertFalse(browser.isElementDisplayed(loginPage.displayName));
    }

    @Test
    public void testLoginInvalidOTP() {
        loginWithInvalidOTP(validNumber);
        LoginPage loginPage = new LoginPage(browser);
        browser.waitAndClick(loginPage.closeOTPForm);
        Assert.assertFalse(browser.isElementDisplayed(loginPage.displayName));
    }
}
