package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class CategoryPage extends AbstractPage
{
    public CategoryPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = ".sub-category-product-list .list:nth-of-type(1) .product-card-button")
    public WebElement addBasket;


    // Page Objects added
    @FindBy(id = "product-search")
    public WebElement productSearch;

    @FindBy(css = "#page-area > div > div > div.col-md-2.sidebar-container-column > div.category-sidebar > div > div:nth-child(3) > ul > li > ul > li:nth-child(1) > a")
    public WebElement brandChoice;

    @FindBy(linkText = "Önce En Yüksek Fiyat")
    public WebElement sortByHighestPriceButton;

    @FindBy(css = "#product-list-sort > nav > button")
    public WebElement sortMenu;

    @FindBy(css = "a[data-monitor-ga-label='4 Beden']")
    public WebElement size;

}

