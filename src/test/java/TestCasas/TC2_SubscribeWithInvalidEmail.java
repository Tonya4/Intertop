package TestCasas;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class TC2_SubscribeWithInvalidEmail extends BaseTest {

    @Test
    public void subscribeWithInvalidEmail(){
        startPage.openStartPage()
                .clickOnDetyamButton()
                .enterInvalidEmailIntoSubscribe(TestData.INVALID_EMAIL)
                .clickOnSubscribeButton()
                .checkIsErrorEmailMessageVisible()
                .clickOnCloseErrorEmailMessageButton()
        ;
    }
}
