package TestCasas;

import BaseTest.BaseTest;
import org.junit.Test;

public class AddToFavoriteTest extends BaseTest {

    @Test
    public void addToFavorite(){
        startPage.openStartPage()
        .clickOnFavoritesButton()
        .checkFavoriteEmptyMessage()
        .clickOnObuvButton()
        .clickOnKrossovkiButton()
        .addToFavorite()
        .clickOnFavoritesButton()
        .checkIsFavoriteProductVisible()
        ;
    }
}
