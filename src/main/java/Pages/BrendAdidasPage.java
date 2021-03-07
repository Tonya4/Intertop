package Pages;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;

public class BrendAdidasPage extends ParentPage{

    @FindBy(xpath = ".//img[@src='/upload/iblock/97d/97de2cbc5363086cc113635799454cbb.png'] ")
    private WebElement adidasLogo;

    @FindBy(xpath = ".//section[@class='about-brand']//h1[text()='Adidas']")
    private WebElement adidasAbout;

    public BrendAdidasPage (WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/brands/adidas/";
    }

    //=========================================================

    public BrendAdidasPage checkIsRedirectToAdidasPage() {
        Assert.assertThat("Invalid page"
                , webDriver.getCurrentUrl(),
                Matchers.containsString(baseUrl + getRelativeUrl()));
        logger.info("===== Adidas brand Page was opened =====");
        return this;
    }

    public BrendAdidasPage checkIsAdidasLogoDisplayed(){
        checkIsElementVisible(adidasLogo);
        return this;
    }

    public BrendAdidasPage checkIsAdidasAboutDisplayed(){
        checkIsElementVisible(adidasAbout);
        return this;
    }

}
