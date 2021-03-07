package BaseTest;

import Pages.BrandsPage;
import Pages.BrendAdidasPage;
import Pages.FavoritesPage;
import Pages.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

import static Pages.ParentPage.configProperties;

    public class BaseTest {
        public WebDriver webDriver;
        protected Logger logger = Logger.getLogger(getClass());
        protected StartPage startPage;
        protected BrandsPage brandsPage;
        protected BrendAdidasPage brandAdidasPage;
        protected FavoritesPage favoritesPage;


        @Rule
        public TestName testName = new TestName();


        @Before
        public void setUp() throws Exception {
            logger.info("-----  " + testName.getMethodName() + " was started  -----");
            webDriver = initDriver();

            webDriver.manage().window().maximize();  //full size for window
            webDriver.manage().timeouts().implicitlyWait(configProperties.TIME_FOR_DFFAULT_WAIT(), TimeUnit.SECONDS); //default time for waiting
            logger.info("Browser was opend");
            startPage = new StartPage(webDriver); // from this go to constructor

        }

        // CHROME OR FIREFOX
        private WebDriver initDriver() throws Exception {
            String browser = System.getProperty("browser"); //det from property
            if ((browser == null) || ("chrome".equalsIgnoreCase(browser)) ){
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(browser)){
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else if ("ie".equalsIgnoreCase(browser)){
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            } else {
                throw new Exception("Check browser var");
            }
        }

        @After
        public void teamDown(){
            webDriver.quit();
            logger.info("Browser was closed");
            logger.info("-----  " + testName.getMethodName() + " was ended  -----");
        }

        protected void checkExpectedResult(String message, boolean actualResult){
            Assert.assertTrue(message, actualResult);
        }
    }


