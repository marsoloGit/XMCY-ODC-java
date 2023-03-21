package ui.selenium.webPages;

import config.Settings;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    private static String pageUrl;

    static final int ELEMENT_WAIT = Settings.WEBDRIVER_ELEMENT_WAIT;
    private WebDriver driver;
    private String rootUri;

    private BasePage(WebDriver driver, String rootUri) {
        this.driver = driver;
        this.rootUri = rootUri;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, ELEMENT_WAIT), this);

    }

    public BasePage(WebDriver driver) {
        this(driver, Settings.XMCY_URL);

    }


    public void open(String uri){

        rootUri = (!this.rootUri.isEmpty()) ? this.rootUri: "";
        this.driver.get(rootUri + uri);

    }


    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public String title() {
        return this.driver.getTitle();
    }

    public WebDriver getDriver(){
        return this.driver;

    }


}
