package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='menu-item']//a[@href='/brands/'] ")
    private Button brandsButton;


    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/ua/";
    }

//=========================================================

     public BrandsPage clickOnBrandsButton(){
        clickOnElement(brandsButton);
        return new BrandsPage(webDriver);
    }
}
