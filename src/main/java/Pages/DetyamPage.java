package Pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetyamPage extends ParentPage {

    final String ProductFromCarousel = ".//*[@class='one-product vue-one-product carousel_item' and @position = '%s']";

    @FindBy(xpath = ".//input[@name='SUB-EMAIL']")
    private WebElement subscribeField;

    @FindBy(xpath = ".//*[@class='subscribe-card-in']")
    private WebElement ErrorEmailMessage;

    @FindBy(xpath = ".//*[@id='subscribe_add']")
    private WebElement SubscribeButton;

    @FindBy(xpath = ".//*[@class= 'sub-close']")
    private WebElement CloseErrorEmailMessageButton;

    @FindBy(xpath = ".//a[@href= '/catalog/gender-devochki_malchiki-novelty/']")
    private WebElement newButton;

    public DetyamPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/detyam/";
    }

//=========================================================

    public DetyamPage checkIsRedirectedOnDetyamPage() {
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
        logger.info("===== Detyam Page was opened =====");
        return this;
    }

    public ProductPage clickOnProductFromCarouselPosition(int position) {
        TestData.productTitle_CheckProductPageTest = rememberPruductTitle(webDriver.findElement(By.xpath(String.format(ProductFromCarousel, position))));
        clickOnElement(webDriver.findElement(By.xpath(String.format(ProductFromCarousel, position))), "'Product from carousel' ");
        return new ProductPage(webDriver);
    }

    public DetyamPage enterInvalidEmailIntoSubscribe(String invalidEmail){
        enterTextInToElement(subscribeField, invalidEmail);
        return this;
    }

    public DetyamPage checkIsErrorEmailMessageVisible(){
        checkIsElementVisible(ErrorEmailMessage);
        return this;
    }

    public DetyamPage clickOnSubscribeButton(){
        clickOnElement(SubscribeButton, "'Subscribe button' ");
        return this;
    }

    public DetyamPage clickOnCloseErrorEmailMessageButton(){
        clickOnElement(CloseErrorEmailMessageButton, "'Close error message' ");
        return this;
    }

    public DetyamNewPage clickOnNewButton(){
        clickOnElement(newButton, "'New button' ");
        return new DetyamNewPage(webDriver);
    }


}




