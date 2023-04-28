package ui.jdi.webPages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Link;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static ui.jdi.webPages.XmSite.economicCalendarPage;

public class ResearchEducationPage extends WebPage {

    @FindBy(how = How.LINK_TEXT, using="Economic Calendar")
    private static Link lnkEconomicCalendar;


    public EconomicCalendarPage navigateToCalendar() {
        lnkEconomicCalendar.click();
        return economicCalendarPage;
    }
}
