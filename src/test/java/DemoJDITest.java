
import config.Const;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.jdi.webPages.XmSite;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static ui.jdi.webPages.XmSite.*;


public class DemoJDITest extends TestInit  {

//    @BeforeSuite(alwaysRun = true)
//    static void setUp() {
////        String a = DRIVER.name;
////        openSite(XmSite.class);
//        initElements(XmSite.class);
//        homePage.open();
//    }

    @Test
    public void checkFlowToCalendar() {
//        homePage.open();
        homePage.navigateToResearchAndEducation();
        navigation_menu.select("RESEARCH & EDUCATION");
        researchEducationPage.navigateToCalendar();

    }


    @DataProvider(name="dateRanges")
    public Object[][] data(){
        return new Object [][]{
                { Const.CalendarRanges.TODAY },
                { Const.CalendarRanges.TOMORROW },
                { Const.CalendarRanges.NEXT_WEEK },
                { Const.CalendarRanges.NEXT_MONTH }
        };
    }


    @Test(dataProvider="dateRanges")
    public void testcheckCalendarSlider(Const.CalendarRanges range){
        economicCalendarPage.open();
        economicCalendarPage.move_slider_to(Integer.toString(range.getRangeNum()));
//		List<String> actualDatesRange = calendarPage.datePicker.getSelectedRange();
////		List<String> expectedDatesRange = Const.CalendarRanges.getRange()

    }





}

