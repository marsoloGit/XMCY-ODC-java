//import com.epam.jdi.light.driver.get.DriverUtils;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.settings.WebSettings;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.awt.*;

@JSite("https://www.xm.com")
public class DomoJDITest {

    @Url("/economic-calendar")
    public static class EconomicCalendarPage extends WebPage {
        @UI("q")
        public static TextField searchField;
    }

//    @Url("/economic-calendar")
//    public static EconomicCalendarPage economicCalendarPage;
//
//    @BeforeMethod
//    public void setUp() {
////        DriverUtils.getDriver(); // Initialize the web driver
//        WebSettings.logger.info("Run Test");
//    }
//
//    @Test
//    public void moveSliderToNextWeek() {
//        economicCalendarPage.open(); // Open the Economic Calendar page
//        economicCalendarPage.timeFrameSlider.expand(); // Expand the time frame slider
//        economicCalendarPage.timeFrameSlider.setValue("Next week"); // Set the slider to "Next week"
//        assert economicCalendarPage.timeFrameSlider.getValue().equals("Next week"); // Assert that the slider is set to "Next week"
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        DriverUtils.closeDriver(); // Close the web driver
//    }
}

