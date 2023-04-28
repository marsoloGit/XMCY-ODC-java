import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui.jdi.webPages.XmSite;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static ui.jdi.webPages.XmSite.homePage;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
//        initElements(XmSite.class);
        openSite(XmSite.class);
        logger.info("Run Tests");
        homePage.open();
    }

    @AfterSuite(alwaysRun = true)
    public  void teardown() {
        killAllSeleniumDrivers();
    }

}
