import config.Settings;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.selenium.Driver;
import ui.selenium.modals.CookieModal;
import ui.selenium.webPages.HomePage;


public class BasicTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = Driver.getBrowserInstance(Settings.BROWSER);
        HomePage homePage = new HomePage(driver);
        homePage.open("/");
        new CookieModal(getDriver()).acceptAllCookies();


    }


    @AfterClass
    public void cleanUp() {
        driver.quit();


    }

     WebDriver getDriver() {
        return this.driver;
    }

}
