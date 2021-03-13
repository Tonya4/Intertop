package TestCasas;

import BaseTest.BaseTest;
import org.junit.Test;

public class TC5_FiltrationTest extends BaseTest {

    @Test
    public void filtrationProducts() throws InterruptedException {
        startPage.openStartPage()
        .clickOnDetyamButton()
        .checkIsRedirectedOnDetyamPage()
        .clickOnNewButton()
        .checkIsRedirectedOnDetyamNewPage()
        .clichOnColorButton()
        .clichOnWhiteColorButton()
        .clichOnSizeButton()
        .clichOnSize36Button()
        .checkFilters("Для дівчаток;Для хлопчиків;Білий;36");
        ;
    }
}



