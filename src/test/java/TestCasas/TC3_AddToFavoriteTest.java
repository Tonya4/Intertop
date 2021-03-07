package TestCasas;

import BaseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

public class TC3_AddToFavoriteTest extends BaseTest {

    @Test
    public void addToFavorite(){
       favoritesPage = startPage.openStartPage()
        .clickOnFavoritesButton()
        .checkIsRedirectedOnFavoritesPage()
        .checkFavoriteEmptyMessage()
        .clickOnObuvButton()
        .clickOnKrossovkiButton()
        .checkIsRedirectedOnKrossovkiZhPage()
        .addToFavorite()
        .clickOnFavoritesButton()
        .checkIsRedirectedOnFavoritesPage()
        .checkIsFavoriteProductVisible()
        ;
    }

    @After
    public void deleteFromFavotire() {
        favoritesPage.deleteFavoritesProducts()
                .checkFavoriteEmptyMessage()
                ;
    }

}
