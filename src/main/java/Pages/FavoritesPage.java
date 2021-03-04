package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class FavoritesPage extends ParentPage{

    @FindBy(xpath =".//*[@class ='one-item-slide-in']")
    private WebElement favoriteProduct;

    @FindBy(xpath = ".//*[@class ='one-item-fav']")
    private Button deleteFavoriteButton;

    @FindBy(xpath = ".//*[@class='menu-item']//a[@href='/catalog/zhenskaya_obuv/'] ")
    private WebElement obuvButton;

    @FindBy(xpath =".//*/b[text()='У вас поки немає товарів у списку “Обране”']")
    private WebElement favoriteEmptyMessage;

    @FindBy(xpath = ".//*[@href='/catalog/zhenskaya_obuv/krossovki/']")
    private WebElement krossovkiButton;

    public FavoritesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/favorites/";
    }

    public FavoritesPage deleteFavoritesProduct(){
        clickOnElement(deleteFavoriteButton);
        return this;
    }

   /* public FavoritesPage deleteFavoritesProducts(){
        int counter = 0;
        while (checkIsElementVisible(favoriteProduct) && counter <100){
            clickOnElement(webDriver.findElement(By.xpath(deleteFavoriteButton)));
            counter ++;
        }
        return this;
    }
     */

   public FavoritesPage clickOnObuvButton(){
       clickOnElement(obuvButton);
       return new FavoritesPage (webDriver);
   }

    public KrossovkiZhPage clickOnKrossovkiButton(){
        clickOnElement(krossovkiButton);
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

/*
  int counter = 0;
        while (!listOfPosts.isEmpty() && counter < 100){
            clickOnElement(webDriver.findElement(
                    By.xpath(String.format(postTitleLocator, post_title))), " Post with title " +post_title);
            new SinglePostPage(webDriver)
                    .checkIsRedirectToSinglePostPage()
                    .clickOnDeletePostButton()
                    .checkIsRedirectToProfilePage()
                    .checkSuccessDeletePost();
            listOfPosts = webDriver.findElements(By.xpath(String.format(postTitleLocator, post_title)));
            counter ++;
        }
        return this;
 */
