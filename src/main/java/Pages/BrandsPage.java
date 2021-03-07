package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

import static org.hamcrest.CoreMatchers.containsString;

public class BrandsPage extends ParentPage{

    @FindBy(xpath = ".//span[text()='adidas']")
    private WebElement adidasButton;

    public BrandsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/brands/";
    }

    //=========================================================

    public BrandsPage checkIsRedirectToBrandsPage(){
        Assert.assertThat("Invalid page"
                , webDriver.getCurrentUrl()
                , containsString(baseUrl + getRelativeUrl()));
        logger.info("===== Brands Page was opened =====");
        return this;
    }

    public BrendAdidasPage clickOnAdidasButton(){
        clickOnElement(adidasButton, "'Adidas Button' ");
        return new BrendAdidasPage(webDriver);
    }


}
