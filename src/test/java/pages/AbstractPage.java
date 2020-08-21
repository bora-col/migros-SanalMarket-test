package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class AbstractPage
{
    protected AbstractPage(Browser browser)
    {
        PageFactory.initElements(browser, this);
    }

    // Page Objects added
    @FindBy(className = "modal-backdrop")
    public WebElement hiddenAdd;

    @FindBy(className = "announcement-modal")
    public WebElement secondPopup;

    @FindBy(css = "#deliveryFromStoreAnnouncement > div > div > div > button")
    public WebElement secondPopupClose;

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;
}
