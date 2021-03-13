package Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends ParentPage{

    @FindBy(xpath =".//*[@class ='one-item-slide-in']")
    private WebElement favoriteProduct;

    @FindBy(xpath = ".//*[@class ='one-item-fav']")
    private WebElement deleteFavoriteButton;

    @FindBy(xpath = ".//a[@href='/ua/catalog/zhenskaya_obuv/'] ")
    private WebElement obuvButton;

    @FindBy(xpath =".//*/b[text()='У вас поки немає товарів у списку “Обране”']")
    private WebElement favoriteEmptyMessage;

    @FindBy(xpath = ".//*[@href='/ua/catalog/zhenskaya_obuv/krossovki/']")
    private WebElement krossovkiButton;

    public FavoritesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/favorites/";
    }

//=========================================================

    public FavoritesPage deleteFavoritesProduct(){
        clickOnElement(deleteFavoriteButton);
        return this;
    }

    public FavoritesPage deleteFavoritesProducts(){
         int counter = 0;
         while (isElementDisplayed(favoriteProduct) && counter <100){
         clickOnElement(deleteFavoriteButton);
         counter ++;
         }
        return this;
    }

    public FavoritesPage checkIsRedirectedOnFavoritesPage() {
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
        logger.info("===== Favorite Page was opened =====");
        return this;
    }

   public FavoritesPage clickOnObuvButton(){
       clickOnElement(obuvButton, "'Obuv button' ");
       return new FavoritesPage (webDriver);
   }

    public KrossovkiZhPage clickOnKrossovkiButton(){
        clickOnElement(krossovkiButton, "'Krossovki button' ");
        return new KrossovkiZhPage (webDriver);
    }

    public FavoritesPage checkFavoriteEmptyMessage(){
        checkIsElementVisible(favoriteEmptyMessage);
        return this;
    }

    public FavoritesPage checkIsFavoriteProductVisible(){
       checkIsElementVisible(favoriteProduct);
       return this;
    }

}

