package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class LoginPage extends AbstractPage
{
    public LoginPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = "#signInForm > div.form-part.email-part > label > input[type=email]")
    public WebElement inputEmail;

    @FindBy(css = "#signInForm > div.form-part.password-part > label > input[type=password]")
    public WebElement inputPassword;

    @FindBy(id = "membership-modal-login-button")
    public WebElement loginButton;

    @FindBy(className = "display-name")
    public WebElement displayName;



    // Page Objects added
    @FindBy(id = "phoneNumber")
    public WebElement inputPhoneNumber;

    @FindBy(id = "phoneNumberToVerify")
    public WebElement inputVerificationNumber;

    @FindBy(id = "verifyOtpButton")
    public WebElement verifyOtpButton;

    @FindBy(id = "phoneNumber-error")
    public WebElement phoneNumberError;

    @FindBy(id = "otp-error-message")
    public WebElement OTPerror;

    @FindBy(css = "#membership-modal > div > div > div.modal-header > button")
    public WebElement closeLoginForm;

    @FindBy(css = "#otp-modal > div > div > div.modal-header > button")
    public WebElement closeOTPForm;

}
