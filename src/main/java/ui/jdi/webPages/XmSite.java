package ui.jdi.webPages;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.material.elements.navigation.Menu;

@JSite("https://www.xm.com")
public class XmSite {
//    @Url("/")
    public static HomePage homePage;

//    @Url("/")
    public static ResearchEducationPage researchEducationPage;

//    @Url("/research/economicCalendar")
    public static EconomicCalendarPage economicCalendarPage;

    @UI("#main-nav")
    public static Menu navigation_menu;

    public static Dialog cookieModal;

}

