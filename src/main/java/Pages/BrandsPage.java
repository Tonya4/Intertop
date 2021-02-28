package Pages;

import org.openqa.selenium.WebDriver;

public class BrandsPage extends ParentPage{


    public BrandsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/brands/";
    }
}
