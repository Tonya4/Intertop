package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KrossovkiZhPage extends ParentPage{

    @FindBy(xpath = ".//*[@class='product-fav']")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = ".//*[@class='user-menu-item item_favorite one-user-menu u-2 active']")
    private WebElement favoritesButton;

    public KrossovkiZhPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/catalog/zhenskaya_obuv/krossovki/";
    }

    public KrossovkiZhPage addToFavorite(){
        clickOnElement(addToFavoriteButton);
        return this;
    }

    public FavoritesPage clickOnFavoritesButton(){
        clickOnElement(favoritesButton);
        return new FavoritesPage(webDriver);
    }
}
