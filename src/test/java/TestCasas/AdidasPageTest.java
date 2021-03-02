package TestCasas;

import BaseTest.BaseTest;
import org.junit.Test;

public class AdidasPageTest extends BaseTest {

    @Test
    public void openAdidasPage(){
        startPage.openStartPage()
                 .clickOnBrandsButton()
                 .checkIsRedirectToBrandsPage()
                 .clickOnAdidasButton()
                 .checkIsRedirectToAdidasPage()
                 .checkIsAdidasLogoDisplayed()
                 .checkIsAdidasAboutDisplayed()
                ;
    }


}
