package Pages;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DetyamNewPage extends ParentPage{

    @FindBy (xpath = ".//*[@class= 'filter-select filter-prop-default one-filter COLOR']")
    private WebElement colorButton;

    @FindBy (xpath = ".//*[contains(text(),'Білий')]")
    private WebElement whiteColorButton;

    @FindBy (xpath = ".//*[@class= 'filter-select filter-prop-default one-filter SIZE']")
    private WebElement sizeButton;

    @FindBy (xpath = ".//*[contains(text(),'36')]")
    private WebElement size36Button;



    public DetyamNewPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/catalog/gender-devochki_malchiki-novelty/";
    }
//=========================================================

    public DetyamNewPage checkIsRedirectedOnDetyamNewPage() {
        Assert.assertEquals("Invalid page"
            , baseUrl + getRelativeUrl()
            , webDriver.getCurrentUrl());
         logger.info("===== Detyam New Page was opened =====");
    return this;
    }

    public DetyamNewPage clichOnColorButton(){
        clickOnElement(colorButton, "'Color Button '");
        return this;
    }

    public DetyamNewPage clichOnWhiteColorButton(){
        clickOnElement(whiteColorButton, "'White colour Button '");
        return this;
    }

    public DetyamNewPage clichOnSizeButton(){
        clickOnElement(sizeButton, "'Color Button '");
        return this;
    }

    public DetyamNewPage clichOnSize36Button(){
        clickOnElement(size36Button, "'White colour Button '");
        return this;
    }

    public DetyamNewPage checkFilters(String expectedFilters) throws InterruptedException {
        Thread.sleep(1000);
        String[] expectedFiltersArray = expectedFilters.split(";");

        List<WebElement> actualFiltersList = webDriver.findElements(By.xpath(
                ".//*[@class='filters-selected']//li"));

        SoftAssertions softAssertions = new SoftAssertions();

        ArrayList<String> actualFiltersTEXT = new ArrayList<>();
        for (WebElement element : actualFiltersList){
            actualFiltersTEXT.add(element.getText());
        }

        for (int i = 0; i < expectedFiltersArray.length; i++) {
            softAssertions.assertThat(expectedFiltersArray[i]).isIn(actualFiltersTEXT);
        }
        softAssertions.assertAll();

        return this;
    }

}
