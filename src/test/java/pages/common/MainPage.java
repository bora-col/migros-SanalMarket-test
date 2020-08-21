package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class MainPage extends AbstractPage
{
    public MainPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(id = "membership-login-link")
    public WebElement loginButton;

    @FindBy(css = "a[data-monitor-ga-action='Kırmızı Et']")
    public WebElement meatCategory;

    @FindBy(css = ".shoping-cart-icon-block .fa-shopping-cart")
    public WebElement shoppingBasketButton;

    @FindBy(className = "progress-bar-text")
    public WebElement progressBarText;

    @FindBy(css = ".action-td .plus-orange")
    public WebElement plusButton;

    @FindBy(className = "rubbish")
    public WebElement trashButton;

    @FindBy(className = "go-to-basket-button")
    public WebElement goToBasketButton;



    // Page Objects added
    @FindBy(linkText = "Et, Tavuk, Balık")
    public WebElement meatFishChichkenMenu;

    @FindBy(css = "div.wis-mfp-content-34011 > button")
    public WebElement firstPopup;

    @FindBy(id = "membership-modal")
    public WebElement loginForm;

    @FindBy(linkText = "Bebek, Oyuncak")
    public WebElement babyToyMenu;

    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement diaperCategory;

}
