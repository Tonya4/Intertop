package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class StartPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='menu-item']//a[@href='/brands/'] ")
    private Button brandsButton;

    @FindBy(xpath = ".//*[@class='menu-item']//a[@href='/catalog/zhenskaya_obuv/'] ")
    private WebElement obuvButton;

    @FindBy(xpath = ".//*[@class='user-menu-item item_favorite one-user-menu u-2 active']")
    private WebElement favoritesButton;


    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

//=========================================================

    public StartPage openStartPage(){
        try {
            webDriver.get(baseUrl + getRelativeUrl());
            logger.info("Start Page was opened");
        }catch (Exception e){
            logger.error("Can not open Start page");
            Assert.fail("Can not open Start page");
        }
        return this;
    }

     public BrandsPage clickOnBrandsButton(){
        clickOnElement(brandsButton);
        return new BrandsPage(webDriver);
    }

    public StartPage clickOnObuvButton(){
        clickOnElement(obuvButton);
        return new StartPage(webDriver);
    }

    public FavoritesPage clickOnFavoritesButton(){
        clickOnElement(favoritesButton);
        return new FavoritesPage(webDriver);
    }
}
