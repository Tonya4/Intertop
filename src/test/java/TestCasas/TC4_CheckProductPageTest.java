package TestCasas;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class TC4_CheckProductPageTest extends BaseTest {

    @Test
    public void checkProductPage(){
         startPage.openStartPage()
                 .clickOnDetyamButton()
                 .checkIsRedirectedOnDetyamPage()
                 .clickOnProductFromCarouselPosition(1)
                 .checkIsRedirectedOnProductPage()
                 .isProductTitleOnPageElements(TestData.productTitle_CheckProductPageTest)
                 ;
     }

}
