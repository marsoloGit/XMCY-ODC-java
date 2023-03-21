package ui.selenium.webPages;

import org.openqa.selenium.WebDriver;

public class SiteNavigation extends BasePage {

    public SiteNavigation(WebDriver driver) {
        super(driver);
    }


    public EconomicCalendarPage navigateToEconomicCalendar() {
        open("/research/economicCalendar");
        return new EconomicCalendarPage(getDriver());
    }


}



