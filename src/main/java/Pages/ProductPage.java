package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ParentPage {

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/product/";
    }

    @FindBy(xpath = ".//*[@class='page-product-element page-product-element--bottom-header']")
    private WebElement bottomHeafer;

    @FindBy(xpath = ".//*[@class='product-top']//*[@class='user-product-name']")
    private WebElement rightProductTot;

    @FindBy(xpath = ".//*[@class='prod-acc']")
    private WebElement aboutProd;

//=========================================================

    public ProductPage checkIsRedirectedOnProductPage() {
        Assert.assertTrue ("Invalid page", webDriver.getCurrentUrl().contains(baseUrl + getRelativeUrl()));
        logger.info("===== Product Page was opened =====");
        return this;
    }

    public ParentPage isProductTitleOnPageElements(String productTitle){
        isTextInElement(bottomHeafer,  productTitle);
        isTextInElement(rightProductTot,  productTitle);
        isTextInElement(aboutProd,  productTitle);
        return this;
    }

}
